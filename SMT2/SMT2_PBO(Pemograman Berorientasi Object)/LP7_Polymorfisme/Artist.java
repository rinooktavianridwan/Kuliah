package LP7_Polymorfisme;

class Artist extends Karyawan {

    private String gayaGambar;
    private String lamaKisaranGambar;
    private String toolsImage;

    public Artist(String gayaGambar, String lamaKisaranGambar, String toolsImage, String namaKaryawan, String id, int usia, int gaji) {
        super(namaKaryawan, id, usia, gaji);
        this.gayaGambar = gayaGambar;
        this.lamaKisaranGambar = lamaKisaranGambar;
        this.toolsImage = toolsImage;
    }

    public String getGayaGambar() {
        return gayaGambar;
    }

    public String getLamaKisaranGambar() {
        return lamaKisaranGambar;
    }

    public String getToolsImage() {
        return toolsImage;
    }

    public void print() {
        super.print();
        System.out.println("Gaya Gambar\t: " + gayaGambar);
        System.out.println("Lama Gambar\t: " + lamaKisaranGambar);
        System.out.println("Aplikasi\t: " + toolsImage);
    }

}
