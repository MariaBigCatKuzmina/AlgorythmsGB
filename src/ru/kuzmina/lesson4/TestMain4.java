package ru.kuzmina.lesson4;

public class TestMain4 {

    public static void main(String[] args) {
        testHomeWork();
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


}
