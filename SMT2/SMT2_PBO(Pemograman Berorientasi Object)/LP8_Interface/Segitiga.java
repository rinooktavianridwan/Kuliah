package LP8_Interface;

class Segitiga extends BangunDatar implements Hitung {

    private double alas;
    private double tinggi;
    public static int jumlahSegitiga;

    public Segitiga(String nama, double alas, double tinggi) {
        super(nama);
        this.alas = alas;
        this.tinggi = tinggi;
        jumlahSegitiga++;
        listBangunDatar[jumlahBangunDatar++] = this;
    }

    public void info() {
        System.out.println("Nama Bangun Datar\t: " + getNama());
        System.out.println("Alas Segitiga\t\t: " + alas);
        System.out.println("Tinggi Segitiga\t\t: " + tinggi);
        System.out.printf("Luas Segitiga\t\t: %.2f\n", hitungLuas());
        System.out.printf("Keliling Segitiga\t: %.2f\n", hitungKeliling());
        System.out.printf("Sisi Miring Segitiga\t: %.2f\n", hitungSpesial());
        System.out.println("===============================================");
    }

    public static void printJumlahSegitiga() {
        System.out.println("Jumlah Segitiga\t\t: " + jumlahSegitiga);
    }

    @Override
    public double hitungLuas() {
        return (alas * tinggi * (0.5));
    }

    @Override
    public double hitungKeliling() {
        return (alas + tinggi + hitungSpesial());

    }

    @Override
    public double hitungSpesial() {
        return (Math.sqrt(Math.pow(alas, 2) + Math.pow(tinggi, 2)));
    }
}
