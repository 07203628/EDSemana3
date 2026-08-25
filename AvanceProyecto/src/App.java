package EDSemana3.AvanceProyecto.src;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final Lists tasks = new Lists();
    private static final Map<String, Queue<Task>> departmentQueues = new HashMap<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            String option = INPUT.nextLine().trim();
            switch (option) {
                case "1" -> addTask();
                case "2" -> showTasks();
                case "3" -> deleteTask();
                case "4" -> showPendingTasks();
                case "5" -> showDepartmentQueues();
                case "0" -> running = false;
                default -> System.out.println("Opcion no valida.");
            }
        }
        System.out.println("Sistema cerrado.");
    }

    private static void printMenu() {
        System.out.println("\n=== SISTEMA EMPRESARIAL DE GESTION DE TAREAS ===");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Ver todas las tareas pendientes");
        System.out.println("3. Eliminar tarea");
        System.out.println("4. Ver pendientes por urgencia y departamento");
        System.out.println("5. Ver cola de atencion por departamento");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static void addTask() {
        System.out.print("Descripcion de la tarea: ");
        String description = INPUT.nextLine().trim();
        if (description.isEmpty()) {
            System.out.println("La descripcion no puede estar vacia.");
            return;
        }

        int urgency = readUrgency();
        System.out.print("Departamento responsable: ");
        String department = INPUT.nextLine().trim();
        if (department.isEmpty()) {
            System.out.println("El departamento no puede estar vacio.");
            return;
        }

        Task task = new Task(nextId++, description, urgency, department);
        tasks.insert(task);
        departmentQueues.computeIfAbsent(department, key -> new Queue<>()).enqueue(task);
        System.out.println("Tarea agregada con id " + task.getId() + ".");
    }

    private static int readUrgency() {
        while (true) {
            System.out.print("Urgencia (1 = baja, 2 = media, 3 = alta): ");
            try {
                int urgency = Integer.parseInt(INPUT.nextLine().trim());
                if (urgency >= 1 && urgency <= 3) {
                    return urgency;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Ingrese 1, 2 o 3.");
        }
    }

    private static void showTasks() {
        if (tasks.size() == 0) {
            System.out.println("No hay tareas pendientes.");
            return;
        }
        System.out.println("\nTareas pendientes de la empresa:");
        printList(tasks.getHead());
    }

    private static void showPendingTasks() {
        List<Task> orderedTasks = new ArrayList<>();
        Node<Task> current = tasks.getHead();
        while (current != null) {
            orderedTasks.add(current.getData());
            current = current.getNext();
        }
        orderedTasks.sort(Comparator.comparingInt(Task::getUrgency).reversed()
                .thenComparing(Task::getDepartment, String.CASE_INSENSITIVE_ORDER)
                .thenComparingInt(Task::getId));

        if (orderedTasks.isEmpty()) {
            System.out.println("No hay tareas pendientes.");
            return;
        }
        System.out.println("\nPendientes ordenadas por urgencia y departamento:");
        for (Task task : orderedTasks) {
            System.out.println(task);
        }
    }

    private static void showDepartmentQueues() {
        if (departmentQueues.isEmpty()) {
            System.out.println("No hay colas de atencion pendientes.");
            return;
        }

        System.out.println("\nColas de atencion por departamento (orden FIFO):");
        departmentQueues.keySet().stream().sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach(department -> {
                    Queue<Task> queue = departmentQueues.get(department);
                    System.out.println("- " + department + " (" + queue.getSize() + " tareas)");
                    printQueue(queue);
                });
    }

    private static void printQueue(Queue<Task> queue) {
        Queue<Task> remaining = new Queue<>();
        while (!queue.isEmpty()) {
            Task task = queue.dequeue();
            System.out.println("  " + task);
            remaining.enqueue(task);
        }
        while (!remaining.isEmpty()) {
            queue.enqueue(remaining.dequeue());
        }
    }

    private static void deleteTask() {
        System.out.print("Id de la tarea a eliminar: ");
        try {
            int id = Integer.parseInt(INPUT.nextLine().trim());
            Task task = tasks.find(id);
            if (task == null) {
                System.out.println("No se encontro una tarea con ese id.");
                return;
            }

            tasks.delete(id);
            Queue<Task> queue = departmentQueues.get(task.getDepartment());
            removeFromDepartmentQueue(queue, id);
            if (queue.isEmpty()) {
                departmentQueues.remove(task.getDepartment());
            }
            System.out.println("Tarea eliminada.");
        } catch (NumberFormatException exception) {
            System.out.println("El id debe ser un numero.");
        }
    }

    private static void removeFromDepartmentQueue(Queue<Task> queue, int id) {
        if (queue == null) {
            return;
        }
        Queue<Task> remaining = new Queue<>();
        while (!queue.isEmpty()) {
            Task task = queue.dequeue();
            if (task.getId() != id) {
                remaining.enqueue(task);
            }
        }
        while (!remaining.isEmpty()) {
            queue.enqueue(remaining.dequeue());
        }
    }

    private static void printList(Node<Task> current) {
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
