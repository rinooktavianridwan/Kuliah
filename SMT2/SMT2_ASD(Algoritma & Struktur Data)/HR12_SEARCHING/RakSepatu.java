package HR12_SEARCHING;

import java.util.Scanner;

public class RakSepatu {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int jumlahSepatu = in.nextInt();
        int[] rakSepatu = new int[jumlahSepatu];
        for (int i = 0; i < jumlahSepatu; i++) {
            rakSepatu[i] = in.nextInt();
        }
        insertionSort(rakSepatu);
        int jumlahCariSepatu = in.nextInt();
        int [] cariSepatu = new int[jumlahCariSepatu];
        for (int i = 0; i < jumlahCariSepatu; i++) {
            cariSepatu[i] = in.nextInt();
        }

        //Output
        System.out.print("[");
        for (int i = 0; i < jumlahSepatu; i++) {
            if (i == jumlahSepatu - 1) {
                System.out.print(rakSepatu[i]);
            } else {
                System.out.print(rakSepatu[i] + ", ");
            }
        }
        System.out.println("]");
        for (int i = 0; i < jumlahCariSepatu; i++) {
            int index = binarySearch(rakSepatu, cariSepatu[i]);
            if (index == -1) {
                System.out.println("Ukuran sepatu " + cariSepatu[i] + " tidak ditemukan dalam rak");
            } else {
                System.out.println("Ukuran sepatu " + cariSepatu[i] + " ditemukan pada rak posisi " + index);
            }
        }

    }

    private static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];

            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static int binarySearch(int[] arr, int data) {
        int l = 0;
        int r = arr.length - 1;
        int m = (l + r) / 2;

        while (l <= r) {
            m = (l + r) / 2;
            // data ditemukan pada indeks tengah
            if (data == arr[m]) {
                return arr.length - 1 - m;
            }
            // data lebih kecil dari elemen tengah
            if (data > arr[m]) {
                return arr.length - 1 - m; // ubah batas atas
            }
            // data lebih besar dari elemen tengah
            if (data < arr[m]) {
                return arr.length - 1 - m; // ubah batas bawah
            }
        }
        return -1;
    }
}
