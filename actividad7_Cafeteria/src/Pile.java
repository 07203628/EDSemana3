public class Pile<T> {
    private Node<T> top;

    public Pile() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(top);
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pile is empty");
        }
        T data = top.getData();
        top = top.getNext();
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pile is empty");
        }
        return top.getData();
    }

    public void printPile() {
        if (isEmpty()) {
            System.out.println("\nNo hay pedidos atendidos");
        } else {
            System.out.println("\nPedidos atendidos: ");
        }
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
