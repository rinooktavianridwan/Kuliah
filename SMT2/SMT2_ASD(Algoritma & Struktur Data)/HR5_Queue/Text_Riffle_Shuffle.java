package HR5_Queue;

import java.util.Scanner;

public class Text_Riffle_Shuffle {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Queue shuffleKartu = new Queue();
        Scanner in = new Scanner(System.in);
        String namaTumpukanKartu = in.nextLine();
        int jumlahAcakKartu = in.nextInt();

        System.out.println(shuffleKartu.shuffleKartu(namaTumpukanKartu, jumlahAcakKartu));
    }
}

class NodeQueue {
    char data;
    NodeQueue next;

    public NodeQueue(char data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    NodeQueue head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public String shuffleKartu(String masukan, int kali) {
        Queue queue = new Queue();
        int jumlahHuruf = masukan.length();
        int tengah = jumlahHuruf / 2;
        if (jumlahHuruf % 2 == 1) {
            tengah++;
        }

        for (int i = 0; i < jumlahHuruf; i++) {
            queue.enqueue(masukan.charAt(i));
        }

        String hasilShuffle = "";
        for (int i = 0; i < kali; i++) {
            NodeQueue pointer1 = queue.head;

            for (int j = 0; j < tengah; j++) {
                char hurufPertama = pointer1.data;
                hasilShuffle += hurufPertama;
                pointer1 = pointer1.next;

                NodeQueue pointer2 = queue.head;
                for (int k = 0; k < jumlahHuruf; k++) {
                    if (k == tengah +j) {
                        char hurufTengah = pointer2.data;
                        hasilShuffle += hurufTengah;
                        break;
                    } else {
                        pointer2 = pointer2.next;
                    }
                }
            }

            for (int m = 0; m < jumlahHuruf; m++) {
                queue.dequeue();
            }
            
            for (int l = 0; l < jumlahHuruf; l++) {
                queue.enqueue(hasilShuffle.charAt(l));
            }
            if(i<kali-1){
                hasilShuffle="";
            }
        }

        return hasilShuffle;
    }

    public void enqueue(char data) {
        NodeQueue input = new NodeQueue(data);

        if (size == 0) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }

        size++;
    }

    public void dequeue() {
        if (size != 0) {
            head = head.next;
            size--;
        }
    }
}