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

public class TelevisionBrandChannelComparatorTest {
    private Comparator<Television> comparator = new TelevisionBrandChannelComparator();

    @Test
    public void testCompare() throws InvalidChannelException {  // throws clause needed because it's an unhandled checked exception
        Television television = new Television("RCA");
        Television television1 = new Television("Sony");

        assertTrue(comparator.compare(television, television1) < 0);  // RCA < Sony

        // if same brand, then compare channel
        television1.setBrand("RCA");    // now they have the same brand
        television.changeChannel(50);  // but television's channel is lower
        television1.changeChannel(60);

        assertTrue(comparator.compare(television, television1) < 0);  // RCA = RCA, 50 < 60

        television1.changeChannel(50);  // now all properties are the same
        assertTrue(comparator.compare(television, television1) == 0); // RCA = RCA, 50 = 50
    }
}