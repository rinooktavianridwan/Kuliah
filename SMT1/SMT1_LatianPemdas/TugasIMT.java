
import java.util.Scanner;

public class TugasIMT {

    public static void main(String[] args) {
        double b, t, IMT;

        Scanner in = new Scanner(System.in);
        System.out.print("Berat Badan (kg) : ");
        b = in.nextDouble();
        System.out.print("Tinggi Badan (m) : ");
        t = in.nextDouble();
        System.out.println("");
        System.out.println("");

        IMT = b / (t * t);

        if (IMT <= 18.5) {
            System.out.printf("IMT = %.2f \t\t", IMT);
            System.out.println("Termasuk Kurus\n");

        } else if (18.5 < IMT && IMT <= 25) {

            System.out.printf("IMT =  %.2f \t\t", IMT);
            System.out.println("Termasuk Normal\n");

        } else if (25 < IMT && IMT <= 30) {

            System.out.printf("IMT = %.2f \t\t", IMT);
            System.out.println("Termasuk Gemuk\n");

        } else if (IMT > 30) {
            System.out.printf("IMT = %.2f \t\t", IMT);
            System.out.println("Termasuk Kegemukan\n");

        }
    }
}
