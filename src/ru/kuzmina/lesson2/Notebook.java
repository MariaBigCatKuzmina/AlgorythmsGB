package ru.kuzmina.lesson2;

import java.util.Objects;

public class Notebook {
    private final String producerName;
    private final int cost;
    private final int ramVolume;
    private final int nameSortPriority;

    public Notebook(String producerName, int cost, int ramVolume, int nameSortPriority) {
        this.producerName = producerName;
        this.cost = cost;
        this.ramVolume = ramVolume;
        this.nameSortPriority = nameSortPriority;
    }

    public String getProducerName() {
        return producerName;
    }

    public int getCost() {
        return cost;
    }

    public int getRamVolume() {
        return ramVolume;
    }

    public int getNameSortPriority() {
        return nameSortPriority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return cost == notebook.cost && ramVolume == notebook.ramVolume && Objects.equals(producerName, notebook.producerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producerName, cost, ramVolume);
    }
}
