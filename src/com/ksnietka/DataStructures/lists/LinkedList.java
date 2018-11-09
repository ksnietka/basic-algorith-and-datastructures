package com.ksnietka.DataStructures.lists;

import java.util.Collection;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>{
    private int size;
    private Node head;

    @Override
    public E get(Integer index) {
        Node current = getNode(index);
        return (E) current.getData();
    }

    private Node getNode(Integer index) {
        Node current = head;
        for(int i = 0; i < index; i++) {
            if (current.hasNext()) {
                current = current.getNext();
            } else {
                throw new NoSuchElementException();
            }
        }
        return current;
    }

    @Override
    public void add(E element) {
        Node tempElement = new Node(element);
        Node currentElement = head;

        if (currentElement == null) {
            head = tempElement;
        }
        if (currentElement != null) {
            while(currentElement.hasNext()) {
                currentElement = currentElement.getNext();
            }
            currentElement.setNext(tempElement);
        }
        size++;
    }

    @Override
    public void delete(Integer index) {
        Node previous = this.getNode(index - 1);
        Node toDelete = previous.getNext();
        if (toDelete!= null && toDelete.hasNext())
            previous.setNext(toDelete.getNext());
        toDelete = null;
        size--;
    }

    @Override
    public Integer indexOf(E element) {
        return null;
    }

    @Override
    public Boolean contains(E element) {
        return null;
    }

    @Override
    public void addAll(Collection<E> collection) {

    }
    public Integer size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("aaa");
        stringLinkedList.add("bbb");
        stringLinkedList.add("bbb");
        stringLinkedList.add("bbb");
        stringLinkedList.add("ccc");
        System.out.println(stringLinkedList.size());
        System.out.println(stringLinkedList.get(0));
        System.out.println(stringLinkedList.get(1));
        System.out.println(stringLinkedList.get(2));
        System.out.println(stringLinkedList.get(4));
        System.out.println(stringLinkedList.size());
        stringLinkedList.delete(3);
        System.out.println(stringLinkedList.size());
        System.out.println(stringLinkedList.get(3));
        stringLinkedList.delete(4);
        System.out.println(stringLinkedList.size());
    }
}


class Node {
    private final Object data;
    private Node next;

    public Node(Object e) {
        data = e;
    }

    public Boolean hasNext() {
        return next != null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextOb) {
        next = nextOb;
    }

    public Object getData() {
        return data;
    }

}