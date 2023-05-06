/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyKasus1;

import java.util.*;

public class Implementasi {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Karyawan> listKaryawan = new ArrayList<>();
        ArrayList<Hewan> listHewan = new ArrayList<>();
        LinkedHashSet<String> riwayatPelayanan = new LinkedHashSet<>();

        while (true) {
            System.out.println("\nMenu");
            System.out.println("0. Keluar");
            System.out.println("1. Karyawan");
            System.out.println("2. Hewan");
            System.out.println("3. Tampilkan riwayat");
            System.out.print("Input: ");
            // Handle input mismatch exception
            int menu;
            try {
                menu = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input menu tidak valid. Silakan coba lagi.");
                input.nextLine();
                continue;
            }

            if (menu == 0) {
                break;
            } else if (menu == 1) {
                System.out.println("\nMenu Karyawan");
                System.out.println("0. Kembali ke menu");
                System.out.println("1. Tambahkan karyawan");
                System.out.println("2. Tambahkan admin");
                System.out.println("3. Tambahkan groomer");
                System.out.println("4. Tambahkan dokter hewan");
                System.out.println("5. Tampilkan karyawan");
                System.out.print("Input: ");
                // Handle input mismatch exception
                try {
                    menu = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Input menu tidak valid. Silakan coba lagi.");
                    input.nextLine();
                    continue;
                }

                if (menu == 0) {
                    continue;
                } else if (menu == 1) {
                    inputKaryawan(1, listKaryawan);
                } else if (menu == 2) {
                    inputKaryawan(2, listKaryawan);
                } else if (menu == 3) {
                    inputKaryawan(3, listKaryawan);
                } else if (menu == 4) {
                    inputKaryawan(4, listKaryawan);
                } else if (menu == 5) {
                    if (listKaryawan.size() == 0) {
                        System.out.println("Tidak ada karyawan yang terdaftar");
                    } else {
                        for (int i = 0; i < listKaryawan.size(); i++) {
                            listKaryawan.get(i).print();
                        }
                    }
                } else {
                    System.out.println("Menu tidak tersedia");
                }
            } else if (menu == 2) {
                System.out.println("\nMenu hewan");
                System.out.println("0. Kembali ke menu");
                System.out.println("1. Tambahkan kucing");
                System.out.println("2. Tambahkan anjing");
                System.out.println("3. Tambahkan kelinci");
                System.out.println("4. Tampilkan hewan");
                System.out.print("Input: ");
                // Handle input mismatch exception
                try {
                    menu = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Input menu tidak valid. Silakan coba lagi.");
                    input.nextLine();
                    continue;
                }

                if (menu == 0) {
                    continue;
                } else if (menu == 1) {
                    inputHewan(1, listHewan);
                } else if (menu == 2) {
                    inputHewan(2, listHewan);
                } else if (menu == 3) {
                    inputHewan(3, listHewan);
                } else if (menu == 4) {
                    if (listHewan.size() == 0) {
                        System.out.println("Tidak ada hewan yang terdaftar");
                    } else {
                        for (int i = 0; i < listHewan.size(); i++) {
                            listHewan.get(i).print();
                        }
                    }
                } else {
                    System.out.println("Menu tidak tersedia");
                }
            } else if (menu == 3) {
                if (listHewan.isEmpty()) {
                    System.out.println("Tidak ada riwayat layanan");
                } else {
                    for (int i = 0; i < listHewan.size(); i++) {
                        Admin admin = new Admin();
                        admin.riwayatPelayanan(riwayatPelayanan, listHewan.get(i));
                    }
                    for (String s : riwayatPelayanan) {
                        System.out.println(s);
                    }
                }

            } else {
                System.out.println("Menu tidak tersedia");
            }
        }
        input.close();
    }

    static void inputKaryawan(int menu, ArrayList<Karyawan> list) {
        System.out.println("Silahkan masukkan data karyawan anda");
        if (menu == 1) {
            inputKaryawanNormal(list);
        } else if (menu == 2) {
            inputKaryawanAdmin(list);
        } else if (menu == 3) {
            inputKaryawanGroomer(list);
        } else if (menu == 4) {
            inputKaryawanDokter(list);
        }
    }

    static void inputKaryawanNormal(ArrayList<Karyawan> list) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan ID: ");
        String id = input.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = input.nextLine();
        System.out.print("Masukkan nomer telfon: ");
        String noTelp = input.nextLine();
        System.out.print("Masukkan jenis kelamin: ");
        String jenisKelamin = input.nextLine();
        System.out.print("Masukkan umur: ");
        // Handle input mismatch exception
        int umur;
        try {
            umur = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input umur tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }
        System.out.print("Masukkan gaji: ");
        // Handle input mismatch exception
        int gaji;
        try {
            gaji = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input gaji tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }

        // Membuat object karyawan dan memasukkan ke list
        Karyawan karyawan = new Karyawan(nama, id, alamat, noTelp, jenisKelamin, umur, gaji);
        list.add(karyawan);

        // Agar buffer bisa turun untuk segera mendapat input nextline
        if (input.hasNextLine()) {
            input.nextLine();
        }
    }

    static void inputKaryawanAdmin(ArrayList<Karyawan> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan ID: ");
        String id = input.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = input.nextLine();
        System.out.print("Masukkan nomer telfon: ");
        String noTelp = input.nextLine();
        System.out.print("Masukkan jenis kelamin: ");
        String jenisKelamin = input.nextLine();
        System.out.print("Masukkan divisi: ");
        String divisi = input.nextLine();
        System.out.print("Masukkan umur: ");
        // Handle input mismatch exception
        int umur;
        try {
            umur = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input umur tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }
        System.out.print("Masukkan gaji: ");
        // Handle input mismatch exception
        int gaji;
        try {
            gaji = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input gaji tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }

        Admin admin = new Admin(nama, id, alamat, noTelp, jenisKelamin, umur, gaji, divisi);
        list.add(admin);

        if (input.hasNextLine()) {
            input.nextLine();
        }
    }

    static void inputKaryawanGroomer(ArrayList<Karyawan> list) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan ID: ");
        String id = input.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = input.nextLine();
        System.out.print("Masukkan nomer telfon: ");
        String noTelp = input.nextLine();
        System.out.print("Masukkan jenis kelamin: ");
        String jenisKelamin = input.nextLine();
        System.out.print("Masukkan posisi: ");
        String posisi = input.nextLine();
        System.out.print("Masukkan bagian: ");
        String bagian = input.nextLine();
        System.out.print("Masukkan umur: ");
        // Handle input mismatch exception
        int umur;
        try {
            umur = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input umur tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }
        System.out.print("Masukkan gaji: ");
        /// Handle input mismatch exception
        int gaji;
        try {
            gaji = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input gaji tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }

        Groomer groomer = new Groomer(nama, id, alamat, noTelp, jenisKelamin, umur, gaji, bagian);
        list.add(groomer);

        if (input.hasNextLine()) {
            input.nextLine();
        }
    }

    static void inputKaryawanDokter(ArrayList<Karyawan> list) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan ID: ");
        String id = input.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = input.nextLine();
        System.out.print("Masukkan nomer telfon: ");
        String noTelp = input.nextLine();
        System.out.print("Masukkan jenis kelamin: ");
        String jenisKelamin = input.nextLine();
        System.out.print("Masukkan spesialis: ");
        String spesialis = input.nextLine();
        System.out.print("Masukkan tingkat pendidikan: ");
        String tingkatPendidikan = input.nextLine();
        System.out.print("Masukkan umur: ");
        // Handle input mismatch exception
        int umur;
        try {
            umur = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input umur tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }
        System.out.print("Masukkan gaji: ");
        // Handle input mismatch exception
        int gaji;
        try {
            gaji = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input gaji tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }

        DokterHewan dokterHewan = new DokterHewan(nama, id, alamat, noTelp, jenisKelamin, umur, gaji, spesialis, tingkatPendidikan);
        list.add(dokterHewan);

        if (input.hasNextLine()) {
            input.nextLine();
        }
    }

    static void inputHewan(int menu, ArrayList<Hewan> list) {
        System.out.println("Silahkan masukkan data hewan");
        if (menu == 1) {
            inputHewanKucing(list);
        } else if (menu == 2) {
            inputHewanAnjing(list);
        } else if (menu == 3) {
            inputHewanKelinci(list);
        }
    }

    static void inputHewanKucing(ArrayList<Hewan> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ID pelanggan: ");
        String noPelanggan = input.nextLine();
        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = input.nextLine();
        System.out.print("Masukkan nama hewan: ");
        String namaHewan = input.nextLine();
        String jenisHewan = "Kucing";
        System.out.print("Masukkan warna hewan: ");
        String warnaHewan = input.nextLine();
        ArrayList<JenisPerawatan> kebutuhan = new ArrayList();
        Set<Integer> nomorPerawatan = new LinkedHashSet<>();
        int totalHarga = 0;
        int jumlahKebutuhan = 0;
        while (true) {
            if (jumlahKebutuhan == 6) {
                System.out.println("Anda telah memesan semua kebutuhan untuk perawatan hewan");
                break;
            }
            System.out.println("Masukkan kebutuhan pelayanan : ");
            System.out.println("Jenis Perawatan : ");
            System.out.println("1. Suntik Vaksin\t\t\t (Rp.115.000)");
            System.out.println("2. Suntik Anti Kutu\t\t\t (Rp.75.000)");
            System.out.println("3. Suntik Scabies\t\t (Rp.70.000)");
            System.out.println("4. Suntik Anti Jamur Kulit\t (Rp.70.000)");
            System.out.println("5. Pemeriksaan Rawat Inap\t (Rp.150.000)");
            System.out.println("6. Pemeriksaan Rawat Jalan\t (Rp.65.000)");
            System.out.println("Pilihan boleh lebih dari satu (Pisahkan spasi)");
            System.out.println("Contoh : 1 2 3 4 5 6");
            System.out.print("Pilihan : ");
            String pilihan = input.nextLine().trim();
            String[] KumpulanPilihan = pilihan.split(" ");
            for (int i = 0; i < KumpulanPilihan.length; i++) {
                int masukan;
                try {
                    masukan = Integer.parseInt(KumpulanPilihan[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Input pilihan " + KumpulanPilihan[i] + "tidak valid");
                    break;
                }
                if (nomorPerawatan.contains(masukan)) {
                    System.out.println("Anda sudah memilih jenis perawatan nomor " + masukan + " sebelumnya");
                } else if (masukan == 1) {
                    totalHarga += JenisPerawatan.suntikVaksin.harga;
                    kebutuhan.add(JenisPerawatan.suntikVaksin);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 1 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 2) {
                    totalHarga += JenisPerawatan.suntikAntiKutu.harga;
                    kebutuhan.add(JenisPerawatan.suntikAntiKutu);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 2 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 3) {
                    totalHarga += JenisPerawatan.suntikScabies.harga;
                    kebutuhan.add(JenisPerawatan.suntikScabies);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 3 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 4) {
                    totalHarga += JenisPerawatan.suntikAntiJamurKulit.harga;
                    kebutuhan.add(JenisPerawatan.suntikAntiJamurKulit);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 4 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 5) {
                    totalHarga += JenisPerawatan.pemeriksaanRawatInap.harga;
                    kebutuhan.add(JenisPerawatan.pemeriksaanRawatInap);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 5 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 6) {
                    totalHarga += JenisPerawatan.pemeriksaanRawatJalan.harga;
                    kebutuhan.add(JenisPerawatan.pemeriksaanRawatJalan);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 6 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan > 6 || masukan < 1) {
                    System.out.println("Pilihan " + masukan + "tidak ada");
                }
            }

            System.out.print("Apakah ingin menambah perawatan (ya/tidak) :");
            String perintah = input.nextLine().trim();
            if (perintah.equalsIgnoreCase("tidak")) {
                if (nomorPerawatan.isEmpty()) {
                    System.out.println("Tidak ada perawatan yang dipesan");
                    return;
                } else {
                    break;
                }
            } else if (!perintah.equalsIgnoreCase("tidak") && !perintah.equalsIgnoreCase("ya")) {
                System.out.println("(Tolong masukkan iya atau tidak)");
                boolean kondisi = true;
                while (kondisi) {
                    System.out.print("Apakah ingin menambah perawatan (ya/tidak) : ");
                    String perintah2 = input.nextLine();
                    if (perintah2.equalsIgnoreCase("tidak")) {
                        if (nomorPerawatan.isEmpty()) {
                            System.out.println("Tidak ada perawatan yang dipesan");
                            return;
                        } else {
                            kondisi = false;
                        }
                    } else if (perintah2.equalsIgnoreCase("ya")) {
                        break;
                    }
                }
                if (kondisi == false) {
                    break;
                }
            }
        }
        System.out.print("Masukkan riwayat penyakit: ");
        String riwayatPenyakit = input.nextLine();
        String kebiasaanMencakar = null;
        while (true) {
            System.out.print("Masukkan kebiasaan mencakar(ya/tidak): ");
            kebiasaanMencakar = input.nextLine();
            if (kebiasaanMencakar.equalsIgnoreCase("tidak")) {
                break;
            } else if (kebiasaanMencakar.equalsIgnoreCase("ya")) {
                break;
            } else {
                System.out.println("(Tolong masukkan iya atau tidak)");
            }
        }
        System.out.print("Masukkan tahun kelahiran: ");
        // Handle input mismatch exception
        int tahunKelahiran;
        try {
            tahunKelahiran = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tahun kelahiran tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }
        System.out.print("Masukkan umur hewan (bulan) : ");
        // Handle input mismatch exception
        int umurHewan;
        try {
            umurHewan = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input umur hewan tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }

        Kucing kucing = new Kucing(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, kebutuhan, riwayatPenyakit, tahunKelahiran, umurHewan, totalHarga, kebiasaanMencakar);
        list.add(kucing);

        if (input.hasNextLine()) {
            input.nextLine();
        }
//        if (kebutuhan.equalsIgnoreCase("grooming")) {
//            System.out.println("\n[Kucing sudah di grooming]");
//        } else if (kebutuhan.equalsIgnoreCase("periksa")) {
//            System.out.println("\n[Kucing sudah di periksa]");
//        }
    }

    static void inputHewanAnjing(ArrayList<Hewan> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ID pelanggan: ");
        String noPelanggan = input.nextLine();
        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = input.nextLine();
        System.out.print("Masukkan nama hewan: ");
        String namaHewan = input.nextLine();
        String jenisHewan = "Anjing";
        System.out.print("Masukkan warna hewan: ");
        String warnaHewan = input.nextLine();
        ArrayList<JenisPerawatan> kebutuhan = new ArrayList();
        Set<Integer> nomorPerawatan = new LinkedHashSet<>();
        int totalHarga = 0;
        int jumlahKebutuhan = 0;
        while (true) {
            if (jumlahKebutuhan == 6) {
                System.out.println("Anda telah memesan semua kebutuhan untuk perawatan hewan");
                break;
            }
            System.out.println("Masukkan kebutuhan pelayanan : ");
            System.out.println("Jenis Perawatan : ");
            System.out.println("1. Suntik Vaksin\t\t\t (Rp.115.000)");
            System.out.println("2. Suntik Anti Kutu\t\t\t (Rp.75.000)");
            System.out.println("3. Suntik Scabies\t\t (Rp.70.000)");
            System.out.println("4. Suntik Anti Jamur Kulit\t (Rp.70.000)");
            System.out.println("5. Pemeriksaan Rawat Inap\t (Rp.150.000)");
            System.out.println("6. Pemeriksaan Rawat Jalan\t (Rp.65.000)");
            System.out.println("Pilihan boleh lebih dari satu (Pisahkan spasi)");
            System.out.println("Contoh : 1 2 3 4 5 6");
            System.out.print("Pilihan : ");
            String pilihan = input.nextLine().trim();
            String[] KumpulanPilihan = pilihan.split(" ");
            for (int i = 0; i < KumpulanPilihan.length; i++) {
                int masukan;
                try {
                    masukan = Integer.parseInt(KumpulanPilihan[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Input pilihan " + KumpulanPilihan[i] + "tidak valid");
                    break;
                }
                if (nomorPerawatan.contains(masukan)) {
                    System.out.println("Anda sudah memilih jenis perawatan nomor " + masukan + " sebelumnya");
                } else if (masukan == 1) {
                    totalHarga += JenisPerawatan.suntikVaksin.harga;
                    kebutuhan.add(JenisPerawatan.suntikVaksin);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 1 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 2) {
                    totalHarga += JenisPerawatan.suntikAntiKutu.harga;
                    kebutuhan.add(JenisPerawatan.suntikAntiKutu);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 2 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 3) {
                    totalHarga += JenisPerawatan.suntikScabies.harga;
                    kebutuhan.add(JenisPerawatan.suntikScabies);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 3 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 4) {
                    totalHarga += JenisPerawatan.suntikAntiJamurKulit.harga;
                    kebutuhan.add(JenisPerawatan.suntikAntiJamurKulit);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 4 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 5) {
                    totalHarga += JenisPerawatan.pemeriksaanRawatInap.harga;
                    kebutuhan.add(JenisPerawatan.pemeriksaanRawatInap);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 5 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 6) {
                    totalHarga += JenisPerawatan.pemeriksaanRawatJalan.harga;
                    kebutuhan.add(JenisPerawatan.pemeriksaanRawatJalan);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 6 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan > 6 || masukan < 1) {
                    System.out.println("Pilihan " + masukan + "tidak ada");
                }
            }

            System.out.print("Apakah ingin menambah perawatan (ya/tidak) :");
            String perintah = input.nextLine().trim();
            if (perintah.equalsIgnoreCase("tidak")) {
                if (nomorPerawatan.isEmpty()) {
                    System.out.println("Tidak ada perawatan yang dipesan");
                    return;
                } else {
                    break;
                }
            } else if (!perintah.equalsIgnoreCase("tidak") && !perintah.equalsIgnoreCase("ya")) {
                System.out.println("(Tolong masukkan iya atau tidak)");
                boolean kondisi = true;
                while (kondisi) {
                    System.out.print("Apakah ingin menambah perawatan (ya/tidak) : ");
                    String perintah2 = input.nextLine();
                    if (perintah2.equalsIgnoreCase("tidak")) {
                        if (nomorPerawatan.isEmpty()) {
                            System.out.println("Tidak ada perawatan yang dipesan");
                            return;
                        } else {
                            kondisi = false;
                        }
                    } else if (perintah2.equalsIgnoreCase("ya")) {
                        break;
                    }
                }
                if (kondisi == false) {
                    break;
                }
            }
        }
        System.out.print("Masukkan riwayat penyakit: ");
        String riwayatPenyakit = input.nextLine();
        String kebiasaanMenggigit = null;
        while (true) {
            System.out.print("Masukkan kebiasaan menggigit (ya/tidak):");
            kebiasaanMenggigit = input.nextLine();
            if (kebiasaanMenggigit.equalsIgnoreCase("tidak")) {
                break;
            } else if (kebiasaanMenggigit.equalsIgnoreCase("ya")) {
                break;
            } else {
                System.out.println("(Tolong masukkan iya atau tidak)");
            }
        }
        System.out.print("Masukkan tahun kelahiran: ");
        // Handle input mismatch exception
        int tahunKelahiran;
        try {
            tahunKelahiran = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tahun kelahiran tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }
        System.out.print("Masukkan umur hewan (bulan) : ");
        // Handle input mismatch exception
        int umurHewan;
        try {
            umurHewan = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input umur hewan tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }

        Anjing anjing = new Anjing(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, kebutuhan, riwayatPenyakit, tahunKelahiran, umurHewan, totalHarga, kebiasaanMenggigit);
        list.add(anjing);

        if (input.hasNextLine()) {
            input.nextLine();
        }

    }

    static void inputHewanKelinci(ArrayList<Hewan> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan ID pelanggan: ");
        String noPelanggan = input.nextLine();
        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = input.nextLine();
        System.out.print("Masukkan nama hewan: ");
        String namaHewan = input.nextLine();
        String jenisHewan = "Kelinci";
        System.out.print("Masukkan warna hewan: ");
        String warnaHewan = input.nextLine();
        ArrayList<JenisPerawatan> kebutuhan = new ArrayList();
        Set<Integer> nomorPerawatan = new LinkedHashSet<>();
        int totalHarga = 0;
        int jumlahKebutuhan = 0;
        while (true) {
            if (jumlahKebutuhan == 6) {
                System.out.println("Anda telah memesan semua kebutuhan untuk perawatan hewan");
                break;
            }
            System.out.println("Masukkan kebutuhan pelayanan : ");
            System.out.println("Jenis Perawatan : ");
            System.out.println("1. Suntik Vaksin\t\t\t (Rp.115.000)");
            System.out.println("2. Suntik Anti Kutu\t\t\t (Rp.75.000)");
            System.out.println("3. Suntik Scabies\t\t (Rp.70.000)");
            System.out.println("4. Suntik Anti Jamur Kulit\t (Rp.70.000)");
            System.out.println("5. Pemeriksaan Rawat Inap\t (Rp.150.000)");
            System.out.println("6. Pemeriksaan Rawat Jalan\t (Rp.65.000)");
            System.out.println("Pilihan boleh lebih dari satu (Pisahkan spasi)");
            System.out.println("Contoh : 1 2 3 4 5 6");
            System.out.print("Pilihan : ");
            String pilihan = input.nextLine().trim();
            String[] KumpulanPilihan = pilihan.split(" ");
            for (int i = 0; i < KumpulanPilihan.length; i++) {
                int masukan;
                try {
                    masukan = Integer.parseInt(KumpulanPilihan[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Input pilihan " + KumpulanPilihan[i] + "tidak valid");
                    break;
                }
                if (nomorPerawatan.contains(masukan)) {
                    System.out.println("Anda sudah memilih jenis perawatan nomor " + masukan + " sebelumnya");
                } else if (masukan == 1) {
                    totalHarga += JenisPerawatan.suntikVaksin.harga;
                    kebutuhan.add(JenisPerawatan.suntikVaksin);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 1 telah dipesan");
                    jumlahKebutuhan++;
                    

                } else if (masukan == 2) {
                    totalHarga += JenisPerawatan.suntikAntiKutu.harga;
                    kebutuhan.add(JenisPerawatan.suntikAntiKutu);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 2 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 3) {
                    totalHarga += JenisPerawatan.suntikScabies.harga;
                    kebutuhan.add(JenisPerawatan.suntikScabies);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 3 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 4) {
                    totalHarga += JenisPerawatan.suntikAntiJamurKulit.harga;
                    kebutuhan.add(JenisPerawatan.suntikAntiJamurKulit);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 4 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 5) {
                    totalHarga += JenisPerawatan.pemeriksaanRawatInap.harga;
                    kebutuhan.add(JenisPerawatan.pemeriksaanRawatInap);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 5 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan == 6) {
                    totalHarga += JenisPerawatan.pemeriksaanRawatJalan.harga;
                    kebutuhan.add(JenisPerawatan.pemeriksaanRawatJalan);
                    nomorPerawatan.add(masukan);
                    System.out.println("Perawatan nomor 6 telah dipesan");
                    jumlahKebutuhan++;

                } else if (masukan > 6 || masukan < 1) {
                    System.out.println("Pilihan " + masukan + " tidak ada");
                }
            }

            System.out.print("Apakah ingin menambah perawatan (ya/tidak) : ");
            String perintah = input.nextLine().trim();
            if (perintah.equalsIgnoreCase("tidak")) {
                if (nomorPerawatan.isEmpty()) {
                    System.out.println("Tidak ada perawatan yang dipesan");
                    return;
                } else {
                    break;
                }
            } else if (!perintah.equalsIgnoreCase("tidak") && !perintah.equalsIgnoreCase("ya")) {
                System.out.println("(Tolong masukkan iya atau tidak)");
                boolean kondisi = true;
                while (kondisi) {
                    System.out.print("Apakah ingin menambah perawatan (ya/tidak) :");
                    String perintah2 = input.nextLine();
                    if (perintah2.equalsIgnoreCase("tidak")) {
                        if (nomorPerawatan.isEmpty()) {
                            System.out.println("Tidak ada perawatan yang dipesan");
                            return;
                        } else {
                            kondisi = false;
                        }
                    } else if (perintah2.equalsIgnoreCase("ya")) {
                        break;
                    }
                }
                if (kondisi == false) {
                    break;
                }
            }
        }
        System.out.print("Masukkan riwayat penyakit: ");
        String riwayatPenyakit = input.nextLine();
        String kebiasaanMelompat = null;
        while (true) {
            System.out.print("Masukkan kebiasaan melompat (ya/tidak):");
            kebiasaanMelompat = input.nextLine();
            if (kebiasaanMelompat.equalsIgnoreCase("tidak")) {
                break;
            } else if (kebiasaanMelompat.equalsIgnoreCase("ya")) {
                break;
            } else {
                System.out.println("(Tolong masukkan iya atau tidak)");
            }
        }
        System.out.print("Masukkan tahun kelahiran: ");
        // Handle input mismatch exception
        int tahunKelahiran;
        try {
            tahunKelahiran = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input tahun kelahiran tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }
        System.out.print("Masukkan umur hewan (bulan) : ");
        // Handle input mismatch exception
        int umurHewan;
        try {
            umurHewan = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input umur hewan tidak valid. Silakan coba lagi.");
            input.nextLine();
            return;
        }

        Kelinci kelinci = new Kelinci(noPelanggan, namaPelanggan, namaHewan, jenisHewan, warnaHewan, kebutuhan, riwayatPenyakit, tahunKelahiran, umurHewan, totalHarga, kebiasaanMelompat);
        list.add(kelinci);

        if (input.hasNextLine()) {
            input.nextLine();
        }
    }
}
