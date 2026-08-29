
public class SimpleHashTable <K, V> {

    public static final int SIZE = 10;
    public Node<K, V>[] menu;

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    public SimpleHashTable() {
        menu = (Node<K, V>[]) new Node[SIZE];
    }

    private int hash(K key) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }
        return Math.floorMod(key.hashCode(), SIZE);
    }

    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> newNode = new Node<K, V>(key, value);
        if (menu[index] == null) {
            menu[index] = newNode;
        } else {
            Node<K, V> current = menu[index];
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> current = menu[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

}