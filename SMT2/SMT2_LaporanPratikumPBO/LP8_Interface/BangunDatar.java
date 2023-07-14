package LP8_Interface;

abstract class BangunDatar {

    private String nama;
    public static BangunDatar[] listBangunDatar;
    public static int jumlahBangunDatar = 0;

    public BangunDatar(String nama) {
        this.nama = nama;
    }

    public void info() {

    }

    public String getNama() {
        return nama;
    }

    public static void printJumlahSemuaBangunDatar() {
        System.out.println("===============================================");
        System.out.println("Jumlah Bangun Datar\t: " + jumlahBangunDatar);
        Segitiga.printJumlahSegitiga();
        PersegiPanjang.printJumlahPersegiPanjang();
        Lingkaran.printJumlahLingkaran();
        Trapesium.printJumlahTrapesium();
        Layang.printJumlahLayang();

    }

    public static void printSemuaInfo() {
        System.out.println("===============================================");
        System.out.println("Nama Nama Bangun Datar\t: ");
        if (jumlahBangunDatar > 0) {
            if (BangunDatar.listBangunDatar != null) {
                for (BangunDatar bangun : BangunDatar.listBangunDatar) {
                    if (bangun instanceof Segitiga) {
                        System.out.println(((Segitiga) bangun).getNama());
                    } else if (bangun instanceof PersegiPanjang) {
                        System.out.println(((PersegiPanjang) bangun).getNama());
                    } else if (bangun instanceof Lingkaran) {
                        System.out.println(((Lingkaran) bangun).getNama());
                    } else if (bangun instanceof Layang) {
                        System.out.println(((Layang) bangun).getNama());
                    } else if (bangun instanceof Trapesium) {
                        System.out.println(((Trapesium) bangun).getNama());
                    }
                }
            }
        }
        System.out.println("===============================================");
        if (jumlahBangunDatar > 0) {
            if (BangunDatar.listBangunDatar != null) {
                for (BangunDatar bangun : BangunDatar.listBangunDatar) {
                    if (bangun instanceof Segitiga) {
                        ((Segitiga) bangun).info();
                    } else if (bangun instanceof PersegiPanjang) {
                        ((PersegiPanjang) bangun).info();
                    } else if (bangun instanceof Lingkaran) {
                        ((Lingkaran) bangun).info();
                    } else if (bangun instanceof Layang) {
                        ((Layang) bangun).info();
                    } else if (bangun instanceof Trapesium) {
                        ((Trapesium) bangun).info();
                    }

                }
            }
        }
    }

}
