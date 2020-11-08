package m;

import static m.Main.UP;
import static m.Main.DOWN;

public class Node {
    public int item;
    public Node next;

    public Node() {
        next = null;
    }

    public Node(int val) {
        item = val;
        next = null;
    }

    public static Node createRandomNode() {
        Node newNode = new Node();
        newNode.item = (int) (Math.random() * (UP - DOWN + 1)) + DOWN;
        return newNode;
    }
}