package net.droidit.array;

import java.util.Random;
import java.util.Scanner;

public class StackQueue {
    private int[] array;
    //TODO: Try to utilize all the array's memory, instead of splitting the memory between stack and queue
    private int stackIndex = -1;
    private int queuePushIndex = -1;
    private int queuePopIndex = 1;

    public StackQueue(int capacity) {
        array = new int[capacity];
    }

    public boolean pushToStack(int e) {
        if (canBePushed()) {
            stackIndex = stackIndex < 0 ? 0 : stackIndex;
            array[stackIndex] = e;
            stackIndex += 2;
            return true;
        } else {
            return false;
        }
    }

    public int popFromStack() {
        int temp = 0;
        if (stackIndex >= 0) {
            temp = array[stackIndex];
            stackIndex = stackIndex - 2;
        }
        return temp;
    }

    public boolean enqueue(int e) {
        if (canBePushed()) {
            queuePushIndex = queuePushIndex < 0 ? 1 : queuePushIndex;
            array[queuePushIndex] = e;
            queuePushIndex += 2;
            return true;
        } else {
            return false;
        }
    }

    public int dequeue() {
        int temp = 0;
        if (queuePushIndex >= 1) {
            temp = array[queuePopIndex];
            int j = 1;
            //TODO: implement circular queue
            for (int i = 3; i <= queuePushIndex; i = i + 2) {
                array[j] = array[i];
                j = j + 2;
            }

            queuePushIndex = queuePushIndex - 2;
        }
        return temp;
    }

    public boolean canBePushed() {
        if ((stackIndex + queuePushIndex) > array.length - 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in .nextInt();
        Random rand = new Random();
        StackQueue stackQueue = new StackQueue(10);
        for (int i = 0; i < t; i++) {

        }
    }
}