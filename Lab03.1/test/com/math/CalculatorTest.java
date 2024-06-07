/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    //business object(s) under test - called a "fixture"
    private Calculator calculator;

    //set-up method
    @Before
    public void setUp()  {
        System.out.println("Set- Up");
        calculator = new Calculator();
    }
    @After
    public void tearDown() { //used as a clean-up method. Not used a- lot, useful for files, used for things that open/ close
        System.out.println("Clean- Up");

    }

    @Test
    public void testAdd() {
        System.out.println("Test Add");
        assertEquals(5, calculator.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        System.out.println("Test Divide");
        assertEquals(2.5, calculator.divide(5, 2), .001); //expected, actual, delta
    }

    @Test
    public void testEven(){
        System.out.println("Test Even");
        assertTrue(calculator.isEven(10));
        assertFalse(calculator.isEven(13));

    }
}