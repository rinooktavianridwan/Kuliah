package LP10_Collection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Main2 {

    public static void main(String[] args) {
        ArrayList<Pemain2> timA = new ArrayList<>();
        ArrayList<Pemain2> timB = new ArrayList<>();

        timA.add(new Pemain2(168, 50));
        timA.add(new Pemain2(170, 60));
        timA.add(new Pemain2(165, 56));
        timA.add(new Pemain2(168, 55));
        timA.add(new Pemain2(172, 60));
        timA.add(new Pemain2(170, 70));
        timA.add(new Pemain2(169, 66));
        timA.add(new Pemain2(165, 56));
        timA.add(new Pemain2(171, 72));
        timA.add(new Pemain2(166, 56));

        timB.add(new Pemain2(170, 66));
        timB.add(new Pemain2(167, 60));
        timB.add(new Pemain2(165, 59));
        timB.add(new Pemain2(166, 58));
        timB.add(new Pemain2(168, 58));
        timB.add(new Pemain2(175, 71));
        timB.add(new Pemain2(172, 68));
        timB.add(new Pemain2(171, 68));
        timB.add(new Pemain2(168, 65));
        timB.add(new Pemain2(169, 60));

        System.out.println("Jawaban Nomor 2 : ");
        // Mengurutkan data tim A dan tim B berdasarkan tinggi badan
        System.out.println("A. Data seluruh pemain : ");
        System.out.println("Seluruh data tim A:");
        printPemain(timA);
        System.out.println("\nSeluruh data tim B:");
        printPemain(timB);
        System.out.println("===============================================");

        System.out.println("\nB. Hasil pencarian tinggi badan di tim B : ");
        int targetTinggi1 = 168;
        int targetTinggi2 = 160;
        cariPemainTinggi(timB, targetTinggi1);
        cariPemainTinggi(timB, targetTinggi2);

        System.out.println("\nC. Hasil pencarian berat badan di tim A : ");
        int targetBerat1 = 56;
        int targetBerat2 = 53;
        cariPemainBerat(timA, targetBerat1);
        cariPemainBerat(timA, targetBerat2);

        System.out.println("\nD. Pemain di Tim A ada yang mempunyai tinggi badan atau berat badan yang sama dengan pemain di Tim B : ");
        cariPemainSama(timA, timB);
    }

    private static void printPemain(ArrayList<Pemain2> tim) {
        System.out.println("Tinggi Badan\t| Berat Badan");
        System.out.println("-----------------|--------------");
        for (Pemain2 pemain : tim) {
            System.out.printf("\t%4d\t|\t%4d\n", pemain.getTinggiBadan(), pemain.getBeratBadan());
        }
    }

    private static void cariPemainTinggi(ArrayList<Pemain2> tim, int target) {
        Collections.sort(tim, (p1, p2) -> p1.getTinggiBadan() - p2.getTinggiBadan());
        int index = Collections.binarySearch(tim, new Pemain2(target, 0), (p1, p2) -> p1.getTinggiBadan() - p2.getTinggiBadan());

        if (index >= 0) {
            System.out.println("Pemain dengan tinggi badan " + target + " cm ditemukan di tim.");
        } else {
            System.out.println("Pemain dengan tinggi badan " + target + " cm tidak ditemukan di tim.");
        }
    }

    private static void cariPemainBerat(ArrayList<Pemain2> tim, int target) {
        Collections.sort(tim, (p1, p2) -> p1.getBeratBadan() - p2.getBeratBadan());
        int index = Collections.binarySearch(tim, new Pemain2(0, target), (p1, p2) -> p1.getBeratBadan() - p2.getBeratBadan());

        if (index >= 0) {
            System.out.println("Pemain dengan berat badan " + target + " kg ditemukan di tim.");
        } else {
            System.out.println("Pemain dengan berat badan " + target + " kg tidak ditemukan di tim.");
        }
    }

    private static void cariPemainSama(ArrayList<Pemain2> timA, ArrayList<Pemain2> timB) {
        HashSet<Integer> pemainSamaBerat = new HashSet<>();
        HashSet<Integer> pemainSamaTinggi = new HashSet<>();

        for (Pemain2 pemainA : timA) {
            int indexTinggi = Collections.binarySearch(timB, pemainA, (p1, p2) -> p1.getTinggiBadan() - p2.getTinggiBadan());
            int indexBerat = Collections.binarySearch(timB, pemainA, (p1, p2) -> p1.getBeratBadan() - p2.getBeratBadan());

            if (indexTinggi >= 0 && !pemainSamaTinggi.contains(pemainA.getTinggiBadan())) {
                pemainSamaTinggi.add(pemainA.getTinggiBadan());
            }

            if (indexBerat >= 0 && !pemainSamaBerat.contains(pemainA.getBeratBadan())) {
                pemainSamaBerat.add(pemainA.getBeratBadan());
            }
        }

        if (!pemainSamaTinggi.isEmpty()) {
            System.out.println("Pemain dengan tinggi badan yang sama ditemukan di Tim A dan Tim B.");
            System.out.println("- Tinggi yang sama:");
            for (int tinggi : pemainSamaTinggi) {
                System.out.print(tinggi + " ");
            }
            System.out.println();
        } else {
            System.out.println("Tidak ada pemain di Tim A yang memiliki tinggi badan yang sama dengan pemain di Tim B.");
        }
        if (!pemainSamaBerat.isEmpty()) {
            System.out.println("Pemain dengan berat badan yang sama ditemukan di Tim A dan Tim B.");
            System.out.println("- Berat yang sama:");
            for (int berat : pemainSamaBerat) {
                System.out.print(berat + " ");
            }
            System.out.println();
        } else {
            System.out.println("Tidak ada pemain di Tim A yang memiliki berat badan yang sama dengan pemain di Tim B.");
        }
    }

}
