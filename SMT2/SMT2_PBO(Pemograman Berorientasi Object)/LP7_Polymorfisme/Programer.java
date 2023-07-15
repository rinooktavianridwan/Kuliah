package LP7_Polymorfisme;

class Programer extends Karyawan {

    private String bahasaYangPalingDikuasai;
    private String jenisProgrammer;
    private String shift;

    public Programer(String bahasaYangPalingDikuasai, String jenisProgrammer, String shift, String namaKaryawan, String id, int usia, int gaji) {
        super(namaKaryawan, id, usia, gaji);
        this.bahasaYangPalingDikuasai = bahasaYangPalingDikuasai;
        this.jenisProgrammer = jenisProgrammer;
        this.shift = shift;
    }

    public String getBahasaYangPalingDikuasai() {
        return bahasaYangPalingDikuasai;
    }

    public String getJenisProgrammer() {
        return jenisProgrammer;
    }

    public String getShift() {
        return shift;
    }

    public void print() {
        super.print();
        System.out.println("Bahasa Keahlian\t: " + bahasaYangPalingDikuasai);
        System.out.println("Jenis Programer\t: " + jenisProgrammer);
        System.out.println("Shift Kerja\t: " + shift);
    }
}
