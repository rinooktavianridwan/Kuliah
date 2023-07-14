package LP8_Interface;

class PersegiPanjang extends BangunDatar implements Hitung {

    private double panjang;
    private double lebar;
    public static int jumlahPersegiPanjang;

    public PersegiPanjang(String nama, double panjang, double lebar) {
        super(nama);
        this.lebar = lebar;
        this.panjang = panjang;
        jumlahPersegiPanjang++;
        listBangunDatar[jumlahBangunDatar++] = this;
    }

    public void info() {
        System.out.println("Nama Bangun Datar\t: " + getNama());
        System.out.println("Panjang Persegi Panjang\t: " + panjang);
        System.out.println("Lebar Persegi Panjang\t: " + lebar);
        System.out.printf("Luas Persegi Panjang\t: %.2f\n", hitungLuas());
        System.out.printf("Keliling Persegi Panjang\t: %.2f\n", hitungKeliling());
        System.out.printf("Diagonal Persegi Panjang\t: %.2f\n", hitungSpesial());
        System.out.println("===============================================");
    }

    public static void printJumlahPersegiPanjang() {
        System.out.println("Jumlah Persegi Panjang\t: " + jumlahPersegiPanjang);
    }

    @Override
    public double hitungLuas() {
        return (panjang * lebar);
    }

    @Override
    public double hitungKeliling() {
        return ((2 * panjang) + (2 * lebar));
    }

    @Override
    public double hitungSpesial() {
        return (Math.sqrt(Math.pow(panjang, 2) + Math.pow(lebar, 2)));
    }
}
