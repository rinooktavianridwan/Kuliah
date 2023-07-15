package HR2_CollectionGeneric;


import java.util.Scanner;

public class Pengelompokan_Pekerjaan_Warga {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int angka = in.nextInt();
        in.nextLine(); 
        Warga [] dataWarga = new Warga [angka] ;
        String [] seleksiPekerjaan = new String [angka];
        
        for (int i = 0; i < angka; i++) {
            dataWarga[i] = new Warga();
            dataWarga[i].nik = in.nextLine();
            dataWarga[i].nama = in.nextLine();
            dataWarga[i].pekerjaan = in.nextLine();
            dataWarga[i].jk = in.nextLine();
            dataWarga[i].agama = in.nextLine();
            seleksiPekerjaan[i] = dataWarga [i].pekerjaan;
        }
        
        for(int i=0; i< seleksiPekerjaan.length; i++){
            for(int j=i+1; j<seleksiPekerjaan.length; j++){
                if(seleksiPekerjaan[i] != null && seleksiPekerjaan[i].equals(seleksiPekerjaan[j])){
                    seleksiPekerjaan[j] = null;
                }
            }
        }
        
        for(int i=0; i<dataWarga.length; i++){
            if(seleksiPekerjaan[i] != null){
                System.out.println("Berdasarkan pekerjaan "+ dataWarga[i].pekerjaan + ":");
                System.out.println("");
                for (int j = 0; j < dataWarga.length; j++) {
                    if(seleksiPekerjaan[i].equals(dataWarga[j].pekerjaan)){
                        System.out.println("NIK: "+ dataWarga[j].nik);
                        System.out.println("Nama: "+ dataWarga[j].nama);
                        System.out.println("Jenis Kelamin: "+ dataWarga[j].jk);
                        System.out.println("Agama: "+ dataWarga[j].agama);
                        System.out.println("");
                    }

                }
            }    
            
        }
    }
}
class Warga {
	String nik;
	String nama;
    String pekerjaan;
    String jk;
    String agama;
	/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Warga. */
    public Warga() {
        
    }
    
}