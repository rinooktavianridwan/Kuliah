
import java.util.Scanner;
/*
Contoh Input :
PAKET
1.3
30
15
10
PICKUP
*/

public class T2_RinoOktavianRidwan_1 {

    public static void main(String[] args) {
        String Type_paket, Jenis_pengantar, Jenis_keluar = null, Jenis_biaya;
        float Berat_paket, Panjang_paket, Lebar_kiriman, Tinggi_kiriman;
        float Berat_volumetrik, Berat_pembulatan, Total_biaya, Biaya1kg = 100000;
        Scanner in = new Scanner(System.in);
        Scanner inP = new Scanner(System.in);
        Type_paket = in.nextLine();
        Berat_paket = inP.nextFloat();
        Panjang_paket = inP.nextFloat();
        Lebar_kiriman = inP.nextFloat();
        Tinggi_kiriman = inP.nextFloat();
        Jenis_pengantar = in.nextLine();
        //aritmatika

        if ("PAKET".equals(Type_paket)) {
            if (null != Jenis_pengantar) {
                switch (Jenis_pengantar) {
                    case "PICKUP" ->
                        Jenis_keluar = "PAKET DIAMBIL DAN DITERIMA";
                    case "ANTARSENDIRI" ->
                        Jenis_keluar = "PAKET DITERIMA";
                }
            }
        }
        if ("DOKUMEN".equals(Type_paket)) {
            if (null != Jenis_pengantar) {
                switch (Jenis_pengantar) {
                    case "PICKUP" ->
                        Jenis_keluar = "DOKUMEN DIAMBIL DAN DITERIMA";
                    case "ANTARSENDIRI" ->
                        Jenis_keluar = "DOKUMEN DITERIMA";
                }
            }
        }

        Berat_pembulatan = Math.round(Berat_paket);
        Berat_volumetrik = (Panjang_paket * Lebar_kiriman * Tinggi_kiriman) / 3000;
        if (Berat_volumetrik >= Berat_pembulatan) {
            Jenis_biaya = "BIAYA_VOLUMETRIK";
            Total_biaya = Biaya1kg * Berat_volumetrik;
            if ("PICKUP".equals(Jenis_pengantar)) {
                Total_biaya += 4000;
            }
        } else {
            Jenis_biaya = "BIAYA_BERAT";
            Total_biaya = Biaya1kg * Berat_pembulatan;
            if ("PICKUP".equals(Jenis_pengantar)) {
                Total_biaya += 4000;
            }
        }
        System.out.println(Jenis_keluar);
        System.out.println(Jenis_biaya);
        System.out.printf("BERAT_PEMBULATAN %.0f\n", Berat_pembulatan);
        System.out.printf("BERAT_VOLUMETRIK %.2f\n", Berat_volumetrik);
        System.out.printf("TOTAL %.0f", Total_biaya);
    }
}
