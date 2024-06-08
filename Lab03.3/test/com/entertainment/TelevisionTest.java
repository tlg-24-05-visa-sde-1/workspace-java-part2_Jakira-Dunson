package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
* BVT:
* volume
* -1, 0 and 100, 101
* channel
* 0, 1 and 999, 1000
*/


public class TelevisionTest {
    private Television television;

    @Before
    public void setUp()  {
        television = new Television();
    }

    @Test
    public void changeChannel_shouldStoreValue_validInput_lowerBound()
    throws Exception{
        television.changeChannel(1);
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowIllegalArgumentException_invalidInput_lowerBound()
    throws InvalidChannelException {
        television.changeChannel(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound(){
        television.setVolume(101);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound(){
        television.setVolume(-1);
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