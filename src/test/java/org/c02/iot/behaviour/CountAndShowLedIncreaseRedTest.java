package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Andre on 04.02.2017.
 */
public class CountAndShowLedIncreaseRedTest {

    CountAndShowLedIncreaseRed countAndShowLed;
    InternetButtonImpl button;

    @Before
    public void setUp() throws Exception {
        button = mock(InternetButtonImpl.class);
        countAndShowLed = new CountAndShowLedIncreaseRed(button);
    }


    @Test
    public void testGetColorRedButtonClicked() throws Exception {
        when(button.getButtonCounter(InternetButtonApi.ButtonDirection.North)).thenReturn(1);
        Assert.assertEquals(10, countAndShowLed.getColorRed(1));
    }

    @Test
    public void testGetColorRedButtonNotClicked() throws Exception {
        when(button.getButtonCounter(InternetButtonApi.ButtonDirection.North)).thenReturn(0);
        Assert.assertEquals(0, countAndShowLed.getColorRed(0));
    }
}