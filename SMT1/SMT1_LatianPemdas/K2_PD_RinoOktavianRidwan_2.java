
import java.util.Scanner;

public class K2_PD_RinoOktavianRidwan_2 {

    public static void main(String[] args) {
        int[][] x = new int[3][3];
        int angka;
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                angka = in.nextInt();
                if (angka == 0) {
                    break;
                }
                x[i][j] = angka;
            }

        }
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.print(x[i][j]);
            }
            System.out.println();

        }
    }
}
