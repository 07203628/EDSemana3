import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> clientQueue = new Queue<>();
        Pile<String> orderHistory = new Pile<>();
        SimpleHashTable<String, String> menu = new SimpleHashTable<>();

        menu.put("Café", "$30");
        menu.put("Té", "$25");
        menu.put("Chocolate", "$35");

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("\nCafé Tecmilenio");
            System.out.println("1. Hacer pedido");
            System.out.println("2. Mostrar pedidos");
            System.out.println("3. Mostrar menú");
            System.out.println("4. Borrar ultimo pedido");
            System.out.println("5. Atender pedido");
            System.out.println("6. Historial de pedidos atendidos");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("\n\nIngrese su nombre: ");
                    String name = sc.next();
                    System.out.print("\n¿Qué desea pedir?: ");
                    String order = sc.next();
                    clientQueue.enqueue(name + " - " + order);
                    System.out.println("Pedido realizado.");
                    break;

                case 2:
                    if (clientQueue.isEmpty()) {
                        System.out.println("No hay pedidos");
                    } else {
                        System.out.println("Pedidos: ");
                        clientQueue.printQueue();
                    }
                    break;

                case 3:
                    System.out.println("\n\nMenú: ");
                    String[] menuItems = {"Café", "Té", "Chocolate"};
                    for (String item : menuItems) {
                        System.out.println(item + " - " + menu.get(item));
                    }
                    break;

                case 4:
                    if (clientQueue.isEmpty()) {
                        System.out.println("\nNo hay pedidos para borrar");
                    } else {
                        String removedOrder = clientQueue.dequeue();
                        System.out.println("\nSe ha borrado el pedido de: " + removedOrder);
                    }
                    break;

                case 5:
                    if (clientQueue.isEmpty()) {
                        System.out.println("\nNo hay pedidos para atender");
                    } else {
                        System.out.println("\nAtendiendo pedido: " + clientQueue.dequeue());
                    }

                case 6:
                    if (orderHistory.isEmpty()) {
                        System.out.println("\nNo hay pedidos atendidos");
                    } else {
                        System.out.println("\nPedidos atendidos: ");
                        orderHistory.printPile();
                    }
                    break;

                case 7:
                    System.out.println("\nSaliendo...");
                    running = false;
                    break;

                default:
                    System.out.println("\nOpción inválida");
                    break;
            }
        }
    }
}
