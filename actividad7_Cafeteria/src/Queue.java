public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<T> (data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("\nNo hay pedidos");
        } else {
            System.out.println("\nPedidos: ");
        }
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    

}