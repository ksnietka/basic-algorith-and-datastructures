package com.ksnietka.DataStructures.queues;

public interface Queue<E> {
    void enqueue(E t);
    E dequeue();
    E peek();
    E take() throws InterruptedException;
}
