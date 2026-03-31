class CustomHashMap {
    static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final int SIZE = 10;
    private final Node[] table = new Node[SIZE];
    private int hash(int key) {
        return key % SIZE;
    }
    void put(int key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (table[index] == null) {
            table[index] = newNode;
            return;
        }
        Node current = table[index];
        while (current.next != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        current.next = newNode;
    }
    Integer get(int key) {
        int index = hash(key);
        Node current = table[index];
        while (current != null) {
            if (current.key == key)
                return current.value;
            current = current.next;
        }
        return null;
    }
    void remove(int key) {
        int index = hash(key);
        Node current = table[index], prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null)
                    table[index] = current.next;
                else
                    prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
public class CustomHashMapDemo {
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 100);
        map.put(2, 200);
        System.out.println("Value for key 1: " + map.get(1));
        map.remove(1);
        System.out.println("Value for key 1 after removal: " + map.get(1));
    }
}
