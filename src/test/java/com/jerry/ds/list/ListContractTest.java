package com.jerry.ds.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class ListContractTest {
    protected List<Integer> list;

    protected abstract List<Integer> createList();

    protected List<Integer> createPopulatedList(){
            List<Integer> newList = createList();
            for (int i = 1; i <= 10; i++) {
                newList.add(i);
            }
            return newList;
    }

    @BeforeEach
    void setup() {
        list = createPopulatedList();
    }

    @Test
    void newListShouldBeEmpty() {
        list = createList();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void addElementShouldIncreaseSize() {
        list = createList();

        list.add(1);
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());

        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void addNullElementShouldThrowException() {
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    void getElementShouldReturnCorrectValue() {
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void getShouldThrowExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
    }

    @Test
    void containsShouldReturnTrueForExistingElement() {
        assertTrue(list.contains(1));
        assertTrue(list.contains(5));
        assertTrue(list.contains(10));
    }

    @Test
    void containsShouldReturnFalseForNonExistingElement() {
        assertFalse(list.contains(0));
        assertFalse(list.contains(11));
        assertFalse(list.contains(-1));
    }

    @Test
    void containsShouldThrowExceptionForNullElement() {
        assertThrows(NullPointerException.class, () -> list.contains(null));
    }

    @Test
    void addAtIndexShouldInsertElementAtCorrectPosition() {
        list.add(0, 0);
        assertEquals(0, list.get(0));

        list.add(5, 99);
        assertEquals(99, list.get(5));

        list.add(list.size(), 100);
        assertEquals(100, list.get(list.size() - 1));
    }

    @Test
    void addAtIndexShouldShiftElements() {
        list.add(0, 0);
        assertEquals(1, list.get(1));

        list.add(5, 99);
        assertEquals(5, list.get(6));

        list.add(list.size(), 100);
        assertEquals(10, list.get(list.size() - 2));
    }

    @Test
    void addAtIndexShouldThrowExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 99));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(list.size() + 1, 99));
    }

    @Test
    void addAtIndexShouldThrowExceptionForNullElement() {
        assertThrows(NullPointerException.class, () -> list.add(0, null));
        assertThrows(NullPointerException.class, () -> list.add(5, null));
        assertThrows(NullPointerException.class, () -> list.add(list.size(), null));
    }

    @Test
    void removeElementShouldReturnElementAndShift() {
        Integer removed = list.remove(5);

        assertEquals(5, removed);
        assertEquals(9, list.size());
        assertEquals(6, list.get(4));
    }

    @Test
    void removeElementNotFoundShouldThrow() {
        assertThrows(java.util.NoSuchElementException.class, () -> list.remove(999));
    }

    @Test
    void removeNullShouldThrow() {
        assertThrows(NullPointerException.class, () -> list.remove(null));
    }

    @Test
    void removeAtShouldReturnElementAndShift() {
        Integer first = list.removeAt(0);
        assertEquals(1, first);
        assertEquals(9, list.size());
        assertEquals(2, list.get(0));

        Integer last = list.removeAt(list.size() - 1);
        assertEquals(10, last);
        assertEquals(8, list.size());
    }

    @Test
    void removeShouldMakeContainsReturnFalseWhenElementNoLongerExists() {
        list = createPopulatedList();

        Integer removed = list.remove(5);

        assertEquals(5, removed);
        assertFalse(list.contains(5));
    }

    @Test
    void removeByValueShouldPreserveRemainingOrder() {
        list.remove(5);

        int[] expected = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], list.get(i));
        }
    }

    @Test
    void removeAtShouldThrowForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(list.size()));
    }

    @Test
    void clearShouldEmptyList() {
        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void clearOnAlreadyEmptyListShouldStillWork() {
        list.clear();
        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void iteratorShouldTraverseAndThrowWhenExhausted() {
        java.util.Iterator<Integer> it = list.iterator();
        int expected = 1;

        while (it.hasNext()) {
            Integer val = it.next();
            assertEquals(expected++, val);
        }

        assertFalse(it.hasNext());
        assertThrows(java.util.NoSuchElementException.class, () -> it.next());
    }
    @Test
    void multipleIteratorsShouldTraverseIndependently() {
        java.util.Iterator<Integer> it1 = list.iterator();
        java.util.Iterator<Integer> it2 = list.iterator();

        assertEquals(1, it1.next());
        assertEquals(1, it2.next());
        assertEquals(2, it1.next());
        assertEquals(2, it2.next());
    }

    @Test
    void emptyListContainsShouldReturnFalse() {
        list = createList();
        assertFalse(list.contains(1));
    }

    @Test
    void removeFromEmptyListShouldThrow() {
        list = createList();
        assertThrows(java.util.NoSuchElementException.class, () -> list.remove(1));
    }

    @Test
    void removeAtFromEmptyListShouldThrow() {
        list = createList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0));
    }

    @Test
    void iteratorOnEmptyListShouldHaveNoNext() {
        list = createList();
        java.util.Iterator<Integer> it = list.iterator();

        assertFalse(it.hasNext());
        assertThrows(java.util.NoSuchElementException.class, () -> it.next());
    }

    @Test
    void singleElementListShouldBehaveCorrectly() {
        list = createList();
        list.add(42);

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(42, list.get(0));

        Integer removed = list.removeAt(0);
        assertEquals(42, removed);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void removeOnlyElementByValueShouldLeaveListEmpty() {
        list = createList();
        list.add(99);

        Integer removed = list.remove(99);
        assertEquals(99, removed);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void clearShouldAllowReuse() {
        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(100);
        list.add(200);

        assertEquals(2, list.size());
        assertEquals(100, list.get(0));
        assertEquals(200, list.get(1));
    }

    @Test
    void addAtZeroOnEmptyListShouldWork() {
        list = createList();
        list.add(0, 123);

        assertEquals(1, list.size());
        assertEquals(123, list.get(0));
    }

    @Test
    void addAtSizeOnEmptyListShouldWork() {
        list = createList();
        list.add(list.size(), 456);

        assertEquals(1, list.size());
        assertEquals(456, list.get(0));
    }

    @Test
    void removeFirstElementShouldShiftAllRemainingElements() {
        Integer removed = list.removeAt(0);

        assertEquals(1, removed);
        assertEquals(9, list.size());

        for (int i = 0; i < list.size(); i++) {
            assertEquals(i + 2, list.get(i));
        }
    }

    @Test
    void removeLastElementShouldNotAffectEarlierElements() {
        Integer removed = list.removeAt(list.size() - 1);

        assertEquals(10, removed);
        assertEquals(9, list.size());

        for (int i = 0; i < list.size(); i++) {
            assertEquals(i + 1, list.get(i));
        }
    }

    @Test
    void removeShouldOnlyRemoveFirstOccurrenceWhenMultipleDuplicatesExist() {
        list = createList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);

        Integer removed = list.remove(2);

        assertEquals(2, removed);
        assertEquals(4, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.get(3));
    }
}
