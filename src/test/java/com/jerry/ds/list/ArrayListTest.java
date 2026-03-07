package com.jerry.ds.list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    private List<Integer> list;

    @BeforeEach
    public void setup() {
        list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
    
    @Test
    public void newListShouldBeEmpty() {
        list = new ArrayList<>();
        assertTrue(list.isEmpty());
        assertTrue(list.size() == 0);
    }

    @Test
    public void addElementShouldIncreaseSize() {
        list = new ArrayList<>();
        list.add(1);
        assertTrue(list.size() == 1);
        assertFalse(list.isEmpty());
        list.add(2);
        list.add(3);
        assertTrue(list.size() == 3);
        assertFalse(list.isEmpty());
    }
    @Test
    public void addNullElementShouldThrowException() {
        assertThrows(NullPointerException.class, () -> list.add(null));
    }

    @Test
    public void getElementShouldReturnCorrectValue() {
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i) == i + 1);
        }
    }

    @Test
    public void getShouldThrowExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(list.size()));
    }

    @Test
    public void containsShouldReturnTrueForExistingElement() {
        assertTrue(list.contains(1));
        assertTrue(list.contains(5));
        assertTrue(list.contains(10));
    }
    @Test
    public void containsShouldReturnFalseForNonExistingElement() {
        assertFalse(list.contains(0));
        assertFalse(list.contains(11));
        assertFalse(list.contains(-1));
    }
    @Test
    public void containsShouldThrowExceptionForNullElement() {
        assertThrows(NullPointerException.class, () -> list.contains(null));
    }

    @Test
    public void addAtIndexShouldInsertElementAtCorrectPosition() {
        list.add(0, 0); // Insert at the beginning
        assertTrue(list.get(0) == 0);
        list.add(5, 99); // Insert in the middle
        assertTrue(list.get(5) == 99);
        list.add(list.size(), 100); // Insert at the end
        assertTrue(list.get(list.size() - 1) == 100);
    }

    @Test
    public void addAtIndexShouldShiftElements() {
        list.add(0, 0); // Insert at the beginning
        assertTrue(list.get(1) == 1); // Original first element should now be at index 1
        list.add(5, 99); // Insert in the middle
        assertTrue(list.get(6) == 5); // Original element at index 5 should now be at index 6
        list.add(list.size(), 100); // Insert at the end
        assertTrue(list.get(list.size() - 2) == 10); // Original last element should now be second to last
    }
    @Test
    public void addAtIndexShouldThrowExceptionForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 99));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(list.size() + 1, 99));
    }

    @Test
    public void addAtIndexShouldThrowExceptionForNullElement() {
        assertThrows(NullPointerException.class, () -> list.add(0, null));
        assertThrows(NullPointerException.class, () -> list.add(5, null));
        assertThrows(NullPointerException.class, () -> list.add(list.size(), null));
    }

    @Test
    public void listShouldResizeDynamically() {
        for (int i = 11; i <= 20; i++) {
            list.add(i);
        }
        assertTrue(list.size() == 20);
        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i) == i + 1);
        }
    }

    @Test
    public void removeElementShouldReturnElementAndShift() {
        Integer removed = list.remove(5);
        assertEquals(5, removed);
        assertEquals(9, list.size());
        assertEquals(6, list.get(4)); // element after removed should shift into its place
    }

    @Test
    public void removeElementNotFoundShouldThrow() {
        assertThrows(java.util.NoSuchElementException.class, () -> list.remove(999));
    }

    @Test
    public void removeNullShouldThrow() {
        assertThrows(NullPointerException.class, () -> list.remove(null));
    }

    @Test
    public void removeAtShouldReturnElementAndShift() {
        Integer first = list.removeAt(0);
        assertEquals(1, first);
        assertEquals(9, list.size());
        assertEquals(2, list.get(0));

        Integer last = list.removeAt(list.size() - 1);
        assertEquals(10, last);
        assertEquals(8, list.size());
    }

    @Test
    public void removeAtShouldThrowForInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(list.size()));
    }

    @Test
    public void clearShouldEmptyList() {
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void iteratorShouldTraverseAndThrowWhenExhausted() {
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
    public void constructorWithInvalidCapacityShouldThrow() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayList<Integer>(0));
        assertThrows(IllegalArgumentException.class, () -> new ArrayList<Integer>(-5));
    }

    @Test
    public void duplicatesShouldBeAllowedAndRemoveRemovesFirstOccurrence() {
        list.add(5);
        assertEquals(11, list.size());
        assertTrue(list.contains(5));
        Integer removed = list.remove(5);
        assertEquals(5, removed);
        // one 5 should still remain (we added a duplicate)
        assertTrue(list.contains(5));
        assertEquals(6, list.get(4));
        assertEquals(5, list.get(9));
    }

    @Test
    public void largeResizePreservesOrder() {
        list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            list.add(i);
        }
        assertEquals(200, list.size());
        for (int i = 0; i < 200; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
public void emptyListContainsShouldReturnFalse() {
    list = new ArrayList<>();
    assertFalse(list.contains(1));
}

@Test
public void removeFromEmptyListShouldThrow() {
    list = new ArrayList<>();
    assertThrows(java.util.NoSuchElementException.class, () -> list.remove(1));
}

@Test
public void removeAtFromEmptyListShouldThrow() {
    list = new ArrayList<>();
    assertThrows(IndexOutOfBoundsException.class, () -> list.removeAt(0));
}

@Test
public void iteratorOnEmptyListShouldHaveNoNext() {
    list = new ArrayList<>();
    java.util.Iterator<Integer> it = list.iterator();
    assertFalse(it.hasNext());
    assertThrows(java.util.NoSuchElementException.class, () -> it.next());
}

@Test
public void singleElementListShouldBehaveCorrectly() {
    list = new ArrayList<>();
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
public void removeOnlyElementByValueShouldLeaveListEmpty() {
    list = new ArrayList<>();
    list.add(99);

    Integer removed = list.remove(99);
    assertEquals(99, removed);
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
}

@Test
public void clearShouldAllowReuse() {
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
public void addAtZeroOnEmptyListShouldWork() {
    list = new ArrayList<>();
    list.add(0, 123);

    assertEquals(1, list.size());
    assertEquals(123, list.get(0));
}

@Test
public void addAtSizeOnEmptyListShouldWork() {
    list = new ArrayList<>();
    list.add(list.size(), 456);

    assertEquals(1, list.size());
    assertEquals(456, list.get(0));
}

@Test
public void removeFirstElementShouldShiftAllRemainingElements() {
    Integer removed = list.removeAt(0);

    assertEquals(1, removed);
    assertEquals(9, list.size());
    for (int i = 0; i < list.size(); i++) {
        assertEquals(i + 2, list.get(i));
    }
}

@Test
public void removeLastElementShouldNotAffectEarlierElements() {
    Integer removed = list.removeAt(list.size() - 1);

    assertEquals(10, removed);
    assertEquals(9, list.size());
    for (int i = 0; i < list.size(); i++) {
        assertEquals(i + 1, list.get(i));
    }
}

@Test
public void removeShouldOnlyRemoveFirstOccurrenceWhenMultipleDuplicatesExist() {
    list = new ArrayList<>();
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

@Test
public void customInitialCapacityOfOneShouldResizeCorrectly() {
    list = new ArrayList<>(1);
    list.add(10);
    list.add(20);
    list.add(30);

    assertEquals(3, list.size());
    assertEquals(10, list.get(0));
    assertEquals(20, list.get(1));
    assertEquals(30, list.get(2));
}

}
