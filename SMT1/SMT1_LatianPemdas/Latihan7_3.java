
import java.util.Scanner;

//LATIHAN 7.3
public class Latihan7_3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        int[] angka = new int[100];
        int dalam;
        int skor;

        skor = 0;
        for (int i = 0; i < angka.length; i++) {
            dalam = in.nextInt();
            if (dalam == 0) {
                break;
            }
            angka[i] = dalam;
            skor++;
        }
        for (int i = 0; i <= skor; i++) {
            int jumlah = 0;
            for (int j = i; j < skor; j++) {
                if (angka[i] == angka[j]) {
                    jumlah += 1;

                }

                if (angka[i] != angka[j]) {
                    jumlah *= 0;
                }
                if (jumlah != 0) {
                    System.out.printf("%d occurs %d %s%n", i, jumlah, jumlah > 1 ? "times" : "time");

                }
            }

        }
    }
}
