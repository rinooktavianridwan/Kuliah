package UTP_FreePass;

class Penyihir extends Karakter {

    private double areaDamage;

    public Penyihir(String nama, double nyawa, double energi, double serangan, double areaDamage) {
        super(nama, nyawa, energi, serangan);
        this.areaDamage = areaDamage;
    }

    public void serang(Karakter karakterLain) {
        super.serang(karakterLain);
        double damage = getSerangan();
        if (karakterLain.getNyawa() > 0) {
            System.out.printf(">> %s Memberikan Damage Kepada %s Sebesar %.0f\n", getNama(), karakterLain.getNama(), damage);
            System.out.printf(">> %s Memberikan Damage Kepada Seluruh Pemain Kecuali Target Sebesar %.0f\n", getNama(), (damage * areaDamage / 100));
        }
        karakterLain.setNyawa(karakterLain.getNyawa() - damage);
    }

    public void printStatus() {
        System.out.printf("%s\t: HP = %.0f/%.0f | Turn = %.0f/%.0f | Attack = %.0f | Area Damage = %.0f%%\t[ Tipe Penyihir ]\n", getNama(), getNyawa(), getMaxNyawa(), getEnergi(), getMaxEnergi(), getSerangan(), areaDamage);

    }

    public double getAreaDamage() {
        return areaDamage;
    }

}
