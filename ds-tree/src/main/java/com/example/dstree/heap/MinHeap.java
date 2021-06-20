package com.example.dstree.heap;

import java.util.Arrays;

public class MinHeap {
    private int index;
    private int size;
    private int[] heap;

    @Override
    public String toString() {
        return "MinHeap{" +
                "index=" + index +
                ", size=" + size +
                ", heap=" + Arrays.toString(heap) +
                '}';
    }

    public MinHeap(int size) {
        this.index = 0;
        this.size = size;
        this.heap = new int[size];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return (i * 2) + 1;
    }

    private int rightChild(int i) {
        return (i * 2) + 2;
    }

    private void swapElements(int index, int parentIndex) {
        int temp = heap[index];
        int parent = heap[parentIndex];
        heap[parentIndex] = temp;
        heap[index] = parent;

    }

    public int[] insertElements(int val) {

        heap[index] = val;
        int currentIndex = parent(index);
        int k = index;
        while (index < size) {
            if (val < heap[currentIndex]) {
                swapElements(k, currentIndex);
                k = currentIndex;
                currentIndex = parent(currentIndex);
            } else {
                break;
            }
        }
        index++;
        return heap;
    }
    public int[] removeSmallestElement() {
        heap[0] = heap[size-1];
        heap[size-1] = 0;
        index = 0;
        int currentIndex = index;
        while (currentIndex < size) {
            int leftIndex = leftChild(currentIndex);
            int rightIndex = rightChild(currentIndex);

            if(leftIndex < size && rightIndex < size && heap[leftIndex] < heap[rightIndex]) {
                if(heap[leftIndex] < heap[currentIndex]) {
                    swapElements(currentIndex, leftIndex);
                    currentIndex = leftIndex;
                }

            } else if(leftIndex < size && rightIndex < size && heap[rightIndex] < heap[leftIndex]) {
                if(heap[rightIndex] < heap[currentIndex]) {
                    swapElements(currentIndex, rightIndex);
                    currentIndex = rightIndex;
                }
            } else {
                break;
            }

        }
        return heap;
    }


}
