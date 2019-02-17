package com.ksnietka.DataStructures.map;

import com.ksnietka.DataStructures.lists.LinkedList;

public class HashMap <T> {
    class Node {
        private String getKey() {
            return key;
        }

        private T getValue() {
            return value;
        }

        private Node(String key, T value) {
            this.key = key;
            this.value = value;
        }

        private String key;
        private T value;
    }

    private Integer M;
    private final Integer R = 1;
    private LinkedList<Node>[] hashTable;

    @SuppressWarnings({"unchecked"})
    HashMap(int size) {
        M = size;
        hashTable = (LinkedList<Node>[]) new LinkedList[size];
        for (int i = 0; i < hashTable.length; i++)
            hashTable[i] = new LinkedList<>();
    }

    public void put(String key, T value) {
        final LinkedList<Node> nodeLinkedList = getList(key);
        nodeLinkedList.add(new Node(key, value));
    }

    private LinkedList<Node> getList(String key) {
        final int hash = hashFunction(key);
        return hashTable[hash];
    }

    public T get(String key) {
        final LinkedList<Node> list = getList(key);
        for (int i = 0; i < list.size(); i++) {
            final Node node = list.get(i);
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    private int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (R * hash + key.charAt(i)) %M;
        }
        return hash;
    }
}
