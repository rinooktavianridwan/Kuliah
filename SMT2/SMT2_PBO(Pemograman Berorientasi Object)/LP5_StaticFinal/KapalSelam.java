package LP5_StaticFinal;

class KapalSelam extends KendaraanMiliter {

    private int kedalaman;

    public KapalSelam(String nama, int jumlahMuatan, String negara, int kedalaman) {
        super(nama, jumlahMuatan, negara);
        this.kedalaman = kedalaman;
        listKendaraanMiliter[jumlahKendaraan++] = this;
    }

    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Kemampuan Menyelam : " + kedalaman + " Km Dibawah Permukaan Air Laut");
    }
}
