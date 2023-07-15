package UTP_FreePass;

class Main {

    public static void main(String[] args) {
        Karakter blade = new Fighter("Blade", 80, 2, 30, 30);
        Karakter spellcaster = new Penyihir("Spellcaster", 60, 2, 20, 40);
        Karakter hellPhantom = new Assasin("HellPhantom", 50, 2, 10, 3);
        Karakter shadow = new Assasin("Shadow", 50, 2, 10, 2);
        Karakter[] hero = {hellPhantom, spellcaster};

        Karakter slayer = new Fighter("Slayer", 70, 2, 20, 20);
        Karakter shadowmancer = new Penyihir("Shadowmancer", 60, 2, 20, 20);
        Karakter silentCore = new Assasin("SilentCore", 40, 2, 20, 2);
        Karakter[] musuh = {slayer, silentCore};

        Arena arena = new Arena(hero, musuh);
        arena.mulai();
    }
}
