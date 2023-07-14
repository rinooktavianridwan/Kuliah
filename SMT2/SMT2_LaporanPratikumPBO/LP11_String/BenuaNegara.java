package LP11_String;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class BenuaNegara {

    private String nama;
    private List<String> daftarNegara;

    public BenuaNegara(String nama) {
        this.nama = nama;
        this.daftarNegara = new ArrayList<>();
    }

    public void tambahNegara(String negara) {
        daftarNegara.add(negara);
    }

    public void printInfoBenua() {
        System.out.println("\nBenua " + nama + " memiliki " + jumlahNegara() + " negara");
        System.out.println("Daftar negara: " + tampilkanDaftarNegara());
    }

    public String tampilkanDaftarNegara() {
        StringJoiner joiner = new StringJoiner(", ");
        for (String negara : daftarNegara) {
            joiner.add(negara);
        }
        return joiner.toString();
    }

    public int jumlahNegara() {
        return daftarNegara.size();
    }

    public String getNama() {
        return nama;
    }

}
