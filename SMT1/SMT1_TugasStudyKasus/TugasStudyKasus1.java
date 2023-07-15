
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class TugasStudyKasus1 {

    public static void main(String[] args) {
        String nama, alm, no, tglb, sa, st;
        long nik, np, d1, d2, hargatiket = 50000;
        int jt;

        NumberFormat numberFormatter = NumberFormat.getNumberInstance(Locale.GERMANY);
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        //input
        System.out.println("==============================================");
        System.out.printf("\t\tFILKOM RAIL EXPRESS\n ");
        System.out.printf("\t  PROGRAM PEMESANAN TIKET KERETA\n");
        System.out.println("==============================================");
        System.out.println("Silahkan masukkan data berikut");
        System.out.print("Nama\t\t\t: ");
        nama = input.nextLine();
        System.out.print("NIK\t\t\t: ");
        nik = input.nextLong();
        System.out.print("Alamat\t\t\t: ");
        alm = in.nextLine();
        System.out.print("Nomor Telepon\t\t: ");
        no = in.nextLine();
        System.out.print("Tanggal Keberangkatan\t: ");
        tglb = in.nextLine();
        System.out.print("Stasiun Asal\t\t: ");
        sa = in.nextLine();
        System.out.print("Stasiun Tujuan\t\t: ");
        st = in.nextLine();
        System.out.print("Jumlah Tiket\t\t: ");
        jt = input.nextInt();
        System.out.print("Nominal Pembayaran\t: ");
        np = input.nextLong();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        //aritmatika
        d1 = jt * hargatiket;
        d2 = np - d1;
        String Str = numberFormatter.format(d1);
        String Str1 = numberFormatter.format(np);
        String Str2 = numberFormatter.format(d2);

        //output
        System.out.println("=============================================");
        System.out.println("\t   Pemesanan Tiket Berhasil");
        System.out.println("=============================================");
        System.out.println("\t\tDETAIL PESANAN");
        System.out.println("=============================================");
        System.out.printf("Nama\t\t\t: %s\n", nama);
        System.out.printf("NIK\t\t\t: %d\n", nik);
        System.out.printf("Alamat\t\t\t: %s\n", alm);
        System.out.printf("Nomor Telepon\t\t: %s\n", no);
        System.out.printf("Tanggal Keberangkatan\t: %s\n", tglb);
        System.out.printf("Stasiun Asal\t\t: %s\n", sa);
        System.out.printf("Stasiun Tujuan\t\t: %s\n", st);
        System.out.printf("Jumlah Tiket\t\t: %d\n", jt);
        System.out.println("");
        System.out.println("");
        System.out.print("Total Harga\t\t: Rp " + Str);
        System.out.println(",-");
        System.out.print("Nominal Pembayaran\t: Rp " + Str1);
        System.out.println(",-");
        System.out.print("Kembalian\t\t: Rp " + Str2);
        System.out.println(",-");
        System.out.println("=============================================");

    }
}
