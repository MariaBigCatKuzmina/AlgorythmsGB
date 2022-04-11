package ru.kuzmina.lesson4;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TestMain4 {

    public static void main(String[] args) {
//        testLinkedList();
        testHomeWork();
//        testIterator();
    }

    private static void testLinkedList() {

        var linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
//
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);
//
        linkedList.display();
//
        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));
//
        System.out.println("remove first: " + linkedList.removeFirst());
        linkedList.remove(4);
        linkedList.remove(11);
//
        linkedList.display();

    }

    private static void testHomeWork() {

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insert(16,6);
        linkedList.insert(11,1);
        linkedList.insert(14,4);
        //ДОЛЖНО РАБОТАТЬ!
        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }
    }


    private static void testIterator() {
        List<Integer> linkedList = new java.util.LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (Integer integer : linkedList) {
            System.out.println(integer);
        }

        ListIterator<Integer> iterator = linkedList.listIterator();
        //first:reset
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer + " до него " + iterator.previous());
            iterator.next();
            if (!iterator.hasNext()) {
                break;
            }
        }
    }
}
