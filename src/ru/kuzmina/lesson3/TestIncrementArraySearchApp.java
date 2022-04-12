package ru.kuzmina.lesson3;

import java.util.Arrays;

public class TestIncrementArraySearchApp {
    public static void main(String[] args) {
        IncrementArray arr = new IncrementArray(10);
        System.out.println(arr);
        System.out.println("Пропущенное значение: " + arr.findMissingElement());
    }
}
