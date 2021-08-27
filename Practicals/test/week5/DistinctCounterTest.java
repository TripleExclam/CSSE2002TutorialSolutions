package week5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctCounterTest {
    private DistinctCounter distinct;
    private String[] strings;


    @Before
    public void setup() {
        distinct = new DistinctCounter();
        strings = new String[] {"Carrot", "Potato", "Tomato"};
    }

    @Test
    public void testSingleStringAdd() {
        distinct.add("Potato");

        assertEquals(1,
                distinct.getDistinctCount());
        String[] result = distinct.getStrings();
        assertEquals(1, result.length);
        assertEquals("Potato", result[0]);
        // Alternatively
        assertArrayEquals(new String[] {"Potato"}, result);
    }

    @Test
    public void testInitialState() {
        assertEquals(0, distinct.getDistinctCount());
        assertArrayEquals(new String[0], distinct.getStrings());
    }

    @Test
    public void testAddMultipleStrings() {
        distinct.add(strings[0]);
        distinct.add(strings[1]);
        distinct.add(strings[2]);
        assertEquals(3, distinct.getDistinctCount());
        assertArrayEquals(strings, distinct.getStrings());
    }

    @Test
    public void testCorrectOrder() {
        distinct.add(strings[2]);
        distinct.add(strings[1]);
        distinct.add(strings[0]);
        assertEquals(3, distinct.getDistinctCount());
        assertArrayEquals(strings, distinct.getStrings());
    }

    @Test
    public void testCorrectOrderWithDuplicates() {
        distinct.add(strings[2]);
        distinct.add(strings[0]);
        distinct.add(strings[2]);
        distinct.add(strings[1]);
        distinct.add(strings[2]);
        distinct.add(strings[1]);
        distinct.add(strings[0]);
        assertEquals(3, distinct.getDistinctCount());
        assertArrayEquals(strings, distinct.getStrings());
    }

    @Test
    public void testAddMultipleDuplicatedStrings() {
        distinct.add(strings[0]);
        distinct.add(strings[1]);
        distinct.add(strings[1]);
        distinct.add(strings[2]);
        distinct.add(strings[2]);
        distinct.add(strings[2]);
        assertEquals(3, distinct.getDistinctCount());
        assertArrayEquals(strings, distinct.getStrings());
    }
}
