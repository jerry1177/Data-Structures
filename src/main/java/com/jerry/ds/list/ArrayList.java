package com.jerry.ds.list;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* Array-backed implementation of the List interface.

Elements are stored in a dynamically resizing array.
Capacity grows by doubling when the array becomes full.

Time complexity:
append: amortized O(1)
insert: O(n)
remove: O(n) */

public class ArrayList<T> implements List<T> {
    private int size;
    private int capacity;
    private T[] elements;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.elements = (T[]) new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        this.size = 0;
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        this.capacity = initialCapacity;
        this.elements = (T[]) new Object[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements to iterate");
                }
                return elements[currentIndex++];
            }
        };
    }

    @Override
    public void add(T element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        if (size == capacity) {
            resize();
        }
        elements[size] = element;
        size++;
    }

    @Override
    public void add(int index, T element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            resize();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        T value = elements[index];
        return value;
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        Object[] newElements = new Object[capacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = (T[]) newElements;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T remove(T element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                T removedElement = elements[i];
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[size - 1] = null;
                size--;
                return removedElement;
            }
        }
        throw new NoSuchElementException("Element not found: " + element);
    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}