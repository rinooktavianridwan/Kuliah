package LP7_Polymorfisme;

class Manager extends Karyawan {

    private String devisi;
    private int jumlahAnggota;

    public Manager(String devisi, int jumlahAnggota, String namaKaryawan, String id, int usia, int gaji) {
        super(namaKaryawan, id, usia, gaji);
        this.devisi = devisi;
        this.jumlahAnggota = jumlahAnggota;
    }

    public String getDevisi() {
        return devisi;
    }

    public int getJumlahAnggota() {
        return jumlahAnggota;
    }

    public void print() {
        super.print();
        System.out.println("Devisi\t\t: " + devisi);
        System.out.println("Jumlah Anggota\t: " + jumlahAnggota);
    }

}
