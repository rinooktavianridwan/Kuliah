package LP8_Interface;

class Trapesium extends BangunDatar implements Hitung {

    private double alasAtas;
    private double alasBawah;
    private double tinggi;
    public static int jumlahTrapesium;

    public Trapesium(String nama, double alasAtas, double alasBawah, double tinggi) {
        super(nama);
        this.alasAtas = alasAtas;
        this.alasBawah = alasBawah;
        this.tinggi = tinggi;
        jumlahTrapesium++;
        listBangunDatar[jumlahBangunDatar++] = this;
    }

    public void info() {
        System.out.println("Nama Bangun Datar\t: " + getNama());
        System.out.println("Alas Atas Trapesium\t: " + alasAtas);
        System.out.println("Alas Bawah Trapesium\t: " + alasBawah);
        System.out.println("Tinggi Trapesium\t\t: " + tinggi);
        System.out.printf("Luas Trapesium\t\t: %.2f\n", hitungLuas());
        System.out.printf("Keliling Trapesium\t: %.2f\n", hitungKeliling());
        System.out.printf("Luas Kotak Dalam Trapesim\t: %.2f\n", hitungSpesial());
        System.out.println("===============================================");
    }

    public static void printJumlahTrapesium() {
        System.out.println("Jumlah Trapesium\t\t: " + jumlahTrapesium);
    }

    @Override
    public double hitungLuas() {
        return ((alasAtas + alasBawah) * tinggi / 2);
    }

    @Override
    public double hitungKeliling() {
        double alasSegitigaKecil = (alasBawah - alasAtas) / 2;
        double sisiMiring = Math.sqrt(Math.pow(alasSegitigaKecil, 2) + Math.pow(tinggi, 2));
        return ((sisiMiring * 2) + alasAtas + alasBawah);
    }

    @Override
    public double hitungSpesial() {
        return (alasAtas * tinggi);
    }

}
