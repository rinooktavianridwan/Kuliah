package UAP;

import java.util.ArrayList;
import java.util.Scanner;

class Data {

    public static ArrayList<Tanaman> tanaman;
    public static ArrayList<Integer> lokasi;
    public static Scanner in;

    public static void mulai() {
        tanaman = new ArrayList<>();
        lokasi = new ArrayList<>();
        in = new Scanner(System.in);

        System.out.print("Masa tanam (bulan): ");
        int masaTanamBulan = in.nextInt();
        int masaTanamHari = masaTanamBulan * 30;
        System.out.println();

        System.out.println("---------------------------");
        System.out.println("PROSES PENANAMAN");
        System.out.println("---------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("Mau menanam apa?");
            System.out.println("1. Tomat");
            System.out.println("2. Stroberi");
            System.out.println("3. Persik");
            System.out.print("Pilihan: ");
            int pilihan = in.nextInt();

            Tanaman tumbuhan;
            switch (pilihan) {
                case 1:
                    tumbuhan = new Tomat();
                    break;
                case 2:
                    tumbuhan = new Stroberi();
                    break;
                case 3:
                    tumbuhan = new Persik();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    i--;
                    continue;
            }

            tanaman.add(tumbuhan);
            System.out.println(tumbuhan.getClass().getSimpleName() + " berhasil ditanam.");
        }
        System.out.println();

        System.out.println("---------------------------");
        System.out.println("PROSES PERKEMBANGAN");
        System.out.println("---------------------------");
        for (int i = 1; i <= masaTanamHari; i++) {
            for (int j = 0; j < tanaman.size(); j++) {
                Tanaman tumbuhan = tanaman.get(j);

                if (tumbuhan.status().equals("Hidup")) {
                    tumbuhan.berkembang();

                } else if (!lokasi.contains(j)) {
                    System.out.println("--> Tanaman " + tumbuhan.getClass().getSimpleName() + " telah mati");
                    lokasi.add(j);
                    menanam();
                }
            }
            if (i % 90 == 0) {
                for (Tanaman tanamans : tanaman) {
                    if (!lokasi.contains(tanaman.indexOf(tanaman))) {
                        if (tanamans instanceof Tomat tomat) {
                            tomat.treatment();
                        }
                        if (tanamans instanceof Stroberi stroberi) {
                            stroberi.treatment();
                        }
                        if (tanamans instanceof Persik persik) {
                            persik.treatment();
                        }
                    }
                }
            }
        }

    }

    public static void menanam() {
        System.out.println("Mau menanam apa?");
        System.out.println("1. Tomat");
        System.out.println("2. Stroberi");
        System.out.println("3. Persik");
        System.out.print("Pilihan: ");
        int pilihan = in.nextInt();

        Tanaman tumbuhan;
        switch (pilihan) {
            case 1:
                tumbuhan = new Tomat();
                break;
            case 2:
                tumbuhan = new Stroberi();
                break;
            case 3:
                tumbuhan = new Persik();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        tanaman.add(tumbuhan);
        System.out.println(tumbuhan.getClass().getSimpleName() + " berhasil ditanam.");
    }

    public static void info() {
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("------HASIL MENANAM-------");
        System.out.println("---------------------------");
        for (int i = 0; i < tanaman.size(); i++) {
            Tanaman tumbuhan = tanaman.get(i);
            System.out.println("Tanaman ke-" + (i + 1) + " (" + tumbuhan.getClass().getSimpleName() + "):");
            System.out.println("Masa Hidup\t\t: " + tumbuhan.getMasaHidup() + " hari");
            System.out.println("Umur Tanaman\t\t: " + tumbuhan.getLamaHidup() + " hari");
            System.out.println("Buah yang dihasilkan\t: " + tumbuhan.getBuah() + " buah " + tumbuhan.getClass().getSimpleName());
            System.out.println("Status\t\t\t: " + tumbuhan.status());
            System.out.println();
        }

    }

}
