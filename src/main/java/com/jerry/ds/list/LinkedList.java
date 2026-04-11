package com.jerry.ds.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
/*
Linked-node implementation of the List interface.

Elements are stored as nodes linked together in sequence.

Time complexity:
append: O(1) if tail maintained
insert: O(n)
remove: O(n)
*/

public class LinkedList<T> implements List<T> {
    public class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) {
                    throw new java.util.NoSuchElementException();
                }
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // attach new node to the end of the list
            tail = newNode; // update tail reference to the new last node
        }
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (element == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = head; // new node points to current head
            head = newNode; // update head reference to the new node
            if (size == 0) {
                tail = newNode; // if list was empty, tail also points to the new node
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // traverse to the node before the insertion point
            }
            newNode.next = current.next; // new node points to the next node in the list
            current.next = newNode; // previous node points to the new node
            if (newNode.next == null) {
                tail = newNode; // if inserted at the end, update tail reference
            }
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // traverse to the desired index
        }
        return current.value; // return the value at the index
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(element)) {
                return true; // element found in the list
            }
            current = current.next; // move to the next node
        }
        return false; // element not found in the list
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T remove(T element) {
        if (element == null) {
            throw new NullPointerException("Null elements are not allowed");
        }
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (current.value.equals(element)) {
                if (previous == null) {
                    head = current.next; // remove the first node
                } else {
                    previous.next = current.next; // bypass the node to be removed
                }
                if (current == tail) {
                    tail = previous; // update tail if removing the last node
                }
                size--;
                return current.value; // return the removed value
            }
            previous = current;
            current = current.next;
        }
        throw new NoSuchElementException("Element not found in the list");
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        Node<T> previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }
        if (current == tail) {
            tail = previous;
        }
        size--;
        return current.value;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

}
