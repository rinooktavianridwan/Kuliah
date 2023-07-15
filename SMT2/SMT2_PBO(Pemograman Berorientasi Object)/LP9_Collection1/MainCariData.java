package LP9_Collection1;

import java.util.LinkedHashMap;
import java.util.Map;

class MainCariData {

    public static void main(String[] args) {
        Map<Integer, Integer> timA = new LinkedHashMap<>();
        timA.put(180, 64);
        timA.put(173, 54);
        timA.put(165, 55);
        timA.put(168, 49);
        timA.put(172, 71);
        timA.put(170, 68);
        timA.put(169, 56);
        timA.put(165, 68);
        timA.put(171, 57);
        timA.put(166, 66);

        Map<Integer, Integer> timB = new LinkedHashMap<>();
        timB.put(170, 65);
        timB.put(167, 46);
        timB.put(165, 66);
        timB.put(166, 59);
        timB.put(168, 76);
        timB.put(175, 65);
        timB.put(172, 70);
        timB.put(171, 70);
        timB.put(180, 67);
        timB.put(169, 60);

        CariData dataPemain = new CariData(timA, timB);
        dataPemain.printSemuaData();
    }
}
