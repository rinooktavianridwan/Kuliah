package HR3_DLL_CDL;

import java.util.Scanner;

public class Toko_Buku {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int jumlahPerintah = in.nextInt();
        in.nextLine();
        DLL perpustakaan = new DLL();
        int batas = 0;
       
        for(int i = 0; i < jumlahPerintah; i++) {
            if(batas==10){
                break;
            }
            String perintah = in.nextLine().trim();
            String namaBuku;
            int hargaBuku;
            switch(perintah) {
            
                case "TAMBAH" -> {
                    namaBuku = in.nextLine().trim();
                    hargaBuku = in.nextInt();
                    in.nextLine();
                    perpustakaan.add(namaBuku, hargaBuku);
                    System.out.println(namaBuku + " berhasil ditambah");
                }

                case "HAPUS" -> {
                    namaBuku = in.nextLine().trim();
                    perpustakaan.remove(namaBuku);
                    break;
                }

                case "CARI" -> {
                     String periksa = in.nextLine().trim();
                     perpustakaan.search(periksa);   
                }
            
                case "HITUNG" -> {
                    perpustakaan.hitung();                    
                }
                
                case "CETAK" -> {
                    perpustakaan.print();
                }
            }
            if(i<jumlahPerintah-1){
            System.out.println();
            }
            batas++;
        }
          
    }
}


class NodeDLL {
  /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeCDLL. */
    String namaBuku;
    int hargaBuku;
    NodeDLL next;
    NodeDLL prev;

    public NodeDLL(String namaBuku, int hargaBuku) {
        this.namaBuku = namaBuku;
        this.hargaBuku = hargaBuku;
        this.next = null;
        this.prev = null;
    }
}


class DLL {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named CDLL. */
    NodeDLL head;
    NodeDLL tail;
    int size = 0;

    public int size() {
        return size;
    }
    
    public void add(String buku, int harga) {
        NodeDLL input = new NodeDLL(buku, harga);
        if (size == 0) {
            head = tail = input;
        }
        else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        } 
        size++;
    }

    public void remove(String namaBuku) {  
        if (size == 0) {
                System.out.println("Tidak dapat menghapus, buku tidak ditemukan");
            } 
        else  if (head.namaBuku.equalsIgnoreCase(namaBuku)){
            System.out.println(head.namaBuku + " berhasil dihapus");
            head = head.next;
            if(head!=null){
               head.prev = null;
            }
                size--;
            } 
        else {
            NodeDLL periksa = head;
            NodeDLL tanda = head.next;
            while (tanda != null && !(tanda.namaBuku.equalsIgnoreCase(namaBuku))) {
                periksa = tanda;
                tanda = tanda.next;
            }
            if (tanda == null) {
                System.out.println("Tidak dapat menghapus, buku tidak ditemukan");
            } else {
                System.out.println(tanda.namaBuku + " berhasil dihapus");
                periksa.next = tanda.next;
                if (tanda.next != null) {
                    tanda.next.prev = periksa;
                }
                else{
                    tail = periksa;
                }
                size--;
            }
       }
    }

     public void search(String cari) {
            if (size == 0) {
                System.out.println("Buku tidak ditemukan");
            }
            else {
            NodeDLL periksa = head;
            while (periksa != null) {
                if (periksa.namaBuku.equalsIgnoreCase(cari)) {
                    System.out.println("Buku = " + periksa.namaBuku);
                    System.out.println("Harga = " + periksa.hargaBuku);
                    return;
                }
                periksa = periksa.next;
            }
            System.out.println("Buku tidak ditemukan");
            }
        }

    public void print() {
        if(size == 0){
            System.out.println("Belum ada transaksi yang dibuat");
        }else{
            NodeDLL temp = tail;
            System.out.print("Daftar Transaksi : ");
            while (temp != null){
                System.out.print(temp.namaBuku);
                temp = temp.prev;
                if(temp != null) {
                    System.out.print(", ");
                }
            }
            System.out.println("");

        }
    }

    public void hitung() {
        if(size == 0){
            System.out.println("Tidak ada transaksi yang sedang dilakukan");
        }else{
            int jumlahHarga = 0;
            NodeDLL temp = head;
            while (temp != null){
               jumlahHarga += temp.hargaBuku;
               temp = temp.next;
            }
            System.out.println("Total = "+jumlahHarga);
        }
    }

}

