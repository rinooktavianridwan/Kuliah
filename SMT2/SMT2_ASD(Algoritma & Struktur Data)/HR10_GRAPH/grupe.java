package HR10_GRAPH;

import java.util.Scanner;

public class grupe {

    public static void main(String[] args) {
        // Inisialisasi array groups1
        Scanner in = new Scanner(System.in);
        int ukuran = in.nextInt();
        int[][] graph = new int[ukuran][ukuran];
        for (int i = 0; i < ukuran; i++) {
            for (int j = 0; j < ukuran; j++) {
                graph[i][j] = in.nextInt();
            }
        }


        System.out.println("Setelah koordinasi");
        for (int i = 0; i < ukuran; i++) {
            for (int j = 0; j < ukuran; j++) {
                if (i == j) {
                    graph[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < ukuran; i++) {
            for (int j = 0; j < ukuran; j++) {
                System.out.print(graph[i][j]+ " ");
            }
            System.out.println();
        }

        //operasi
        for (int i = 0; i < ukuran; i++) {
            for (int j = 1; j < ukuran; j++) {
                if (cekAngka(graph[i]) && cekAngka(graph[j]) && i!=j){
                    if (cekSama(graph[i], graph[j])) {
                        graph[i] = gabunganAnggota(graph[i], graph[j]);
                    }
                }
            }
        }
        
        System.out.println("Setelah gabungan");
        for (int i = 0; i < ukuran; i++) {
            for (int j = 0; j < ukuran; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        
        //jumlah grup
        int jumlah=0;
        for (int i = 0; i < ukuran; i++) {
            if(cekAngka(graph[i])){
                jumlah+=1;
            }
        }
        System.out.println(jumlah);

    }

    public static boolean cekAngka(int array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean cekSama(int array1[], int array2[]) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 1 && array2[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public static int[] gabunganAnggota(int array1[], int array2[]) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 1 || array2[i] == 1) {
                array1[i] = 1;
                array2[i] = 0;
            }
        }
        return array1;
    }
    

}
