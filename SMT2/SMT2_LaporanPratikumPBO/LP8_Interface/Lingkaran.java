package LP8_Interface;

class Lingkaran extends BangunDatar implements Hitung {

    private double jari;
    private static final double PI = 3.14;
    public static int jumlahLingkaran;

    public Lingkaran(String nama, double jari) {
        super(nama);
        this.jari = jari;
        jumlahLingkaran++;
        listBangunDatar[jumlahBangunDatar++] = this;
    }

    public void info() {
        System.out.println("Nama Bangun Datar\t: " + getNama());
        System.out.println("Jari-jari Lingkaran\t: " + jari);
        System.out.printf("Luas Lingkaran\t\t: %.2f\n", hitungLuas());
        System.out.printf("Keliling Lingkaran\t: %.2f\n", hitungKeliling());
        System.out.printf("Tembereng Lingkarang\t: %.2f\n", hitungSpesial());
        System.out.println("===============================================");
    }

    public static void printJumlahLingkaran() {
        System.out.println("Jumlah Lingkaran\t\t: " + jumlahLingkaran);
    }

    @Override
    public double hitungLuas() {
        return (PI * Math.pow(jari, 2));
    }

    @Override
    public double hitungKeliling() {
        return (2 * PI * jari);
    }

    @Override
    public double hitungSpesial() {
        return (((PI * Math.pow(jari, 2)) / 4) - (Math.pow(jari, 2) / 2));
    }

}
