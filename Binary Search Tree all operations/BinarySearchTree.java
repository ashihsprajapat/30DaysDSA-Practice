public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node buildBinarytree(Node root, int val) {
        // static int idx=-1;
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = buildBinarytree(root.left, val);
        } else {
            root.right = buildBinarytree(root.right, val);
        }
        return root;
    }

    public static void inoerder(Node root) {
        if (root == null) {
            return;
        }
        inoerder(root.left);
        System.out.print(root.data + "   ");
        inoerder(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = buildBinarytree(null, nodes[i]);
        }
        System.out.println(root.data);
        inoerder(root);
    }
}