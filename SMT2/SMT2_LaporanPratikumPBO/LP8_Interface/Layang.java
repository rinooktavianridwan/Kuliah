package LP8_Interface;

class Layang extends BangunDatar implements Hitung {

    private double diagonal1;
    private double diagonal2;
    private double sisiMiring1;
    private double sisiMiring2;
    public static int jumlahLayang;

    public Layang(String nama, double diagonal1, double diagonal2, double sisiMiring1, double sisiMiring2) {
        super(nama);
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiMiring1 = sisiMiring1;
        this.sisiMiring2 = sisiMiring2;
        jumlahLayang++;
        listBangunDatar[jumlahBangunDatar++] = this;
    }

    public void info() {
        System.out.println("Nama Bangun Datar\t: " + getNama());
        System.out.println("Diagonal 1 Layang\t: " + diagonal1);
        System.out.println("Diagonal 2 Layang\t: " + diagonal2);
        System.out.println("Sisi Miring 1 Layang\t: " + sisiMiring1);
        System.out.println("Sisi Miring 2 Layang\t: " + sisiMiring2);
        System.out.printf("Luas Layang\t\t: %.2f\n", hitungLuas());
        System.out.printf("Keliling Layang\t\t: %.2f\n", hitungKeliling());
        System.out.printf("Luas Segitiga Besar Layang\t: %.2f\n", hitungSpesial());
        System.out.println("===============================================");
    }

    public static void printJumlahLayang() {
        System.out.println("Jumlah Layang\t\t: " + jumlahLayang);
    }

    @Override
    public double hitungLuas() {
        return ((diagonal1 * diagonal2) / 2);
    }

    @Override
    public double hitungKeliling() {
        return (2 * (sisiMiring1 + sisiMiring2));
    }

    @Override
    public double hitungSpesial() {
        double tinggiSegitigaBesar = Math.sqrt(Math.pow(sisiMiring1, 2) - Math.pow((diagonal2 * 0.5), 2));
        return 0.5 * tinggiSegitigaBesar * (diagonal2);

    }

}
