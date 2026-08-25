package EDSemana3.AvanceProyecto.src;

public class Lists {
    private Node<Task> head;
    private int size;

    public void insert(Task task) {
        Node<Task> newNode = new Node<>(task);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public boolean delete(int id) {
        Node<Task> previous = null;
        Node<Task> current = head;
        while (current != null) {
            if (current.getData().getId() == id) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }

    public Task find(int id) {
        Node<Task> current = head;
        while (current != null) {
            if (current.getData().getId() == id) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    public int size() {
        return size;
    }

    public Node<Task> getHead() {
        return head;
    }
}
