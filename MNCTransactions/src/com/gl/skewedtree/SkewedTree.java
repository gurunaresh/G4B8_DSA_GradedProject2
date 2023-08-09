package com.gl.skewedtree;

class Node {
    int val;
    Node left;
    Node right;
    
    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SkewedTree {

    // Function to perform a right rotation
    private static Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    // Function to convert BST to ascending order right-skewed tree
    private static Node toRightSkewed(Node root) {
        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root = rightRotate(root);
        }

        root.right = toRightSkewed(root.right);

        return root;
    }

    // In-order traversal of the tree to verify the order
    private static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        // Construct a BST
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.right.left = new Node(55);

        // Convert BST to ascending order right-skewed tree
        Node skewedRoot = toRightSkewed(root);

        // Print the elements in ascending order using in-order traversal
        System.out.println("Ascending Order Right-Skewed Tree:");
        inOrder(skewedRoot);
    }
}
