# Datastructures Design

## Global Rules

These rules apply to all collections in this library unless otherwise specified.

### Null Handling
- Null elements are not allowed.
- Passing null to insertion or query methods throws `NullPointerException`.

### Duplicates
- Duplicate elements are allowed unless otherwise specified.

### Thread Safety
- Collections are not thread-safe.

### Iteration
- Iteration order is deterministic when applicable.
- Collections that support iteration follow their documented traversal order.

### Indexing
- Indexed collections use zero-based indexing.

## Exceptions

### IndexOutOfBoundsException
- Thrown when an index is outside the allowed range.

### NullPointerException
- Thrown when a null element is provided to a method that does not permit nulls.

### NoSuchElementException
- Thrown when attempting to access, remove, or peek at an element that does not exist in an empty structure.

---

# List

A `List` maintains positional order and supports zero-based index access.

The list preserves element order based on insertion and modification operations.  
It does not automatically sort elements.

## Characteristics

- preserves positional order
- zero-based indexing
- duplicates allowed
- null elements not allowed
- iteration order follows index order
- supports Java `Iterable<T>`

## Iteration

- `List` implements Java's `Iterable<T>` contract.
- Iteration order follows index order from `0` to `size - 1`.

## Operation Rules

### add(T element)
- Adds the specified element to the end of the list.
- Throws `NullPointerException` if `element` is null.

### add(int index, T element)
- Inserts the specified element at the specified position in the list.
- Shifts the element currently at that position, if any, and all subsequent elements to the right.
- Valid index range: `0..size` inclusive.
- Allows insertion at the front or end of the list.
- Throws `NullPointerException` if `element` is null.
- Throws `IndexOutOfBoundsException` if `index < 0 || index > size()`.

### get(int index)
- Returns the element at the specified position in the list.
- Valid index range: `0..size - 1`.
- Throws `IndexOutOfBoundsException` if `index < 0 || index >= size()`.

### contains(T element)
- Returns `true` if the list contains the specified element, otherwise `false`.
- Throws `NullPointerException` if `element` is null.

### size()
- Returns the number of elements currently in the list.

### isEmpty()
- Returns `true` if the list contains no elements, otherwise `false`.

### remove(T element)
- Removes the first occurrence of the specified element from the list, if it is present.
- Shifts any subsequent elements to the left.
- Returns the removed element if it was found and removed.
- Returns `null` if the element was not found.
- Throws `NullPointerException` if `element` is null.

### removeAt(int index)
- Removes the element at the specified position in the list.
- Shifts any subsequent elements to the left.
- Returns the removed element.
- Valid index range: `0..size - 1`.
- Throws `IndexOutOfBoundsException` if `index < 0 || index >= size()`.

### clear()
- Removes all elements from the list.
- After this operation, `size()` must return `0` and `isEmpty()` must return `true`.

## Notes

- `List` is ordered, but not sorted.
- Ordering is based on insertion and modification behavior, not element value.
- Implementations may differ internally, but all must follow this contract.