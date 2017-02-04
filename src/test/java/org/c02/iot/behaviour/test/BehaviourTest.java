package org.c02.iot.behaviour.test;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.behaviour.CountAndShowLed;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.mockito.Mockito.*;

public class BehaviourTest {

    CountAndShowLed countAndShowLed;
    InternetButtonImpl button;

    @Before
    public void setUp() throws Exception {
        button = mock(InternetButtonImpl.class);
        countAndShowLed = new CountAndShowLed(button);
    }

    @Test
    public void testBehaviour() {

        InternetButtonApi buttonInstance = new InternetButtonApi() {

            @Override
            public int getButtonCounter(ButtonDirection button) {
                if (button == ButtonDirection.North)
                    return 5;
                return 0;
            }

            @Override
            public void resetButtonCounters() {
                Assert.fail();
            }

            @Override
            public void setLed(int postition, Color color) {
                Assert.assertEquals(5, postition);
                Assert.assertEquals(Color.GREEN, color);
            }

            @Override
            public void allLedsOff() {
                Assert.fail();
            }

            @Override
            public void playSound() {
                Assert.fail();
            }

            @Override
            public void playSound(int sound) {

            }

            @Override
            public int getXValue() {
                return 0;
            }

            @Override
            public int getYValue() {
                return 0;
            }

            @Override
            public int getZValue() {
                return 0;
            }
        };

        CountAndShowLed beh = new CountAndShowLed(buttonInstance);

        beh.run();
    }

    @Test
    public void testGetButtonCountBelow12() throws Exception {
        when(button.getButtonCounter(InternetButtonApi.ButtonDirection.North)).thenReturn(5);
        Assert.assertEquals(5, countAndShowLed.getButtonCount());
    }

    @Test
    public void testGetButtonCountIs12() throws Exception {
        when(button.getButtonCounter(InternetButtonApi.ButtonDirection.North)).thenReturn(12);
        countAndShowLed.run();
        verify(button, times(1)).allLedsOff();
    }

    @Test
    public void testGetButtonCountOver12() throws Exception {
        when(button.getButtonCounter(InternetButtonApi.ButtonDirection.North)).thenReturn(13);
        Assert.assertEquals(1, countAndShowLed.getButtonCount());
    }
}
