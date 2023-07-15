package HR12_SEARCHING;

import java.util.Scanner;

public class Username_Instagram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);

        String cariHuruf = "";
        if (in.hasNextLine()) {
            cariHuruf = in.nextLine().trim();
        }
        String username = "";
        if (in.hasNextLine()) {
            username = in.nextLine().trim();
        }
        if ("".equals(username) || "".equals(cariHuruf)) {

        } else {
            cariIndex(cariHuruf, username);
        }
    }

    public static void cariIndex(String cariHuruf, String username) {
        DLL ui = new DLL();
        System.out.println("Hasil Searching");
        String[] kumplanUser = username.split(" ");
        for (int i = 0; i < kumplanUser.length; i++) {
            int count = 0;
            String[] perKalimat = kumplanUser[i].split("");
            for (int j = 0; j < kumplanUser[i].length(); j++) {
                if (perKalimat[j].equalsIgnoreCase(cariHuruf)) {
                    count++;
                }
            }
            ui.addLast(kumplanUser[i], count);

        }
        ui.insertionSort();
        ui.printToLast();

    }
}

class NodeDLL {

    String userName;
    int count;
    NodeDLL next;
    NodeDLL prev;

    public NodeDLL(String namaBarang, int data) {
        this.userName = namaBarang;
        this.count = data;
        this.next = null;
        this.prev = null;
    }
}

class DLL {

    NodeDLL head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(String namaBarang, int data) {
        NodeDLL input = new NodeDLL(namaBarang, data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void insertionSort() {
        if (size <= 1) {
            return;
        }

        NodeDLL current = head.next;

        while (current != null) {
            NodeDLL temp = current;
            int tempHarga = temp.count;
            String tempNamaBarang = temp.userName;

            while (temp.prev != null && temp.prev.count > tempHarga) {
                temp.count = temp.prev.count;
                temp.userName = temp.prev.userName;
                temp = temp.prev;
            }

            temp.count = tempHarga;
            temp.userName = tempNamaBarang;

            current = current.next;
        }
    }

    public void printToLast() {
        NodeDLL pointer = head;
        while (pointer != null) {
            System.out.println(pointer.userName + " = " + pointer.count);
            pointer = pointer.next;
        }
    }

}
