package ru.kuzmina.lesson5;

import java.util.ArrayList;
import java.util.List;

public class RucksackTest {
    public static void main(String[] args) {
        Rucksack rucksack = new Rucksack(15);
        List<Subject> allSubjects = new ArrayList<>();
        allSubjects.add(new Subject("Book", 5, 10));
        allSubjects.add(new Subject("Golden Ring", 2, 100));
        allSubjects.add(new Subject("Earphones", 3, 50));
        allSubjects.add(new Subject("Notebook", 8, 150));
        allSubjects.add(new Subject("Barbell", 12, 5));

        System.out.println(rucksack.getBestItemsSet(allSubjects));
    }
}
