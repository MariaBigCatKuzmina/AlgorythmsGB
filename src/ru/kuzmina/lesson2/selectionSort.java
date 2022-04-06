package ru.kuzmina.lesson2;

public class selectionSort {
    private static void change(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void sort(int[] arr) {
        int min, max;
        int high = arr.length;
        for (int i = 0; i < high; i++) {
            min = i;
            max = high - 1;
            for (int j = i + 1; j < high; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            change(arr, i, min);
            change(arr, high - 1, max);
            high--;
        }
    }
}
