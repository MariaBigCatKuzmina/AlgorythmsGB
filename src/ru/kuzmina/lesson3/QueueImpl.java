package ru.kuzmina.lesson3;

import java.util.Arrays;

public class QueueImpl<E> implements Queue<E> {
    protected final E[] arr;
    protected int first;
    protected int last;
    protected int itemsAmount;
    protected final int length;

    public QueueImpl(int length) {
        this.length = length;
        this.first = 0;
        this.last = -1;
        this.itemsAmount = 0;
        this.arr = (E[]) new Object[length];
    }


    @Override
    public boolean push(E value) {
        if (itemsAmount < length) {
            if (last == length - 1) {
                last = 0;
            } else {
                last++;
            }
            arr[last] = value;
            itemsAmount++;
            return true;
        }
        return false;
    }

    @Override
    public E pop() {
        if (itemsAmount > 0) {
            E deletedValue = arr[first];
            arr[first] = null;
            if (first == length - 1) {
                first = 0;
            } else {
                first++;
            }
            itemsAmount--;
            return deletedValue;
        }
        return null;
    }

    @Override
    public E peek() {
        return arr[first];
    }

    @Override
    public boolean isEmpty() {
        return itemsAmount == 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public String toString() {
        return "QueueImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", first=" + first +
                ", last=" + last +
                ", itemsAmount=" + itemsAmount +
                ", length=" + length +
                '}';
    }
}
