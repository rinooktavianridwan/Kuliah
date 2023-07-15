
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class TugasStudyKasus4 {

    public static void main(String[] args) {
        String nama, alamat, no_telepon, tanggal_berangkat, stasiun_asal, stasiun_tujuan, List_ID;
        /*input*/
        long nik, nominal_pembayaran, total_harga, kembalian_normal, Harga_tiket;
        /*in*/
        int jumlah_tiket, jenis_tiket, pilihan, pilihan_kurangdana;
        /*inp*/
        String rute = null;
        int hargatiket = 0;
        int km = 0;
        int batas_simpan = 0;
        String[] History = new String[5];
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(Locale.GERMANY);
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Scanner inp = new Scanner(System.in);

        //menu
        System.out.println("==============================================");
        System.out.printf("\t\tFILKOM RAIL EXPRESS\n ");
        System.out.printf("\t  PROGRAM PEMESANAN TIKET KERETA\n");
        System.out.println("==============================================");
        for (pilihan = 1; pilihan <= 5; pilihan++) {
            printMenu();
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

                //aritmatika      
                km = Hitung_jarak(stasiun_asal, stasiun_tujuan, km);
                Harga_tiket = Hitung_hargatiket(jenis_tiket, hargatiket, km);
                total_harga = Hitung_Total(Harga_tiket, jumlah_tiket);
                kembalian_normal = Hitung_Kembalian(nominal_pembayaran, total_harga);
                rute = ruteperjalanan(stasiun_asal, stasiun_tujuan, rute);
                if ((("malang".equals(stasiun_asal)) && ("surabaya".equals(stasiun_tujuan) || "yogyakarta".equals(stasiun_tujuan) || "serang".equals(stasiun_tujuan)))
                        || (("surabaya".equals(stasiun_asal)) && ("semarang".equals(stasiun_tujuan) || "bandung".equals(stasiun_tujuan)))
                        || ("yogyakarta".equals(stasiun_asal) && ("jakarta".equals(stasiun_tujuan)))) {
                    if (jenis_tiket == 1 || jenis_tiket == 2 || jenis_tiket == 3) {

                        //output
                        while (nominal_pembayaran < total_harga) {
                            System.out.println("==============================================");
                            System.out.println("Maaf, uang anda tidak mencukupi");
                            System.out.println("==============================================");
                            System.out.println("1. Batalkan Pesanan");
                            System.out.println("2. Ulangi Pembayaran");
                            System.out.print("Pilihan anda: ");
                            pilihan_kurangdana = inp.nextInt();
                            if (pilihan_kurangdana == 2) {
                                System.out.print("Masukkan Nominal Pembayaran : ");
                                nominal_pembayaran = inp.nextLong();
                                kembalian_normal = Hitung_Kembalian(nominal_pembayaran, total_harga);
                            }
                            if (pilihan_kurangdana == 1) {
                                break;
                            }
                        }
                        if (nominal_pembayaran >= total_harga) {
                            String Str = numberFormatter.format(total_harga);
                            String Str1 = numberFormatter.format(nominal_pembayaran);
                            String Str2 = numberFormatter.format(kembalian_normal);
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
                            List_ID = List_ID(stasiun_asal, stasiun_tujuan, tanggal_berangkat);
                            tambahHistory(List_ID, batas_simpan, History);
                            batas_simpan++;
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
                printJenisTiket();
            }
            if (pilihan == 3) {
                printListStasiun();
            }
            if (pilihan == 4) {
                printHistory(History, batas_simpan);
            }
            if (pilihan >= 5 || pilihan <= 0) {
                break;
            }
        }
    }

    //Kumpulan Methode
    public static void printMenu() {
        System.out.println("");
        System.out.println("Menu");
        System.out.println("1. Beli Tiket");
        System.out.println("2. Lihat Jenis Tiket");
        System.out.println("3. List Stasiun");
        System.out.println("4. Riwayat Pesanan");
        System.out.println("5. Keluar");
        System.out.print("Masukkan pilihan anda : ");
    }

    public static void printListStasiun() {
        System.out.println("List stasiun tersedia : ");
        System.out.println("1. Malang \t\t 4. Semarang \t\t 7. Serang");
        System.out.println("2. Surabaya \t\t 5. Bandung \t\t ");
        System.out.println("3. Yogyakarta \t\t 6. Jakarta \t\t ");

    }

    public static void printJenisTiket() {
        System.out.println("Jenis Tiket : ");
        System.out.println("1. Economi Class");
        System.out.println("2. Business Class");
        System.out.println("3. First Class");
    }

    public static int Hitung_jarak(String stasiun_asal, String stasiun_tujuan, int km) {
        if ("malang".equals(stasiun_asal)) {
            if (null != stasiun_tujuan) {
                switch (stasiun_tujuan) {
                    case "surabaya" ->
                        km = 100;
                    case "yogyakarta" ->
                        km = 400;
                    case "serang" ->
                        km = 1000;
                }
            }
        }
        if ("surabaya".equals(stasiun_asal)) {
            if (null != stasiun_tujuan) {
                switch (stasiun_tujuan) {
                    case "semarang" ->
                        km = 350;
                    case "bandung" ->
                        km = 700;
                }
            }
        }
        if ("yogyakarta".equals(stasiun_asal)) {
            if (null != stasiun_tujuan) {
                switch (stasiun_tujuan) {
                    case "jakarta" ->
                        km = 500;
                }
            }
        }
        return km;
    }

    public static long Hitung_hargatiket(int jenis_tiket, int hargatiket, int km) {
        switch (jenis_tiket) {
            case 1 ->
                hargatiket = 400;
            case 2 ->
                hargatiket = 700;
            case 3 ->
                hargatiket = 1000;
        }
        return hargatiket * km;
    }

    public static long Hitung_Total(long Harga_tiket, int jumlah_tiket) {
        return Harga_tiket * jumlah_tiket;
    }

    public static long Hitung_Kembalian(long nominal_pembayaran, long total_harga) {
        return nominal_pembayaran - total_harga;
    }

    public static String List_ID(String stasiun_asal, String stasiun_tujuan, String tanggal_berangkat) {
        switch (stasiun_asal) {
            case "malang" ->
                stasiun_asal = "MLG";
            case "surabaya" ->
                stasiun_asal = "SBY";
            case "yogyakarta" ->
                stasiun_asal = "YOG";
        }
        switch (stasiun_tujuan) {
            case "serang" ->
                stasiun_tujuan = "SRG";
            case "surabaya" ->
                stasiun_tujuan = "SBY";
            case "yogyakarta" ->
                stasiun_tujuan = "YOG";
            case "semarang" ->
                stasiun_tujuan = "SEM";
            case "bandung" ->
                stasiun_tujuan = "BND";
            case "jakarta" ->
                stasiun_tujuan = "JKT";
        }
        return stasiun_asal + "-" + stasiun_tujuan + " : " + tanggal_berangkat;
    }

    public static void tambahHistory(String List_ID, int batas_simpan, String[] History) {
        History[batas_simpan] = List_ID;
    }

    public static void printHistory(String[] History, int batas_simpan) {
        for (int i = 0; i < batas_simpan; i++) {
            if (History[i] != null) {
                System.out.println((i + 1) + ". " + History[i]);
            }
        }
    }

    public static String ruteperjalanan(String stasiun_asal, String stasiun_tujuan, String rute) {
        if ("malang".equals(stasiun_asal)) {
            if (null != stasiun_tujuan) {
                switch (stasiun_tujuan) {
                    case "surabaya" ->
                        rute = "Malang - Surabaya (100 km)";
                    case "yogyakarta" ->
                        rute = "Malang - Yogyakarta (400 km)";
                    case "serang" ->
                        rute = "Malang - Serang (1000 km)";
                }
            }
        }
        if ("surabaya".equals(stasiun_asal)) {
            if (null != stasiun_tujuan) {
                switch (stasiun_tujuan) {
                    case "semarang" ->
                        rute = "Surabaya - Semarang (350 km)";
                    case "bandung" ->
                        rute = "Surabaya - Bandung (700 km)";
                }
            }
        }
        if ("yogyakarta".equals(stasiun_asal)) {
            if (null != stasiun_tujuan) {
                switch (stasiun_tujuan) {
                    case "jakarta" ->
                        rute = "Yogyakarta - Jakarta (500 km)";
                }
            }
        }
        return rute;
    }
}
