# Datastructures Design

## Global Rules

These rules apply to all collections in this library unless otherwise
specified.

### Null Handling

-   Null elements are not allowed.
-   Passing null to insertion or query methods throws
    `NullPointerException`.

### Duplicates

-   Duplicate elements are allowed unless otherwise specified.

### Thread Safety

-   Collections are **not thread-safe**.

### Iteration

-   Iteration order is deterministic when applicable.
-   Collections that support iteration follow their documented traversal
    order.

### Indexing

-   Indexed collections use **zero-based indexing**.

------------------------------------------------------------------------

## Exceptions

### IndexOutOfBoundsException

Thrown when an index is outside the allowed range.

### NullPointerException

Thrown when a null element is provided to a method that does not permit
nulls.

### NoSuchElementException

Thrown when attempting to access or remove an element that does not
exist.

### IllegalArgumentException

Thrown when an invalid argument is passed to a method.

------------------------------------------------------------------------

# List

A `List` maintains **positional order** and supports **zero-based index
access**.

The list preserves element order based on insertion and modification
operations. It **does not automatically sort elements**.

## Characteristics

-   preserves positional order
-   zero-based indexing
-   duplicates allowed
-   null elements not allowed
-   iteration order follows index order
-   supports Java `Iterable<T>`

------------------------------------------------------------------------

## List Iteration

`List` implements Java's `Iterable<T>` contract.

Iteration order follows index order from:

0 → size - 1

Calling `next()` when no elements remain must throw
`NoSuchElementException`.

------------------------------------------------------------------------

## Operation Rules

### add(T element)

Adds the specified element to the **end of the list**.

Throws: - `NullPointerException` if element is null

------------------------------------------------------------------------

### add(int index, T element)

Inserts the specified element at the specified position in the list.

All subsequent elements are shifted **one position to the right**.

Valid index range: 0..size (inclusive)

Throws: - `NullPointerException` if element is null -
`IndexOutOfBoundsException` if index \< 0 or index \> size

------------------------------------------------------------------------

### get(int index)

Returns the element at the specified position.

Valid index range: 0..size-1

Throws: - `IndexOutOfBoundsException` if index \< 0 or index \>= size

------------------------------------------------------------------------

### contains(T element)

Returns `true` if the list contains the specified element.

Throws: - `NullPointerException` if element is null

------------------------------------------------------------------------

### size()

Returns the number of elements currently in the list.

------------------------------------------------------------------------

### isEmpty()

Returns `true` if the list contains no elements.

------------------------------------------------------------------------

### remove(T element)

Removes the **first occurrence** of the specified element.

All subsequent elements are shifted **one position to the left**.

Returns: - the removed element

Throws: - `NullPointerException` if element is null -
`NoSuchElementException` if the element is not present

------------------------------------------------------------------------

### removeAt(int index)

Removes the element at the specified position.

All subsequent elements are shifted **one position to the left**.

Returns: - the removed element

Valid index range: 0..size-1

Throws: - `IndexOutOfBoundsException` if index \< 0 or index \>= size

------------------------------------------------------------------------

### clear()

Removes all elements from the list.

After calling `clear()`: size() == 0 isEmpty() == true

------------------------------------------------------------------------

## List Complexity Expectations

  Operation       ArrayList        LinkedList
  --------------- ---------------- ------------
  get(index)      O(1)             O(n)
  add(element)    amortized O(1)   O(1)
  add(index)      O(n)             O(n)
  remove(index)   O(n)             O(n)
  contains        O(n)             O(n)

------------------------------------------------------------------------

# ArrayList Implementation Notes

`ArrayList` is an **array-backed implementation** of `List`.

## Internal Structure

The structure maintains: - a backing array - current size - current
capacity

------------------------------------------------------------------------

## Resizing Strategy

When the backing array becomes full: capacity = capacity \* 2

A new array is allocated and existing elements are copied into it.

------------------------------------------------------------------------

## Initial Capacity

Default capacity: 10

Custom capacity must be **greater than 0**.

Throws: - `IllegalArgumentException` if initial capacity \<= 0

------------------------------------------------------------------------

# Stack

A `Stack` is a **last-in, first-out (LIFO)** collection.

Elements are added and removed from the **top** of the stack.

## Characteristics

-   LIFO behavior
-   duplicates allowed
-   null elements not allowed
-   supports Java `Iterable<T>`
-   iteration order follows **top → bottom**

------------------------------------------------------------------------

## Stack Iteration

`Stack` implements Java's `Iterable<T>` contract.

Iteration order follows stack order from:

top → bottom

Calling `next()` when no elements remain must throw
`NoSuchElementException`.

------------------------------------------------------------------------

## Stack Operation Rules

### push(T element)

Adds the specified element to the **top of the stack**.

Throws: - `NullPointerException` if element is null

------------------------------------------------------------------------

### pop()

Removes and returns the **top element**.

Throws: - `NoSuchElementException` if the stack is empty

------------------------------------------------------------------------

### peek()

Returns the **top element without removing it**.

Throws: - `NoSuchElementException` if the stack is empty

------------------------------------------------------------------------

### size()

Returns the number of elements in the stack.

------------------------------------------------------------------------

### isEmpty()

Returns `true` if the stack contains no elements.

------------------------------------------------------------------------

### clear()

Removes all elements from the stack.

After calling `clear()`: size() == 0 isEmpty() == true

------------------------------------------------------------------------

## Stack Complexity Expectations

  Operation   ArrayStack       LinkedStack
  ----------- ---------------- -------------
  push        amortized O(1)   O(1)
  pop         O(1)             O(1)
  peek        O(1)             O(1)

------------------------------------------------------------------------

# Summary

All collection implementations must follow the behavioral rules defined
in this document regardless of their internal structure.

Implementations may differ internally but must preserve:

-   ordering semantics
-   index rules
-   exception behavior
-   iteration behavior
-   contract guarantees
