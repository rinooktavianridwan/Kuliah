package LP6_Inheritance;

class Buku {

    protected String judul;
    protected String penulis;
    protected String ISBN;
    protected String tahunTerbit;
    protected String jenis;

    public Buku(String judul, String penulis, String ISBN, String tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.ISBN = ISBN;
        this.tahunTerbit = tahunTerbit;
        this.jenis = "Buku";
    }

    public void print() {
        System.out.println("===============================================");
        System.out.println("Informasi : " + jenis);
        System.out.println("Judul\t\t: " + judul);
        System.out.println("Penulis\t\t: " + penulis);
        System.out.println("ISBN\t\t: " + ISBN);
        System.out.println("Tahun Terbit\t: " + tahunTerbit);
        System.out.println("");
    }

}
