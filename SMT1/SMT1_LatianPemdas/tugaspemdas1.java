
import java.util.Scanner;

//LATIHAN 7.4
public class tugaspemdas1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        int[] angka = new int[100];
        int dalam;
        int skor;
        int ratarata;
        skor = ratarata = 0;
        for (int i = 0; i < angka.length; i++) {
            dalam = in.nextInt();
            if (dalam < 0) {
                break;
            }
            angka[i] = dalam;
            skor++;
            ratarata += angka[i];
        }

        ratarata /= skor;

        int x, y;
        x = y = 0;
        for (int j = 0; j < skor; j++) {
            if (angka[j] < ratarata && angka[j] >= 0) {
                y++;
            }
            if (angka[j] >= ratarata && angka[j] <= 100) {
                x++;
            }
        }
        System.out.println("Rata-rata : " + ratarata);
        System.out.println("Jumlah angka dibawah rata rata : " + y);
        System.out.println("Jumlah angka diatas rata rata : " + x);

    }

}
