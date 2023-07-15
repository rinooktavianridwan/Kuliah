package HR2_CollectionGeneric;

import java.util.Scanner;

public class Ganjil_Genap {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int jumlahAngka = in.nextInt();
        in.nextLine(); 
        String[] kumpulanAngka = new String[jumlahAngka];

        for (int i = 0; i < jumlahAngka; i++) {
            kumpulanAngka[i] = in.nextLine();
        }
        
        for (int i = 0; i < jumlahAngka; i++) {
            if (isInteger(kumpulanAngka[i])) {
                Printer<Integer> printer = new Printer<>(Integer.parseInt(kumpulanAngka[i]));
                printer.print();
            } else {
                Printer<String> printer = new Printer<>(kumpulanAngka[i]);
                printer.print();
            }
        }
    }
    
    public static boolean isInteger(String test) {
        try {
            Integer.parseInt(test);
            return true;
        } catch (NumberFormatException gagal) {
            return false;
        }
    }
    
}

    
class Printer <T> {
  /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Printer. */
    public T isian;

    public Printer(T isian) {
        this.isian = isian;
    }

    public void print() {
        if (isian instanceof Integer) {
            System.out.println(isian + " adalah Integer");
        } else if (isian instanceof String) {
            System.out.println(isian + " adalah String");
        }
    }
    
    
}