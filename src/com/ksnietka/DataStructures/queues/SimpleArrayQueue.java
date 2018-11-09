package com.ksnietka.DataStructures.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleArrayQueue<E>
    implements Queue<E> {
    private static Long DEFAULT_MAX_SIZE = 10L;
    private Long maxSize;
    private List<E> data = new ArrayList<>();

    private SimpleArrayQueue(Long size) {
        this.maxSize = size;
    }


    @Override
    public synchronized void enqueue(E t) {
        if (this.data.size() >= maxSize)
            throw new StackOverflowError();
        data.add(t);
    }

    @Override
    public synchronized  E dequeue() {
        try {
            return data.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public synchronized E peek() {
        try {
            return data.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    static <E> Queue<E> create() {
        return new SimpleArrayQueue<>(DEFAULT_MAX_SIZE);
    }

    static <E>Queue<E> create(Long neededSize) {
        return new SimpleArrayQueue<>(neededSize);
    }

    @Override
    public E take() throws InterruptedException {
        try {
            return data.get(0);
        } catch (IndexOutOfBoundsException e) {
            return take();
        }
    }

    public static void main(String[] args) throws InterruptedException, Exception {
        ArrayList<String> strings = new ArrayList<>();
        Queue<String> queue = SimpleArrayQueue.create(5L);
        queue.enqueue("add");
        queue.enqueue("bbb");
        queue.enqueue("aaaas");

        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                queue.enqueue("after");
                queue.enqueue("aaaaa");
                queue.enqueue("aaaaa");
                queue.enqueue("aaaaa");
                queue.enqueue("aaaaa");
                queue.enqueue("aaaaa");
                queue.enqueue("aaaaa");
            } catch(Exception e) {

            }
        });
        thread.run();

        System.out.print(queue.take());


    }
}
