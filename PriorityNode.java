package m;

import static m.Main.UP;
import static m.Main.DOWN;

public class PriorityNode {
    public int item;
    public PriorityNode next;
    public int priority;

    public PriorityNode() { // empty
        next = null;
    }

    public PriorityNode(int val) { // with specialized value
        item = val;
        next = null;
    }

    public static PriorityNode createRandomNode() { // random value
        PriorityNode newNode = new PriorityNode();
        newNode.item = (int) (Math.random() * (UP - DOWN + 1)) + DOWN;
        newNode.priority = Integer.parseInt(Character.toString(Integer.toString(newNode.item).charAt(0)));
        return newNode;
    }
}
