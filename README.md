# datastructures

A Java data structures library implemented from scratch.

This project focuses on clean API design, multiple implementations of core data structures, and comprehensive testing using JUnit 5.

Package namespace:

com.jerry.ds

---

## Goals

- Implement core data structures manually
- Provide interchangeable implementations
- Maintain professional API design
- Use contract-based testing
- Publish as a reusable Maven artifact

---
## Design Documentation

See docs/design.md for architecture decisions and behavioral contracts.

---

## Milestone Roadmap

### Milestone 1

Core linear collections

- List
- Stack
- Queue
- Deque

Implementations planned:

- ArrayList
- LinkedList
- ArrayStack
- LinkedStack
- ArrayQueue
- LinkedQueue
- ArrayDeque
- LinkedDeque

---

### Milestone 2

Hash-based collections

- Map
- Set
- HashMap
- HashSet

---

### Milestone 3

Tree structures

- Binary Search Tree
- Heap
- Priority Queue

---

### Milestone 4

Advanced structures

- Graph
- Trie

---

## Testing

All data structures are tested using **JUnit 5**.

Testing strategy includes:

- contract tests
- implementation-specific tests
- invariant verification

---

## Example Dependency (future)

```xml
<dependency>
    <groupId>com.jerry</groupId>
    <artifactId>datastructures</artifactId>
    <version>0.1.0</version>
</dependency>