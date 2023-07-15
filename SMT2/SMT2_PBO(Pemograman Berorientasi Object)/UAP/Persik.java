package UAP;

class Persik extends Tanaman implements Perawatan {

    public Persik() {
        setMasaHidup(180);
        setBerbuah(250);
        setPerkembangan(0.15);
        setProsesBerbuah(0);
    }

    @Override
    public void treatment() {
        setPerkembangan(getPerkembangan() + 0.025);
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
        return "Persik: " + super.toString();
    }
}
