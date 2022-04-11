package ru.kuzmina.lesson4;


import ru.kuzmina.lesson3.QueueImpl;

import java.util.Arrays;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {
//    private final E[] arr;
//    private int first;
//    private int last;
//    private int itemsAmount;
//    private final int length;

//    public DequeImpl(int length) {
//        super(length);
//        this.length = length;
//        this.left = 0;
//        this.right = -1;
//        this.itemsAmount = 0;
//        this.arr = (E[]) new Object[length];
//    }

    public DequeImpl(int length) {
        super(length);
    }

    @Override
    public boolean insertLeft(E value) {
//        System.out.println(("insert left " + value.toString()));
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
//        System.out.println(("insert right " + value.toString()));
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
//            System.out.println("remove right " + deletedValue.toString());
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

//    @Override
//    public boolean push(E value) {
//        if (itemsAmount < length) {
//            if (last == length - 1) {
//                last = 0;
//            } else {
//                last++;
//            }
//            arr[last] = value;
//            itemsAmount++;
//            return true;
//        }
//        return false;
//    }

//    @Override
//    public E pop() {
//        if (itemsAmount > 0) {
//            E deletedValue = arr[first];
////            System.out.println("remove left " + deletedValue.toString());
//            arr[first] = null;
//            if (first == length - 1) {
//                first = 0;
//            } else {
//                first++;
//            }
//            itemsAmount--;
//            return deletedValue;
//        }
//        return null;
//    }


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
