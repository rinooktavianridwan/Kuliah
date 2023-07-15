package LP6_Inheritance;

class Komik extends Buku {

    private String jenisGambar;
    private String jumlahPanel;

    public Komik(String judul, String penulis, String ISBN, String tahunTerbit, String jenisGambar, String jumlahPanel) {
        super(judul, penulis, ISBN, tahunTerbit);
        this.jenis = "Komik";
        this.jenisGambar = jenisGambar;
        this.jumlahPanel = jumlahPanel;

    }

    public void print() {
        super.print();
        System.out.println("Jenis Gambar\t: " + jenisGambar);
        System.out.println("Jumlah Panel\t: " + jumlahPanel);
        System.out.println("");
    }

}
