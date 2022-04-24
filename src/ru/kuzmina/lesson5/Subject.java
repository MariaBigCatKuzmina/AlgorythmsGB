package ru.kuzmina.lesson5;

public class Subject {
    private final String name;
    private final int weight;
    private final int cost;

    public Subject(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "'" + name + "'";
    }
}
