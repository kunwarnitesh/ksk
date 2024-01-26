package com.ksk.dsa.tree;

public class BSTProblems {

    Node root;

    public static void main(String[] args) {

        BSTProblems tree = new BSTProblems();

        /* Constructing tree given in the above figure */
        tree.root = new Node(3);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(4);
        tree.printInOrder(tree.root);
    }

    /**
     * In Order recursive
     * @param root
     */
    public void printInOrder(Node root){

        if (root==null){
            return;
        }
        printInOrder(root.left);
        System.out.printf(""+root.data);
        printInOrder(root.right);
    }

    public void printLevelOrder(Node root){


        if (root==null){
            return;
        }
        printInOrder(root.left);
        System.out.printf(""+root.data);
        printInOrder(root.right);
    }

    /**
     * This method is used to identify the height of the Binary Tree
     * @param root
     * @return
     */
    public int height(Node root){
        if (root == null){
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        if (lheight>rheight){
            return (lheight + 1);
        }else{
            return (rheight + 1);
        }
    }


    static class Node {
        int data;
        Node left, right;

        public Node(int d)
        {
            data = d;
            left = right = null;
        }
    }
}
