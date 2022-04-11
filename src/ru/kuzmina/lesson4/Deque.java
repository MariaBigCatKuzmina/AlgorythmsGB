package ru.kuzmina.lesson4;

import ru.kuzmina.lesson3.Queue;

public interface Deque<E> extends Queue<E> {
    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();

}
