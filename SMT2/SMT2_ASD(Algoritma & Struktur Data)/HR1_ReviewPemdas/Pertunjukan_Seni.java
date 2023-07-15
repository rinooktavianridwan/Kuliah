package HR1_ReviewPemdas;

import java.util.Scanner;

public class Pertunjukan_Seni {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner (System.in);
        int baris = in.nextInt();
        int kolom = in.nextInt();
        
        int [][] duduk = new int [baris][kolom];
        
        
        int penonton = in.nextInt();
        
        for ( int i = 0; i<penonton; i++){
            int pertama = in.nextInt();
            int kedua = in.nextInt();
            duduk[pertama][kedua] = 10;
            
            
        }
        int c=0;
        for(int j= 0; j<baris; j++){
            for (int k=0; k<kolom; k++){
                if(duduk[j][k]==10){
                    System.out.print("X ");
                }
                else{
                    System.out.print("O ");
                }
                c++;
                if(c==kolom){
                    System.out.println("");
                    c=0;
                }
                
            }
        }
        
        
    }
}