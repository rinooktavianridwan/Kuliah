package HR14_UAP;


import java.util.Scanner;


class Node {
    Node prev;
    Node next;
    String artist;
    String judul;

    Node(String artist, String judul) {
        this.artist = artist;
        this.judul = judul;
    }
}

class DoubleLinkedListScratch {
    Node head;
    Node tail;
    Node state;

    int length = 0;
    void addSong(Node newNode) {
		/*
         * KATA MASBRO KERJAIN DISINI !!
         */
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    void printPlaylist() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Artist: " + temp.artist + " | Judul: " + temp.judul);
            temp = temp.next;
        }
    }

    void playPlaylist() {
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        if (head == null) {
        } else {
            this.state = head;
            System.out.println("Now Playing:");
            System.out.println("Artist: " + state.artist + " | Judul: " + state.judul);
        }
    }

    void printCurrentPlay() {
        if (this.state == null) {
            return;
        } else System.out.println("Now Playing:\nArtist: " + state.artist + " | Judul: " + state.judul);
    }

    void toNextSong() {
        if (this.state.next == null) {
            System.out.println("Cannot go to next song, no song specified in playlist!");
        } 
      	 /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        else {
            this.state = state.next;
            System.out.println("Now Playing:");
            System.out.println("Artist: " + state.artist + " | Judul: " + state.judul);
        }
    }

    void toPreviousSong() {
        if (this.state.prev == null) {
            System.out.println("Cannot go to preivous song, no song specified in playlist!");
        } 
      	 /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        else {
            this.state = state.prev;
            System.out.println("Now Playing:");
            System.out.println("Artist: " + state.artist + " | Judul: " + state.judul);
        }
    }
}

class QueueScratch {
    Node head;
    Node tail;
    int length = 0;

    void addSong(Node newNode) {
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    Node deQueue() {
        if (length == 0) {
            System.out.println("No song to pick from waiting list!");
            return null;
        }
        /*
         * KATA MASBRO KERJAIN DISINI !!
         */
        else {
            Node dequeuedNode = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            dequeuedNode.next = null;
            length--;
            return dequeuedNode;
        }
    }

    void printWaitingList() {
        Node temp = head;
        System.out.println("Waiting List:");
        for (int i = 0; i < length; i++) {
            System.out.println("Artist: " + temp.artist + " | Judul: " + temp.judul);
            temp = temp.next;
        }
    }
}

public class Spotijoox {
    public static void main(String args[] ) throws Exception {
        DoubleLinkedListScratch playlist = new DoubleLinkedListScratch();
        QueueScratch waitingList = new QueueScratch();
        Scanner in = new Scanner(System.in);

        int totalActions = in.nextInt();
        in.nextLine();
        for (int action = 0; action < totalActions; action++) {
            String actionIndicator = in.nextLine();
            if (actionIndicator.equals("ADDSONG"))
                playlist.addSong(new Node(in.nextLine(), in.nextLine()));
            if (actionIndicator.equals("PLAYSONG"))
                playlist.playPlaylist();
            if (actionIndicator.equals("NEXTSONG"))
                playlist.toNextSong();
            if (actionIndicator.equals("PREVSONG"))
                playlist.toPreviousSong();
            if (actionIndicator.equals("PRINTSONG"))
                playlist.printCurrentPlay();
            if (actionIndicator.equals("PRINTPLAYLIST"))
                playlist.printPlaylist();
            if (actionIndicator.equals("ADDWAIT"))
                waitingList.addSong(new Node(in.nextLine(), in.nextLine()));
            if (actionIndicator.equals("ADDSONGWAIT"))
                playlist.addSong(waitingList.deQueue());
            if (actionIndicator.equals("PRINTWAIT"))
                waitingList.printWaitingList();
        }
    }
}