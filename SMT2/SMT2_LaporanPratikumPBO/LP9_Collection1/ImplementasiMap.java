package LP9_Collection1;

import java.util.*;

class ImplementasiMap {

    private Map<Integer, List<Integer>> pemainTimA;
    private Map<Integer, List<Integer>> pemainTimB;
    private Map<Integer, Integer> timSementara;

    public ImplementasiMap(Map<Integer, List<Integer>> timA, Map<Integer, List<Integer>> timB) {
        this.pemainTimA = timA;
        this.pemainTimB = timB;
        this.timSementara = new HashMap<>();
    }

    public void updateBeratTimB(Map<Integer, List<Integer>> pemainTim, int tinggi, int berat) {
        if (pemainTim.containsKey(tinggi)) {
            List<Integer> beratList = pemainTim.get(tinggi);
            beratList.clear();
            beratList.add(berat);
        } else {
            System.out.println("Tinggi pemain tidak ditemukan");
        }
    }

    public void filterTimAB(Map<Integer, List<Integer>> pemainTim1, Map<Integer, List<Integer>> pemainTim2) {
        timSementara.clear();
        for (Map.Entry<Integer, List<Integer>> entry : pemainTim1.entrySet()) {
            int tinggi = entry.getKey();
            if (pemainTim2.containsKey(tinggi)) {
                timSementara.put(tinggi, entry.getValue().get(entry.getValue().size() - 1));
            }
        }
        System.out.println("Tinggi Badan\t| Berat Badan");
        System.out.println("-----------------|--------------");
        for (Map.Entry<Integer, Integer> entry : timSementara.entrySet()) {
            int tinggi = entry.getKey();
            int berat = entry.getValue();
            System.out.println("\t" + tinggi + "\t|\t" + berat);
        }
    }

    public void eliminatePemain(int batas) {
        Iterator<Map.Entry<Integer, Integer>> iterator = timSementara.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int tinggi = entry.getKey();
            if (tinggi < batas) {
                iterator.remove();
            }
        }
        System.out.println("Tinggi Badan\t| Berat Badan");
        System.out.println("-----------------|--------------");
        for (Map.Entry<Integer, Integer> entry : timSementara.entrySet()) {
            int tinggi = entry.getKey();
            int berat = entry.getValue();
            System.out.println("\t" + tinggi + "\t|\t" + berat);
        }
    }

    public void printDataPemain(Map<Integer, List<Integer>> pemainTim) {
        System.out.println("Tinggi Badan\t| Berat Badan");
        System.out.println("-----------------|--------------");
        for (Map.Entry<Integer, List<Integer>> entry : pemainTim.entrySet()) {
            int tinggi = entry.getKey();
            List<Integer> beratList = entry.getValue();
            StringBuilder berat = new StringBuilder();
            for (int i = 0; i < beratList.size(); i++) {
                if (i > 0) {
                    berat.append(", ");
                }
                berat.append(beratList.get(i));
            }
            System.out.println("\t" + tinggi + "\t|\t" + berat);
        }
    }

    public void printSemuaData() {
        System.out.println("Jawaban Soal 2 (Implementasi Map) : ");
        System.out.println("a. Semua data awal pemain Tim A & Tim B : ");
        System.out.println("Data Pemain Tim A : ");
        printDataPemain(pemainTimA);
        System.out.println("Data Pemain Tim B : ");
        printDataPemain(pemainTimB);
        System.out.println("===============================================");
        // Melakukan Update Data Pemain Pada Tim B
        updateBeratTimB(pemainTimB, 168, 66);
        System.out.println("b. Data Setelah Update : ");
        System.out.println("Data Pemain Tim B : ");
        printDataPemain(pemainTimB);
        System.out.println("===============================================");

        // Implementasikan Map untuk menyimpan data tinggi badan dan berat badan dari tim A yang tinggi badannya sama dengan tim B.
        System.out.println("c. Data tinggi badan dan berat badan dari tim A yang tinggi badannya sama dengan tim B : ");
        filterTimAB(pemainTimA, pemainTimB);
        System.out.println("===============================================");

        // Map dengan pemain yang memiliki tinggi badan 168 keatas Dari Data Kesamaan
        System.out.println("d. Map dengan pemain yang memiliki tinggi badan 168 keatas");
        System.out.println("(Hasil Akhir Map Data Pemain) : ");
        System.out.println("Data Pemain Tim A : ");
        eliminatePemain(168);
        System.out.println("Data Pemain Tim B : ");
        printDataPemain(pemainTimB);
        System.out.println("===============================================");
    }
}
