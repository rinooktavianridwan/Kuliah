package LP2d3_ContructorOverloading;

class Main {

    public static void main(String[] args) {

        Karyawan karyawan1 = new Karyawan("Rino", "15B67cfj","19", "Malang", "Pemasaran", "1000000");
        karyawan1.printKaryawan();

        Karyawan karyawan2 = new Karyawan("Oke", "23b65Hgd", "25", "Jakarta", "Akutansi");
        karyawan2.printKaryawan();

        Karyawan karyawan3 = new Karyawan("Docker", "56G47Htr", "30", "Bali");
        karyawan3.printKaryawan();
        Karyawan karyawan4 = new Karyawan("Jumastro", "25Hj86hjU", "40");
        karyawan4.printKaryawan();
        Karyawan karyawan5 = new Karyawan("Vistorko", "23Gh76Yo");
        karyawan5.printKaryawan();

        Karyawan karyawan6 = new Karyawan("Jordon");
        karyawan6.printKaryawan();

        Karyawan karyawan7 = new Karyawan();
        karyawan7.printKaryawan();

    }
}