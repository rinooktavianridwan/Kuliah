package LP8_Interface;

class MainInteface {

    public static void main(String[] args) {

        BangunDatar.listBangunDatar = new BangunDatar[10];
        Lingkaran li1 = new Lingkaran("Lingkaran OX", 7);
        Lingkaran li2 = new Lingkaran("Lingkaran OY", 21);
        Lingkaran li3 = new Lingkaran("Lingkaran OZ", 14);

        PersegiPanjang pp1 = new PersegiPanjang("Persegi Panjang ABCD", 15, 3);
        PersegiPanjang pp2 = new PersegiPanjang("Persegi Panjang EFGH", 10, 5);

        Segitiga se1 = new Segitiga("Segitiga ABC", 8, 4);
        Segitiga se2 = new Segitiga("Segitiga XYZ", 16, 10);

        Trapesium tra1 = new Trapesium("Trapesium MNOP", 8, 12, 4);

        Layang la1 = new Layang("Layang-layang HIJK", 10, 5, 6, 10);
        BangunDatar.printJumlahSemuaBangunDatar();
        BangunDatar.printSemuaInfo();
    }

}
