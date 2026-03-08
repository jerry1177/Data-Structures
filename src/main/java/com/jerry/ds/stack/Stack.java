package com.jerry.ds.stack;

/**
 * Represents a last-in, first-out (LIFO) stack of elements.
 *
 * <p>
 * Elements are added and removed from the top of the stack.
 * The most recently pushed element is the first element to be removed.
 * </p>
 *
 * <p>
 * Characteristics:
 * <ul>
 *   <li>LIFO (last-in, first-out) behavior</li>
 *   <li>Duplicates are allowed</li>
 *   <li>Null elements are not permitted</li>
 *   <li>Iteration follows stack order from top to bottom</li>
 * </ul>
 * </p>
 *
 * @param <T> the type of elements stored in this stack
 */
public interface Stack<T> extends Iterable<T> {

    /**
     * Pushes the specified element onto the top of the stack.
     *
     * @param element the element to push onto the stack
     * @throws NullPointerException if the specified element is null
     */
    void push(T element);

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the element removed from the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    T pop();

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return the element currently at the top of the stack
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    T peek();

    /**
     * Returns the number of elements currently stored in the stack.
     *
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Returns {@code true} if the stack contains no elements.
     *
     * @return {@code true} if the stack is empty, otherwise {@code false}
     */
    boolean isEmpty();

    /**
     * Removes all elements from the stack.
     * After this operation, the stack will be empty.
     */
    void clear();
}