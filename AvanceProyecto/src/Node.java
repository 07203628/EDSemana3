package EDSemana3.AvanceProyecto.src;

public class Node <T> {
    private T data;
    private Node <T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void push (T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(this.next);
        this.next = newNode;
    }

    public void pop() {
        if (this.next != null) {
            this.next = this.next.getNext();
        }
    }

    public T peek() {
        if (this.next != null) {
            return this.next.getData();
        }
        return null;
    }

}
