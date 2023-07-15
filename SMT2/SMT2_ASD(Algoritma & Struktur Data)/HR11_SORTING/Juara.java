package HR11_SORTING;

import java.util.Scanner;

public class Juara {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        DLL dataLombaKelompok = new DLL();
        int jumlahPerintah = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < jumlahPerintah; i++) {
            String perintah = in.nextLine();
            String[] kumPerintah = perintah.split(" ");
            if (perintah.equalsIgnoreCase("insert")) {
                String dataSemuaKelompok = in.nextLine();
                String[] dataSetiapKelompok = dataSemuaKelompok.split(";");
                int jumlahKelompok = 0;
                for (int j = 0; j < dataSetiapKelompok.length; j++) {
                    String dataKelompok[] = dataSetiapKelompok[j].split(" ");
                    int nilaiPemaparan = Integer.parseInt(dataKelompok[1]);
                    int nilaiKreativitas = Integer.parseInt(dataKelompok[2]);
                    int nilaiDiskusi = Integer.parseInt(dataKelompok[3]);
                    double totalNilai = (nilaiPemaparan * 20 / 100) + (nilaiKreativitas * 50 / 100) + (nilaiDiskusi * 30 / 100);
                    dataLombaKelompok.addLast(dataKelompok[0], totalNilai, Integer.parseInt(dataKelompok[4]), dataKelompok[5]);
                    jumlahKelompok++;
                }
                System.out.println("Berhasil memasukkan " + jumlahKelompok + " data kelompok");
            }
            if (kumPerintah[0].equalsIgnoreCase("find")) {
                if (kumPerintah[1].equalsIgnoreCase("umum")) {
                    dataLombaKelompok.findJuaraUmum();
                } else if (kumPerintah[1].equalsIgnoreCase("favorit")) {
                    dataLombaKelompok.findFavorit();
                } else if (kumPerintah[1].equalsIgnoreCase("lingkungan")) {
                    dataLombaKelompok.findLingkungan();
                } else if (kumPerintah[1].equalsIgnoreCase("kesehatan")) {
                    dataLombaKelompok.findKesehatan();
                } else if (kumPerintah[1].equalsIgnoreCase("teknologi")) {
                    dataLombaKelompok.findTeknologi();
                }
            }
        }
    }
}

class NodeDLL {

    String namaKelompok;
    double totalNilai;
    int jumlahVoting;
    String topik;
    NodeDLL next;
    NodeDLL prev;

    public NodeDLL(String namaKelompok, double totalNilai, int jumlahVoting, String topik) {
        this.namaKelompok = namaKelompok;
        this.totalNilai = totalNilai;
        this.jumlahVoting = jumlahVoting;
        this.topik = topik;
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

    public void addLast(String namaKelompok, double totalNilai, int jumlahVoting, String topik) {
        NodeDLL input = new NodeDLL(namaKelompok, totalNilai, jumlahVoting, topik);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void removeFirst() {
        head.prev = null;
        head = head.next;
        size--;
    }

    public void removeLast() {
        if (size == 1) {
            head.prev = null;
            head = head.next;
            size--;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void insertionSort() {
        if (size <= 1) {
            return;
        }

        NodeDLL current = head.next;

        while (current != null) {
            NodeDLL temp = current;
            double tempNilai = temp.totalNilai;
            String tempNamaKelompok = temp.namaKelompok;
            int tempJumlahVoting = temp.jumlahVoting;
            String tempTopik = temp.topik;

            while (temp.prev != null && temp.prev.totalNilai < tempNilai) {
                temp.totalNilai = temp.prev.totalNilai;
                temp.namaKelompok = temp.prev.namaKelompok;
                temp.jumlahVoting = temp.prev.jumlahVoting;
                temp.topik = temp.prev.topik;
                temp = temp.prev;
            }

            temp.totalNilai = tempNilai;
            temp.namaKelompok = tempNamaKelompok;
            temp.jumlahVoting = tempJumlahVoting;
            temp.topik = tempTopik;

            current = current.next;
        }
    }

    public void insertionSortFavorit() {
        if (size <= 1) {
            return;
        }

        NodeDLL current = head.next;

        while (current != null) {
            NodeDLL temp = current;
            int tempFavorit = temp.jumlahVoting;
            double tempTotalNilai = temp.totalNilai;
            String tempNamaKelompok = temp.namaKelompok;
            String tempTopik = temp.topik;

            while (temp.prev != null && temp.prev.jumlahVoting < tempFavorit) {
                temp.totalNilai = temp.prev.totalNilai;
                temp.namaKelompok = temp.prev.namaKelompok;
                temp.jumlahVoting = temp.prev.jumlahVoting;
                temp.topik = temp.prev.topik;
                temp = temp.prev;
            }

            temp.jumlahVoting = tempFavorit;
            temp.namaKelompok = tempNamaKelompok;
            temp.totalNilai = tempTotalNilai;
            temp.topik = tempTopik;

            current = current.next;
        }
    }

    public void findJuaraUmum() {
        insertionSort();
        NodeDLL pointer = head;
        int urutan = 1;
        System.out.println("Juara umum:");
        while (pointer != null) {
            if (urutan > 5) {
                break;
            }
            System.out.printf("%d. %s: %.0f, %d\n", urutan, pointer.namaKelompok, pointer.totalNilai, pointer.jumlahVoting);
            pointer = pointer.next;
            urutan++;
        }
        System.out.println();
    }

    public void findFavorit() {
        insertionSortFavorit();
        System.out.println("Juara favorit:");
        NodeDLL pointer = head;
        int urutan = 1;
        while (pointer != null) {
            if (urutan > 2) {
                break;
            }
            System.out.printf("%d. %s: %.0f, %d\n", urutan, pointer.namaKelompok, pointer.totalNilai, pointer.jumlahVoting);
            pointer = pointer.next;
            urutan++;
        }
        System.out.println();
    }

    public void print() {
        NodeDLL pointer = head;
        int urutan = 1;
        while (pointer != null) {
            if (urutan > 3) {
                break;
            }
            System.out.printf("%d. %s: %.0f, %d\n", urutan, pointer.namaKelompok, pointer.totalNilai, pointer.jumlahVoting);
            pointer = pointer.next;
            urutan++;
        }
        System.out.println();
    }

    public void findLingkungan() {
        DLL lingkungan = new DLL();
        NodeDLL pointer = head;
        while (pointer != null) {
            if (pointer.topik.equalsIgnoreCase("lingkungan")) {
                lingkungan.addLast(pointer.namaKelompok, pointer.totalNilai, pointer.jumlahVoting, pointer.topik);
            }
            pointer = pointer.next;
        }
        lingkungan.insertionSort();
        System.out.println("Juara lingkungan:");
        lingkungan.print();
    }

    public void findKesehatan() {
        DLL kesehatan = new DLL();
        NodeDLL pointer = head;
        while (pointer != null) {
            if (pointer.topik.equalsIgnoreCase("kesehatan")) {
                kesehatan.addLast(pointer.namaKelompok, pointer.totalNilai, pointer.jumlahVoting, pointer.topik);
            }
            pointer = pointer.next;
        }
        kesehatan.insertionSort();
        System.out.println("Juara kesehatan:");
        kesehatan.print();
    }

    public void findTeknologi() {
        DLL teknologi = new DLL();
        NodeDLL pointer = head;
        while (pointer != null) {
            if (pointer.topik.equalsIgnoreCase("teknologi")) {
                teknologi.addLast(pointer.namaKelompok, pointer.totalNilai, pointer.jumlahVoting, pointer.topik);
            }
            pointer = pointer.next;
        }
        teknologi.insertionSort();
        System.out.println("Juara teknologi:");
        teknologi.print();
    }
}
