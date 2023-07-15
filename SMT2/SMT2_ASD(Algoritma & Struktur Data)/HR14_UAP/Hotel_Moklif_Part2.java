package HR14_UAP;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    private String name;
    private Node helper;
    private List<Edge> edges;
    private int distance;
    private Node previous;

    public Node(String name) {
        this.name = name;
        edges = new ArrayList<>();
        distance = Integer.MAX_VALUE;
        previous = null;
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Node destination, int weight) {
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        edges.add(new Edge(destination, weight));
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return helper;
    }

    public void setNext(Node next) {
        this.helper = next;
    }
}

class Edge {
    private Node destination;
    private int weight;

    public Edge(Node destination, int weight) {
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        this.destination = destination;
        this.weight = weight;
    }

    public Node getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}

class Graph {
    private Node head;
    private List<Node> nodes = new ArrayList<>();

    public void setKota(Node kota) {
        if (head == null) {
            head = kota;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(kota);
        }
        nodes.add(kota);
    }

    public Node getKota(String nama) {
        for (Node nodeTemp : nodes) {
            if (nodeTemp.getName().equals(nama)) {
                return nodeTemp;
            }
        }
        return null;
    }

    public void computeShortestPaths(Node source) {
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        source.setDistance(0);

        List<Node> daftarGraph = new ArrayList<>();
        daftarGraph.add(source);

        while (!daftarGraph.isEmpty()) {
            Node current = daftarGraph.remove(0);
            for (Edge edge : current.getEdges()) {
                int newDistanceKota = current.getDistance() + edge.getWeight();
                if (newDistanceKota < edge.getDestination().getDistance()) {
                    edge.getDestination().setDistance(newDistanceKota);
                    edge.getDestination().setPrevious(current);
                    if (!daftarGraph.contains(edge.getDestination())) {
                        daftarGraph.add(edge.getDestination());
                    }
                }
            }
        }
    }

    public List<Node> getShortestPathTo(Node target) {
        List<Node> path = new ArrayList<>();
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        Node current = target;
        while (current != null) {
            path.add(0, current);
            current = current.getPrevious();
        }
        return path;
    }
}

public class Hotel_Moklif_Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        // Membuat node dari A hingga H      
        for (int i = 0; i < 8; i++) {
            char name = (char) ('A' + i);
            Node newNode = new Node(String.valueOf(name));
            graph.setKota(newNode);
        }

        // Input nama destinasi dan banyak edge yang dibuat
        String destination = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();

        // Looping menginput edge
        for (int i = 0; i < n; i++) {
            String edgesInput = scanner.nextLine();
            String[] edges = edgesInput.split(" ");
            String namaAsal = edges[0];
            String namaTujuan = edges[1];
            int weight = Integer.parseInt(edges[2]);

            Node kotaAsal = graph.getKota(namaAsal);
            Node kotaTujuan = graph.getKota(namaTujuan);

            kotaAsal.addEdge(kotaTujuan, weight);
            kotaTujuan.addEdge(kotaAsal, weight); 
        }

        // Mencari rute terdekat
        graph.computeShortestPaths(graph.getKota("A"));
        Node destinationNode = graph.getKota(destination);
        List<Node> path = graph.getShortestPathTo(destinationNode);

        // Mencetak rute dan jarak ke kota tujuan
        for (Node node : path) {
            System.out.print(node.getName() + " ");
        }
        System.out.println();
        System.out.println(destinationNode.getDistance());
    }
}
