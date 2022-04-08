package ru.kuzmina.lesson3;

public interface Queue<E> {
    boolean push(E value);
    E pop();
    E peek();
    boolean isEmpty();
    int size();

}
