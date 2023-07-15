
package HR8_HT_BST;

import java.util.Scanner;

public class DataBukuPerpustakaan {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int jumlahPerintah = in.nextInt();
        BST binarySearchTree = new BST();
        in.nextLine();
        for (int i = 0; i < jumlahPerintah; i++) {
            String perintah = in.nextLine();
            if (perintah.equalsIgnoreCase("Tambah Data")) {
                System.out.println("Masukkan tahun: ");
                int tahun = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();
                }
                System.out.println("Masukkan judul: ");
                String judul = in.nextLine();
                System.out.println("Masukkan penulis: ");
                String penulis = in.nextLine();
                binarySearchTree.add(tahun, judul, penulis);
                System.out.println("Data berhasil ditambahkan");
            } else if (perintah.equalsIgnoreCase("Hapus Data")) {
                System.out.println("Masukkan tahun buku yang ingin dihapus:");
                int tahun = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();
                }
                binarySearchTree.delete(tahun);
                System.out.println("Data berhasil dihapus");
            } else if (perintah.equalsIgnoreCase("Cari Data")) {
                int tahun;
                System.out.println("1. Cari Buku Paling Lama");
                System.out.println("2. Cari Buku Paling Baru");
                System.out.println("3. Cari Buku Lain");
                System.out.println("Masukkan pilihan Anda:");
                int pilihan = in.nextInt();
                if (in.hasNextLine()) {
                    in.nextLine();
                }
                switch (pilihan) {
                    case 1 -> {
                        if (binarySearchTree.isEmpty()) {
                            System.out.println("Buku tidak ada");
                        } else {
                            tahun = binarySearchTree.findSmallestValue(binarySearchTree.root);
                            binarySearchTree.search(binarySearchTree.root, tahun);
                        }
                    }
                    case 2 -> {
                        if (binarySearchTree.isEmpty()) {
                            System.out.println("Buku tidak ada");
                        } else {
                            tahun = binarySearchTree.findBiggestValue(binarySearchTree.root);
                            binarySearchTree.search(binarySearchTree.root, tahun);
                        }

                    }
                    case 3 -> {
                        System.out.println("Masukkan tahun buku yang ingin dicari:");
                        tahun = in.nextInt();
                        if (in.hasNextLine()) {
                            in.nextLine();
                        }
                        binarySearchTree.search(binarySearchTree.root, tahun);
                    }
                    default -> {
                    }
                }

            } else if (perintah.equalsIgnoreCase("Tampilkan Data")) {
                if (binarySearchTree.isEmpty()) {
                    System.out.println("Tidak ada data yang ditemukan");
                } else {
                    binarySearchTree.preorder(binarySearchTree.root);
                }
            }

        }

    }
}

class NodeBST {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeBST. */
    int tahun;
    String judul;
    String penulis;
    NodeBST left, right;

    public NodeBST(int tahun, String judul, String penulis) {
        this.tahun = tahun;
        this.judul = judul;
        this.penulis = penulis;
        left = right = null;
    }
}

class BST {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named BST. */
    NodeBST root;

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int tahun, String judul, String penulis) {
        root = add(root, tahun, judul, penulis);
    }

    public NodeBST add(NodeBST current, int tahun, String judul, String penulis) {
        NodeBST temp = current;
        if (temp == null) {
            temp = new NodeBST(tahun, judul, penulis);
        } else if (tahun < current.tahun) {
            temp.left = add(current.left, tahun, judul, penulis);
        } else if (tahun > current.tahun) {
            temp.right = add(current.right, tahun, judul, penulis);
        }
        return temp;
    }

    public void delete(int tahun) {
        root = delete(root, tahun);
    }

    public NodeBST delete(NodeBST current, int data) {
        if (current == null) {
            return null;
        }
        if (data < current.tahun) {
            current.left = delete(current.left, data);
            return current;
        } else if (data > current.tahun) {
            current.right = delete(current.right, data);
            return current;
        } else {
            // jika data yang akan dihapus merupakan leaf node
            if (current.left == null && current.right == null) {
                return null;
            }
            // jika data yang dihapus memiliki 1 child node
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            // jika data yang dihapus memiliki 2 child node
            int smallestValue = findSmallestValue(current.right);
            current.tahun = smallestValue;
            current.right = delete(current.right, smallestValue);
            return current;
        }
    }

    public void search(NodeBST root, int tahun) {
        NodeBST temp = root;
        if (temp == null) {
            System.out.println("Buku tidak ada");
            return;
        }
        while (temp != null) {
            if (temp.tahun == tahun) {
                System.out.println(temp.tahun + " - " + temp.judul + " - " + temp.penulis);
                return;
            } else if (temp.tahun > tahun) {
                temp = temp.left;
            } else if (temp.tahun < tahun) {
                temp = temp.right;
            }

        }
        if (temp == null) {
            System.out.println("Buku tidak ada");
        }

    }

    public int findSmallestValue(NodeBST root) {
        if (root.left == null) {
            return root.tahun;
        } else {
            return findSmallestValue(root.left);
        }
    }

    public int findBiggestValue(NodeBST root) {
        if (root.right == null) {
            return root.tahun;
        } else {
            return findBiggestValue(root.right);
        }
    }

    public void preorder(NodeBST current) {
        System.out.println(current.tahun + " - " + current.judul + " - " + current.penulis);
        if (current.left != null) {
            preorder(current.left);
        }
        if (current.right != null) {
            preorder(current.right);
        }
    }

}
