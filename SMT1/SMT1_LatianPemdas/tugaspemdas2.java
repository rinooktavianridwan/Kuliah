
import java.util.Arrays;
import java.util.Scanner;

//LATIHAN 7.3
public class tugaspemdas2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan angka antara 1 sampai 100 (masukkan angka 0 untuk berhenti) :  ");
        int[] angka = new int[100];
        int dalam;
//scan angka
        for (int i = 0; i < angka.length; i++) {
            dalam = in.nextInt();
            if (dalam == 0) {
                break;
            }
            angka[i] = dalam;
        }
//perhitungan angka
        Arrays.sort(angka);
        int keluaran = 0;

        for (int i = 0; i < angka.length; i++) {
            int jumlah = 0;
            if (keluaran >= angka[i]) {
            } else {
                keluaran = angka[i];
                for (int j = 0; j < angka.length; j++) {
                    if (keluaran == angka[j]) {
                        jumlah++;
                    }
                }
                System.out.println(keluaran + " occurs " + jumlah + ((jumlah == 1) ? " time" : " times"));
            }
        }
    }
}
