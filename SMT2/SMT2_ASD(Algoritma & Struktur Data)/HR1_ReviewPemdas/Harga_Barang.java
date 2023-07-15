package HR1_ReviewPemdas;

import java.util.Scanner;

public class Harga_Barang {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner (System.in);
      
        int batas = in.nextInt();
        in.nextLine();        
        String [] kumbarang = new String [batas];
        int [] kumharga = new int [batas];
        
        for (int i= 0; i<batas; i++){
            kumbarang[i] = in.nextLine();
            kumharga [i] = in.nextInt();
            if(in.hasNextLine()){
                in.nextLine();
            }
        }
        
        int jumlah=0;
        int hargatinggi = 0;
        
        for (int j = 0; j<batas; j++){
            jumlah+=kumharga[j];
            if(hargatinggi<kumharga[j]){
                hargatinggi = kumharga[j];
            }
        }
        int ratarata = jumlah/batas;
        
        
        int hargarendah = hargatinggi;
        for (int j = 0; j<batas; j++){
            jumlah+=kumharga[j];
            if(hargarendah>kumharga[j]){
                hargarendah = kumharga[j];
            }
        }
        
        
        
        
        //keluar
        System.out.println("Daftar Harga:");
        for (int k=0; k<batas; k++){
            System.out.println("Nama: " + kumbarang[k]);
            System.out.println("Harga: "+ kumharga[k]);
        }
        System.out.println("Harga Tertinggi: "+hargatinggi );
        System.out.println("Harga Terendah: "+ hargarendah );
        System.out.println("Rata-rata Harga: " + ratarata);
    }
}