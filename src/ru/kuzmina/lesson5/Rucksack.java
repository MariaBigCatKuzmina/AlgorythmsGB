package ru.kuzmina.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Rucksack {

    private final int maxWeight;

    private List<Subject> bestItemsSet;
    private int rucksackCost;

    public Rucksack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int getSetCost(List<Subject> set) {
        int totalCost = 0;
        for (Subject subject : set) {
            totalCost += subject.getCost();
        }
        return totalCost;
    }

    private int getSetWeight(List<Subject> set) {
        int totalWeight = 0;
        for (Subject subject : set) {
            totalWeight += subject.getWeight();
        }
        return totalWeight;
    }

    private void getBestSubjects(List<Subject> givenSubjects) {
        if (givenSubjects.size() > 0) {
            int setWeight = getSetWeight(givenSubjects);
            int cost = getSetCost(givenSubjects);
              if (bestItemsSet == null && setWeight <= maxWeight || setWeight <= maxWeight && cost > rucksackCost) {
                rucksackCost = cost;
                bestItemsSet = givenSubjects;
            }
        }
            for (int i = 0; i < givenSubjects.size(); i++) {
                List<Subject> newSet = new ArrayList<>(List.copyOf(givenSubjects));
                newSet.remove(i);
                getBestSubjects(newSet);
            }

    }

    public List<Subject> getBestItemsSet(List<Subject> allItemsSet) {
        getBestSubjects(allItemsSet);
        return bestItemsSet;
    }


}
