package m;

public class WeighedQueue {
    public Node head;
    public Node tail;
    public int size;
    public double rate;

    public WeighedQueue (double rate) {
        head = null;
        tail = null;
        this.rate = rate;
    }

    public static WeighedQueue randomWeighedQueue(double rate, int size) {
        WeighedQueue newQueue = new WeighedQueue(rate);
        for (int i = 0; i < size; i++) {
            newQueue.insert(Node.createRandomNode());
        }
        return newQueue;
    }

    public void insert(Node toAdd) {
        if (size == 0) {
            head = toAdd;
        } else {
            tail.next = toAdd;
        }
        tail = toAdd;
        size++;
    }

    public Node extract() {
        Node toReturn = head;
        head = head.next;
        size--;
        return toReturn;
    }

    public Node search(int val) {
        Node current = head;
        while (current != null && current.item != val) {
            current = current.next;
        }
        return current;
    }

    public void print() {
        if (size == 0) {
            System.out.print("/empty/");
        } else {
            Node toPrint = head;
            while (toPrint != null) {
                System.out.printf("%d ", toPrint.item);
                toPrint = toPrint.next;
            }
        }
        System.out.println();
    }

}
