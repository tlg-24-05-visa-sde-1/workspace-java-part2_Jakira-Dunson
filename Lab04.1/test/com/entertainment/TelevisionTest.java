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
import org.junit.Test;

public class TelevisionTest {

    @Test
    public void testSetVolume() {
        Television television = new Television();

        television.setVolume(0);    // valid volume, min value
        assertEquals(0, television.getVolume());

        television.setVolume(100);  // valid volume, max value
        assertEquals(100, television.getVolume());
    }

    /**
     * Written using try-catch-or-fail technique.
     * This allows us to trap the exception and verify its message.
     * It also allows us to test multiple calls to the business method in one test method (which may not always be desirable).
     * We are testing both lower and upper bounds in this one test method (mainly to show the technique, and that you can).
     */
    @Test
    public void testSetVolumeIllegalArgumentException() {
        Television television = new Television();

        try {
            television.setVolume(-1);  // if method works correctly, exception is thrown and control jumps to catch block
            fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: -1. Allowed range: [0,100].", e.getMessage());  // verify the exception message
        }

        try {
            television.setVolume(101); // if method works correctly, exception is thrown and control jumps to catch block
            fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Invalid volume: 101. Allowed range: [0,100].", e.getMessage());  // verify the exception message
        }
    }

    @Test
    public void testChangeChannel() throws InvalidChannelException {  // throws clause needed because it's an unhandled checked exception
        Television television = new Television();

        television.changeChannel(1);    // valid channel, min value
        assertEquals(1, television.getCurrentChannel());

        television.changeChannel(999);  // valid channel, max value
        assertEquals(999, television.getCurrentChannel());
    }

    /**
     * The two test methods below are Written using the @Test annotation's 'expected' attribute.
     * This is simpler and more compact than the try-catch-or-fail approach.
     * But we forego the opportunity to verify the exception's message,
     * and we can only make one business call per test method.
     * This is because once the exception is thrown, we don't catch it here, which means it propagates back to the caller of
     * the test method (the JUnit test runner), and method execution terminates immediately - normal exception behavior.
     */
    @Test(expected=InvalidChannelException.class)
    public void testChangeChannelInvalidChannelException_LowerBound() throws InvalidChannelException {  // unhandled checked exception
        Television television = new Television();
        television.changeChannel(0);
        television.changeChannel(1000);  // WRONG: this is never reached, need another test method (see next test method)
    }

    @Test(expected=InvalidChannelException.class)
    public void testChangeChannelInvalidChannelException_UpperBound() throws InvalidChannelException {  // unhandled checked exception
        Television television = new Television();
        television.changeChannel(1000);
    }

    @Test
    public void testEquals() {  // brand, volume, display
        Television television = new Television("RCA", 10, DisplayType.LED);
        Television television1 = new Television("RCA", 10, DisplayType.LED);
        assertEquals(television, television1);
        assertEquals(television1, television);

        television1.setBrand("X");
        assertNotEquals(television, television1);
    }

    @Test
    public void testHashCode() {  // brand, volume, display
        Television television = new Television("RCA", 10, DisplayType.LED);
        Television television1 = new Television("RCA", 10, DisplayType.LED);
        // equal objects must have equal hashcodes
        assertEquals(television.hashCode(), television1.hashCode());
    }

    @Test
    public void testCompareTo() { // natural order defined by brand only
        Television television = new Television("RCA");
        Television television1 = new Television("Sony");
        Television television2 = new Television("Zenith");
        assertTrue(television.compareTo(television1) < 0);  // RCA < Sony
        assertTrue(television2.compareTo(television1) > 0);  // Zenith > Sony

        television1.setBrand("RCA");
        assertTrue(television.compareTo(television1) == 0); // RCA = RCA
    }
}