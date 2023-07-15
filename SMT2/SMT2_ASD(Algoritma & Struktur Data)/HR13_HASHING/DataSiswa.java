package HR13_HASHING;

import java.util.Scanner;

public class DataSiswa {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sizeHashtable = in.nextInt();
        HashTable HT = new HashTable(sizeHashtable);
        int jumlahPerintah = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < jumlahPerintah; i++) {
            String perintah = in.nextLine().trim();
            if (perintah.equalsIgnoreCase("tambah")) {
                String[] dataSiswa = in.nextLine().split(";");
                for (int j = 0; j < dataSiswa.length; j++) {
                    String[] siswa = dataSiswa[j].split(" ");
                    String namaSiswa = "";
                    for (int k = 1; k < siswa.length; k++) {
                        namaSiswa += siswa[k];
                        if(k<siswa.length-1){
                            namaSiswa+=" ";
                        }
                    }
                    HT.insert(Integer.parseInt(siswa[0]), namaSiswa);
                }
                System.out.println("Berhasil memasukkan " + dataSiswa.length + " data siswa");

            } else if (perintah.equalsIgnoreCase("cari")) {
                int nisSiswa = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();
                }
                HT.search(nisSiswa);

            } else if (perintah.equalsIgnoreCase("hapus")) {
                int nisSiswa = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();
                }
                HT.delete(nisSiswa);

            }
        }
    }
}

class HashTable {

    private int[] NIS;
    private String[] namaSiswa;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.NIS = new int[size];
        this.namaSiswa = new String[size];
    }

    public void insert(int nis, String nama) {
        int indexHash = nis % size;
        // proses hashing
        if (NIS[indexHash] == 0) {
            NIS[indexHash] = nis;
            namaSiswa[indexHash] = nama;
        } else {
            int initialIndex = indexHash;
            while (true) {
                indexHash = (indexHash + 1) % size;
                if (indexHash == initialIndex) {
                    System.out.println("Tabel hash penuh");
                    return;
                }
                if (NIS[indexHash] == 0) {
                    NIS[indexHash] = nis;
                    namaSiswa[indexHash] = nama;
                    return;
                }
            }
        }
    }

    public void search(int nis) {
        int indexHash = nis % size;
        // Mencari di dalam tabel dengan linear probing
        int initialIndex = indexHash;
        while (true) {
            if (NIS[indexHash] == nis) {
                System.out.println("NIS " + nis + " adalah " + namaSiswa[indexHash] + ", ditemukan pada indeks " + indexHash);
                return;
            }
            indexHash = (indexHash + 1) % size;
            if (indexHash == initialIndex) {
                break;
            }
        }
        System.out.println("Data siswa dengan NIS " + nis + " tidak ditemukan");
    }

    public void delete(int nis) {
        int indexHash = nis % size;
        // Menghapus data dengan linear probing
        int initialIndex = indexHash;
        while (true) {
            if (NIS[indexHash] == nis) {
                NIS[indexHash] = 0;
                namaSiswa[indexHash] = null;
                System.out.println("Data siswa dengan NIS " + nis + " berhasil dihapus");
                return;
            }
            indexHash = (indexHash + 1) % size;
            if (indexHash == initialIndex) {
                break;
            }
        }
        System.out.println("Data siswa dengan NIS " + nis + " tidak ditemukan");
    }
}
