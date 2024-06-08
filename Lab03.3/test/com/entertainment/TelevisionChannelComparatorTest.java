package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
    private Television television;
    private Television television2;
    private TelevisionChannelComparator comparator;

    @Before
    public void setUp() {
        television = new Television();  // channel 3 by default
        television2 = new Television();  // channel 3 by default

        // also need to create the Comparator<Television> object
        comparator = new TelevisionChannelComparator();
    }

    @Test
    public void compare_shouldReturnZero_whenSameChannel() {
        assertEquals(0, comparator.compare(television, television2));
    }

    @Test
    public void compare_shouldReturnNegativeNumber_when1stChannelLessThan2ndChannel()
            throws InvalidChannelException {
        television.changeChannel(2);
        assertTrue(comparator.compare(television, television2) < 0);
    }

    @Test
    public void compare_shouldReturnPositiveNumber_when1stChannelGreaterThan2ndChannel()
            throws InvalidChannelException {
        television.changeChannel(4);
        assertTrue(comparator.compare(television, television2) > 0);
    }
}