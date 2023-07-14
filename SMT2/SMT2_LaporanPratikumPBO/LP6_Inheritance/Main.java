package LP6_Inheritance;

class Main {

    public static void main(String[] args) {
        Buku buku1 = new Buku("1984", "George Orwell", "9780451524935", "1949");
        Buku buku2 = new Buku("The Hobbit", "J.R.R. Tolkien", "9780547928227", "1937");
        buku1.print();
        buku2.print();

        Komik komik1 = new Komik("Naruto Gaiden: The Seventh Hokage and the Scarlet Spring", "Masashi Kishimoto", "978-4-08-880723-8", "2015", "Manga (Tidak Bewarna)", "14-16");
        Komik komik2 = new Komik("Berserk", "Kentaro Miura", "978-4-59-213710-2", "1989", "Manga (Bewarna)", "16-18");
        komik1.print();
        komik2.print();

        Majalah majalah1 = new Majalah("National Geographic Indonesia", "Tim National Geographic Indonesia", "978-602-5513-52-4", "2020", "Alam dan Lingkungan", "232");
        Majalah majalah2 = new Majalah("Cosmopolitan Indonesia", "Tim Cosmopolitan Indonesia", "977-2334-84-730-7", "2020", "Gaya Hidup", "048");
        majalah1.print();
        majalah2.print();

        Buku sejarah1 = new Sejarah("Sejarah Asia", "Rhoads Murphey", "978-0-415-77394-7", "2010", "Asia", "Zaman Kuno");
        Buku sejarah2 = new Sejarah("Sejarah Mesir Kuno", " John Romer", "978-0-312-61427-3", "2012", "Mesir", "Mesir Kuno");
        sejarah1.print();
        sejarah2.print();

    }

}
