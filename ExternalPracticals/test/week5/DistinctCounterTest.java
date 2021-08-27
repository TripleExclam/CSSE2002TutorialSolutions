package week5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctCounterTest {
    private DistinctCounter distinct;
    private static String[] data;
    private static String[] dupeFree;
// matthew.burton@uq.edu.au
    @Before
    public void setup() {
        distinct = new DistinctCounter();

        dupeFree = new String[] {
                "Ahmad", "Ella", "Matt",
                "Mike", "Savita"
        };
        data = new String[] {
                "Ahmad", "Ella", "Matt", "Matt",
                "Mike",  "Mike", "Savita", "Savita"
        };
    }

    @Test
    public void testDefaultState() {
        assertEquals(0,
                distinct.getDistinctCount());
        assertArrayEquals(new String[0],
                distinct.getStrings());
    }

    // test duplicate strings
    @Test
    public void testDuplicates() {
        for (String s : data) {
            distinct.add(s);
        }

        assertEquals(dupeFree.length + 1,
                distinct.getDistinctCount());
        assertArrayEquals(dupeFree,
                distinct.getStrings());
    }

    // test no duplicates
    @Test
    public void testNoDuplicates() {
        for (String s : dupeFree) {
            distinct.add(s);
        }

        assertEquals(dupeFree.length,
                distinct.getDistinctCount());
        assertArrayEquals(dupeFree,
                distinct.getStrings());
    }


    // test that strings are returned in alphabetical order
    @Test
    public void testOrder() {
        for (int i = data.length - 1; i >= 0 ; i--) {
            distinct.add(data[i]);
        }

        assertEquals(dupeFree.length,
                distinct.getDistinctCount());
        assertArrayEquals(dupeFree,
                distinct.getStrings());
    }

    // setup() -> create all your data
    // run the test method
    // teardown() -> delete all your data
}