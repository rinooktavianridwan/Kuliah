/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyKasus1;

import java.util.LinkedHashSet;

public class Karyawan {

    public String nama;
    public String id;
    private String alamat;
    private String noTelp;
    public String jenisKelamin;
    public int umur;
    public String posisi;
    private int gaji;

    public Karyawan() {
    }

    public Karyawan(String nama, String id, String alamat, String noTelp, String jenisKelamin, String posisi, int umur, int gaji) {
        this.nama = nama;
        this.id = id;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
        this.posisi = posisi;
        this.gaji = gaji;
    }

    public void print() {
        System.out.println("\n" + posisi + " " + nama);
        System.out.println("Nama\t\t\t: " + nama);
        System.out.println("ID\t\t\t\t: " + id);
        System.out.println("Alamat\t\t\t: " + alamat);
        System.out.println("Nomer telfon\t: " + noTelp);
        System.out.println("Jenis Kelamin\t: " + jenisKelamin);
        System.out.println("Umur\t\t\t: " + umur);
        System.out.println("Kategori\t\t: " + posisi);
        System.out.println("Gaji\t\t\t: " + gaji);
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }
}

class Admin extends Karyawan {

    public String divisi;

    public Admin() {
    }

    public Admin(String nama, String id, String alamat, String noTelp, String jenisKelamin, String posisi, int umur, int gaji, String divisi) {
        super(nama, id, alamat, noTelp, jenisKelamin, posisi, umur, gaji);
        this.divisi = divisi;
    }

    public void riwayatPelayanan(LinkedHashSet<String> list, Hewan hewan) {

        if (hewan instanceof Kucing) {
            for (int i = 0; i < hewan.kebutuhan.length; i++) {
                if (hewan.kebutuhan[i].equalsIgnoreCase("grooming")) {
                    list.add("kucing" + " \"" + hewan.namaHewan + "\" " + "sudah di " + hewan.kebutuhan + " oleh groomer");
                } else if (hewan.kebutuhan[i].equalsIgnoreCase("periksa")) {
                    list.add("kucing" + " \"" + hewan.namaHewan + "\" " + "sudah di " + hewan.kebutuhan + " oleh dokter hewan");
                }

            }

        } else if (hewan instanceof Anjing) {
            for (int i = 0; i < hewan.kebutuhan.length; i++) {
                if (hewan.kebutuhan[i].equalsIgnoreCase("grooming")) {
                    list.add("kucing" + " \"" + hewan.namaHewan + "\" " + "sudah di " + hewan.kebutuhan + " oleh groomer");
                } else if (hewan.kebutuhan[i].equalsIgnoreCase("periksa")) {
                    list.add("kucing" + " \"" + hewan.namaHewan + "\" " + "sudah di " + hewan.kebutuhan + " oleh dokter hewan");
                }

            }
        } else if (hewan instanceof Kelinci) {
            for (int i = 0; i < hewan.kebutuhan.length; i++) {
                if (hewan.kebutuhan[i].equalsIgnoreCase("grooming")) {
                    list.add("kucing" + " \"" + hewan.namaHewan + "\" " + "sudah di " + hewan.kebutuhan + " oleh groomer");
                } else if (hewan.kebutuhan[i].equalsIgnoreCase("periksa")) {
                    list.add("kucing" + " \"" + hewan.namaHewan + "\" " + "sudah di " + hewan.kebutuhan + " oleh dokter hewan");
                }

            }
        }

    }
}

class Groomer extends Karyawan {

    public String bagian;

    public Groomer() {
    }

    public Groomer(String nama, String id, String alamat, String noTelp, String jenisKelamin, String posisi, int umur, int gaji, String bagian) {
        super(nama, id, alamat, noTelp, jenisKelamin, posisi, umur, gaji);
        this.bagian = bagian;
    }

    public void tugasGroomer(Hewan hewan) {
        System.out.println("[" + hewan.namaHewan + " sudah di grooming]");
    }

    public void print() {
        super.print();
        System.out.println("Bagian\t\t\t: " + bagian);
    }
}

class DokterHewan extends Karyawan {

    public String spesialis;
    private String tingkatPendidikan;

    public DokterHewan() {
    }

    public DokterHewan(String nama, String id, String alamat, String noTelp, String jenisKelamin, String posisi, int umur, int gaji, String spesialis, String tingkatPendidikan) {
        super(nama, id, alamat, noTelp, jenisKelamin, posisi, umur, gaji);
        this.spesialis = spesialis;
        this.tingkatPendidikan = tingkatPendidikan;
    }

    public void tugasDokter(Hewan hewan) {
        System.out.println("[" + hewan.namaHewan + " sudah di layani]");
    }

    public void print() {
        super.print();
        System.out.println("Spesialis\t\t: " + spesialis);
        System.out.println("Pendidikan\t\t: " + tingkatPendidikan);
    }
}
