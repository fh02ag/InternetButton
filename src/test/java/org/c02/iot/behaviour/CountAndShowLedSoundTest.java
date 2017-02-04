package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by Andre on 04.02.2017.
 */
public class CountAndShowLedSoundTest {

    CountAndShowLedSound countAndShowLed;
    InternetButtonImpl button;

    @Before
    public void setUp() throws Exception {
        button = mock(InternetButtonImpl.class);
        countAndShowLed = new CountAndShowLedSound(button);
    }

    @Test
    public void testIsPlayingSoundNecessaryIsNotNecessary() throws Exception {
        Assert.assertEquals(false, countAndShowLed.isPlayingSoundNecessary(5));
    }

    @Test
    public void testIsPlayingSoundNecessaryIsNecessary10() throws Exception {
        Assert.assertEquals(true, countAndShowLed.isPlayingSoundNecessary(10));
    }

    @Test
    public void testIsPlayingSoundNecessaryIsNecessary20() throws Exception {
        Assert.assertEquals(true, countAndShowLed.isPlayingSoundNecessary(20));
    }

    @Test
    public void testIsPlayingSoundNecessaryNotNecessary0() throws Exception {
        Assert.assertEquals(false, countAndShowLed.isPlayingSoundNecessary(0));
    }
}