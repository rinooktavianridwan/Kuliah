package LP5_StaticFinal;

class KendaraanMiliter {

    private String nama;
    private int jumlahMuatan;
    public static KendaraanMiliter[] listKendaraanMiliter;
    public static int jumlahKendaraan = 0;
    private final String negara;
    private String kondisi = "Baik";

    public KendaraanMiliter(String nama, int jumlahMuatan, String negara) {
        this.nama = nama;
        this.jumlahMuatan = jumlahMuatan;
        this.negara = negara;
    }

    public void tampilkanData() {
        System.out.println("===============================================");
        System.out.println("Nama Kendaraan\t: " + nama);
        System.out.println("Jumlah Muatan\t: " + jumlahMuatan + " Ton");
        System.out.println("Negara\t\t: " + negara);
        System.out.println("Kondisi Kendaraan : " + kondisi);

    }

    public static void tampilSemua() {
        System.out.println("===============================================");
        System.out.println("Informasi Semua Kendaraan Perang Yang Ada");
        if (jumlahKendaraan > 0) {
            if (KendaraanMiliter.listKendaraanMiliter != null) {
                for (KendaraanMiliter kendaraan : KendaraanMiliter.listKendaraanMiliter) {
                    if (kendaraan instanceof KapalPerang) {
                        ((KapalPerang) kendaraan).tampilkanData();
                    } else if (kendaraan instanceof KapalSelam) {
                        ((KapalSelam) kendaraan).tampilkanData();
                    }
                }
            }
        }
    }

    public String getNama() {
        return nama;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getKondisi() {
        return kondisi;
    }

    public String getNegara() {
        return negara;
    }

    public void serangan(KendaraanMiliter target) {
        System.out.println("================== SERANGAN ===================");
        if (target.equals(this)) {
            System.out.println("Tidak dapat menyerang diri sendiri.");
        } else if (target.getKondisi().equals("Rusak")) {
            System.out.println("Kendaraan " + target.getNama() + " sudah dalam kondisi rusak dan tidak dapat diserang.");
        } else if (this.negara.equals(target.getNegara())) {
            System.out.println("Tidak dapat menyerang kendaraan dengan negara yang sama.");
        } else {
            metodeFinal(target);
            target.setKondisi("Rusak");
        }
    }

    public final void metodeFinal(KendaraanMiliter target) {
        if (target.getKondisi().equals("Rusak")) {
            System.out.println("Kendaraan " + target.getNama() + " sudah dalam kondisi rusak dan tidak dapat diserang.");
        } else {
            System.out.println("Kendaraan " + this.nama + " menembak dan menghancurkan " + target.getNama());
            target.setKondisi("Rusak");
        }
    }

    public static void tampilkanJumlahKendaraan() {
        System.out.println("Total Kendaraan Militer\t: " + jumlahKendaraan);
    }

}
