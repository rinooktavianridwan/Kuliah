package UAP;

class Tomat extends Tanaman implements Perawatan {

    public Tomat() {
        setMasaHidup(100);
        setBerbuah(100);
        setPerkembangan(0.25);
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
        return "Tomat: " + super.toString();
    }
}
