package ru.kuzmina.lesson2;

public class InsertionSort {
    public static void sort(Notebook[] arr) {
        for(int i = 1; i < arr.length; i++) {
            Notebook temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].getCost() > temp.getCost()) {
                arr[j + 1] = arr[j];
                j--;
            }

            while (j >= 0 && arr[j].getCost() == temp.getCost() && arr[j].getRamVolume() > temp.getRamVolume()) {
                arr[j + 1] = arr[j];
                j--;
            }

            while (j >= 0 && arr[j].getCost() == temp.getCost() && arr[j].getRamVolume() == temp.getRamVolume()
                          && arr[j].getNameSortPriority() >= temp.getNameSortPriority()) {
                arr[j + 1] = arr[j];
                j--;
            }


            arr[j + 1] = temp;
        }
    }
}
