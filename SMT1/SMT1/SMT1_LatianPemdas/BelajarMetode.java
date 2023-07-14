
import java.util.Scanner;

public class BelajarMetode {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        char pilihan = '0';
        do {
            System.out.println("Masukkan Pilihan : ");
            System.out.println("1. Perkalian a dengan b");
            System.out.println("2. Penjumlahan a dengan b");
            System.out.println("3. Menampilkan a sebanyak b");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            pilihan = in.next().charAt(0);
            int c, a, b;
            switch (pilihan) {

                case '1':
                    //perkalian
                    System.out.print("Masukkan Nilai a : ");
                    a = in.nextInt();
                    System.out.print("Masukkan Nilai b : ");
                    b = in.nextInt();
                    c = a * b;
                    System.out.println("Hasil Perkalian a dengan b adalah : " + (c));
                    break;

                case '2':
                    System.out.print("Masukkan Nilai a : ");
                    a = in.nextInt();
                    System.out.print("Masukkan Nilai b : ");
                    b = in.nextInt();
                    c = a + b;
                    System.out.println("Hasil Perkalian a dengan b adalah : " + (c));
                    break;

                case '3':
                    System.out.print("Masukkan Nilai a : ");
                    a = in.nextInt();
                    System.out.print("Masukkan Nilai b : ");
                    b = in.nextInt();
                    for (int i = 0; i < b; i++) {
                        System.out.println(a);
                    }
                    break;

            }
            System.out.println("");
        } while (pilihan != '0');
    }
}
