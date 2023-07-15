package HR4_Stack;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Stack wadahKata = new Stack();
        
        Scanner in = new Scanner (System.in);
        String kata = in.nextLine();
        String balikKata = wadahKata.balikKata(kata);
        if(kata == null ? balikKata == null : kata.equalsIgnoreCase(balikKata)){
            System.out.println("Kata atau kalimat tersebut adalah palindrome.");
        }else{
            System.out.println("Kata atau kalimat tersebut bukan palindrome.");
        }       
    }
}

class NodeStack {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    int data;
    NodeStack next;

    public NodeStack(char data) {
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

    public void push(char data) {
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

    public char pop() {
        char data = (char) tail.data;
        if (size == 1) {
            head = tail = null;
            size--;
        }
        else if (size != 0) {
            NodeStack pointer = head;
            while (pointer.next != tail) {
                pointer = pointer.next;
            }
            pointer.next = null;
            tail = pointer;
            size--;
        }
        return data;
    }

    public String balikKata(String masukan) {
        String balikKata="";
        Stack terbalik = new Stack();
        for (int i = 0; i < masukan.length(); i++) {
            terbalik.push(masukan.charAt(i));
        }
        for (int i = 0; i < masukan.length(); i++) {
            balikKata += terbalik.pop();
        }
        return balikKata;
    }

}