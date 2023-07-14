/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LP4_Encapsulation;

class Karyawan {

    private String namaKaryawan;
    private String id;
    private int usia;
    private int gaji;
    private Proyek proyek;
    private String[] penghargaan;

    public Karyawan(String namaKaryawan, String id, int usia, int gaji, Proyek proyek) {
        this.namaKaryawan = namaKaryawan;
        this.id = id;
        this.usia = usia;
        this.gaji = gaji;
        this.proyek = proyek;
        this.penghargaan = new String[100];
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public void tambahGaji() {
        int tambahGaji = (int) (gaji / 10);
        this.gaji = gaji + tambahGaji;
    }

    public String[] getPenghargaan() {
        return penghargaan;
    }

    public void setPenghargaan(String[] penghargaan) {
        this.penghargaan = penghargaan;
    }

    public Proyek getProyek() {
        return proyek;
    }

    public void tambahPenghargaan(String penghargaan) {
        for (int i = 0; i < this.penghargaan.length; i++) {
            if (i < 5) {
                if (this.penghargaan[i] == null) {
                    this.penghargaan[i] = penghargaan;
                    tambahGaji();
                    return;
                }
            }
            if (i >= 5) {
                System.out.println("Perhargaan "
                        + getNamaKaryawan() + " Tidak Boleh Lebih Dari 5");
                return;
            }
        }
    }

    public void printKaryawan() {
        System.out.println("");

        System.out.println("===============================================");
        System.out.println("Nama\t: " + getNamaKaryawan());
        System.out.println("Id\t: " + getId());
        System.out.println("Usia\t: " + getUsia());
        System.out.println("Gaji\t: " + getGaji());

        System.out.println("===============================================");
        printProyek();
        printPenghargaan();
        System.out.println("");
    }

    public void printProyek() {
        System.out.println("Nama Proyek\t: "
                + getProyek().getNamaProyek());
        System.out.println("Lokasi\t\t: "
                + getProyek().getLokasi());
        System.out.println("Durasi\t\t: "
                + getProyek().getDurasi());

        System.out.println("===============================================");
    }

    public void printPenghargaan() {
        System.out.println("List Penghargaan : ");
        for (int i = 0; i < penghargaan.length; i++) {
            if (penghargaan[i] != null) {
                System.out.println("Penghargaan " + (i + 1)
                        + " : " + penghargaan[i]);
            }
        }
    }

}
