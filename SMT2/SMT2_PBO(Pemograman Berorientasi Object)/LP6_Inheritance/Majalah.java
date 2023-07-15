package LP6_Inheritance;

class Majalah extends Buku {

    private String kategoriMajalah;
    private String edisi;

    public Majalah(String judul, String penulis, String ISBN, String tahunTerbit, String kategoriMajalah, String edisi) {
        super(judul, penulis, ISBN, tahunTerbit);
        this.jenis = "Majalah";
        this.kategoriMajalah = kategoriMajalah;
        this.edisi = edisi;
    }

    public void print() {
        super.print();
        System.out.println("Kategori Majalah : " + kategoriMajalah);
        System.out.println("Edisi Majalah\t: " + edisi);
        System.out.println("");
    }

}
