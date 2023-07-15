package QUIZ_GRAPH;

class Queue {

    Node head;
    Node tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int koorPeta) {
        Node antrianKoor = new Node(koorPeta);
        if (isEmpty()) {
            head = tail = antrianKoor;
        } else {
            tail.next = antrianKoor;
            tail = antrianKoor;
        }
        size++;
    }

    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public boolean jalanKebenaran(int koorPeta) {
        Node tempKoor = head;
        while (tempKoor != null) {
            if (tempKoor.koorPeta == koorPeta) {
                return true;
            }
            tempKoor = tempKoor.next;
        }
        return false;
    }

    public void cariJalan(int[][] peta, int mulai, int selesai) {
        Queue[] antrianJalan = new Queue[peta.length];
        for (int i = 0; i < peta.length; i++) {
            antrianJalan[i] = new Queue();
            for (int j = 0; j < peta.length; j++) {
                if (peta[i][j] == 1) {
                    antrianJalan[i].enqueue(j);
                }
            }
        }
        Stack historyJalan = new Stack();
        boolean[] cekSudahPernah = new boolean[antrianJalan.length];
        historyJalan.push(mulai);
        cekSudahPernah[mulai] = true;
        while (!historyJalan.isEmpty()) {
            int tanda = historyJalan.top();
            if (antrianJalan[tanda].jalanKebenaran(selesai)) {
                historyJalan.push(selesai);
                break;
            } else {
                Node pengecekan = antrianJalan[tanda].head;
                boolean cek = false;
                while (pengecekan != null) {
                    int tanda1 = pengecekan.koorPeta;
                    if (!cekSudahPernah[tanda1]) {
                        historyJalan.push(tanda1);
                        cekSudahPernah[tanda1] = true;
                        cek = true;
                        break;
                    }
                    pengecekan = pengecekan.next;

                }
                if (!cek) {
                    historyJalan.pop();
                }
            }
        }
        historyJalan.print();
    }

}
