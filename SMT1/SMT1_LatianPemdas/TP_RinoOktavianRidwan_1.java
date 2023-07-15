
import java.util.Scanner;

/*
Contoh Input :
SISWA Ani
SISWA Budi
SISWA Caca
PRINT_SISWA
MATPEL Matematika
MATPEL Biologi
MATPEL Fisika
MATPEL Kimia
PRINT_MATPEL
NILAI Ani GENAP Matematika 80
NILAI Ani GENAP Fisika 85
NILAI Ani GENAP Kimia 75
NILAI Ani GENAP Biologi 70
NILAI Ani GANJIL Matematika 85
NILAI Ani GANJIL Fisika 80
NILAI Ani GANJIL Kimia 80
NILAI Ani GANJIL Biologi 75
NILAI Budi GENAP Matematika 90
NILAI Budi GENAP Fisika 85
NILAI Budi GENAP Kimia 90
NILAI Budi GENAP Biologi 80
NILAI Budi GANJIL Matematika 75
NILAI Budi GANJIL Fisika 70
NILAI Budi GANJIL Kimia 75
NILAI Budi GANJIL Biologi 70
NILAI Caca GENAP Matematika 80
NILAI Caca GENAP Fisika 85
NILAI Caca GENAP Kimia 90
NILAI Caca GENAP Biologi 80
NILAI Caca GANJIL Matematika 85
NILAI Caca GANJIL Fisika 90
NILAI Caca GANJIL Kimia 75
NILAI Caca GANJIL Biologi 90
PRINT_RAPORT Ani
PRINT_RAPORT Budi
PRINT_RAPORT Caca
CARI_JUARA GANJIL
CARI_JUARA GENAP
HITUNG_NILAI GANJIL
HITUNG_NILAI GENAP
 */

 /*
SISWA Ani
SISWA Budi
SISWA Caca
PRINT_SISWA
MATPEL Matematika
MATPEL Biologi
MATPEL Fisika
MATPEL Kimia
PRINT_MATPEL
 */
public class TP_RinoOktavianRidwan_1 {

    final static int MAX_SISWA = 10;
    final static int MAX_MATPEL = 10;
    final static int MAX_SEMESTER = 2;

    /* menyimpan nama siswa */
    static String[] siswa = new String[MAX_SISWA];

    /* menyimpan nama matpel per siswa tiap semester, semester ganjil=0, genap=1 */
    static String[][][] siswaMatpel = new String[MAX_SISWA][MAX_SEMESTER][MAX_MATPEL];


    /* menyimpan nilai matpel per siswa tiap semester, semester ganjil=0, genap=1 */
    static double[][][] siswaMatpelNilai = new double[MAX_SISWA][MAX_SEMESTER][MAX_MATPEL];

    /* menyimpan banyak siswa */
    static int banyakSiswa = 0;

    /* menyimpan banyak matpel */
    static int banyakSiswaMatpel = 0;

    public static String konversiNilai(double nilai) {
        String huruf_Penentu = null;
        if (80 < nilai && nilai < 100) {
            huruf_Penentu = "A";
        }
        if (75 < nilai && nilai <= 80) {
            huruf_Penentu = "B+";
        }
        if (69 < nilai && nilai <= 75) {
            huruf_Penentu = "B";
        }
        if (65 < nilai && nilai <= 69) {
            huruf_Penentu = "C+";
        }
        if (59 < nilai && nilai <= 65) {
            huruf_Penentu = "C";
        }
        if (55 < nilai && nilai <= 59) {
            huruf_Penentu = "D+";
        }
        if (40 < nilai && nilai <= 55) {
            huruf_Penentu = "D";
        }
        if (nilai <= 40) {
            huruf_Penentu = "E";
        }
        return huruf_Penentu;
    }

    public static void tambahSiswa(String nama) {
        siswa[banyakSiswa] = nama;
        banyakSiswa++;

    }

    public static void tambahMatpel(String matpel) {
        for (int i = 0; i < banyakSiswa; i++) {
            for (int j = 0; j < MAX_SEMESTER; j++) {
                siswaMatpel[i][j][banyakSiswaMatpel] = matpel;
            }
        }
        banyakSiswaMatpel++;
    }

    public static int cariSiswa(String nama) {
        int posisi = 0;
        for (int i = 0; i < banyakSiswa; i++) {
            if (!siswa[i].equals(nama)) {
                posisi++;
            } else {
                break;
            }
        }
        return posisi;
    }

    public static int cariMatpel(String matpel) {
        int posisi = 0;
        for (int i = 0; i < banyakSiswaMatpel; i++) {
            if (!siswaMatpel[0][0][posisi].equals(matpel)) {
                posisi++;
            } else {
                break;
            }
        }
        return posisi;
    }

    /*
nama: nama siswa
semester: semester, 0 untuk ganjil, 1 untuk genap
matpel: nama matpel
nilai: nilai matpel tiap semester
     */
    public static void isiDataSiswa(String nama, int semester, String matpel, int nilai) {
        if (semester == 0) {
            siswaMatpelNilai[cariSiswa(nama)][semester][cariMatpel(matpel)] = nilai;
        }
        if (semester == 1) {
            siswaMatpelNilai[cariSiswa(nama)][semester][cariMatpel(matpel)] = nilai;
        }
    }

    public static void printSiswa() {
        System.out.println();
        System.out.print("SISWA : ");
        for (int i = 0; i < banyakSiswa; i++) {
            if (siswa[i] != null) {
                System.out.print(siswa[i] + " ");
            }
        }
        System.out.println();
    }

    public static void printMatpel() {
        System.out.print("MATA PELAJARAN: ");
        for (int i = 0; i < banyakSiswaMatpel; i++) {
            if (siswaMatpel[0][0][i] != null) {
                System.out.print(siswaMatpel[0][0][i] + " ");
            }
        }
        System.out.println();
    }

    public static void printRaportSiswa(String nama) {
        double nilai;
        int posisisiswa;
        System.out.println(">> BEGIN RAPORT <<");
        System.out.println();
        System.out.println("Nama: " + nama);
        System.out.println("Semester: Ganjil");
        System.out.printf("%-20s%c%10s%c%15s\n", "Mata Pelajaran", '|', "Nilai", '|', "Nilai Huruf");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < banyakSiswaMatpel; i++) {
            posisisiswa = cariSiswa(nama);
            System.out.printf("%-20s%c%10s%c%15s\n", siswaMatpel[posisisiswa][0][i], '|', siswaMatpelNilai[posisisiswa][0][i], '|', konversiNilai(siswaMatpelNilai[posisisiswa][0][i]));
        }
        System.out.println();
        System.out.println("Semester: Genap");
        System.out.printf("%-20s%c%10s%c%15s\n", "Mata Pelajaran", '|', "Nilai", '|', "Nilai Huruf");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < banyakSiswaMatpel; i++) {
            posisisiswa = cariSiswa(nama);
            System.out.printf("%-20s%c%10s%c%15s\n", siswaMatpel[posisisiswa][1][i], '|', siswaMatpelNilai[posisisiswa][1][i], '|', konversiNilai(siswaMatpelNilai[posisisiswa][1][i]));
        }
        System.out.println();
        System.out.println(">> END RAPORT <<");
    }

    public static int cariJuara(int semester) {
        int posisi = 0;
        double[] ratarata = new double[banyakSiswa];
        for (int i = 0; i < banyakSiswa; i++) {
            double jumnilai = 0;
            for (int j = 0; j < banyakSiswaMatpel; j++) {
                jumnilai += siswaMatpelNilai[i][semester][j];
            }
            ratarata[i] = jumnilai / banyakSiswaMatpel;
            double juara = ratarata[0];
            for (int j = 0; j < banyakSiswa; j++) {
                if (ratarata[j] > juara) {
                    juara = ratarata[j];
                    posisi = j;
                }

            }
        }
        return posisi;
    }

    public static void hitungNilai(int semester) {
        String huruf;
        for (int i = 0; i < banyakSiswa; i++) {
            int NILAIA = 0, NILAIB = 0, NILAIb = 0, NILAIC = 0, NILAIc = 0, NILAID = 0, NILAId = 0, NILAIE = 0;
            for (int j = 0; j < banyakSiswaMatpel; j++) {
                huruf = konversiNilai(siswaMatpelNilai[i][semester][j]);
                if ("A" == huruf) {
                    NILAIA++;
                }
                if ("B+" == huruf) {
                    NILAIB++;
                }
                if ("B" == huruf) {
                    NILAIb++;
                }
                if ("C+" == huruf) {
                    NILAIC++;
                }
                if ("C" == huruf) {
                    NILAIc++;
                }
                if ("D+" == huruf) {
                    NILAID++;
                }
                if ("D" == huruf) {
                    NILAId++;
                }
                if ("E" == huruf) {
                    NILAIE++;
                }
            }
            System.out.print(siswa[i] + " ");
            if (NILAIA > 0) {
                System.out.print("A:" + NILAIA + " ");
            }
            if (NILAIB > 0) {
                System.out.print("B+:" + NILAIB + " ");
            }
            if (NILAIb > 0) {
                System.out.print("B:" + NILAIb + " ");
            }
            if (NILAIC > 0) {
                System.out.print("C+:" + NILAIC + " ");
            }
            if (NILAIc > 0) {
                System.out.print("c:" + NILAIc + " ");
            }
            if (NILAID > 0) {
                System.out.print("D:" + NILAID + " ");
            }
            if (NILAIE > 0) {
                System.out.print("E:" + NILAIE + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String nama, perintah, jika, masukan, matpel;
        int semester = 0, nilai, jumnilai = 0, ratarata = 0;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < siswa.length; i++) {
            perintah = in.next();
            if ("PRINT_SISWA".equals(perintah)) {
                printSiswa();
                break;
            }
            masukan = in.next();
            if ("SISWA".equals(perintah)) {
                tambahSiswa(masukan);
            }
        }
        for (int i = 0; i < MAX_MATPEL; i++) {
            perintah = in.next();
            if ("PRINT_MATPEL".equals(perintah)) {
                printMatpel();
                break;
            }
            masukan = in.next();
            if ("MATPEL".equals(perintah)) {
                tambahMatpel(masukan);
            }
        }
        for (int i = 0; i < banyakSiswa * banyakSiswaMatpel * MAX_SEMESTER; i++) {
            perintah = in.next();
            if (perintah.equals("NILAI")) {
                nama = in.next();
                jika = in.next();
                if ("GENAP".equals(jika)) {
                    semester = 1;
                } else if ("GANJIL".equals(jika)) {
                    semester = 0;
                }
                matpel = in.next();
                nilai = in.nextInt();
                isiDataSiswa(nama, semester, matpel, nilai);
            }
        }
        for (int i = 0; i < banyakSiswa; i++) {
            perintah = in.next();
            masukan = in.next();
            if (perintah.equals("PRINT_RAPORT")) {
                printRaportSiswa(masukan);
            }
        }
        for (int i = 0; i < 4; i++) {
            perintah = in.next();
            masukan = in.next();
            if (masukan.equals("GANJIL")) {
                semester = 0;
            } else if (masukan.equals("GENAP")) {
                semester = 1;
            }

            if (perintah.equals("CARI_JUARA")) {
                int juara = cariJuara(semester);
                System.out.println("JUARA_1 " + masukan + " " + siswa[juara]);
            }
            if (perintah.equals("HITUNG_NILAI")) {
                hitungNilai(semester);
            }
        }
    }

}
