package com.jerry.ds.list;

/**
 * A generic List interface that defines the basic operations for a list data structure.
 * This interface allows for dynamic resizing and provides methods for adding, retrieving,
 * checking for elements, and removing elements from the list.
 *
 * @param <T> the type of elements in this list
 * 
 */

public interface List<T> extends Iterable<T> {

    /**
     * Adds the specified element to the end of the list.
     * The list will grow dynamically as elements are added.
     * @param element the element to be added to the list
     * @throws NullPointerException if the specified element is null
     */
    void add(T element);
    
    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any subsequent elements to the right.
     * @param index index at which the specified element is to be inserted
     * @param element the element to be inserted
     * @throws NullPointerException if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
     */
    void add(int index, T element);
        
    /**
     * Retrieves the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    T get(int index);

    /**
     * Checks if the list contains the specified element.
     * @param element the element to search for
     * @return true if the list contains the specified element, false otherwise
     * @throws NullPointerException if the specified element is null
     */
    boolean contains(T element);
    
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    int size();
    
    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param element the element to be removed from this list, if present
     * @return the element that was removed from the list, or null if the element was not found
     * @throws NullPointerException if the specified element is null
     */
    T remove(T element);
    
    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws NullPointerException if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    T removeAt(int index);
    
        /**
        * Removes all of the elements from this list. The list will be empty after this call returns.
        */
    void clear();
}
