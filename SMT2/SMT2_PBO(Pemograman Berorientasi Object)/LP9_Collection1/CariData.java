package LP9_Collection1;

import java.util.*;

class CariData {

    private Map<Integer, Integer> pemainTimA;
    private Map<Integer, Integer> pemainTimB;

    public CariData(Map<Integer, Integer> pemainTimA, Map<Integer, Integer> pemainTimB) {
        this.pemainTimA = pemainTimA;
        this.pemainTimB = pemainTimB;
    }

    public void cariTinggiSama() {
        System.out.print("a. Data tinggi badan yang sama : ");
        Set<Integer> tinggiSama = new LinkedHashSet<>(pemainTimA.keySet());
        tinggiSama.retainAll(pemainTimB.keySet());
        System.out.println(tinggiSama);
        System.out.println();
    }

    public void cariBeratSama() {
        System.out.print("b. Data berat badan yang sama : ");
        Set<Integer> beratSama = new LinkedHashSet<>(pemainTimA.values());
        beratSama.retainAll(pemainTimB.values());
        System.out.println(beratSama);
        System.out.println();
    }

    public void rentangNilaiTinggi() {
        System.out.println("c.  Rentang nilai dari tinggi badan kedua tim : ");
        int minTinggiTimA = Collections.min(pemainTimA.keySet());
        int maxTinggiTimA = Collections.max(pemainTimA.keySet());
        int minTinggiTimB = Collections.min(pemainTimB.keySet());
        int maxTinggiTimB = Collections.max(pemainTimB.keySet());
        System.out.println("- Tim A: [" + minTinggiTimA + " - " + maxTinggiTimA + "]");
        System.out.println("- Tim B: [" + minTinggiTimB + " - " + maxTinggiTimB + "]");
        System.out.println();
    }

    public void rentangNilaiBerat() {
        System.out.println("d.  Rentang nilai dari berat badan kedua tim : ");
        int minBeratTimA = Collections.min(pemainTimA.values());
        int maxBeratTimA = Collections.max(pemainTimA.values());
        int minBeratTimB = Collections.min(pemainTimB.values());
        int maxBeratTimB = Collections.max(pemainTimB.values());
        System.out.println("- Tim A: [" + minBeratTimA + " - " + maxBeratTimA + "]");
        System.out.println("- Tim B: [" + minBeratTimB + " - " + maxBeratTimB + "]");
        System.out.println();
    }

    public void cariBedaTinggiBadanTim(Map<Integer, Integer> pemainTim1, Map<Integer, Integer> pemainTim2) {
        Set<Integer> tinggiTim1TidakAdaDiTim2 = new LinkedHashSet<>(pemainTim1.keySet());
        tinggiTim1TidakAdaDiTim2.removeAll(pemainTim2.keySet());
        System.out.println(tinggiTim1TidakAdaDiTim2);
        System.out.println();
    }

    public void cariBedaBeratBadanTim(Map<Integer, Integer> pemainTim1, Map<Integer, Integer> pemainTim2) {
        Set<Integer> beratTim1TidakAdaDiTim2 = new LinkedHashSet<>(pemainTimB.values());
        beratTim1TidakAdaDiTim2.removeAll(pemainTimA.values());
        System.out.println(beratTim1TidakAdaDiTim2);
        System.out.println();
    }

    public void printSemuaData() {
        System.out.println("Jawaban Soal 1 (Cari Data) : ");
        cariTinggiSama();
        cariBeratSama();
        rentangNilaiTinggi();
        rentangNilaiBerat();
        System.out.println("e. Tinggi badan pada Tim A yang tidak ada di Tim B : ");
        cariBedaTinggiBadanTim(pemainTimA, pemainTimB);
        System.out.println("f. Berat badan pada Tim B yang tidak ada di Tim A : ");
        cariBedaBeratBadanTim(pemainTimB, pemainTimA);

    }
}
