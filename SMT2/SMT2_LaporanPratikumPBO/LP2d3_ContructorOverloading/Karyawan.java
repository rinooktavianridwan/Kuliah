package LP2d3_ContructorOverloading;

class Karyawan {

    public String nama;
    public String id;
    public String usia;
    public String alamat;
    public String divisi;
    public String gaji;

    public Karyawan(String nama, String id, String usia, String alamat, String divisi, String gaji) {
        this.nama = nama;
        this.id = id;
        this.usia = usia;
        this.alamat = alamat;
        this.divisi = divisi;
        this.gaji = gaji;
    }

    public Karyawan(String nama, String id, String usia, String alamat, String divisi) {
        this.nama = nama;
        this.id = id;
        this.usia = usia;
        this.alamat = alamat;
        this.divisi = divisi;
        this.gaji = "Tidak ada data";
    }

    public Karyawan(String nama, String id, String usia, String alamat) {
        this.nama = nama;
        this.id = id;
        this.usia = usia;
        this.alamat = alamat;
        this.divisi = "Tidak ada data";
        this.gaji = "Tidak ada data";
    }

    public Karyawan(String nama, String id, String usia) {
        this.nama = nama;
        this.id = id;
        this.usia = usia;
        this.alamat = "Tidak ada data";
        this.divisi = "Tidak ada data";
        this.gaji = "Tidak ada data";
    }

    public Karyawan(String nama, String id) {
        this.nama = nama;
        this.id = id;
        this.usia = "Tidak ada data";
        this.alamat = "Tidak ada data";
        this.divisi = "Tidak ada data";
        this.gaji = "Tidak ada data";
    }

    public Karyawan(String nama) {
        this.nama = nama;
        this.id = "Tidak ada data";
        this.usia = "Tidak ada data";
        this.alamat = "Tidak ada data";
        this.divisi = "Tidak ada data";
        this.gaji = "Tidak ada data";
    }

    public Karyawan() {
        this.nama = "Tidak ada data";
        this.id = "Tidak ada data";
        this.usia = "Tidak ada data";
        this.alamat = "Tidak ada data";
        this.divisi = "Tidak ada data";
        this.gaji = "Tidak ada data";
    }

    public void printKaryawan() {
        System.out.println("Nama : " + nama);
        System.out.println("Id : " + id);
        System.out.println("Usia : " + usia);
        System.out.println("Alamat : " + alamat);
        System.out.println("Divisi : " + divisi);
        System.out.println("Gaji : " + gaji);
        System.out.println("");
    }

}
