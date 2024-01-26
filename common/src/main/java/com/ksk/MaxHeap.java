package com.ksk;

public class MaxHeap {

    private int[] Heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize){
        this.maxSize = maxSize;
        this.size =0;
        Heap = new int[maxSize];
    }

    public static void main(String[] args) {

        System.out.println("The Max Heap is ");

        MaxHeap maxHeap = new MaxHeap(15);

        // Inserting nodes
        // Custom inputs
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
//        for (int i = 0; i < 2; i++)
//            maxHeap.extractMax();
        // Print and display the maximum value in heap
        System.out.println("The max val is "+maxHeap.extractMax());
        maxHeap.print();
    }

    private void print() {
        for (int i =0; i<size/2;i++){
            System.out.print("Parent Node : " + Heap[i]);

            if (getLeftChildIndex(i)
                    < size) // if the child is out of the bound
                // of the array
                System.out.print(" Left Child Node: "
                        + Heap[getLeftChildIndex(i)]);

            if (getRightChildIndex(i)
                    < size) // the right child index must not
                // be out of the index of the array
                System.out.print(" Right Child Node: "
                        + Heap[getRightChildIndex(i)]);

            System.out.println(); // for new line
        }
    }

    private void insert(int data) {
        if (size<maxSize){
            Heap[size] = data;
            int current = size;
            while (Heap[current]>Heap[getParentIndex(current)]){
                swapNodes(current,getParentIndex(current));
                current = getParentIndex(current);
            }
            size++;
        }else{
            System.out.println("Heap is full");
        }

    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos)){
            return;
        }
        if (Heap[pos] < Heap[getLeftChildIndex(pos)] || Heap[pos] < Heap[getRightChildIndex(pos)]){
            if (Heap[pos] < Heap[getLeftChildIndex(pos)]){
                swapNodes(pos,getLeftChildIndex(pos));
                maxHeapify(getLeftChildIndex(pos));
            } else if (Heap[pos] < Heap[getRightChildIndex(pos)]) {
                swapNodes(pos,getRightChildIndex(pos));
                maxHeapify(getRightChildIndex(pos));
            }
        }

    }

    public int extractMax()
    {
        int popped = Heap[0];
        Heap[0] = Heap[--size];
        maxHeapify(0);
        return popped;
    }


    private void  swapNodes(int i,int j){
        int temp = Heap[i];
        Heap[i] = Heap[j];
        Heap[j] = temp;
    }

    private int getParentIndex(int index) {
        return (index-1)/2;
    }

    private int getLeftChildIndex(int index) {
        return 2*index+1;
    }

    private int getRightChildIndex(int index) {
        return 2*index+2;
    }

    private boolean isLeaf(int pos){
        if (pos >= (size / 2) && pos <= size)
            return true;
        return false;
    }

}
