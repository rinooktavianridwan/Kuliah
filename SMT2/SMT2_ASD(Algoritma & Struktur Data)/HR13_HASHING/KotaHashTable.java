
package HR13_HASHING;

import java.util.Scanner;

public class KotaHashTable {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int ukuranHash = in.nextInt();
        HashTable HTOH = new HashTable(ukuranHash);
        int jumlahPerintah = in.nextInt();
        in.nextLine();
        String[] namaKota = in.nextLine().split(" ");
        if (!namaKota[0].equalsIgnoreCase("")) {
            for (int i = 0; i < namaKota.length; i++) {
                HTOH.insert(namaKota[i]);
            }
        }
        HTOH.printTable();
        System.out.println();
        for (int i = 0; i < jumlahPerintah; i++) {
            String[] perintah = in.nextLine().split(" ");
            if (perintah[0].equalsIgnoreCase("Cari")) {
                if (HTOH.search(perintah[1])) {
                    System.out.println("Kota ada di dalam tabel");
                } else {
                    System.out.println("Kota tidak ada di dalam tabel");
                }
            } else if (perintah[0].equalsIgnoreCase("Hapus")) {
                HTOH.delete(perintah[1]);
            } else if (perintah[0].equalsIgnoreCase("Tampilkan")) {
                HTOH.printTable();
            }
        }
    }

}

class HashTable {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named HashTable. */
    private SLL[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new SLL[size];
    }

    public void insert(String namaKota) {
        String ASCIIkode = getKodeKota(namaKota);
        System.out.println("Kode ASCII dari " + namaKota + " adalah " + ASCIIkode);
        int index = getIndexKota(ASCIIkode);
        int total = index % size;
        System.out.println("Index dari " + namaKota + " adalah " + total);
        // memasukkan ke dalam tabel
        if (table[total] == null) {
            table[total] = new SLL();
        }
        if (table[total].isExists(namaKota)) {
            return;
        }
        table[total].add(new NodeSLL(namaKota));
    }

    public boolean search(String namaKota) {
        String ASCIIkode = getKodeKota(namaKota);
        int index = getIndexKota(ASCIIkode);
        int total = index % size;
        if (table[total] == null) {
            return false;
        }
        return table[total].isExists(namaKota);
    }

    public void delete(String namaKota) {
        String ASCIIkode = getKodeKota(namaKota);
        int index = getIndexKota(ASCIIkode);
        int total = index % size;
        if (table[total] == null) {
            return;
        }
        table[total].remove(namaKota);
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + " -> ");
            if (table[i] == null) {
                System.out.println("[]");
            } else {
                table[i].print();
            }
        }
    }

    public String getKodeKota(String kota) {
        String kataASCII = "";
        for (int i = 0; i < kota.length(); i++) {
            char karakter = kota.charAt(i);
            kataASCII += (int) karakter;
        }
        return kataASCII;
    }

    public int getIndexKota(String kodeKota) {
        int digit2 = 0;
        int digit4 = 0;
        for (int i = 0; i < 4; i++) {
            String angka = "";
            if (i == 1) {
                angka += kodeKota.charAt(i);
                digit2 += Integer.parseInt(angka);
            }
            if (i == 3) {
                angka += kodeKota.charAt(i);
                digit4 += Integer.parseInt(angka);
            }
        }

        return (digit2 * 10 + digit4);
    }
}

class NodeSLL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeSLL. */
    String data;
    NodeSLL next;

    public NodeSLL(String data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named SLL. */
    NodeSLL head;
    NodeSLL tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(NodeSLL input) {
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void remove(String data) {
        NodeSLL pointer = head;
        NodeSLL prev = null;
        while (pointer != null) {
            if (data.equals(pointer.data)) {
                if (prev == null) {
                    head = pointer.next;
                } else {
                    prev.next = pointer.next;
                }
                System.out.println(pointer.data + " berhasil dihapus");
                size--;
                return;
            }
            prev = pointer;
            pointer = pointer.next;
        }
    }

    public boolean isExists(String data) {
        NodeSLL pointer = head;
        while (pointer != null) {
            if (data.equals(pointer.data)) {

                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void print() {
        NodeSLL pointer = head;
        System.out.print("[");
        while (pointer != null) {
            System.out.print(pointer.data);
            if (pointer.next != null) {
                System.out.print(", ");
            }
            pointer = pointer.next;
        }
        System.out.println("]");
    }

}