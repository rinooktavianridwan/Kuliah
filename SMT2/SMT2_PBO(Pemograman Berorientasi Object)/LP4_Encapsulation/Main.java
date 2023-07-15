
package LP4_Encapsulation;

class Main {

    public static void main(String[] args) {

        Proyek proyek1 = new Proyek("Pengelolaan Pajak", "Jakarta", "10 Taun");
        Proyek proyek2 = new Proyek("Pembiayaan Fasilitas Umum", "Indonesia", "1 tahun");
        Proyek proyek3 = new Proyek("Pembanguan Desa", "Malang", "3 Bulan");

        Karyawan karyawan1 = new Karyawan("Rino Oktavian R", "aeyrv23", 17, 10000000, proyek1);
        Karyawan karyawan2 = new Karyawan("Onir Naivatko N", "wfiy497", 30, 7000000, proyek2);
        Karyawan karyawan3 = new Karyawan("Rionaru Okid", "T9Bb7nfe", 23, 6000000, proyek3);

        karyawan2.tambahPenghargaan("Best Desain Produk");
        karyawan2.tambahPenghargaan("WorkShop Produk Manager");
        karyawan2.tambahPenghargaan("Pegawai Terbaik Tahun 2000");

        karyawan3.tambahPenghargaan("Pegawai Teladan Tahun 1999");
        karyawan3.tambahPenghargaan("Komunitas Pecinta Lingkungan");
        karyawan3.tambahPenghargaan("Juara 1 Lomba Ketik");
        karyawan3.tambahPenghargaan("Ide Gagasan Terbaik");
        karyawan3.tambahPenghargaan("Juara 1 Lomba Desain Project Startup");
        karyawan3.tambahPenghargaan("Karyawan Sehat");

        karyawan1.printKaryawan();
        karyawan2.printKaryawan();
        karyawan3.printKaryawan();
    }
}
