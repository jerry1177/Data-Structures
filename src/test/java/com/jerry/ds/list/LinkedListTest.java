package com.jerry.ds.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LinkedListTest extends ListContractTest {

    @Override
    protected List<Integer> createList() {
        return new LinkedList<>();
    }

    @Test
    void addFirstElementShouldSetHeadAndTailCorrectly() {
        list = createList();
        list.add(42);

        assertEquals(1, list.size());
        assertEquals(42, list.get(0));
    }

    @Test
    void removingOnlyElementShouldLeaveListEmpty() {
        list = createList();
        list.add(42);

        assertEquals(42, list.removeAt(0));
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(99);
        assertEquals(99, list.get(0));
    }

    @Test
    void removeFirstShouldKeepRemainingOrder() {
        list = createList();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.removeAt(0));
        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
    }
    @Test
    void removeLastShouldKeepRemainingOrder() {
        list = createList();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.removeAt(2));
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    void clearThenAddShouldStillWork() {
        list = createList();
        list.add(1);
        list.add(2);
        list.clear();
    
        assertTrue(list.isEmpty());
    
        list.add(3);
        assertEquals(1, list.size());
        assertEquals(3, list.get(0));
    }
    @Test
    void removingMiddleShouldRelinkNodesCorrectly() {
        list = createList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    
        assertEquals(2, list.remove(2));
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
    }
}
