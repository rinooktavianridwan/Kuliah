
package LP4_Encapsulation;

class Proyek {

    private String namaProyek;
    private String lokasi;
    private String durasi;

    public Proyek(String namaProyek, String lokasi, String durasi) {
        this.namaProyek = namaProyek;
        this.lokasi = lokasi;
        this.durasi = durasi;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

}
