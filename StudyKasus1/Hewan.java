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
    public ArrayList<JenisPerawatan> kebutuhan;
    public String riwayatPenyakit;
    public int tahunKelahiran;
    public int umurHewan;
    public int totalHarga;

    public Hewan() {
    }

    public Hewan(String noPelanggan, String namaPelanggan, String namaHewan, String jenisHewan, String warnaHewan, ArrayList<JenisPerawatan> kebutuhan, String riwayatPenyakit, int tahunKelahiran, int umurHewan, int totalHarga) {
        this.noPelanggan = noPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.namaHewan = namaHewan;
        this.jenisHewan = jenisHewan;
        this.warnaHewan = warnaHewan;
        this.kebutuhan = kebutuhan;
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
        for (int i = 0; i < kebutuhan.size(); i++) {
            if (kebutuhan.get(i) != null) {
                System.out.println(j + ". " + kebutuhan.get(i) +  "\t\t"+kebutuhan.get(i).harga);
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

    public Kucing(String noPelanggan, String namaPelanggan, String namaHewan, String jenisHewan, String warnaHewan, ArrayList<JenisPerawatan> kebutuhan, String riwayatPenyakit, int tahunKelahiran, int umurHewan, int totalHarga, String kebiasaanMencakar) {
        super(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, kebutuhan, riwayatPenyakit, tahunKelahiran, umurHewan, totalHarga);
        this.kebiasaanMencakar = kebiasaanMencakar;
    }

    public void print() {
        super.print();
        System.out.println("Kebiasaaan melompat\t\t: " + kebiasaanMencakar);
    }
}

class Anjing extends Hewan {

    String kebisaanMenggigit;

    public Anjing() {
    }

    public Anjing(String noPelanggan, String namaPelanggan, String namaHewan, String jenisHewan, String warnaHewan, ArrayList<JenisPerawatan> kebutuhan, String riwayatPenyakit, int tahunKelahiran, int umurHewan, int totalHarga, String kebisaanMenggigit) {
        super(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, kebutuhan, riwayatPenyakit, tahunKelahiran, umurHewan, totalHarga);
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

    public Kelinci(String noPelanggan, String namaPelanggan, String namaHewan, String jenisHewan, String warnaHewan, ArrayList<JenisPerawatan> kebutuhan, String riwayatPenyakit, int tahunKelahiran, int umurHewan, int totalHarga, String kebiasaanMelompat) {
        super(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, kebutuhan, riwayatPenyakit, tahunKelahiran, totalHarga, umurHewan);
        this.kebiasaanMelompat = kebiasaanMelompat;
    }

    public void print() {
        super.print();
        System.out.println("Kebiasaan melompat\t\t: " + kebiasaanMelompat);
    }
}

enum JenisPerawatan {
    suntikVaksin(115000),
    suntikAntiKutu(75000),
    suntikScabies(70000),
    suntikAntiJamurKulit(70000),
    pemeriksaanRawatInap(150000),
    pemeriksaanRawatJalan(65000),;

    private JenisPerawatan(int harga) {
        this.harga = harga;
    }

    final int harga;

}
