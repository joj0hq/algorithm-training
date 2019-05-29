
package search;

public class BST {
    Node root = null;

    public static void main(String[] args) {
        Node node = new Node(5, "5");
        System.out.println("+++START++++++++++++");

        BST tree = new BST();
        tree.put(3, "Three");
        tree.put(2, "Two");
        tree.put(1, "One");
        tree.put(5, "Five");
        tree.put(1, "One");
        tree.put(9, "Nine");
        tree.put(8, "Eight");
        tree.put(4, "Four");

        tree.dump();
        System.out.println("");

        tree.delete(5);
        tree.dump();

        System.out.println("");
    }

    public void put(int key, String data) {
        Node newNode = new Node(key, data);
        if (root == null) {
            root = newNode;
        } else {
            Node node = root;
            while (true) {
                if (key == node.key) {
                    node.value = data;
                    return;
                } else if (key < node.key) {
                    if (node.left == null) {
                        node.left = newNode;
                        return;
                    }
                    node = node.left;
                } else if (key > node.key) {
                    if (node.right == null) {
                        node.right = newNode;
                        return;
                    }
                    node = node.right;
                }
            }
        }
    }

    public String get(int key) {
        Node node = root;
        while (true) {
            if (node == null) {
                return null;
            }
            if (node.key == key) {
                return node.value;
            } else if (node.key < key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    public void delete(int key) {
        delete(root, key);
    }

    public Node delete(Node node, int key) {
        if (node.key < key) {
            node.right = delete(node.right, key);
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node min = minNode(node.right);
            min.right = delete(node.right, min.key);
            min.left = node.left;
            return min;
        }
        return node;
    }

    private Node minNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void dump(Node node) {
        if (node.left == null && node.right == null) {
            System.out.println(node.value);
            return;
        }
        System.out.println(node.value + "(");

        if (node.left != null) {
            dump(node.left);
        }
        System.out.println(" - ");
        if (node.right != null) {
            dump(node.right);
        }
        System.out.println(")");
    }

    public void dump() {
        dump(root);
    }


}

class Node {
    public int key;
    public String value;
    public Node left;
    public Node right;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key) {
        this.key = key;
        this.value = Integer.toString(key);
    }
}