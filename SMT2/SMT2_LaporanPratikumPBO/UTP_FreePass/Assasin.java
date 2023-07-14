package UTP_FreePass;

class Assasin extends Karakter {

    private double bonusSerangan;

    public Assasin(String nama, double nyawa, double energi, double serangan, double bonusSerangan) {
        super(nama, nyawa, energi, serangan);
        this.bonusSerangan = bonusSerangan;
    }

    public void serang(Karakter karakterLain) {
        super.serang(karakterLain);
        double damage = getSerangan() * bonusSerangan;
        if (karakterLain.getNyawa() > 0) {
            System.out.printf(">> %s Memberikan Damage Kepada %s Sebesar %.0f\n", getNama(), karakterLain.getNama(), damage);
        }
        karakterLain.setNyawa(karakterLain.getNyawa() - damage);
    }

    public void printStatus() {
        System.out.printf("%s\t: HP = %.0f/%.0f | Turn = %.0f/%.0f | Attack = %.0f | Bonus Attack = %.0fx\t[ Tipe Assasin ]\n", getNama(), getNyawa(), getMaxNyawa(), getEnergi(), getMaxEnergi(), getSerangan(), bonusSerangan);

    }

}
