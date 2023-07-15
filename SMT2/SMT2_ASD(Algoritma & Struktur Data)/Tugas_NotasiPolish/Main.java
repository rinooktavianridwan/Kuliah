package Tugas_NotasiPolish;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        StackArray tumpukanAngka = new StackArray(100); // membuat instance tumpukan1 dengan ukuran 2
        System.out.println("===============================================");
        System.out.println("Masukkan Operasi Matematika:");
        System.out.println("Contoh : 3 + 2 * 7 + 2 - 3 / 1");
        System.out.println("(Harap Dipisah dengan Spasi)");
        System.out.print("Masukkan : ");
        String masukan = in.nextLine();
        String postfix = tumpukanAngka.infixToPostfix(masukan); // memanggil method infixToPostfix dari instance tumpukanAngka
        System.out.println("===============================================");
        System.out.println("Jadi Diperoleh Hasil");
        System.out.println("Notasi Polish : " + postfix);
        System.out.println("===============================================");
    }
}

class StackArray {

    private final char[] stack;
    private int top;

    public StackArray(int size) {
        stack = new char[size];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == stack.length - 1);
    }

    public void push(char inputan) {
        if (!isFull()) {
            stack[++top] = inputan;
        } else {
            System.out.println("Stack overflow!");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("Stack underflow!");
            return '\0';
        }
    }

    public char peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack is empty!");
            return '\0';
        }
    }

    private static boolean cekAngka(char c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean cekOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private static int cekPriority(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }

    public String infixToPostfix(String masukan) {
        String postfix = "";
        for (int i = 0; i < masukan.length(); i++) {
            char inputan = masukan.charAt(i);
            if (cekAngka(inputan)) {
                postfix += inputan;
            } else if (cekOperator(inputan)) {
                while (!isEmpty() && peek() != '(' && cekPriority(peek()) >= cekPriority(inputan)) {
                    postfix += pop();
                }
                push(inputan);
            } else if (inputan == '(') {
                push(inputan);
            } else if (inputan == ')') {
                while (!isEmpty() && peek() != '(') {
                    postfix += pop();
                }
                if (!isEmpty() && peek() != '(') {
                    System.out.println("Invalid infix expression!");
                    return "";
                } else {
                    pop();
                }
            }
        }
        while (!isEmpty()) {
            if (peek() == '(') {
                System.out.println("Invalid infix expression!");
                return "";
            }
            postfix += pop();
        }
        return postfix;
    }

}