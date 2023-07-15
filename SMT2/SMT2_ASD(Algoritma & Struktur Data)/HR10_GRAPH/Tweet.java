package HR10_GRAPH;

import java.util.Scanner;

public class Tweet {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DigraphMatrix DM = new DigraphMatrix(20);
        int jumlahPerintah = in.nextInt();
        in.nextLine();
        for (int i = 0; i < jumlahPerintah; i++) {
            String perintah = in.next().trim();
            if (perintah.equalsIgnoreCase("insert")) {
                String nama = in.next().trim();
                DM.addNama(nama);
            } else if (perintah.equalsIgnoreCase("connect")) {
                String nama1 = in.next().trim();
                String nama2 = in.next().trim();
                DM.addHubungan(nama1, nama2);
            } else if (perintah.equalsIgnoreCase("mostfollowed")) {
                DM.mostfollowed();
            } else if (perintah.equalsIgnoreCase("numgroups")) {
                DM.numGroups();
            } else if (perintah.equalsIgnoreCase("followers")) {
                String nama = in.next().trim();
                DM.followers(nama);
            }
        }
    }
}

class DigraphMatrix {

    int[][] data;
    int size;
    String[] namaPemain;
    int jumlahOrang;

    public DigraphMatrix(int size) {
        this.size = size;
        data = new int[size][size];
        namaPemain = new String[size];
        jumlahOrang = 0;
    }

    public void addNama(String nama) {
        if (cekNama(nama)) {
            System.out.println(nama + " already exists");
        } else {
            namaPemain[jumlahOrang] = nama;
            jumlahOrang++;
            System.out.println(nama + " inserted");
        }
    }

    public boolean cekNama(String nama) {
        for (int i = 0; i < jumlahOrang; i++) {
            if (namaPemain[i].equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public void addHubungan(String nama1, String nama2) {
        int cekNama1 = posisiNama(nama1);
        int cekNama2 = posisiNama(nama2);
        if (cekNama1 != -1 && cekNama2 != -1) {
            data[cekNama1][cekNama2] = 1;
            System.out.println("connect " + nama1 + " with " + nama2 + " success");
        } else {
            if (cekNama1 == -1 && cekNama2 != -1) {
                System.out.println("username " + nama1 + " not found");
            } else if (cekNama1 != -1 && cekNama2 == -1) {
                System.out.println("username " + nama2 + " not found");
            } else if (cekNama1 == -1 && cekNama2 == -1) {
                System.out.println("username " + nama1 + " and " + nama2 + " not found ");
            }
        }
    }

    private int posisiNama(String nama) {
        for (int i = 0; i < jumlahOrang; i++) {
            if (namaPemain[i].equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1;
    }

    public void mostfollowed() {
        int[] followersTerbanyak = new int[jumlahOrang];
        for (int i = 0; i < jumlahOrang; i++) {
            for (int j = 0; j < jumlahOrang; j++) {
                followersTerbanyak[i] += data[j][i];
            }
        }

        int maxFollowers = 0;
        int banyaknyaOrangTerbanyak = 0;
        String[] kumpulanHasilOrang = new String[jumlahOrang];

        for (int i = 0; i < jumlahOrang; i++) {
            if (followersTerbanyak[i] > maxFollowers) {
                kumpulanHasilOrang = new String[jumlahOrang];
                maxFollowers = followersTerbanyak[i];
                banyaknyaOrangTerbanyak = 1;
                kumpulanHasilOrang[0] = namaPemain[i];
            } else if (followersTerbanyak[i] == maxFollowers) {
                kumpulanHasilOrang[banyaknyaOrangTerbanyak] = namaPemain[i];
                banyaknyaOrangTerbanyak++;
            }
        }

        if (banyaknyaOrangTerbanyak == 0) {
            System.out.println("");
        } else {
            for (int i = 0; i < banyaknyaOrangTerbanyak; i++) {
                System.out.print(kumpulanHasilOrang[i]);
                if (i < banyaknyaOrangTerbanyak - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" with " + maxFollowers + " total followers");
        }
    }

    public void numGroups() {
        int[][] groups1 = new int[jumlahOrang][jumlahOrang];

        // Inisialisasi array groups1
        for (int i = 0; i < jumlahOrang; i++) {
            for (int j = 0; j < jumlahOrang; j++) {
                if (i == j) {
                    groups1[i][j] = 1;
                } else {
                    groups1[i][j] = data[i][j];
                }
            }
        }
        
        for (int i = 0; i < jumlahOrang; i++) {
            for (int j = 0; j < jumlahOrang; j++) {
                System.out.print(groups1[i][j]+ " ");
            }
            System.out.println();
        }

        // Periksa elemen yang sama pada array groups1 dan ubah array groups2
        int groupCount = 0;
        for (int i = 0; i < jumlahOrang; i++) {
            for (int j = 0; j < jumlahOrang; j++) {
                if (cekAngka(groups1[i]) && cekAngka(groups1[j]) && i != j) {
                    if (cekSama(groups1[i], groups1[j])) {
                        groups1[i] = gabunganAnggota(groups1[i], groups1[j]);
                    }
                }
            }
        }

        for (int i = 0; i < jumlahOrang; i++) {
            if (cekAngka(groups1[i])) {
                groupCount += 1;
            }
        }
        System.out.println("number of groups: " + groupCount);
    }

    public boolean cekAngka(int array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean cekSama(int array1[], int array2[]) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 1 && array2[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public int[] gabunganAnggota(int array1[], int array2[]) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 1 || array2[i] == 1) {
                array1[i] = 1;
                array2[i] = 0;
            }
        }
        return array1;
    }

    public void followers(String nama) {
        int userIndex = posisiNama(nama);
        if (userIndex != -1) {
            int jumlah = 0;
            for (int i = 0; i < jumlahOrang; i++) {
                jumlah += data[i][userIndex];
            }
            System.out.println(jumlah);
        } else {
            System.out.println("Username " + nama + " not found");
        }
    }

}
