package ru.kuzmina.lesson4;

public class TestDeque {
    public static void main(String[] args) {
        DequeImpl<Integer> deque = new DequeImpl<>(5);

        deque.insertLeft(1);
        System.out.println(deque);
        deque.insertLeft(2);
        System.out.println(deque);

        deque.insertRight(3);
        System.out.println(deque);
        deque.insertRight(4);
        System.out.println(deque);

        deque.insertLeft(5);
        System.out.println(deque);

        deque.insertLeft(6);
        System.out.println(deque);

        deque.removeLeft();
        System.out.println(deque);
    }
}
