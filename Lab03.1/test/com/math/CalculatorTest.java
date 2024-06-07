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
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }

    @Test
    public void testDivide() {
        Calculator calcu = new Calculator();
        assertEquals(2.5, calcu.divide(5, 2), .001); //expected, actual, delta 
    }

    @Test
    public void testEven(){
        Calculator calcul = new Calculator();
        assertTrue(calcul.isEven(10));

    }
}