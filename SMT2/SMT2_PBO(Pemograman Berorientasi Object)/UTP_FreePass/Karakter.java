package UTP_FreePass;

abstract class Karakter {

    private String nama;
    private double nyawa;
    private double energi;
    private double serangan;
    private double maxNyawa;
    private double maxEnergi;

    public Karakter(String nama, double nyawa, double energi, double serangan) {
        this.nama = nama;
        this.nyawa = nyawa;
        this.energi = energi;
        this.serangan = serangan;
        this.maxNyawa = nyawa;
        this.maxEnergi = energi;
    }

    public void serang(Karakter karakterLain) {
        if (karakterLain == null) {
            System.err.println(">> Musuh tidak ditemukan");
            return;
        }
        if (karakterLain.nyawa <= 0) {
            System.err.println(">> Musuh telah mati");
            return;
        }
        if (karakterLain.nyawa >= 0) {
            setEnergi(getEnergi() - 1);
        }
    }

    public boolean isAlive() {
        if (nyawa > 0) {
            return true;
        }
        return false;
    }

    public void pulihkanNyawa() {
        double maxRecoverable = maxNyawa - nyawa;
        if (maxRecoverable != 0) {
            double recoverAmount = Math.min((int) (0.2 * maxNyawa), maxRecoverable);
            nyawa += recoverAmount;
            energi -= 1;
            System.out.println(getNama() + " Telah Memulihkan diri sebanyak " + recoverAmount);
        } else {
            System.out.println("Nyawa Telah Penuh, Tidak Bisa Memulihkan");
        }
    }

    public void serang() {

    }

    public void printStatus() {

    }

    public void resetEnergi() {
        energi = maxEnergi;
    }

    public void Turn() {
        energi -= 1;
    }

    public String getNama() {
        return nama;
    }

    public double getNyawa() {
        return nyawa;
    }

    public double getEnergi() {
        return energi;
    }

    public double getSerangan() {
        return serangan;
    }

    public double getMaxNyawa() {
        return maxNyawa;
    }

    public double getMaxEnergi() {
        return maxEnergi;
    }

    public void setNyawa(double nyawa) {
        this.nyawa = nyawa;
    }

    public void setEnergi(double energi) {
        this.energi = energi;
    }

}
