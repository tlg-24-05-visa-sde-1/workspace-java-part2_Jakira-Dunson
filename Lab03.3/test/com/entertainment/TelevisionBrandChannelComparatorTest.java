package com.entertainment;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TelevisionBrandChannelComparatorTest {
    private Television television;
    private Television television2;
    private TelevisionBrandChannelComparator comparator;

    @Before
    public void setUp() {
        television = new Television("Samsung");  // channel 3 by default
        television2 = new Television("Samsung");  // channel 3 by default
        comparator = new TelevisionBrandChannelComparator();
    }

    @Test
    public void compare_shouldReturnZero_whenSameBrand_sameChannel() {
        assertEquals(0, comparator.compare(television, television2));
    }

    @Test
    public void compare_shouldReturnNegativeNumber_when1stBrandLessThan2ndBrand() {
        television.setBrand("A_lessThan");
        television2.setBrand("B_greaterThan");
        assertTrue(comparator.compare(television, television2) < 0);
    }

    @Test
    public void compare_shouldReturnPositiveNumber_when1stBrandGreaterThan2ndBrand() {
        television.setBrand("B_greaterThan");
        television2.setBrand("A_lessThan");
        assertTrue(comparator.compare(television, television2) > 0);
    }

    @Test
    public void compare_shouldReturnNegativeNumber_whenSameBrand_1stChannelLessThan2ndChannel()
            throws InvalidChannelException {
        television.changeChannel(1);
        television2.changeChannel(2);
        assertTrue(comparator.compare(television, television2) < 0);
    }

    @Test
    public void compare_shouldReturnPositiveNumber_whenSameBrand_1stChannelGreaterThan2ndChannel()
            throws InvalidChannelException {
        television.changeChannel(2);
        television2.changeChannel(1);
        assertTrue(comparator.compare(television, television2) > 0);
    }
}