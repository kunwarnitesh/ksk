package com.ksk.tree;

public class BTreeApplications {
    private BTreeNode root;
    private int t;

    public BTreeApplications(int t) {
        this.root = null;
        this.t = t;
    }
    public static void main(String[] args) {

    }

    public void insert(int k) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = k;
            root.n = 1;
        } else {
            if (root.n == 2*t-1){
                BTreeNode s = new BTreeNode(t,false);
                s.children[0] = root;
                s.splitChild(0,root);
            }

        }
    }
}

class BTreeNode{

    int [] keys;
    int t;
    BTreeNode[] children;
    int n;
    boolean leaf;

    public BTreeNode(int t, boolean leaf){
        this.t =t;
        this.leaf =leaf;
        this.keys =new int[2*t-1];
        this.children = new BTreeNode[2*t];
        this.n=0;
    }

    void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.leaf);
        z.n = t - 1;

        for (int j = 0; j < t - 1; j++)
            z.keys[j] = y.keys[j + t];

        if (!y.leaf) {
            for (int j = 0; j < t; j++)
                z.children[j] = y.children[j + t];
        }

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--)
            children[j + 1] = children[j];

        children[i + 1] = z;

        for (int j = n - 1; j >= i; j--)
            keys[j + 1] = keys[j];

        keys[i] = y.keys[t - 1];
        n++;
    }

}
