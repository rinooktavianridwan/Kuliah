
import java.util.Scanner;

public class aup {

    public static void main(String[] args) {

//      public static String reverse(String angka) {
//    	/* Silahkan Buat Method Untuk Membalikan angka */
//        Scanner input = new Scanner(System.in);
//        angka = input.nextLine();
//        return angka;
//    }
//  
//    public static void main(String[] args) {
//        /* Happy Coding! */
//        
//        Scanner input = new Scanner(System.in);
//        int angka, jika=0, fungsi;
//        String inputan;
//        
//        
//        inputan = input.nextLine();
//        angka = Integer.parseInt(inputan);
//        if(angka==196){
//            System.out.println("Bilangan dilarang!");
//        }
//        fungsi=angka;
//        if(angka!=196){
//      while( angka != 0 )
//      {
//          jika = jika * 10;
//          jika = jika + angka%10;
//          angka = angka/10;
//      }
//        int akar=jika+fungsi;
//        int akar2=0;
//        int kedua=akar;
//        
//        while( kedua != 0 )
//      {
//          akar2 = akar2 * 10;
//          akar2 = akar2 + kedua%10;
//          kedua = kedua/10;
//      }
//        int akar3=akar+akar2;
//        int akar4=0;
//        int ketiga=akar3;
//        
//        while( ketiga != 0 )
//      {
//          akar4 = akar4 * 10;
//          akar4 = akar4 + ketiga%10;
//          ketiga = ketiga/10;
//      }
//        int akar5=akar3+akar4;
//        
//        
//        
//        System.out.println(fungsi+" + "+jika+" = "+akar);
//        System.out.println(akar+ " + "+ akar2+" = "+akar3 );
//        System.out.println(akar3+ " + "+ akar4+" = "+akar5 );
//        System.out.println(akar5+ " merupakan bilangan palindrome");
//        }
        Scanner in = new Scanner(System.in);
        int pertama, kedua;
        int a, b, c;
        int[] kumnilai = new int[3];
        pertama = in.nextInt();
        kedua = in.nextInt();
        for (int i = 0; i < pertama; i++) {
            a = in.nextInt();
            kumnilai[i] = a;

        }

        int sum = 0;
        for (int i = 0; i < pertama; i++) {
            sum += kumnilai[i];
        }
        System.out.print(pertama + kedua + " ");
        System.out.print(sum);

    }
}
