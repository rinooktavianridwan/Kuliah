package HR3_DLL_CDL;

import java.util.Scanner;

public class Dasar_CDLL {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int jumlahPerintah = in.nextInt();
        in.nextLine();
        CDLL kumpulanAngka = new CDLL();
        int batas = 0;
        
        for(int i = 0; i < jumlahPerintah; i++) {
            if(batas==15){
                break;
            }
            String perintah = in.next().trim();
            String dariMana;
            int masukan;

            if(perintah.equalsIgnoreCase("ADD")) {
                dariMana = in.next().trim();
                masukan = in.nextInt();
                if (in.hasNextInt()) {
                        in.nextLine();
                    }
                if(dariMana.equalsIgnoreCase("FIRST")) {
                    kumpulanAngka.addFirst(masukan);
                } else if(dariMana.equalsIgnoreCase("LAST")) {
                    kumpulanAngka.addLast(masukan);
                }
            }
            else if(perintah.equalsIgnoreCase("REMOVE")) {
                dariMana = in.next().trim();
                if(dariMana.equalsIgnoreCase("FIRST")) {
                    kumpulanAngka.removeFirst();
                } else if(dariMana.equalsIgnoreCase("LAST")) {
                    kumpulanAngka.removeLast();
                }
            }
            else if(perintah.equalsIgnoreCase("IS")) {
                String periksa = in.next().trim();
                if(periksa.equalsIgnoreCase("THERE")) {
                    masukan = in.nextInt();
                    if (in.hasNextInt()) {
                        in.nextLine();
                    }
                    if(kumpulanAngka.isExist(masukan)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
            else if(perintah.equalsIgnoreCase("PRINT")) {
                String print = in.next().trim();
                if(print.equalsIgnoreCase("ALL")) {
                    kumpulanAngka.printAll();
                }
            }
            batas++;
        }
    }
}


class NodeCDLL {
  /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeCDLL. */
    int data;
    NodeCDLL next;
    NodeCDLL prev;

    public NodeCDLL(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


class CDLL {
  /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named CDLL. */
    NodeCDLL head, tail;
    int size;


    public void addFirst(int data) {
        NodeCDLL input = new NodeCDLL(data);
        if (size == 0) {
            head = tail = input;
        }
        else {
            input.next = head;
            head.prev = input;
            head = input;
            tail.next = head;
            head.prev = tail;
        }
        size++;
    }
    
    public void addLast(int data) {
        NodeCDLL input = new NodeCDLL(data);
        if (size == 0) {
            head = tail = input;
        }
        else {
            input.prev = tail;
            tail.next = input;
            tail = input;
            tail.next = head;
            head.prev = tail;
        }
        size++;
    }

    public void removeFirst() {
        switch (size) {
            case 0 -> System.out.println("DATA IS EMPTY!");
            case 1 -> {
                head = tail = null;
                size--;
            }
            default -> {
                head = head.next;
                head.prev = tail;
                tail.next = head;
                size--;
            }
        }
    }

    public void removeLast() {
        switch (size) {
            case 0 -> System.out.println("DATA IS EMPTY!");
            case 1 -> {
                head = tail = null;
                size--;
            }
            default -> {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
                size--;
            }
        }
    }

    public boolean isExist(int data) {
        if(size==0){
            return false;
        }
        NodeCDLL temp = head;
        do  {
            if(temp != null){
                if (temp.data == data) return true;
                temp = temp.next;
            }
        } while (temp != head);
        return false;
    }

    public void printAll() {
        if(size==0){
            System.out.println();
        }
        else {
            NodeCDLL temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }while (temp != head);
            System.out.println();
        }
    }
}

