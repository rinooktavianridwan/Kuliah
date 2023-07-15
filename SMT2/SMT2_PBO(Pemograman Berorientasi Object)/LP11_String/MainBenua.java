package LP11_String;

class MainBenua {

    public static void main(String[] args) {
        BenuaNegara asia = new BenuaNegara("Asia");
        asia.tambahNegara("Indonesia");
        asia.tambahNegara("China");
        asia.tambahNegara("Jepang");

        BenuaNegara eropa = new BenuaNegara("Eropa");
        eropa.tambahNegara("Inggris");
        eropa.tambahNegara("Belanda");
        eropa.tambahNegara("Jerman");
        eropa.tambahNegara("Spanyol");
        eropa.tambahNegara("Swedia");

        BenuaNegara afrika = new BenuaNegara("Afrika");
        afrika.tambahNegara("Mesir");
        afrika.tambahNegara("Maroko");
        afrika.tambahNegara("Sudan");
        afrika.tambahNegara("Ghana");

        BenuaNegara australia = new BenuaNegara("Australia");
        australia.tambahNegara("Fiji");
        australia.tambahNegara("Samoa");
        australia.tambahNegara("Tonga");
        australia.tambahNegara("Tuvalu");
        australia.tambahNegara("Nauru");
        australia.tambahNegara("Kiribati");

        System.out.println("Daftar Benua : ");
        asia.printInfoBenua();
        eropa.printInfoBenua();
        afrika.printInfoBenua();
        australia.printInfoBenua();
    }
}
