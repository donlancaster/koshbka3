package m;

import java.util.ArrayList;

public class CombinedQueue {
    public PriorityQueue priorityQueue;
    public ArrayList<WeighedQueue> weighedQueues;
    public CombinedQueue processed;
    public int size;

    public void process() {
        if (priorityQueue == null || weighedQueues == null || size == 0) {
            System.out.println("Некоторые параметры комбинированной очереди не настроены.\nНастройте параметры и повторите попытку");
            return;
        }
        processed = initProcessedQueue();
        int remaining = size;
        for (; remaining != 0 && priorityQueue.size != 0; remaining--) {
            processed.priorityQueue.insert(new PriorityNode(priorityQueue.extract().item));
            processed.size++;
        }
        if (remaining != 0) {
            int j = 0;
            for (WeighedQueue wq : weighedQueues) {
                int toProcess = (int) Math.floor(remaining * wq.rate);
                if (toProcess <= wq.size) {
                    for (int i = 0; i < toProcess; i++) {
                        processed.weighedQueues.get(j).insert(new Node(wq.extract().item));
                        processed.size++;
                    }
                } else {
                    for (int i = 0; i < wq.size; i++) {
                        processed.weighedQueues.get(j).insert(new Node(wq.extract().item));
                        processed.size++;
                    }
                }
                j++;
            }
        }
    }

    private CombinedQueue initProcessedQueue() {
        CombinedQueue toReturn = new CombinedQueue();
        toReturn.priorityQueue = new PriorityQueue();
        toReturn.weighedQueues = new ArrayList<>(weighedQueues.size());
        for (int i = 0; i < weighedQueues.size(); i++) {
            toReturn.weighedQueues.add(new WeighedQueue(weighedQueues.get(i).rate));
        }
        return toReturn;
    }

    public void print() {
        System.out.print("Приоритетная очередь: ");
        priorityQueue.print();
        for (int i = 0; i < weighedQueues.size(); i++) {
            System.out.print("Взвешенная очередь [" + i + "]: ");
            weighedQueues.get(i).print();
        }
    }

    public int getDataSize() {
        int size = priorityQueue.size;
        for (int i = 0; i < weighedQueues.size(); i++) {
            size += weighedQueues.get(i).size;
        }
        return size;
    }

}