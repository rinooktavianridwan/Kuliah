package UAP;

class Stroberi extends Tanaman implements Perawatan {

    public Stroberi() {
        setMasaHidup(60);
        setBerbuah(150);
        setPerkembangan(0.35);
        setProsesBerbuah(0);
    }

    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 0.05);
    }

    @Override
    public void berkembang() {
        setLamaHidup(getLamaHidup() + 1);
        setProsesBerbuah(getProsesBerbuah() + getPerkembangan() * getBerbuah());

        if (getProsesBerbuah() >= getBerbuah()) {
            setBuah(getBuah() + 1);
            if (getProsesBerbuah() == getBerbuah()) {
                setProsesBerbuah(0);
            } else if (getProsesBerbuah() > getBerbuah()) {
                setProsesBerbuah(getProsesBerbuah() - getBerbuah());
            }

        }
    }

    @Override
    public String toString() {
        return "Stroberi: " + super.toString();
    }
}
