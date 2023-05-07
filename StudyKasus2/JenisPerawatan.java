/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package StudyKasus2;

public enum JenisPerawatan {
    SuntikVaksin(115000),
    SuntikAntiKutu(75000),
    SuntikScabies(70000),
    SuntikAntiJamurKulit(70000),
    PemeriksaanRawatInap(150000),
    PemeriksaanRawatJalan(65000),
    Mandi(40000),
    Cukur(35000),
    Trimming(20000);

    private JenisPerawatan(int harga) {
        this.harga = harga;
    }

    final int harga;

}
