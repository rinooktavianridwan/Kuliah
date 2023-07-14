package LP6_Inheritance;

class Sejarah extends Buku {

    private String negaraAtauDaerah;
    private String periodeSejarah;

    public Sejarah(String judul, String penulis, String ISBN, String tahunTerbit, String negaraAtauDaerah, String periodeSejarah) {
        super(judul, penulis, ISBN, tahunTerbit);
        this.jenis = "Sejarah";
        this.negaraAtauDaerah = negaraAtauDaerah;
        this.periodeSejarah = periodeSejarah;
    }

    public void print() {
        super.print();
        System.out.println("Negara Atau Daerah : " + negaraAtauDaerah);
        System.out.println("Periode Sejarah\t: " + periodeSejarah);
        System.out.println("");
    }

}
