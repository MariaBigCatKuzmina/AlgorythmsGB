package ru.kuzmina.lesson2;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortTestApp {
    public static int[] arr = new int[10];

    public static void main(String[] args) {
        fillRandomIntArray(arr);
        System.out.println(Arrays.toString(arr));
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void fillRandomIntArray(int[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(20);
        }
    }
}
