# datastructures

A Java data structures library implemented from scratch.

This project focuses on clean API design, multiple implementations of core data structures, and comprehensive testing using **JUnit 5**. The goal is to build a small, well-structured collections library that mirrors professional library design while implementing the underlying data structures manually.

Package namespace:

com.jerry.ds

---

## Project Status

This project is currently under active development.

Milestone 1 is focused on building the core linear collections and establishing the testing and architecture foundations for the library.

---

## Goals

- Implement core data structures manually (not wrappers around `java.util`)
- Provide interchangeable implementations through common interfaces
- Maintain a clean, consistent, and professional API design
- Use contract-based testing to validate implementations
- Publish the library as a reusable Maven artifact

---

## Design Documentation

Architecture decisions and behavioral contracts are documented here:

docs/design.md

This document defines the rules all implementations must follow, including:

- null handling
- exception behavior
- indexing rules
- iteration behavior
- collection semantics

---

## Milestone Roadmap

### Milestone 1 – Core Linear Collections

Interfaces

- List
- Stack
- Queue
- Deque

Implementations

- ArrayList
- LinkedList
- ArrayStack
- LinkedStack
- ArrayQueue
- LinkedQueue
- ArrayDeque
- LinkedDeque

---

### Milestone 2 – Hash-Based Collections

- Map
- Set
- HashMap
- HashSet

---

### Milestone 3 – Tree Structures

- Binary Search Tree
- Heap
- Priority Queue

---

### Milestone 4 – Advanced Structures

- Graph
- Trie

---

## Testing

All data structures are tested using **JUnit 5**.

Testing strategy includes:

- contract tests (shared behavior tests for interfaces)
- implementation-specific tests
- invariant verification
- edge-case validation

---

## Building the Project

This project uses **Maven** and requires **Java 25**.

Build the project with:

mvn clean install

This will:

- compile the project
- run tests
- package the library
- install the artifact in your local Maven repository

---

## Example Dependency (future)

<dependency> 
    <groupId>com.jerry</groupId> 
    <artifactId>datastructures<artifactId>
    <version>0.1.0</version> 
</dependency>