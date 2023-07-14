package LP11_String;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class MainPecahParagraf {

    public static void main(String[] args) {
        String paragraph = "Saat itu, di tepi pantai yang indah; terdapat seorang perempuan dengan gaun merah. Dia berkata \"Apa yang kamu cari di sini?\" dengan raut wajah penasaran, lalu pria itu menjawab \"Aku mencari arti kehidupan, apakah kau tahu?\" Dengan penuh keyakinan, perempuan itu menyambutnya dengan tanda seru! \"Tentu saja! Kehidupan adalah petualangan yang menakjubkan.\" Mereka berdua berjalan beriringan sambil berbagi cerita; pada suatu titik, pria itu bertanya \"Apakah kamu pernah ke luar negeri?\" Perempuan itu tersenyum dan menjawab \"Ya, aku pernah ke Spanyol, Prancis, Italia, dan banyak lagi!\" Mereka terus berjalan, berhenti sejenak dengan pemandangan matahari terbenam yang indah, dan menikmati momen tersebut dengan bahagia, mereka tahu bahwa ini adalah pengalaman yang berharga dalam hidup mereka.";

        // Menghapus tanda baca dan mengubah menjadi huruf kecil
        String hapusTanda = paragraph.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();

        // Membuat map untuk menyimpan token (kata) dan frekuensinya
        Map<String, Integer> frequencyKata = new TreeMap<>();

        // Membuat StringTokenizer untuk memecah string menjadi token (kata)
        StringTokenizer tokenizerKataParagraf = new StringTokenizer(hapusTanda);

        // Menghitung frekuensi masing-masing token
        while (tokenizerKataParagraf.hasMoreTokens()) {
            String tokenKata = tokenizerKataParagraf.nextToken();
            frequencyKata.put(tokenKata, frequencyKata.getOrDefault(tokenKata, 0) + 1);
        }

        // Menampilkan token (kata) dan frekuensinya secara urut berdasarkan abjad
        System.out.println("Kata\t\t| Jumlah");
        System.out.println("------------------------");

        for (Map.Entry<String, Integer> entry : frequencyKata.entrySet()) {
            System.out.println(entry.getKey() + "\t\t| " + entry.getValue());
        }
    }
}
