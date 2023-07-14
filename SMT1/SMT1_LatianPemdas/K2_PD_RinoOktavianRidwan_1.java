
import java.util.Scanner;

public class K2_PD_RinoOktavianRidwan_1 {
 
    public static void main(String[] args) {
        float angka;
        float jumlah=0;
        float ratarata=0;
        float jumy=0;
        String pilihan;
        
        do{
        float[] y = new float[100];
        float[] x = new float[100];
        System.out.println("Masukkan data (0 untuk berhenti ): ");  
        Scanner in = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);
       
        
        for( int i=0;i<x.length;i++){
            angka = in.nextInt();
            if (angka==0)break;
            x[i]= angka;
        }
        
      
        jumy=compute(jumy,x, y);
        jumlah =rray(jumlah,x,y);
        ratarata=computeArray(ratarata,jumlah,jumy, x, y);
      
        System.out.printf("Banyak nilai genap = %.0f\n",jumlah );
        System.out.printf("Jumlah nilai genap = %.0f\n", jumy );
        System.out.printf("ratarata nilai genap = %.1f\n", ratarata );
        
        System.out.println("Apakah anda ingin mengulangi lagi (Y/T)");
        pilihan=inp.nextLine();      
       
        }while("Y".equals(pilihan));
       
    }
       
    
    public static float computeArray(float ratarata, float jumlah, float jumy, float[]x, float[]y){
         
       for (int i=0;i<x.length;i++){
            if (x[i]%2==0 && x[i]!=0){
                y[i]=x[i];
               jumy+=y[i];
               jumlah++;
            }
            
        }
       return jumy/jumlah;
    }
    public static float compute(float jumy, float[]x, float[]y){
         
       for (int i=0;i<x.length;i++){
            if (x[i]%2==0 && x[i]!=0){
                y[i]=x[i];
               jumy+=y[i];
            }
            
        }
       return jumy;
    }
   public static float rray(float jumlah, float[]x, float[]y){
         
       for (int i=0;i<x.length;i++){
            if (x[i]%2==0 && x[i]!=0){
                y[i]=x[i];
               jumlah++;
            }
            
        }
       return jumlah;
    } 
    
    
}
