package HR10_GRAPH;

import java.util.Scanner;

public class Weighted_Graph_List {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int ukuranGraph = in.nextInt();
        in.nextLine();
        WeightedUL wul = new WeightedUL(ukuranGraph);
        WeightedDL wdl = new WeightedDL(ukuranGraph);

        String Weighted_Undigraph_List = in.nextLine();
        String[] kumpulan_WUL = Weighted_Undigraph_List.split(" ");
        for (int i = 0; i < kumpulan_WUL.length; i++) {
            String[] masukanGraph = kumpulan_WUL[i].split(",");
            wul.addEdge(Integer.parseInt(masukanGraph[0]), Integer.parseInt(masukanGraph[1]), Integer.parseInt(masukanGraph[2]));

        }
        String Weighted_Digraph_List = in.nextLine();
        String[] kumpulan_WDL = Weighted_Digraph_List.split(" ");
        for (int i = 0; i < kumpulan_WDL.length; i++) {
            String[] masukanGraph = kumpulan_WDL[i].split(",");
            wdl.addEdge(Integer.parseInt(masukanGraph[0]), Integer.parseInt(masukanGraph[1]), Integer.parseInt(masukanGraph[2]));

        }

        //Output
        System.out.println("Weighted Undigraph List");
        wul.getNodes();
        wul.printList();
        wul.BFS(1);
        wul.DFS(1);
        System.out.println();
        System.out.println("Weighted Digraph List");
        wdl.getNodes();
        wdl.printList();
        wdl.BFS(1);
        wdl.DFS(1);
    }
}

class NodeGL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeGL. */
    int data;
    int weight;
    NodeGL next;

    public NodeGL(int data, int weight) {
        this.weight = weight;
        this.data = data;
        this.next = null;
    }
}

class WeightedUL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named WeightedUL. */
    int size;
    NodeGL[] barisan;

    public WeightedUL(int size) {
        this.size = size;
        barisan = new NodeGL[size];
    }

    public void addEdge(int node1, int node2, int weight) {
        // koneksi node1 ke node2
        if (barisan[node1 - 1] == null) {
            barisan[node1 - 1] = new NodeGL(node2, weight);
        } else {
            NodeGL pointer = barisan[node1 - 1];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new NodeGL(node2, weight);
        }
        // koneksi node2 ke node1
        if (barisan[node2 - 1] == null) {
            barisan[node2 - 1] = new NodeGL(node1, weight);
        } else {
            NodeGL pointer = barisan[node2 - 1];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new NodeGL(node1, weight);
        }
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " -> ");
            NodeGL pointer = barisan[i];
            while (pointer != null) {
                System.out.print(pointer.data + " (" + pointer.weight + ")");
                if (pointer.next != null) {
                    System.out.print(" -> ");
                }
                pointer = pointer.next;
            }
            System.out.println();
        }
    }

    public void getNodes() {
        System.out.print("Nodes: ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[size];
        Queue queue = new Queue();
        visited[start - 1] = true;
        queue.enqueue(start);
        System.out.print("BFS: ");
        while (queue.getSize() != 0) {
            start = queue.poll();
            System.out.print(start + " ");

            NodeGL pointer = barisan[start - 1];
            while (pointer != null) {
                int neighbor = pointer.data;
                if (!visited[neighbor - 1]) {
                    visited[neighbor - 1] = true;
                    queue.enqueue(neighbor);
                }
                pointer = pointer.next;
            }
        }
        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[size];
        System.out.print("DFS: ");
        DFS(start, visited);
        System.out.println();
    }

    public void DFS(int start, boolean[] visited) {
        visited[start - 1] = true;
        System.out.print(start + " ");
        NodeGL pointer = barisan[start - 1];
        while (pointer != null) {
            int neighbor = pointer.data;
            if (!visited[neighbor - 1]) {
                DFS(neighbor, visited);
            }
            pointer = pointer.next;
        }
    }
}

class WeightedDL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named WeightedDL. */
    NodeGL[] barisan;
    int size;

    public WeightedDL(int size) {
        this.size = size;
        barisan = new NodeGL[size];
    }

    public void getNodes() {
        System.out.print("Nodes: ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void addEdge(int node1, int node2, int weight) {
        if (barisan[node1 - 1] == null) {
            barisan[node1 - 1] = new NodeGL(node2, weight);
        } else {
            NodeGL pointer = barisan[node1 - 1];
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = new NodeGL(node2, weight);
        }
    }

    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + " -> ");
            NodeGL pointer = barisan[i];
            while (pointer != null) {
                System.out.print(pointer.data + " (" + pointer.weight + ")");
                if (pointer.next != null) {
                    System.out.print(" -> ");
                }
                pointer = pointer.next;
            }
            System.out.println();
        }
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[size];
        Queue queue = new Queue();
        visited[start - 1] = true;
        queue.enqueue(start);
        System.out.print("BFS: ");
        while (queue.getSize() != 0) {
            start = queue.poll();
            System.out.print(start + " ");

            NodeGL pointer = barisan[start - 1];
            while (pointer != null) {
                int neighbor = pointer.data;
                if (!visited[neighbor - 1]) {
                    visited[neighbor - 1] = true;
                    queue.enqueue(neighbor);
                }
                pointer = pointer.next;
            }
        }
        System.out.println();
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[size];
        System.out.print("DFS: ");
        DFS(start, visited);
        System.out.println();
    }

    public void DFS(int start, boolean[] visited) {
        visited[start - 1] = true;
        System.out.print(start + " ");
        NodeGL pointer = barisan[start - 1];
        while (pointer != null) {
            int neighbor = pointer.data;
            if (!visited[neighbor - 1]) {
                DFS(neighbor, visited);
            }
            pointer = pointer.next;
        }
    }
}

class NodeQueue {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeQueue. */
    int data;
    NodeQueue next;

    public NodeQueue(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Queue. */
    NodeQueue head, tail;
    int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) {
        NodeQueue input = new NodeQueue(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public int poll() {
        int temp = head.data;
        dequeue();
        return temp;
    }
}
