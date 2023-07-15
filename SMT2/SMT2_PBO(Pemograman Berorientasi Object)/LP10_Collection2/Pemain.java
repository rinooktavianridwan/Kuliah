package LP10_Collection2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Pemain {

    private int tinggiBadan;
    private int beratBadan;

    public Pemain(int tinggiBadan, int beratBadan) {
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    public int getTinggiBadan() {
        return tinggiBadan;
    }

    public int getBeratBadan() {
        return beratBadan;
    }

    public static void urutkanTinggiBadan(ArrayList<Pemain> team) {
        Collections.sort(team, Comparator.comparingInt(Pemain::getTinggiBadan));
    }

    public static void urutkanBeratBadan(ArrayList<Pemain> team) {
        Collections.sort(team, Comparator.comparingInt(Pemain::getBeratBadan));
    }

    public static void urutkanTinggiBadanMenurun(ArrayList<Pemain> team) {
        Collections.sort(team, Comparator.comparingInt(Pemain::getTinggiBadan).reversed());
    }

    public static void urutkanBeratBadanMenurun(ArrayList<Pemain> team) {
        Collections.sort(team, Comparator.comparingInt(Pemain::getBeratBadan).reversed());
    }

    public static void printPemain(ArrayList<Pemain> team) {
        System.out.println("Tinggi Badan\t| Berat Badan");
        System.out.println("-----------------|--------------");
        for (Pemain pemain : team) {
            System.out.printf("\t%4d\t|\t%4d\n", pemain.getTinggiBadan(), pemain.getBeratBadan());
        }
        System.out.println();
    }

    public static void cariNilaiMaxMin(ArrayList<Pemain> team) {
        int maxTinggiBadan = Integer.MIN_VALUE;
        int minTinggiBadan = Integer.MAX_VALUE;
        int maxBeratBadan = Integer.MIN_VALUE;
        int minBeratBadan = Integer.MAX_VALUE;

        for (Pemain pemain : team) {
            maxTinggiBadan = Math.max(maxTinggiBadan, pemain.getTinggiBadan());
            minTinggiBadan = Math.min(minTinggiBadan, pemain.getTinggiBadan());
            maxBeratBadan = Math.max(maxBeratBadan, pemain.getBeratBadan());
            minBeratBadan = Math.min(minBeratBadan, pemain.getBeratBadan());
        }

        System.out.println("Tinggi Badan : ");
        System.out.println("Max: " + maxTinggiBadan);
        System.out.println("Min: " + minTinggiBadan);
        System.out.println("Berat Badan : ");
        System.out.println("Max: " + maxBeratBadan);
        System.out.println("Min: " + minBeratBadan);
        System.out.println();
    }

    public static void copyTim(ArrayList<Pemain> timCopy, ArrayList<Pemain> timTujuan) {
        timTujuan.clear();
        timTujuan.addAll(timCopy);
    }
}
