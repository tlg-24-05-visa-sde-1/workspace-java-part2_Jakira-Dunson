package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 * BVT:
 *  volume
 *   -1,0  and  100,101
 *  channel
 *   0,1  and  999,1000
 */
public class TelevisionTest {

    //fixture
    private Television television;

    @Before
    public void setUp() {
        television = new Television();
    }

    @Test
    public void hashCode_shouldReturnFalse_sameBrand_sameVolume_differentDisplay() {
        television.setDisplay(DisplayType.OLED);
        Television otherTelevision = new Television();

        assertNotEquals(television.hashCode(), otherTelevision.hashCode());
    }

    @Test
    public void hashCode_shouldReturnFalse_sameBrand_differentVolume() {
        television.setBrand("Sony");
        Television other = new Television("Sony", 10);

        assertNotEquals(television.hashCode(), other.hashCode());
    }

    @Test
    public void hashCode_shouldReturnFalse_differentBrand_sameVolume() {
        television.setBrand("Samsung");
        Television other = new Television();

        assertNotEquals(television.hashCode(), other.hashCode());
    }

    @Test
    public void hashCode_shouldReturnTrue_allPropertiesSame() {
        Television other = new Television();

        assertEquals(television.hashCode(), other.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_sameVolume_differentDisplay() {
        television.setDisplay(DisplayType.OLED);
        Television otherTv = new Television();

        assertNotEquals(television, otherTv);
    }

    @Test
    public void equals_shouldReturnFalse_sameBrand_differentVolume_sameDisplay() {
        television.setBrand("Sony");
        Television other = new Television("Sony", 10);

        assertNotEquals(television, other);
    }

    @Test
    public void equals_shouldReturnFalse_differentBrand_sameVolume_sameDisplay() {
        television.setBrand("Samsung");
        Television other = new Television();

        assertNotEquals(television, other);
    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        Television other = new Television();

        assertEquals(television, other);
    }

    @Test
    public void compareTo_shouldReturnNegativeNumber_when1stBrandLessThan2ndBrand() {
        television.setBrand("A_lessthan");
        Television other = new Television("B_greaterThan");

        assertTrue(television.compareTo(other) < 0);
    }

    @Test
    public void compareTo_shouldReturnPositiveNumber_when1stBrandGreaterThan2ndBrand() {
        television.setBrand("B_greaterThan");
        Television other = new Television("A_lessThan");

        assertTrue(television.compareTo(other) > 0);
    }

    @Test
    public void compareTo_shouldReturnZero_sameBrands() {
        television.setBrand("Sony");
        Television other = new Television("Sony");

        assertTrue(television.compareTo(other) == 0);
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_upperBound()
            throws InvalidChannelException{
        television.changeChannel(999);
        assertEquals(999, television.getCurrentChannel());
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_lowerBound()
            throws InvalidChannelException{
        television.changeChannel(1);
        assertEquals(1, television.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidInput_lowerBound()
            throws InvalidChannelException{
        try {
            television.changeChannel(0);
            fail("Should have thrown InvalidChannelException");
        } catch (InvalidChannelException e) {
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
            throw e;
        }
    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
        television.setVolume(-1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
        television.setVolume(101);
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        television.setVolume(0);
        assertEquals(0, television.getVolume());
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_upperBound() {
        television.setVolume(100);
        assertEquals(100, television.getVolume());
    }
}