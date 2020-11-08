package m;

public class PriorityQueue {
    public PriorityNode head;
    public PriorityNode tail;
    public int size;

    public PriorityQueue() { // empty
        head = null;
        tail = null;
    }

    public static PriorityQueue randomPriorityQueue(int size) { // filled with random value Nodes
        PriorityQueue newQueue = new PriorityQueue();
        for (int i = 0; i < size; i++) {
            newQueue.insert(PriorityNode.createRandomNode());
        }
        return newQueue;
    }

    public void insert(PriorityNode toAdd) {
        if (size == 0) {
            head = toAdd;
            tail = toAdd;
        } else if (toAdd.priority >= tail.priority) {
            tail.next = toAdd;
            tail = toAdd;
        } else if (toAdd.priority < head.priority) {
            toAdd.next = head;
            head = toAdd;
        } else {
            PriorityNode current = head;
            while (current.next.priority <= toAdd.priority) {
                current = current.next;
            }
            toAdd.next = current.next;
            current.next = toAdd;
            if (tail.next != null)
                tail = toAdd;
        }
        size++;
    }

    public PriorityNode extract() {
        PriorityNode toReturn = head;
        head = head.next;
        size--;
        return toReturn;
    }

    public void print() {
        if (size == 0) {
            System.out.print("/empty/");
        } else {
            PriorityNode toPrint = head;
            while (toPrint != null) {
                System.out.printf("%d ", toPrint.item);
                toPrint = toPrint.next;
            }
        }
        System.out.println();
    }

}