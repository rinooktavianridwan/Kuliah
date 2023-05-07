/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyKasus2;

import java.util.ArrayList;

public class Karyawan implements CetakInfo {

    public String nama;
    public String id;
    private String alamat;
    private String noTelp;
    public String jenisKelamin;
    public String posisi;
    public int umur;
    private int gaji;

    public Karyawan() {
    }

    public Karyawan(String nama, String id, String alamat, String noTelp, String jenisKelamin, int umur, int gaji) {
        this.nama = nama;
        this.id = id;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
        this.posisi = "Karyawan Biasa";
        this.gaji = gaji;
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
}

class Admin extends Karyawan implements CetakInfo {

    public String divisi;

    public Admin() {
    }

    public Admin(String nama, String id, String alamat, String noTelp, String jenisKelamin, int umur, int gaji, String divisi) {
        super(nama, id, alamat, noTelp, jenisKelamin, umur, gaji);
        this.posisi = "Admin";
        this.divisi = divisi;
    }

    public void riwayatPelayanan(ArrayList<String> list, Hewan hewan) {

        if (hewan instanceof Kucing) {
            list.add("Kucing" + " \"" + hewan.namaHewan + "\" ");
            list.add("Jenis Perawatan : ");
            for (int i = 0; i < hewan.jenisPerawatan.size(); i++) {
                if (((Kucing) hewan).jenisPerawatan.get(i) != null) {
                    switch (hewan.jenisPerawatan.get(i)) {
                        case SuntikVaksin ->
                            list.add(JenisPerawatan.SuntikVaksin + " oleh dokter hewan");
                        case SuntikAntiKutu ->
                            list.add(JenisPerawatan.SuntikAntiKutu + " oleh dokter hewan");
                        case SuntikScabies ->
                            list.add(JenisPerawatan.SuntikScabies + " oleh dokter hewan");
                        case SuntikAntiJamurKulit ->
                            list.add(JenisPerawatan.SuntikAntiJamurKulit + " oleh dokter hewan");
                        case PemeriksaanRawatInap ->
                            list.add(JenisPerawatan.PemeriksaanRawatInap + " oleh dokter hewan");
                        case PemeriksaanRawatJalan ->
                            list.add(JenisPerawatan.PemeriksaanRawatJalan + " oleh dokter hewan");
                        case Mandi ->
                            list.add(JenisPerawatan.Mandi + " oleh groomer");
                        case Cukur ->
                            list.add(JenisPerawatan.Cukur + " oleh groomer");
                        case Trimming ->
                            list.add(JenisPerawatan.Trimming + " oleh groomer");

                        default -> {
                        }
                    }
                }
            }
            list.add("");
        } else if (hewan instanceof Anjing) {
            list.add("Anjing" + " \"" + hewan.namaHewan + "\" ");
            list.add("Jenis Perawatan : ");
            for (int i = 0; i < hewan.jenisPerawatan.size(); i++) {
                if (((Anjing) hewan).jenisPerawatan.get(i) != null) {
                    switch (hewan.jenisPerawatan.get(i)) {
                        case SuntikVaksin ->
                            list.add(JenisPerawatan.SuntikVaksin + " oleh dokter hewan");
                        case SuntikAntiKutu ->
                            list.add(JenisPerawatan.SuntikAntiKutu + " oleh dokter hewan");
                        case SuntikScabies ->
                            list.add(JenisPerawatan.SuntikScabies + " oleh dokter hewan");
                        case SuntikAntiJamurKulit ->
                            list.add(JenisPerawatan.SuntikAntiJamurKulit + " oleh dokter hewan");
                        case PemeriksaanRawatInap ->
                            list.add(JenisPerawatan.PemeriksaanRawatInap + " oleh dokter hewan");
                        case PemeriksaanRawatJalan ->
                            list.add(JenisPerawatan.PemeriksaanRawatJalan + " oleh dokter hewan");
                        case Mandi ->
                            list.add(JenisPerawatan.Mandi + " oleh groomer");
                        case Cukur ->
                            list.add(JenisPerawatan.Cukur + " oleh groomer");
                        case Trimming ->
                            list.add(JenisPerawatan.Trimming + " oleh groomer");

                        default -> {
                        }
                    }
                }
            }
            list.add("");
        } else if (hewan instanceof Kelinci) {
            list.add("Kelinci" + " \"" + hewan.namaHewan + "\" ");
            list.add("Jenis Perawatan : ");
            for (int i = 0; i < hewan.jenisPerawatan.size(); i++) {
                if (((Kelinci) hewan).jenisPerawatan.get(i) != null) {
                    switch (hewan.jenisPerawatan.get(i)) {
                        case SuntikVaksin ->
                            list.add(JenisPerawatan.SuntikVaksin + " oleh dokter hewan");
                        case SuntikAntiKutu ->
                            list.add(JenisPerawatan.SuntikAntiKutu + " oleh dokter hewan");
                        case SuntikScabies ->
                            list.add(JenisPerawatan.SuntikScabies + " oleh dokter hewan");
                        case SuntikAntiJamurKulit ->
                            list.add(JenisPerawatan.SuntikAntiJamurKulit + " oleh dokter hewan");
                        case PemeriksaanRawatInap ->
                            list.add(JenisPerawatan.PemeriksaanRawatInap + " oleh dokter hewan");
                        case PemeriksaanRawatJalan ->
                            list.add(JenisPerawatan.PemeriksaanRawatJalan + " oleh dokter hewan");
                        case Mandi ->
                            list.add(JenisPerawatan.Mandi + " oleh groomer");
                        case Cukur ->
                            list.add(JenisPerawatan.Cukur + " oleh groomer");
                        case Trimming ->
                            list.add(JenisPerawatan.Trimming + " oleh groomer");

                        default -> {
                        }
                    }
                }
            }
            list.add("");
        }
    }

    public void print() {
        super.print();
        System.out.println("Divisi\t\t\t: " + divisi);
    }
}

class Groomer extends Karyawan implements CetakInfo {

    public String bagian;

    public Groomer() {
    }

    public Groomer(String nama, String id, String alamat, String noTelp, String jenisKelamin, int umur, int gaji, String bagian) {
        super(nama, id, alamat, noTelp, jenisKelamin, umur, gaji);
        this.posisi = "Groomer";
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

class DokterHewan extends Karyawan implements CetakInfo {

    public String spesialis;
    private String tingkatPendidikan;

    public DokterHewan() {
    }

    public DokterHewan(String nama, String id, String alamat, String noTelp, String jenisKelamin, int umur, int gaji, String spesialis, String tingkatPendidikan) {
        super(nama, id, alamat, noTelp, jenisKelamin, umur, gaji);
        this.posisi = "Dokter Hewan";
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
