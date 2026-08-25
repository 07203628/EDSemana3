package EDSemana3.Actividad6_ColaPrioridades.ColaPrioridades.src;

public class App {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> emergencies = new PriorityQueue<>();

        System.out.println("Patient arrival");
        emergencies.enqueue(101, 3);
        emergencies.enqueue(102, 1);
        emergencies.enqueue(103, 2);

        System.out.println("\nCurrent queue size: " + emergencies.getSize());
        System.out.println("\nNext patient to be treated: " + emergencies.peek());
        emergencies.display();

        emergencies.enqueue(104, 1);
        System.out.println("\nCurrent queue size: " + emergencies.getSize());
        emergencies.display();

        emergencies.dequeue();
        System.out.println("\nCurrent queue size: " + emergencies.getSize());
        emergencies.display();

    }
}
