package LP10_Collection2;

import java.util.ArrayList;

class Main1 {

    public static void main(String[] args) {
        ArrayList<Pemain> teamA = new ArrayList<>();
        ArrayList<Pemain> teamB = new ArrayList<>();
        ArrayList<Pemain> teamC = new ArrayList<>();

        teamA.add(new Pemain(168, 50));
        teamA.add(new Pemain(170, 60));
        teamA.add(new Pemain(165, 56));
        teamA.add(new Pemain(168, 55));
        teamA.add(new Pemain(172, 60));
        teamA.add(new Pemain(170, 70));
        teamA.add(new Pemain(169, 66));
        teamA.add(new Pemain(165, 56));
        teamA.add(new Pemain(171, 72));
        teamA.add(new Pemain(166, 56));

        teamB.add(new Pemain(170, 66));
        teamB.add(new Pemain(167, 60));
        teamB.add(new Pemain(165, 59));
        teamB.add(new Pemain(166, 58));
        teamB.add(new Pemain(168, 58));
        teamB.add(new Pemain(175, 71));
        teamB.add(new Pemain(172, 68));
        teamB.add(new Pemain(171, 68));
        teamB.add(new Pemain(168, 65));
        teamB.add(new Pemain(169, 60));

        System.out.println("Jawaban nomer 1 : ");
        // a. Urutkan tinggi badan pemain secara menaik dan kemudian menurun
        System.out.println("A. Urutan tinggi badan secara menaik (ascending)");
        System.out.println("- Tim A : ");
        Pemain.urutkanTinggiBadan(teamA);
        Pemain.printPemain(teamA);
        System.out.println("- Tim B : ");
        Pemain.urutkanTinggiBadan(teamB);
        Pemain.printPemain(teamB);

        System.out.println("Urutan tinggi badan secara menurun (descending)");
        System.out.println("- Tim A : ");
        Pemain.urutkanTinggiBadanMenurun(teamA);
        Pemain.printPemain(teamA);
        System.out.println("Urutan tinggi badan secara menurun (descending)");
        System.out.println("- Tim B : ");
        Pemain.urutkanTinggiBadanMenurun(teamB);
        Pemain.printPemain(teamB);
        System.out.println("===============================================");

        // b. Urutkan berat badan pemain secara menaik dan kemudian menurun
        System.out.println("B. Urutan berat badan secara menaik (ascending)");
        System.out.println("- Tim A : ");
        Pemain.urutkanBeratBadan(teamA);
        Pemain.printPemain(teamA);
        System.out.println("- Tim B : ");
        Pemain.urutkanBeratBadan(teamB);
        Pemain.printPemain(teamB);
        System.out.println("Urutan berat badan secara menurun (descending) - Tim 2:");
        System.out.println("- Tim A : ");
        Pemain.urutkanBeratBadanMenurun(teamA);
        Pemain.printPemain(teamA);
        System.out.println("- Tim B : ");
        Pemain.urutkanBeratBadanMenurun(teamB);
        Pemain.printPemain(teamB);
        System.out.println("===============================================");

        // c. Cari nilai maksimum dan minimum Tinggi Badan dan Berat Badan untuk pemain dari masing-masing tim
        System.out.println("C. Nilai maksimum dan minimum : ");
        System.out.println("- Tim A : ");
        Pemain.cariNilaiMaxMin(teamA);
        System.out.println("- Tim B : ");
        Pemain.cariNilaiMaxMin(teamB);
        System.out.println("===============================================");

        // d. Copy seluruh anggota Tim 2 ke Tim 3 yang baru dibentuk
        System.out.println("D. Anggota tim semula beserta tim C hasil copy dari tim B : ");
        Pemain.copyTim(teamB, teamC);
        System.out.println("Tim 1:");
        Pemain.printPemain(teamA);
        System.out.println("Tim 2:");
        Pemain.printPemain(teamB);
        System.out.println("Tim 3 (copy dari Tim 2):");
        Pemain.printPemain(teamC);
    }
}
