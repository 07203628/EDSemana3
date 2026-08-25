public class PriorityQueue <T> {
    private PriorityNode <T> head;
    private PriorityNode <T> front;

    private PriorityNode <T> rear;
    private int size;

    public PriorityQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        PriorityNode<T> current = front;
        System.out.println("Priority Queue:");
        while (current != null) {
            System.out.println("Data: " + current.getData() + ", Priority: " + current.getPriority());
            current = current.getNext();
        }
        System.out.println("Fin.");
    }

    public void enqueue(int data, int priority) {
        PriorityNode <T> newNode = new PriorityNode <T> (data, priority);

        if (isEmpty() || priority < front.getPriority()) {
            newNode.setNext(front);
            front = newNode;
            if (rear == null) {
                rear = newNode;
            }
        } else {
            PriorityNode<T> current = front;
            while (current.getNext() != null && current.getNext().getPriority() <= priority) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) {
                rear = newNode;
            }
            size++;
            System.out.println("Enqueued: " + data + " with priority: " + priority);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        PriorityNode<T> temp = front;
        front = front.getNext();
        if (front == null) { 
            rear = null; 
        }
        size--;
        System.out.println("Dequeued: " + temp.getData() + " with priority: " + temp.getPriority());
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
        return (T) Integer.valueOf(front.getData());
    }

}