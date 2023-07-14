package UTP_FreePass;

import java.util.Scanner;

class Arena {

    private Karakter[] listHero;
    private Karakter[] listMusuh;

    public Arena(Karakter[] listHero, Karakter[] listMusuh) {
        this.listHero = listHero;
        this.listMusuh = listMusuh;
    }

    public void mulai() {
        System.out.println("=================== Pertarungan Dimulai =============");
        while (heroAlive() && musuhAlive()) {
            printSemuaTim();
            giliranTim1();
            giliranTim2();
            resetAllEnemy();
        }
        if (heroAlive()) {
            System.out.println("Selamat Kamu Telah Menang");
        }

        if (musuhAlive()) {
            System.out.println("Maaf Kamu Kalah");
        }
    }

    public void printSemuaTim() {

        System.out.println("");
        System.out.println("Tim Hero :");
        for (Karakter hero : listHero) {
            if (hero.getNyawa() > 0) {
                hero.printStatus();
            }
        }
        System.out.println("Tim Musuh :");
        for (Karakter musuh : listMusuh) {
            if (musuh.getNyawa() > 0) {
                musuh.printStatus();
            }
        }
        System.out.println("");
    }

    public void giliranTim1() {
        if (heroAlive() && musuhAlive()) {
            System.out.println("=============== Giliran Kamu ===============");
            for (Karakter hero : listHero) {
                if (heroAlive() && musuhAlive()) {
                    while (hero.getNyawa() > 0) {
                        Scanner in = new Scanner(System.in);
                        if (hero.getEnergi() >= 0 && heroAlive() && musuhAlive()) {
                            boolean cek = false;
                            System.out.println();
                            System.out.println("=====Turn " + hero.getNama() + " =====");
                            System.out.println("Attack <Target>");
                            System.out.println("Recovery");
                            System.out.println("End");
                            System.out.print("Perintah : ");
                            String perintah = in.next();
                            if (perintah.equalsIgnoreCase("End")) {
                                printSemuaTim();
                                break;
                            } else if (hero.getEnergi() == 0) {
                                System.out.println("[ Maaf energi Telah Habis ]");
                                System.out.println("===== Please End ======");

                            } else if (perintah.equalsIgnoreCase("Attack")) {
                                String Target = in.next();
                                for (Karakter musuh : listMusuh) {
                                    if (Target.equalsIgnoreCase(musuh.getNama())) {
                                        if (musuh.getNyawa() > 0) {
                                            hero.serang(musuh);
                                            if (hero instanceof Penyihir mage) {
                                                for (Karakter musuh1 : listMusuh) {
                                                    if (!Target.equalsIgnoreCase(musuh1.getNama())) {
                                                        musuh1.setNyawa(musuh1.getNyawa() - (mage.getAreaDamage() / 100) * hero.getSerangan());
                                                    }
                                                }
                                            }
                                            printSemuaTim();
                                            cek = true;
                                            break;
                                        }
                                    }

                                }
                                if (cek != true) {
                                    System.out.println("[ Target Tidak Ditemukan ]");
                                }
                            } else if (perintah.equalsIgnoreCase("Recovery")) {
                                hero.pulihkanNyawa();
                                printSemuaTim();

                            }
                        } else {
                            break;
                        }
                    }
                    System.out.println();
                } else {
                    break;
                }
            }
        }
    }

    public void giliranTim2() {
        if (heroAlive() && musuhAlive()) {
            System.out.println("=============== Giliran Musuh ===============");
            for (Karakter musuh : listMusuh) {
                if (heroAlive() && musuhAlive()) {
                    while (musuh.getNyawa() > 0 && heroAlive() && musuhAlive()) {

                        Scanner in = new Scanner(System.in);
                        if (musuh.getEnergi() >= 0 && heroAlive() && musuhAlive()) {
                            boolean cek = false;
                            System.out.println();
                            System.out.println("===== Turn " + musuh.getNama() + " =====");
                            System.out.println("Attack <Target>");
                            System.out.println("Recovery");
                            System.out.println("End");
                            System.out.print("Perintah : ");
                            String perintah = in.next();
                            if (perintah.equalsIgnoreCase("End")) {
                                printSemuaTim();
                                break;
                            }
                            if (musuh.getEnergi() == 0) {
                                System.out.println("[ Maaf energi Telah Habis ]");
                                System.out.println("===== Please End ======");
                            } else if (perintah.equalsIgnoreCase("Recovery")) {
                                musuh.pulihkanNyawa();
                                printSemuaTim();

                            } else if (perintah.equalsIgnoreCase("Attack")) {
                                String Target = in.next();
                                for (Karakter hero : listHero) {
                                    if (Target.equalsIgnoreCase(hero.getNama())) {
                                        if (musuh.getNyawa() > 0) {
                                            musuh.serang(hero);
                                            if (musuh instanceof Penyihir mage) {
                                                for (Karakter hero1 : listHero) {
                                                    if (!Target.equalsIgnoreCase(hero1.getNama())) {
                                                        hero1.setNyawa(hero1.getNyawa() - (mage.getAreaDamage() / 100) * musuh.getSerangan());
                                                    }
                                                }
                                            }
                                            printSemuaTim();
                                            cek = true;
                                            break;
                                        }
                                    }

                                }
                                if (cek != true) {
                                    System.out.println("[ Target Tidak Ditemukan ]");
                                }
                            }

                        } else {
                            break;
                        }
                    }

                    System.out.println();

                } else {
                    break;
                }
            }
        }

    }

    public void resetAllEnemy() {
        for (Karakter hero : listHero) {
            hero.resetEnergi();
        }
        for (Karakter musuh : listMusuh) {
            musuh.resetEnergi();
        }

    }

    public boolean heroAlive() {
        for (Karakter hero : listHero) {
            if (hero.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public boolean musuhAlive() {
        for (Karakter musuh : listMusuh) {
            if (musuh.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public Karakter[] getListHero() {
        return listHero;
    }

    public Karakter[] getListMusuh() {
        return listMusuh;
    }

}
