package LP5_StaticFinal;

class MainPerang {

    public static void main(String[] args) {
        KendaraanMiliter.listKendaraanMiliter = new KendaraanMiliter[10];
        KapalPerang kapalPerang1 = new KapalPerang("Destroyer", 100, "Indonesia", 10);
        KapalPerang kapalPerang2 = new KapalPerang("GoodNight", 150, "Indonesia", 15);
        KapalSelam kapalSelam = new KapalSelam("Kapal Selam Nuklir", 120, "Rusia", 50);

        KendaraanMiliter.tampilkanJumlahKendaraan();
        KendaraanMiliter.tampilSemua();

        //menyerang beda negara
        kapalPerang1.serangan(kapalSelam);
        KendaraanMiliter.tampilSemua();

        //menyerang sama negara
        kapalPerang1.serangan(kapalPerang2);
        KendaraanMiliter.tampilSemua();

        //menyerang diri sendiri
        kapalPerang1.serangan(kapalPerang1);
        KendaraanMiliter.tampilSemua();

        //menyerang musuh yang sudah rusak
        kapalPerang1.serangan(kapalSelam);
        KendaraanMiliter.tampilSemua();

    }
}
