package ru.kuzmina.lesson2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Notebook[] testArr = new Notebook[50];
        fillNotebookArray(testArr);
        System.out.println("Начальный массив: ");
        printNotebookArr(testArr);
        InsertionSort.sort(testArr);
        System.out.println("Отсортированный массив: ");
        printNotebookArr(testArr);
    }
    public static int randomWithParam(int startValue, int endValue, int step){
        Random rnd = new Random();
        int i = rnd.nextInt(endValue / step);
        i = Math.max(i, startValue / step);
        return i * step;
    }

    public static void fillNotebookArray(Notebook[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int producerIndex = rnd.nextInt(4);
            arr[i] = new Notebook(Producer.values()[producerIndex].toString(),
                                randomWithParam(500, 2000, 50),
                                randomWithParam(4, 24, 4), producerIndex);
        }
    }

    public static void printNotebookArr(Notebook[] arr) {
        for (Notebook arrItm : arr) {
            System.out.println("(" + arrItm.getProducerName() + " :: " + arrItm.getCost() + " :: " + arrItm.getRamVolume() + "), ");
        }
    }
}
