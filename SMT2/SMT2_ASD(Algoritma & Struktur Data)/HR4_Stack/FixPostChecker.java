package HR4_Stack;


import java.util.Scanner;

public class FixPostChecker {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack pengolahanPostFix = new Stack();
        
        Scanner in = new Scanner (System.in);
        String postFixPertama = in.nextLine();
        String postFixKedua = in.nextLine();
        
        int hasilPengolahan1 = pengolahanPostFix.perhitungan(postFixPertama);
        int hasilPengolahan2 = pengolahanPostFix.perhitungan(postFixKedua);
        
        if(hasilPengolahan1 == hasilPengolahan2){
            System.out.println("SAMA");
        }else{
            System.out.println("BEDA");
        }       
    }
}

class NodeStack {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    int data;
    NodeStack next;

    public NodeStack(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    NodeStack head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public void push(int data) {
        NodeStack input = new NodeStack(data);  
        if (size==0) {
            head = tail = input;
        }
        else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            return 0;
        }
        int data = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            NodeStack pointer = head;
            while (pointer.next != tail) {
                pointer = pointer.next;
            }
            pointer.next = null;
            tail = pointer;
        }
        size--;
        return data;
    }

    private static boolean cekAngka(char c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean cekOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c=='^');
    }

    public int perhitungan(String masukan) {
        int hasil;
        Stack operasi = new Stack();
        for (int i = 0; i < masukan.length(); i++) {
            char inputan = masukan.charAt(i);
            if (cekAngka(inputan)) {
                operasi.push((char) Character.getNumericValue(inputan));
            } else if (cekOperator(inputan)) {
                int bilanganSebelumnya1 = operasi.pop();
                int bilanganSebelumnya2 = operasi.pop();
                switch (inputan) {
                    case '+' -> {
                        hasil = bilanganSebelumnya2 + bilanganSebelumnya1;
                        operasi.push(hasil);
                    }
                    case '-' -> {
                        hasil = bilanganSebelumnya2 - bilanganSebelumnya1;
                        operasi.push(hasil);
                    }
                    case '*' -> {
                        hasil = bilanganSebelumnya2 * bilanganSebelumnya1;
                        operasi.push(hasil);
                    }
                    case '/' -> {
                        hasil = bilanganSebelumnya2 / bilanganSebelumnya1;
                        operasi.push(hasil);
                    }
                    case '^' -> {
                        hasil = (int) Math.pow(bilanganSebelumnya2, bilanganSebelumnya1);
                        operasi.push(hasil);
                    }
                }
            } 
        }
        return operasi.pop();
    }

}