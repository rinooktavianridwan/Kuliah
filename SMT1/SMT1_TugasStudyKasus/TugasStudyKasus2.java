
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class TugasStudyKasus2 {

    public static void main(String[] args) {
        String nama, alm, no, tglb, sa, st, rute = null;
        long nik, np, d1, d2, hargatiket = 0, km = 0;
        int jt, a;

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
        System.out.println("");
        System.out.println("==============================================");
        System.out.println("Silahkan pilih tiket anda");
        System.out.println("==============================================");
        System.out.println("List stasiun tersedia : ");
        System.out.println("1. Malang \t\t 4. Semarang \t\t 7. Serang");
        System.out.println("2. Surabaya \t\t 5. Bandung \t\t ");
        System.out.println("3. Yogyakarta \t\t 6. Jakarta \t\t ");
        System.out.println("");
        System.out.println("Jenis Tiket : ");
        System.out.println("1. Economi Class");
        System.out.println("2. Business Class");
        System.out.println("3. First Class");
        System.out.println("");
        System.out.print("Tanggal Keberangkatan\t: ");
        tglb = in.nextLine();
        System.out.print("Stasiun Asal\t\t: ");
        sa = in.nextLine();
        System.out.print("Stasiun Tujuan\t\t: ");
        st = in.nextLine();
        System.out.print("Jenis Tiket\t\t: ");
        a = input.nextInt();
        System.out.print("Jumlah Tiket\t\t: ");
        jt = input.nextInt();
        System.out.print("Nominal Pembayaran\t: ");
        np = input.nextLong();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        //aritmatika
        switch (a) {
            case 1 ->
                hargatiket = 400;
            case 2 ->
                hargatiket = 700;
            case 3 ->
                hargatiket = 1000;
            default -> {
            }
        }
        if ("Malang".equals(sa)) {
            if (null != st) {
                switch (st) {
                    case "Surabaya" -> {
                        rute = "Malang - Surabaya (100 km)";
                        km = 100;
                    }
                    case "Yogyakarta" -> {
                        rute = "Malang - Yogyakarta (400 km)";
                        km = 400;
                    }
                    case "Serang" -> {
                        rute = "Malang - Serang (1000 km)";
                        km = 1000;
                    }
                    default -> {
                    }
                }
            }
        }
        if ("Surabaya".equals(sa)) {
            if (null != st) {
                switch (st) {
                    case "Semarang" -> {
                        rute = "Surabaya - Semarang (350 km)";
                        km = 350;
                    }
                    case "Bandung" -> {
                        rute = "Surabaya - Bandung (700 km)";
                        km = 700;
                    }
                    default -> {
                    }
                }
            }
        }
        if ("Yogyakarta".equals(sa)) {
            if (null != st) {
                switch (st) {
                    case "Jakarta" -> {
                        rute = "Yogyakarta - Jakarta (500 km)";
                        km = 500;
                    }
                    default -> {
                    }
                }
            }
        }
        d1 = jt * hargatiket * km;
        d2 = np - d1;
        String Str = numberFormatter.format(d1);
        String Str1 = numberFormatter.format(np);
        String Str2 = numberFormatter.format(d2);

        //output
        if (d2 < 0) {
            System.out.println("==============================================");
            System.out.println("Maaf, uang anda tidak mencukupi");
            System.out.println("==============================================");
        }
        if (d2 > 0) {
            if ((("Malang".equals(sa)) && (("Surabaya".equals(st)) || ("Yogyakarta".equals(st)) || ("Serang".equals(st))))
                    || ("Surabaya".equals(sa) && (("Semarang".equals(st)) || ("Bandung".equals(st))))
                    || ("Yogyakarta".equals(sa)) && ("Jakarta".equals(st))) {
                if (a == 1 || a == 2 || a == 3) {

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
                    System.out.printf("Rute\t\t\t: %s\n", rute);
                    System.out.printf("Jenis Tiket\t\t: %d\n", a);
                    System.out.printf("Jumlah Tiket\t\t: %d\n", jt);
                    System.out.println("");
                    System.out.println("");
                    System.out.print("Total Harga\t\t: Rp " + Str + ",-\n");
                    System.out.print("Nominal Pembayaran\t: Rp " + Str1 + ",-\n");
                    System.out.print("Kembalian\t\t: Rp " + Str2 + ",-\n");
                    System.out.println("=============================================");
                } else {
                    System.out.println("=============================================");
                    System.out.println("Maaf, jenis tiket yang anda masukkan salah");
                    System.out.println("=============================================");
                }
            } else {
                System.out.println("=============================================");
                System.out.println("Maaf, rute tidak ditemukan");
                System.out.println("=============================================");
            }
        }

    }
}
