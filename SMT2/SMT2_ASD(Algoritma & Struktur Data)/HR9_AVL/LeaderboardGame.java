
package HR9_AVL;

import java.util.Scanner;

public class LeaderboardGame {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        AVL avl = new AVL();
        int jumlahPerintah = in.nextInt();
        in.nextLine();
        for (int i = 0; i < jumlahPerintah; i++) {
            String perintah = in.next().trim();
            if (perintah.equalsIgnoreCase("MAIN")) {
                String masukanPemain = in.next().trim();
                String[] pemain = masukanPemain.split("-");
                if (avl.cariNodeChild(avl.root, pemain[0])) {
                    int skor = avl.skorPemain(avl.root, pemain[0]);
                    avl.delete(skor);
                }
                avl.add(pemain[0], Integer.parseInt(pemain[1]));
                System.out.println(pemain[0] + " telah menyelesaikan permainan dengan skor " + pemain[1]);
            } else if (perintah.equalsIgnoreCase("BANDINGKAN")) {
                String bandingkan = in.next().trim();
                String[] perbandingan = bandingkan.split("/");
                avl.perbandingan(perbandingan[0], perbandingan[1]);

            } else if (perintah.equalsIgnoreCase("CARI")) {
                String type = in.next().trim();
                if (type.equalsIgnoreCase("TERTINGGI")) {
                    avl.searchTertinggi(avl.root);
                } else if (type.equalsIgnoreCase("TERENDAH")) {
                    avl.searchTerendah(avl.root);
                } else if (type.equalsIgnoreCase("LAINNYA")) {
                    String namaPemain = in.next().trim();
                    int skor = avl.skorPemain(avl.root, namaPemain);
                    if (skor != -1) {
                        System.out.println("Skor yang dimiliki oleh " + namaPemain + " adalah " + skor);
                    } else {
                        System.out.println("Pemain belum terdaftar");
                    }
                }
            } else if (perintah.equalsIgnoreCase("TAMPILKAN")) {
                if (avl.root == null) {
                    System.out.println("Leaderboard kosong");
                } else {
                    avl.preorder(avl.root);
                }
            }

        }
    }
}

class NodeAVL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named NodeAVL. */
    String pemain;
    int skor, height;
    NodeAVL left, right;

    NodeAVL(String pemain, int skor) {
        this.pemain = pemain;
        this.skor = skor;
        height = 1;
        left = right = null;
    }
}

class AVL {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named AVL. */
    NodeAVL root;

    public int height(NodeAVL N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    public boolean cariNodeChild(NodeAVL root, String input) {
        if (root == null) {
            return false;
        } else if (root.pemain.equalsIgnoreCase(input)) {
            return true;
        } else {
            boolean left = cariNodeChild(root.left, input);
            boolean right = cariNodeChild(root.right, input);
            return left || right;
        }
    }

    public int skorPemain(NodeAVL root, String input) {
        int skor = -1;
        NodeAVL nodeSementara = root;
        while (cariNodeChild(nodeSementara, input)) {
            if (nodeSementara.pemain.equals(input)) {
                skor = nodeSementara.skor;
                break;
            } else if (nodeSementara.left != null && cariNodeChild(nodeSementara.left, input)) {
                nodeSementara = nodeSementara.left;
            } else if (nodeSementara.right != null && cariNodeChild(nodeSementara.right, input)) {
                nodeSementara = nodeSementara.right;
            }
        }
        return skor;
    }

    // fungsi untuk rotasi kanan
    public NodeAVL rightRotate(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL T2 = x.right;
        // rotasi kanan
        x.right = y;
        y.left = T2;
        // perbarui tinggi dari node
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    // fungsi untuk rotasi kiri
    public NodeAVL leftRotate(NodeAVL x) {
        NodeAVL y = x.right;
        NodeAVL T2 = y.left;
        // rotasi kiri
        y.left = x;
        x.right = T2;
        // perbarui tinggi dari node
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    // cek faktor keseimbangan node
    public int getBalance(NodeAVL N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    public void add(String pemain, int skor) {
        root = add(root, pemain, skor);
    }

    public NodeAVL add(NodeAVL node, String pemain, int skor) {
        if (node == null) {
            return (new NodeAVL(pemain, skor));
        }
        if (skor < node.skor) {
            node.left = add(node.left, pemain, skor);
        } else if (skor > node.skor) {
            node.right = add(node.right, pemain, skor);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        // right rotation (left of left)
        if (balance > 1 && skor < node.left.skor) {
            return rightRotate(node);
        }
        // left rotation (right of right)
        if (balance < -1 && skor > node.right.skor) {
            return leftRotate(node);
        }
        // left-right rotation (right of left)
        if (balance > 1 && skor > node.left.skor) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right-left rotation (left of right)
        if (balance < -1 && skor < node.right.skor) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void delete(int skor) {
        root = delete(root, skor);
    }

    public NodeAVL delete(NodeAVL node, int skor) {
        // jika tree hanya memiliki satu node
        if (node == null) {
            return node;
        }
        if (skor < node.skor) {
            node.left = delete(node.left, skor);
        } else if (skor > node.skor) {
            node.right = delete(node.right, skor);
        } else {
            // leaf node
            if (node.left == null && node.right == null) {
                return null;
            }
            // memiliki 1 child node
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            // memiliki 2 child node
            NodeAVL smallestValue = findSmallestValue(node.right);
            node.skor = smallestValue.skor;
            node.pemain = smallestValue.pemain;
            node.right = delete(node.right, smallestValue.skor);
            return node;
        }
        // perbarui tinggi node
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        // cek faktor keseimbangan node
        int balance = getBalance(node);
        // right rotation (left of left)
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // left rotation (right of right)
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // left-right rotation (right of left)
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right-left rotation (left of right)
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public NodeAVL findSmallestValue(NodeAVL node) {
        NodeAVL current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public NodeAVL findBiggestValue(NodeAVL node) {
        NodeAVL current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public void perbandingan(String pemain1, String pemain2) {
        int skorPemain1 = skorPemain(root, pemain1);
        int skorPemain2 = skorPemain(root, pemain2);
        if (skorPemain1 != -1 && skorPemain2 != -1) {
            if (skorPemain1 < skorPemain2) {
                System.out.println(pemain2 + " lebih unggul dari " + pemain1);
            } else {
                System.out.println(pemain1 + " lebih unggul dari " + pemain2);

            }
        } else {
            System.out.println("Tidak bisa dibandingkan karena pemain tidak terdaftar");
        }
    }

    public void preorder(NodeAVL current) {
        System.out.println(current.pemain + " = " + current.skor);
        if (current.left != null) {
            preorder(current.left);
        }
        if (current.right != null) {
            preorder(current.right);
        }
    }

    public int Tertinggi(NodeAVL root) {
        if (root.right == null) {
            return root.skor;
        } else {
            return Tertinggi(root.right);
        }
    }

    public void searchTertinggi(NodeAVL root) {
        if (root == null) {
            System.out.println("Pemain belum terdaftar");
            return;
        }

        int skorTertinggi = Tertinggi(root);

        NodeAVL temp = root;
        while (temp != null) {
            if (temp.skor == skorTertinggi) {
                System.out.println("Pemain dengan skor tertinggi adalah " + temp.pemain + " dengan skor " + temp.skor);
                return;
            } else if (temp.skor > skorTertinggi) {
                temp = temp.left;
            } else if (temp.skor < skorTertinggi) {
                temp = temp.right;
            }
        }

        System.out.println("");
    }

    public int Terendah(NodeAVL root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else if (root.left == null) {
            return root.skor;
        } else {
            return Terendah(root.left);
        }
    }

    public void searchTerendah(NodeAVL root) {
        if (root == null) {
            System.out.println("Pemain belum terdaftar");
            return;
        }

        int skorTerendah = Terendah(root);

        NodeAVL temp = root;
        while (temp != null) {
            if (temp.skor == skorTerendah) {
                System.out.println("Pemain dengan skor terendah adalah " + temp.pemain + " dengan skor " + temp.skor);
                return;
            } else if (temp.skor > skorTerendah) {
                temp = temp.left;
            } else if (temp.skor < skorTerendah) {
                temp = temp.right;
            }
        }

        System.out.println("");
    }
}
