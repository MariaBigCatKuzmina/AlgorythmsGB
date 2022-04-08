package ru.kuzmina.lesson3;

public class TestQueue {

    public static QueueImpl<Integer> queue = new QueueImpl<>(5);

    public static void main(String[] args) {
        queue.push(11);
        queue.push(2);
        queue.push(1);
        queue.push(21);
        queue.push(22);
        System.out.println(queue.toString());

        queue.pop();
        queue.pop();
        System.out.println(queue.toString());

        queue.push(13);
        System.out.println(queue.toString());

    }
}
