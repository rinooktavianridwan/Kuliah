import java.util.Scanner;
public class BelajarMetodeFix{
    //prosedur
    public static void Menu(){
        System.out.println("Masukkan Pilihan : ");
        System.out.println("1. Perkalian a dengan b");
        System.out.println("2. Penjumlahan a dengan b");
        System.out.println("3. Menampilkan a sebanyak b");
        System.out.println("0. Keluar");
        System.out.print("Pilihan : ");
    }
    public static void outputakali (int a, int b){
            System.out.println("Menampilkan "+a+" sebanyak "+ b);
            for (int i=0; i<b; i++){
                System.out.println(a);    
        }
    }
    //fungsi
    public static int inputint(String var){
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Nilai "+ var + " : ");
        return in.nextInt();
        
    }
    
    public static int hasilKali (int a,int b){
        return a*b;
    }

    public static int hasilTambah (int a,int b){
        return a+b;
    }
    
    public static void main(String[] args) {
    int a,b;
        
    
    Scanner in = new Scanner(System.in);
    char pilihan = '0';
    do{
    //Menu
    Menu();
        pilihan = in.next().charAt(0);
        int c = 0;
        switch (pilihan){
            
            case '1' -> {
                //perkalian
                a = inputint("a");
                b = inputint("b");
                c=a*b;
                System.out.println("Hasil Perkalian a dengan b adalah : "+ (c));
            }
                
            case '2' -> {    
                a = inputint("a");
                b = inputint("b");
                c = a+b;
                System.out.println("Hasil Perkalian a dengan b adalah : "+ (c));
            }
              
                 
            case '3' -> {    
                a = inputint("a");
                b = inputint("b");
                outputakali(a,b);
            }
                
            }      
                System.out.println("");
        }while (pilihan!= '0');
    }
}

