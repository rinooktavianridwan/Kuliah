/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LP1_ClassObject;

class Karyawan {

    public String nama;
    public String id;
    public int usia;
    public int gaji;
    public String alamat;
    public String tempatTglLahir;
    public String email;
    public String shiftKerja;

    public Karyawan() {
    }

    public void printKaryawan() {
        System.out.println("Nama : " + nama);
        System.out.println("Id : " + id);
        System.out.println("Usia : " + usia);
        System.out.println("Gaji : " + gaji);
        System.out.println("Alamat : " + alamat);
        System.out.println("Tempat Lahir : " + tempatTglLahir);
        System.out.println("Email : " + email);
        System.out.println("Shift Kerja : " + shiftKerja);
        System.out.println("");
    }

}
