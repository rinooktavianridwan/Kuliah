package LP9_Collection1;

import java.util.*;

class MainImplementasiMap {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> timA = new LinkedHashMap<>();
        List<Integer> beratTimA1 = new ArrayList<>();
        beratTimA1.add(64);
        List<Integer> beratTimA2 = new ArrayList<>();
        beratTimA2.add(54);
        List<Integer> beratTimA3 = new ArrayList<>();
        beratTimA3.add(55);
        beratTimA3.add(68);
        List<Integer> beratTimA4 = new ArrayList<>();
        beratTimA4.add(49);
        List<Integer> beratTimA5 = new ArrayList<>();
        beratTimA5.add(71);
        List<Integer> beratTimA6 = new ArrayList<>();
        beratTimA6.add(68);
        List<Integer> beratTimA7 = new ArrayList<>();
        beratTimA7.add(56);
        List<Integer> beratTimA8 = new ArrayList<>();
        beratTimA8.add(57);
        List<Integer> beratTimA9 = new ArrayList<>();
        beratTimA9.add(66);

        timA.put(180, beratTimA1);
        timA.put(173, beratTimA2);
        timA.put(165, beratTimA3);
        timA.put(168, beratTimA4);
        timA.put(172, beratTimA5);
        timA.put(170, beratTimA6);
        timA.put(169, beratTimA7);
        timA.put(171, beratTimA8);
        timA.put(166, beratTimA9);

        Map<Integer, List<Integer>> timB = new LinkedHashMap<>();
        List<Integer> beratTimB1 = new ArrayList<>();
        beratTimB1.add(65);
        List<Integer> beratTimB2 = new ArrayList<>();
        beratTimB2.add(46);
        List<Integer> beratTimB3 = new ArrayList<>();
        beratTimB3.add(66);
        List<Integer> beratTimB4 = new ArrayList<>();
        beratTimB4.add(59);
        List<Integer> beratTimB5 = new ArrayList<>();
        beratTimB5.add(76);
        List<Integer> beratTimB6 = new ArrayList<>();
        beratTimB6.add(65);
        List<Integer> beratTimB7 = new ArrayList<>();
        beratTimB7.add(70);
        List<Integer> beratTimB8 = new ArrayList<>();
        beratTimB8.add(70);
        List<Integer> beratTimB9 = new ArrayList<>();
        beratTimB9.add(67);
        List<Integer> beratTimB10 = new ArrayList<>();
        beratTimB10.add(60);

        timB.put(170, beratTimB1);
        timB.put(167, beratTimB2);
        timB.put(165, beratTimB3);
        timB.put(166, beratTimB4);
        timB.put(168, beratTimB5);
        timB.put(175, beratTimB6);
        timB.put(172, beratTimB7);
        timB.put(171, beratTimB8);
        timB.put(180, beratTimB9);
        timB.put(169, beratTimB10);

        ImplementasiMap dataPemain = new ImplementasiMap(timA, timB);
        dataPemain.printSemuaData();
    }
}
