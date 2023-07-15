package HR6_UTP;

import java.util.Scanner;

public class HotelMoklif {

    static int penumpangSelamat = 0;

    public static void main(String[] args) {
        /* Selamat Mengerjakan. Semoga semua usaha kalian dalam belajar bisa terbayarkan dengan nilai baik */
        Mobil mobil = new Mobil();
        Motor motor = new Motor();
        Scanner in = new Scanner(System.in);
        int durasi = in.nextInt();
        int jumlahKendaraan = in.nextInt();
        in.nextLine();
        for (int i = 0; i < jumlahKendaraan; i++) {
            String jenisKendaraan = in.next();
            if (jenisKendaraan.equalsIgnoreCase("mobil")) {
                String plat = in.next();
                int penumpang = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();

                }
                mobil.masuk(plat, penumpang);
            }
            if (jenisKendaraan.equalsIgnoreCase("motor")) {
                String plat = in.next();
                int cc = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();

                }
                motor.masuk(plat, cc);
            }
        }

        mobil.cek_selamat(durasi);
        motor.cek_selamat(durasi);
        mobil.cek_timbun();
        motor.cek_timbun();
        System.out.println("Total korban tertimbun sebanyak " + penumpangSelamat + " orang.");

    }
}

class Node {

    String data1;
    int data2;
    Node next;

    Node(String data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

}

class Mobil {

    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    void masuk(String plat, int penumpang) {
        Node input = new Node(plat, penumpang);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;

    }

    Node keluar() {
        if (!isEmpty()) {
            Node mobil = head;
            head = head.next;
            mobil.next = null;
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return mobil;
        }
        return null;
    }

    void cek_selamat(int durasi) {
        System.out.println("Kendaraan selamat :");
        if (isEmpty()) {
            System.out.println("Tidak ada mobil di dalam basement.");
            return;
        }
        SLL mobilselamat = new SLL();
        for (int i = 0; i < durasi; i++) {
            Node mobil = keluar();
            if (mobil != null) {
                mobilselamat.addLast(mobil);
            }
        }
        mobilselamat.mobilprintselamat();
        if (isEmpty()) {
            System.out.println("Semua mobil berhasil keluar dengan selamat.");
        }
    }

    void cek_timbun() {
        System.out.println("");
        System.out.println("Kendaraan tertimbun : ");
        SLL mobiltimbun = new SLL();
        int batas = size;
        for (int i = 0; i < batas; i++) {
            Node mobil = keluar();
            if (mobil != null) {
                mobiltimbun.addLast(mobil);
                HotelMoklif.penumpangSelamat += mobil.data2;
            }
        }
        mobiltimbun.mobilprinttertimbun();
    }

}

class Motor {

    Node head, tail;
    int size = 0;

    boolean isEmpty() {
        return size == 0;
    }

    void masuk(String plat, int cc) {
        Node input = new Node(plat, cc);
        if (isEmpty()) {
            head = tail = input;
        } else {
            if (input.data2 > head.data2) {
                input.next = head;
                head = input;
            } else {
                Node pointer = head;
                while (pointer.next != null && pointer.next.data2 >= input.data2) {
                    pointer = pointer.next;
                }
                input.next = pointer.next;
                pointer.next = input;
            }
        }
        size++;
    }

    Node keluar() {
        if (size == 1) {
            Node motor = head;
            head = tail = null;
            motor.next = null;
            size--;
            return motor;
        } else if (!isEmpty()) {
            Node motor = head;
            head = head.next;
            motor.next = null;
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return motor;
        }
        return null;
    }

    void cek_selamat(int durasi) {
        if (isEmpty()) {
            System.out.println("Tidak ada motor di dalam basement.");
            return;
        }
        SLL motorselamat = new SLL();
        for (int i = 0; i < durasi; i++) {
            Node motor = keluar();
            if (motor != null) {
                motorselamat.addLast(motor);
            }
        }
        motorselamat.motorprintselamat();
        if (isEmpty()) {
            System.out.println("Semua motor berhasil keluar dengan selamat.");
        }
    }

    void cek_timbun() {
        SLL motortimbun = new SLL();
        int batas = size;
        for (int i = 0; i < batas; i++) {
            Node motor = keluar();
            if (motor != null) {
                motortimbun.addFirst(motor);
                HotelMoklif.penumpangSelamat += 1;
            }
        }
        motortimbun.motorprinttertimbun();
    }

}

class SLL {

    Node head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(Node data) {
        if (isEmpty()) {
            head = tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    public void addFirst(Node data) {
        if (isEmpty()) {
            head = tail = data;
        } else {
            data.next = head;
            head = data;
        }
        size++;
    }

    public void motorprintselamat() {
        if (isEmpty()) {
            System.out.println("Tidak ada motor yang selamat.");
        } else {
            Node pointer = head;
            System.out.print("Motor dengan plat nomor ");
            while (pointer != null) {
                System.out.print(pointer.data1 + ", ");
                pointer = pointer.next;
            }
            System.out.println("berhasil keluar dengan selamat.");
        }
    }

    public void mobilprintselamat() {
        if (isEmpty()) {
            System.out.println("Tidak ada mobil yang selamat.");
        } else {
            Node pointer = head;
            System.out.print("Mobil dengan plat nomor ");
            while (pointer != null) {
                System.out.print(pointer.data1 + ", ");
                pointer = pointer.next;
            }
            System.out.println("berhasil keluar dengan selamat.");
        }

    }

    public void motorprinttertimbun() {
        if (isEmpty()) {
            System.out.println("Tidak ada motor yang tertimbun.");
        } else {
            Node pointer = head;
            System.out.print("Motor dengan plat nomor: ");
            while (pointer != null) {
                System.out.print(pointer.data1 + ", ");
                pointer = pointer.next;
            }
            System.out.println("masih tertimbun reruntuhan.");
        }
        System.out.println();

    }

    public void mobilprinttertimbun() {
        if (isEmpty()) {
            System.out.println("Tidak ada mobil yang tertimbun.");
        } else {
            Node pointer1 = head;
            System.out.print("Mobil dengan plat nomor: ");
            while (pointer1 != null) {
                System.out.print(pointer1.data1 + ", ");
                pointer1 = pointer1.next;
            }
            System.out.println("masih tertimbun reruntuhan.");
        }
    }
}
