import java.util.*;

public class binarytree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;

        public static Node buildBinarytree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBinarytree(nodes);
            newNode.right = buildBinarytree(nodes);
            return newNode;

        }

        // perorder traversal
        public static void perorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + "   ");
            perorder(root.left);
            perorder(root.right);
        }

        // Inorder
        public static void Inorder(Node root) {
            if (root == null) {
                return;
            }
            Inorder(root.left);
            System.out.print(root.data + "   ");
            Inorder(root.right);
        }

        // Postorder
        public static void Postorder(Node root) {
            if (root == null) {
                return;
            }
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data + "  ");
        }

        // Levelorder
        public static void Levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                        System.out.println();
                    }

                } else {
                    System.out.print(root.data + "   ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }

                }
            }
        }

        // heigth of tree
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        // count of node
        public static int countNode(Node root) {
            if (root == null) {
                return 0;
            }
            int lN = countNode(root.left);
            int rN = countNode(root.right);
            return lN + rN + 1;
        }

        // Diameter
        public static int Diameter(Node root) {
            if (root == null) {
                return 0;
            }
            int lDia = Diameter(root.left);
            int rDia = Diameter(root.right);
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(Math.max(rDia, rh), rh + lh + 1);
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinarytree(nodes);
        // tree.perorder(root);
        tree.Inorder(root);
        // tree.Postorder(root);
        // tree.Levelorder(root);
        System.out.println();
        System.out.println("height of tree " + tree.height(root));
        System.out.println(tree.countNode(root));
        System.out.println(tree.Diameter(root));
    }
}