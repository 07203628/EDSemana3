public class PriorityNode <T> {
    private int data;
    private int priority;
    private PriorityNode<T> next;

    public PriorityNode(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public int getPriority() {
        return priority;
    }

    public PriorityNode<T> getNext() {
        return next;
    }

    public void setNext(PriorityNode<T> next) {
        this.next = next;
    }

}