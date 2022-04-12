package ru.kuzmina.lesson3;

import java.util.Arrays;
import java.util.Random;

public class IncrementArray {
    int[] arr;

    public IncrementArray(int length) {
        this.arr = new int[length];
        fillArray(length);
    }

    private void fillArray(int length) {
        Random rnd  = new Random();
        int skipIndex = rnd.nextInt(length - 1);
        int step = 1;
        for (int i = 0; i < length; i++) {
            if (i == skipIndex) {
                step = 2;
            }
            arr[i] = i + step;
        }
    }

    public int findMissingElement() {
        int low = 0;
        int high  = arr.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int val = middle + 1;
            if (val == arr[middle]) {
                low = middle + 1;
            } else if (middle - 1 >= 0 && arr[middle] - 1 == arr[middle - 1]) {
                high = middle - 1;
            } else {
                return val;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "IncrementArray{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
