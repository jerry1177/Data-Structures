# Datastructures Design

## Global Rules

These rules apply to all collections in this library unless otherwise specified.

Null Handling
- Null elements are not allowed.
- Passing null to insertion or query methods throws NullPointerException.

Duplicates
- Duplicate elements are allowed unless otherwise specified.

Thread Safety
- Collections are not thread-safe.

Iteration
- Iteration order is deterministic when applicable.
- Collections that support iteration follow their documented traversal order.

Indexing
- Indexed collections use zero-based indexing.

## Exceptions

IndexOutOfBoundsException
- Thrown when an index is outside the allowed range.

NullPointerException
- Thrown when a null element is provided to a method that does not permit nulls.

NoSuchElementException
- Thrown when attempting to access or remove an element that does not exist.

IllegalArgumentException
- Thrown when an invalid argument is passed to a method.

--------------------------------------------------

# List

A List maintains positional order and supports zero-based index access.

The list preserves element order based on insertion and modification operations.
It does not automatically sort elements.

Characteristics

- preserves positional order
- zero-based indexing
- duplicates allowed
- null elements not allowed
- iteration order follows index order
- supports Java Iterable<T>

--------------------------------------------------

Iteration

List implements Java's Iterable<T> contract.

Iteration order follows index order from:

0 → size - 1

Calling next() when no elements remain must throw NoSuchElementException.

--------------------------------------------------

Operation Rules

add(T element)

Adds the specified element to the end of the list.

Throws:
- NullPointerException if element is null.

--------------------------------------------------

add(int index, T element)

Inserts the specified element at the specified position in the list.

All subsequent elements are shifted one position to the right.

Valid index range:
0..size (inclusive)

Throws:
- NullPointerException if element is null
- IndexOutOfBoundsException if index < 0 or index > size

--------------------------------------------------

get(int index)

Returns the element at the specified position.

Valid index range:
0..size-1

Throws:
- IndexOutOfBoundsException if index < 0 or index >= size

--------------------------------------------------

contains(T element)

Returns true if the list contains the specified element.

Throws:
- NullPointerException if element is null.

--------------------------------------------------

size()

Returns the number of elements currently in the list.

--------------------------------------------------

isEmpty()

Returns true if the list contains no elements.

--------------------------------------------------

remove(T element)

Removes the first occurrence of the specified element.

All subsequent elements are shifted one position to the left.

Returns:
- the removed element

Throws:
- NullPointerException if element is null
- NoSuchElementException if the element is not present

--------------------------------------------------

removeAt(int index)

Removes the element at the specified position.

All subsequent elements are shifted one position to the left.

Returns:
- the removed element

Valid index range:
0..size-1

Throws:
- IndexOutOfBoundsException if index < 0 or index >= size

--------------------------------------------------

clear()

Removes all elements from the list.

After calling clear():

size() == 0
isEmpty() == true

--------------------------------------------------

# ArrayList Implementation Notes

ArrayList is an array-backed implementation of List.

Internal Structure

The structure maintains:

- a backing array
- current size
- current capacity

--------------------------------------------------

Resizing Strategy

When the backing array becomes full:

capacity = capacity * 2

A new array is allocated and existing elements are copied into it.

--------------------------------------------------

Initial Capacity

Default capacity: 10

Custom capacity must be greater than 0.

Throws:
- IllegalArgumentException if initial capacity <= 0

--------------------------------------------------

# Summary

All List implementations must follow the behavior defined in this document regardless of their internal structure.

Implementations may differ internally but must preserve:

- ordering
- index semantics
- exception behavior
- iteration behavior