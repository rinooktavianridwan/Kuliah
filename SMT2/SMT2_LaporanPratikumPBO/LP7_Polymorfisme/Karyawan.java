package LP7_Polymorfisme;

abstract class Karyawan {

    private String namaKaryawan;
    private String id;
    private int usia;
    private int gaji;

    public Karyawan(String namaKaryawan, String id, int usia, int gaji) {
        this.namaKaryawan = namaKaryawan;
        this.id = id;
        this.usia = usia;
        this.gaji = gaji;
    }

    public void print() {
        System.out.println("Nama\t\t: " + namaKaryawan);
        System.out.println("ID\t\t: " + id);
        System.out.println("Usia\t\t: " + usia);
        System.out.println("Gaji\t\t: " + "Rp." + gaji + ",00");
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public String getId() {
        return id;
    }

    public int getUsia() {
        return usia;
    }

    public int getGaji() {
        return gaji;
    }

}
