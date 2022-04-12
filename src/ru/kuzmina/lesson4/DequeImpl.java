package ru.kuzmina.lesson4;


import ru.kuzmina.lesson3.QueueImpl;

import java.util.Arrays;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int length) {
        super(length);
    }

    @Override
    public boolean insertLeft(E value) {
        if (itemsAmount < length) {
            if (first == 0) {
                if (arr[first] != null) {
                    first = length - 1;
                }
                last = 0;
            } else {
                first--;
            }
            arr[first] = value;
            itemsAmount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean insertRight(E value) {
        return push(value);
    }

    @Override
    public E removeLeft() {
        return pop();
    }

    @Override
    public E removeRight() {
        if (itemsAmount > 0) {
            E deletedValue = arr[last];
            arr[last] = null;
            if (last == 0) {
                last = length - 1;
            } else {
                last--;
            }
            itemsAmount--;
            return deletedValue;
        }
        return null;
    }

    @Override
    public String toString() {
        return "DequeImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", left=" + first +
                ", right=" + last +
                ", itemsAmount=" + itemsAmount +
                ", length=" + length +
                '}';
    }
}
