package HR11_SORTING;

import java.util.Scanner;

public class Wishlist_THR {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        DLL listBarang = new DLL();
        Scanner in = new Scanner(System.in);
        int jumlahBarang = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        for (int i = 0; i < jumlahBarang; i++) {
            String masukanBarang = in.nextLine();
            String daftarBarang[] = masukanBarang.split(" ");
            listBarang.addLast(daftarBarang[0], Integer.parseInt(daftarBarang[1]));
        }
        int jumlahUang = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        listBarang.insertionSort();
        listBarang.printToLast();
        listBarang.recomendationSpent(jumlahUang);

    }
}

class NodeDLL {

    String namaBarang;
    int harga;
    NodeDLL next;
    NodeDLL prev;

    public NodeDLL(String namaBarang, int data) {
        this.namaBarang = namaBarang;
        this.harga = data;
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
            int tempHarga = temp.harga;
            String tempNamaBarang = temp.namaBarang;

            while (temp.prev != null && temp.prev.harga > tempHarga) {
                temp.harga = temp.prev.harga;
                temp.namaBarang = temp.prev.namaBarang;
                temp = temp.prev;
            }

            temp.harga = tempHarga;
            temp.namaBarang = tempNamaBarang;

            current = current.next;
        }
    }

    public void recomendationSpent(int batasHarga) {
        NodeDLL pointer = head;
        int totalSpent = 0;
        System.out.println("Recommendation:");
        System.out.print("Items bought = ");
        boolean barangPertama = true;

        while (pointer != null) {
            totalSpent += pointer.harga;
            if (totalSpent > batasHarga) {
                totalSpent -= pointer.harga;
                break;
            } else {
                if (barangPertama) {
                    System.out.print(pointer.namaBarang);
                    barangPertama = false;
                } else {
                    System.out.print(", " + pointer.namaBarang);
                }
                pointer = pointer.next;
            }
        }
        System.out.println();
        System.out.println("Total spent = " + totalSpent);
    }

    public void printToLast() {
        NodeDLL pointer = head;
        System.out.println("Sorted Wishlist:");
        while (pointer != null) {
            System.out.println(pointer.namaBarang + " = " + pointer.harga);
            pointer = pointer.next;
        }
        System.out.println();
    }

}
