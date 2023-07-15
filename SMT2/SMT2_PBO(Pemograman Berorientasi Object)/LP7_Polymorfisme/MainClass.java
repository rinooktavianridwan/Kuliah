package LP7_Polymorfisme;

class MainClass {

    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan("GAME MMORPG", "INDONESIA", 9);

        Karyawan programer1 = new Programer("Phyton", "Front End", "Pagi", "Onir", "qurtb9q25", 20, 1000000);
        Karyawan programer2 = new Programer("C++", "Back End", "Siang", "Rino", "25b289asfw", 30, 1500000);
        Karyawan programer3 = new Programer("Java", "Full Stack", "Malam", "Tidar", "247cnre", 25, 3000000);
        perusahaan.tambahKaryawan(programer1);
        perusahaan.tambahKaryawan(programer2);
        perusahaan.tambahKaryawan(programer3);

        Karyawan manager1 = new Manager("Pengembangan Ide", 10, "Joko Goergeo", "q83c8723", 37, 2000000);
        Karyawan manager2 = new Manager("Pemasaran dan Penjualan", 15, "Subaru Jordan", "2ycr3y", 26, 1000000);
        Karyawan manager3 = new Manager("Sponsor", 20, "Naruto boruto", "r3ch2n", 19, 4000000);
        perusahaan.tambahKaryawan(manager1);
        perusahaan.tambahKaryawan(manager2);
        perusahaan.tambahKaryawan(manager3);

        Karyawan artist1 = new Artist("Realistis", "20 Hari", "ArtStation", "Martis Subekti", "ud7n2c4", 34, 2500000);
        Karyawan artist2 = new Artist("Anime", "15 Hari", "CorelDraw", "Kuhaku Render", "3yc478", 23, 1500000);
        Karyawan artist3 = new Artist("Abstrak", "30 Hari", "PhotoShop", "Surkori", "sahn23dc", 43, 3000000);
        perusahaan.tambahKaryawan(artist1);
        perusahaan.tambahKaryawan(artist2);
        perusahaan.tambahKaryawan(artist3);

        perusahaan.printPerusahaan();
    }
}
