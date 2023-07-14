package LP7_Polymorfisme;

class Perusahaan {

    private String namaPerusahaan;
    private String lokasi;
    private int jumlahKaryawan;
    private Karyawan[] listKaryawan;
    private int totalGaji;

    public Perusahaan(String namaPerusahaan, String lokasi, int jumlahKaryawan) {
        this.namaPerusahaan = namaPerusahaan;
        this.lokasi = lokasi;
        this.jumlahKaryawan = jumlahKaryawan;
        listKaryawan = new Karyawan[jumlahKaryawan];
    }

    public void tambahKaryawan(Karyawan karyawan) {
        if (karyawan instanceof Programer) {
            karyawan = (Programer) karyawan;
        }

        if (karyawan instanceof Manager) {
            karyawan = (Manager) karyawan;
        }
        if (karyawan instanceof Artist) {
            karyawan = (Artist) karyawan;
        }
        for (int i = 0; i < listKaryawan.length; i++) {
            if (listKaryawan[i] == null) {
                listKaryawan[i] = karyawan;
                this.totalGaji += karyawan.getGaji();
                return;
            }
        }
    }

    public void printPerusahaan() {
        System.out.println("\t\tDETAIL PERUSAHAAN");
        System.out.println("===============================================");
        System.out.println("Nama Perusahaan\t\t: " + namaPerusahaan);
        System.out.println("Lokasi Perusahaan\t: " + lokasi);
        System.out.println("Jumlah Karyawan\t\t: " + jumlahKaryawan);
        System.out.println("Nama-nama Karyawan\t: ");
        for (int i = 0; i < listKaryawan.length; i++) {
            if (listKaryawan[i] != null) {
                System.out.println((i + 1) + ". " + listKaryawan[i].getNamaKaryawan());
            }
        }
        System.out.println();
        System.out.println("Jumlah Gaji\t\t: " + totalGaji);
        System.out.println("===============================================");
        System.out.println();
        System.out.println("\t\tDETAIL KARYAWAN");
        System.out.println("===============================================");
        printSemuaKaryawan();
    }

    public void printSemuaKaryawan() {
        for (int i = 0; i < listKaryawan.length; i++) {
            if (listKaryawan[i] != null) {
                listKaryawan[i].print();
                System.out.println("=======================================");
            }

        }
    }

}
