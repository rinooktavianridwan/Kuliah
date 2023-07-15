package QUIZ_GRAPH;

class Main {

    public static void main(String[] args) {
        Queue jalanKebenaran = new Queue();
        int[][] Peta = {
            {0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 0},};

        int mulai = 5;
        int selesai = 2;
        jalanKebenaran.cariJalan(Peta, mulai, selesai);
    }
}
