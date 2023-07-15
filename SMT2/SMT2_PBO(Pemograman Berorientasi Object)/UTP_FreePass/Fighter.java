package UTP_FreePass;

class Fighter extends Karakter {

    private double lifesteal;

    public Fighter(String nama, double nyawa, double energi, double serangan, double lifesteal) {
        super(nama, nyawa, energi, serangan);
        this.lifesteal = lifesteal;
    }

    public void serang(Karakter karakterLain) {
        super.serang(karakterLain);
        double damage = karakterLain.getNyawa() - getSerangan();
        double kemampuan = (lifesteal / 100) * getSerangan();
        setNyawa(kemampuan + getNyawa());
        if (karakterLain.getNyawa() > 0) {
            System.out.printf(">> %s Memberikan Damage Kepada %s Sebesar %.0f\n", getNama(), karakterLain.getNama(), getSerangan());
            System.out.printf(">> %s Memulihkan Diri Sebesar %.0f\n", getNama(), kemampuan);
        }
        karakterLain.setNyawa(damage);
    }

    public void printStatus() {
        System.out.printf("%s\t\t: HP = %.0f/%.0f | Turn = %.0f/%.0f | Attack = %.0f | Lifesteal = %.0f%%\t[ Tipe Fighter ]\n", getNama(), getNyawa(), getMaxNyawa(), getEnergi(), getMaxEnergi(), getSerangan(), lifesteal);

    }

}
