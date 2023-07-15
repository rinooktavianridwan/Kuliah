package HR5_Queue;

import java.util.Scanner;

public class Manajemen_Tugas {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PQ catatanTugas = new PQ();
        Scanner in = new Scanner(System.in);
        int jumlah = in.nextInt();
        in.nextLine();
        for (int i = 0; i < jumlah; i++) {
            String perintah = in.nextLine();
            if (perintah.equals("ADD")) {
                String namaTugas = in.nextLine();
                int priority = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();
                }
                catatanTugas.enqueue(namaTugas, priority);
                System.out.println("Task " + '"' + namaTugas + '"' + " has been added with priority " + priority);
            } else if (perintah.equals("EXECUTE")) {
                catatanTugas.dequeue();
            } else if (perintah.equals("DISPLAY")) {
                catatanTugas.print();
            }

        }
    }
}

class NodePQ {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodePQ. */
    String namaTugas;
    int priority;
    NodePQ next;

    public NodePQ(String namaTugas, int priority) {
        this.namaTugas = namaTugas;
        this.priority = priority;
        this.next = null;
    }
}

class PQ {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named PQ. */
    NodePQ head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public void enqueue(String namaTugas, int priority) {
        NodePQ input = new NodePQ(namaTugas, priority);
        if (size == 0) {
            head = tail = input;

        } else {
            if (input.priority < head.priority) {
                input.next = head;
                head = input;
            } else {
                NodePQ pointer = head;
                while (pointer.next != null && pointer.next.priority <= input.priority) {
                    pointer = pointer.next;
                }
                input.next = pointer.next;
                pointer.next = input;
            }
        }
        size++;
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("No tasks left to execute");
        }
        if (size != 0) {
            System.out.println("Executing task " + '"' + head.namaTugas + '"' + " with priority " + head.priority);
            head = head.next;
            size--;
        }
    }

    public void print() {
        NodePQ pointer = head;
        if (size == 0) {
            System.out.println("No tasks in the queue");
        } else {
            System.out.println();
            System.out.println("Tasks in the queue:");
            while (pointer != null) {
                System.out.println("- " + pointer.namaTugas + " (priority " + pointer.priority + ")");
                pointer = pointer.next;
            }
            System.out.println();
        }
    }
}
