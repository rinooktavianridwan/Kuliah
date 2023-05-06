/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyKasus1;

import java.util.ArrayList;

public class Hewan implements CetakInfo {

    public String noPelanggan;
    public String namaPelanggan;
    public String namaHewan;
    public String jenisHewan;
    public String warnaHewan;
    public ArrayList<JenisPerawatan> jenisPerawatan;
    public String riwayatPenyakit;
    public int tahunKelahiran;
    public int umurHewan;
    public int totalHarga;

    public Hewan() {
    }

    public Hewan(String noPelanggan, String namaPelanggan, String namaHewan, String jenisHewan, String warnaHewan, ArrayList<JenisPerawatan> jenisPerawatan, String riwayatPenyakit, int tahunKelahiran, int umurHewan, int totalHarga) {
        this.noPelanggan = noPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.namaHewan = namaHewan;
        this.jenisHewan = jenisHewan;
        this.warnaHewan = warnaHewan;
        this.jenisPerawatan = jenisPerawatan;
        this.riwayatPenyakit = riwayatPenyakit;
        this.tahunKelahiran = tahunKelahiran;
        this.umurHewan = umurHewan;
        this.totalHarga = totalHarga;
    }

    public void print() {
        System.out.println("\nID Pelanggan\t\t\t: " + noPelanggan);
        System.out.println("Nama Pelanggan\t\t\t: " + namaPelanggan);
        System.out.println("Nama Hewan\t\t\t\t: " + namaHewan);
        System.out.println("Jenis Hewan\t\t\t\t: " + jenisHewan);
        System.out.println("Warna Hewan\t\t\t\t: " + warnaHewan);
        System.out.println("Kebutuhan \t\t\t\t: ");
        int j = 1;
        for (int i = 0; i < jenisPerawatan.size(); i++) {
            if (jenisPerawatan.get(i) != null) {
                System.out.println(j + ". " + jenisPerawatan.get(i) +  "\t\t"+jenisPerawatan.get(i).harga);
                j++;
            }
        }
        System.out.println("Riwayat penyakit\t\t: " + riwayatPenyakit);
        System.out.println("Tahun kelahiran hewan\t: " + tahunKelahiran);
        System.out.println("Umur hewan\t\t\t\t: " + umurHewan);
        System.out.println("Total harga\t\t\t\t: " + totalHarga);

    }

}

class Kucing extends Hewan {

    String kebiasaanMencakar;

    public Kucing() {
    }

    public Kucing(String noPelanggan, String namaPelanggan, String namaHewan, String jenisHewan, String warnaHewan, ArrayList<JenisPerawatan> jenisPerawatan, String riwayatPenyakit, int tahunKelahiran, int umurHewan, int totalHarga, String kebiasaanMencakar) {
        super(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, jenisPerawatan, riwayatPenyakit, tahunKelahiran, umurHewan, totalHarga);
        this.kebiasaanMencakar = kebiasaanMencakar;
    }

    public void print() {
        super.print();
        System.out.println("Kebiasaaan mencakar\t\t: " + kebiasaanMencakar);
    }
}

class Anjing extends Hewan {

    String kebisaanMenggigit;

    public Anjing() {
    }

    public Anjing(String noPelanggan, String namaPelanggan, String namaHewan, String jenisHewan, String warnaHewan, ArrayList<JenisPerawatan> jenisPerawatan, String riwayatPenyakit, int tahunKelahiran, int umurHewan, int totalHarga, String kebisaanMenggigit) {
        super(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, jenisPerawatan, riwayatPenyakit, tahunKelahiran, umurHewan, totalHarga);
        this.kebisaanMenggigit = kebisaanMenggigit;
    }

    public void print() {
        super.print();
        System.out.println("Kebiasaan menggigit\t\t: " + kebisaanMenggigit);
    }
}

class Kelinci extends Hewan {

    String kebiasaanMelompat;

    public Kelinci() {
    }

    public Kelinci(String noPelanggan, String namaPelanggan, String namaHewan, String jenisHewan, String warnaHewan, ArrayList<JenisPerawatan> jenisPerawatan, String riwayatPenyakit, int tahunKelahiran, int umurHewan, int totalHarga, String kebiasaanMelompat) {
        super(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, jenisPerawatan, riwayatPenyakit, tahunKelahiran, umurHewan, totalHarga);
        this.kebiasaanMelompat = kebiasaanMelompat;
    }

    public void print() {
        super.print();
        System.out.println("Kebiasaan melompat\t\t: " + kebiasaanMelompat);
    }
}

enum JenisPerawatan {
    SuntikVaksin(115000),
    SuntikAntiKutu(75000),
    SuntikScabies(70000),
    SuntikAntiJamurKulit(70000),
    PemeriksaanRawatInap(150000),
    PemeriksaanRawatJalan(65000),
    Mandi (40000),
    Cukur (35000),
    Trimming (20000);

    private JenisPerawatan(int harga) {
        this.harga = harga;
    }

    final int harga;

}
