/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import static org.junit.Assert.*;
import java.util.Comparator;
import org.junit.Test;

public class TelevisionChannelComparatorTest {
    private Comparator<Television> comparator = new TelevisionChannelComparator();

    @Test
    public void testCompare() throws InvalidChannelException {  // throws clause needed because it's an unhandled checked exception
        Television television = new Television();
        television.changeChannel(5);
        Television television1 = new Television();
        television1.changeChannel(6);

        assertTrue(comparator.compare(television, television1) < 0);  // 5 < 6
        assertTrue(comparator.compare(television1, television) > 0);  // 6 > 5

        television1.changeChannel(5);
        assertTrue(comparator.compare(television, television1) == 0); // 5 = 5
    }
}