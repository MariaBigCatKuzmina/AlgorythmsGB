package ru.kuzmina.lesson6;

public class Node<T extends Comparable<T>> {
    private T value;

    private Node<T> leftChild;
    private Node<T> rightChild;
    Boolean isRepeat;

    int repeatCount;
    int nodeLevel;

    public Node(T value, int nodeLevel) {
        this.value = value;
        this.nodeLevel = nodeLevel;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }


    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }


    public boolean isLeftChild(T value) {
        return getValue().compareTo(value) > 0;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }

    public boolean hasOnlyOneChild() {
        return rightChild != null ^ leftChild != null;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }
}

