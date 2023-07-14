package LP5_StaticFinal;

class KapalPerang extends KendaraanMiliter {

    private int jumlahPesawatPerang;

    public KapalPerang(String nama, int jumlahMuatan, String negara, int jumlahPesawatPerang) {
        super(nama, jumlahMuatan, negara);
        this.jumlahPesawatPerang = jumlahPesawatPerang;
        listKendaraanMiliter[jumlahKendaraan++] = this;
    }

    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Jumlah Pesawat Perang : " + jumlahPesawatPerang + " Unit");
    }

}
