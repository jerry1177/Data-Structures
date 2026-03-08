package com.jerry.ds.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ArrayListTest extends ListContractTest {

    @Override
    protected List<Integer> createList() {
        return new ArrayList<>();
    }
    @Test
    void constructorWithInvalidCapacityShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayList<Integer>(0));
        assertThrows(IllegalArgumentException.class, () -> new ArrayList<Integer>(-5));
    }

    @Test
    void customInitialCapacityOfOneShouldResizeCorrectly() {
        list = createList();

        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void largeResizePreservesOrder() {
        list = createList();

        for (int i = 0; i < 200; i++) {
            list.add(i);
        }

        assertEquals(200, list.size());
        for (int i = 0; i < 200; i++) {
            assertEquals(i, list.get(i));
        }
    }

}
