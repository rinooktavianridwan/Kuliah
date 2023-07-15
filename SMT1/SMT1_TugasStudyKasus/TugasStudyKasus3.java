
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class TugasStudyKasus3 {

    public static void main(String[] args) {
        String nama, alamat, no_telepon, tanggal_berangkat, stasiun_asal, stasiun_tujuan, rute = null;
        /*input*/
        long nik, nominal_pembayaran, nominal_pembayaran_kurang, total_harga, kembalian_normal, kembalian_kurang, hargatiket = 0, km = 0;
        /*in*/
        int jumlah_tiket, jenis_tiket, pilihan, pilihan_kurangdana;
        /*inp*/
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(Locale.GERMANY);
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);

        //menu
        for (pilihan = 1; pilihan < 5; pilihan++) {
            System.out.println("==============================================");
            System.out.printf("\t\tFILKOM RAIL EXPRESS\n ");
            System.out.printf("\t  PROGRAM PEMESANAN TIKET KERETA\n");
            System.out.println("==============================================");
            System.out.println("Menu");
            System.out.println("1. Beli Tiket");
            System.out.println("2. Lihat Jenis Tiket");
            System.out.println("3. List Stasiun");
            System.out.println("4. Keluar");
            System.out.print("Masukkan pilihan anda : ");
            pilihan = inp.nextInt();

            //input
            if (pilihan == 1) {
                System.out.println("Silahkan masukkan data diri anda");
                System.out.print("Nama\t\t\t: ");
                nama = input.nextLine();
                System.out.print("NIK\t\t\t: ");
                nik = in.nextLong();
                System.out.print("Alamat\t\t\t: ");
                alamat = input.nextLine();
                System.out.print("Nomor Telepon\t\t: ");
                no_telepon = input.nextLine();
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
                tanggal_berangkat = input.nextLine();
                System.out.print("Stasiun Asal\t\t: ");
                stasiun_asal = input.nextLine();
                stasiun_asal = stasiun_asal.toLowerCase();
                System.out.print("Stasiun Tujuan\t\t: ");
                stasiun_tujuan = input.nextLine();
                stasiun_tujuan = stasiun_tujuan.toLowerCase();
                System.out.print("Jenis Tiket\t\t: ");
                jenis_tiket = inp.nextInt();
                System.out.print("Jumlah Tiket\t\t: ");
                jumlah_tiket = inp.nextInt();
                System.out.print("Nominal Pembayaran\t: ");
                nominal_pembayaran = in.nextLong();
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");

                //aritmatika
                switch (jenis_tiket) {
                    case 1 ->
                        hargatiket = 400;
                    case 2 ->
                        hargatiket = 700;
                    case 3 ->
                        hargatiket = 1000;
                }
                if ("malang".equals(stasiun_asal)) {
                    if (null != stasiun_tujuan) {
                        switch (stasiun_tujuan) {
                            case "surabaya" -> {
                                rute = "Malang - Surabaya (100 km)";
                                km = 100;
                            }
                            case "yogyakarta" -> {
                                rute = "Malang - Yogyakarta (400 km)";
                                km = 400;
                            }
                            case "serang" -> {
                                rute = "Malang - Serang (1000 km)";
                                km = 1000;
                            }
                        }
                    }
                }
                if ("surabaya".equals(stasiun_asal)) {
                    if (null != stasiun_tujuan) {
                        switch (stasiun_tujuan) {
                            case "semarang" -> {
                                rute = "Surabaya - Semarang (350 km)";
                                km = 350;
                            }
                            case "bandung" -> {
                                rute = "Surabaya - Bandung (700 km)";
                                km = 700;
                            }
                        }
                    }
                }
                if ("yogyakarta".equals(stasiun_asal)) {
                    if (null != stasiun_tujuan) {
                        switch (stasiun_tujuan) {
                            case "jakarta" -> {
                                rute = "Yogyakarta - Jakarta (500 km)";
                                km = 500;
                            }
                        }
                    }
                }
                total_harga = jumlah_tiket * hargatiket * km;
                kembalian_normal = nominal_pembayaran - total_harga;
                String Str = numberFormatter.format(total_harga);
                String Str1 = numberFormatter.format(nominal_pembayaran);
                String Str2 = numberFormatter.format(kembalian_normal);

                //output
                if ((("malang".equals(stasiun_asal)) && (("surabaya".equals(stasiun_tujuan)) || ("yogyakarta".equals(stasiun_tujuan)) || ("serang".equals(stasiun_tujuan))))
                        || ("surabaya".equals(stasiun_asal) && (("semarang".equals(stasiun_tujuan)) || ("bandung".equals(stasiun_tujuan))))
                        || ("yogyakarta".equals(stasiun_asal)) && ("jakarta".equals(stasiun_tujuan))) {
                    if (jenis_tiket == 1 || jenis_tiket == 2 || jenis_tiket == 3) {
                        if (kembalian_normal >= 0) {

                            System.out.println("=============================================");
                            System.out.println("\t   Pemesanan Tiket Berhasil");
                            System.out.println("=============================================");
                            System.out.println("\t\tDETAIL PESANAN");
                            System.out.println("=============================================");
                            System.out.printf("Nama\t\t\t: %s\n", nama);
                            System.out.printf("NIK\t\t\t: %d\n", nik);
                            System.out.printf("Alamat\t\t\t: %s\n", alamat);
                            System.out.printf("Nomor Telepon\t\t: %s\n", no_telepon);
                            System.out.printf("Tanggal Keberangkatan\t: %s\n", tanggal_berangkat);
                            System.out.printf("Rute\t\t\t: %s\n", rute);
                            System.out.printf("Jenis Tiket\t\t: %d\n", jenis_tiket);
                            System.out.printf("Jumlah Tiket\t\t: %d\n", jumlah_tiket);
                            System.out.println("");
                            System.out.println("");
                            System.out.print("Total Harga\t\t: Rp " + Str + ",-\n");
                            System.out.print("Nominal Pembayaran\t: Rp " + Str1 + ",-\n");
                            System.out.print("Kembalian\t\t: Rp " + Str2 + ",-\n");
                            System.out.println("=============================================");
                        }

                        while (kembalian_normal < 0) {
                            int kondisi = 0;
                            for (pilihan_kurangdana = 1; pilihan_kurangdana < 3; pilihan_kurangdana++) {
                                System.out.println("==============================================");
                                System.out.println("Maaf, uang anda tidak mencukupi");
                                System.out.println("==============================================");
                                System.out.println("1. Batalkan Pesanan");
                                System.out.println("2. Ulangi Pembayaran");
                                System.out.print("Pilihan anda: ");
                                pilihan_kurangdana = inp.nextInt();
                                if (pilihan_kurangdana == 2) {
                                    System.out.print("Masukkan Nominal Pembayaran : ");
                                    nominal_pembayaran_kurang = in.nextLong();
                                    kembalian_normal = nominal_pembayaran_kurang - total_harga;
                                    kembalian_kurang = kembalian_normal;
                                    String Str3 = numberFormatter.format(nominal_pembayaran_kurang);
                                    String Str4 = numberFormatter.format(kembalian_kurang);
                                    if (kembalian_kurang >= 0) {
                                        if ((("malang".equals(stasiun_asal)) && (("surabaya".equals(stasiun_tujuan)) || ("yogyakarta".equals(stasiun_tujuan)) || ("serang".equals(stasiun_tujuan))))
                                                || ("surabaya".equals(stasiun_asal) && (("semarang".equals(stasiun_tujuan)) || ("bandung".equals(stasiun_tujuan))))
                                                || ("yogyakarta".equals(stasiun_asal)) && ("jakarta".equals(stasiun_tujuan))) {
                                            if (jenis_tiket == 1 || jenis_tiket == 2 || jenis_tiket == 3) {
                                                System.out.println("=============================================");
                                                System.out.println("\t   Pemesanan Tiket Berhasil");
                                                System.out.println("=============================================");
                                                System.out.println("\t\tDETAIL PESANAN");
                                                System.out.println("=============================================");
                                                System.out.printf("Nama\t\t\t: %s\n", nama);
                                                System.out.printf("NIK\t\t\t: %d\n", nik);
                                                System.out.printf("Alamat\t\t\t: %s\n", alamat);
                                                System.out.printf("Nomor Telepon\t\t: %s\n", no_telepon);
                                                System.out.printf("Tanggal Keberangkatan\t: %s\n", tanggal_berangkat);
                                                System.out.printf("Rute\t\t\t: %s\n", rute);
                                                System.out.printf("Jenis Tiket\t\t: %d\n", jenis_tiket);
                                                System.out.printf("Jumlah Tiket\t\t: %d\n", jumlah_tiket);
                                                System.out.println("");
                                                System.out.println("");
                                                System.out.print("Total Harga\t\t: Rp " + Str + ",-\n");
                                                System.out.print("Nominal Pembayaran\t: Rp " + Str3 + ",-\n");
                                                System.out.print("Kembalian\t\t: Rp " + Str4 + ",-\n");
                                                System.out.println("=============================================");
                                            }
                                        }
                                    }
                                }
                                if (pilihan_kurangdana > 2) {
                                    System.out.println("=============================================");
                                    System.out.println("\tMaaf pilihan tidak tersedia");
                                    System.out.println("=============================================");

                                }
                                if (pilihan_kurangdana == 1) {
                                    kondisi = 1;
                                    break;
                                }
                            }
                            if (kondisi == 1) {
                                System.out.println("=============================================");
                                System.out.println("Pembelian Tiket Telah Dibatalkan");
                                System.out.println("=============================================");
                                break;
                            }
                        }
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
            if (pilihan == 2) {
                System.out.println("Jenis Tiket : ");
                System.out.println("1. Economi Class");
                System.out.println("2. Business Class");
                System.out.println("3. First Class");
                System.out.println("");
            }
            if (pilihan == 3) {
                System.out.println("List stasiun tersedia : ");
                System.out.println("1. Malang \t\t 4. Semarang \t\t 7. Serang");
                System.out.println("2. Surabaya \t\t 5. Bandung \t\t ");
                System.out.println("3. Yogyakarta \t\t 6. Jakarta \t\t ");
                System.out.println("");
            }
            if (pilihan == 4 || pilihan <= 0) {
                System.out.println("==============================================");
                System.out.printf("\t\tFILKOM RAIL EXPRESS\n ");
                System.out.printf("\t\t   TERIMA KASIH\n");
                System.out.println("==============================================");
                break;
            }
        }
    }
}
