package org.c02.iot;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Andre on 04.02.2017.
 */
public class InternetButtonImplTest {

    InternetButtonImpl impl;
    ParticleApiWrapper wrapper;


    @Before
    public void setUp() throws Exception {
        wrapper = mock(ParticleApiWrapper.class);
        impl = new InternetButtonImpl(wrapper);

        when(wrapper.callMethod(anyString(), anyString())).thenReturn(0);
        when(wrapper.readVariable(anyString())).thenReturn(0);
    }

    @Test
    public void testSetLedValid() throws Exception {
        impl.setLed(1, new Color(255, 255, 255));
        verify(wrapper, times(1)).callMethod("led", "01255255255");
    }

    @Test
    public void testPlaySound() throws Exception {
        impl.playSound();
        verify(wrapper, times(1)).callMethod("play", null);
    }

    @Test
    public void testPlaySoundWithParam() throws Exception {
        impl.playSound(2);
        verify(wrapper, times(1)).callMethod("play", "2");
    }

    @Test
    public void testGetButtonCounterNorth() throws Exception {
        impl.getButtonCounter(InternetButtonApi.ButtonDirection.North);
        verify(wrapper, times(1)).readVariable("countButton1");
    }

    @Test
    public void testGetButtonCounterSouth() throws Exception {
        impl.getButtonCounter(InternetButtonApi.ButtonDirection.South);
        verify(wrapper, times(1)).readVariable("countButton2");
    }

    @Test
    public void testGetButtonCounterEast() throws Exception {
        impl.getButtonCounter(InternetButtonApi.ButtonDirection.East);
        verify(wrapper, times(1)).readVariable("countButton3");
    }

    @Test
    public void testGetButtonCounterWest() throws Exception {
        impl.getButtonCounter(InternetButtonApi.ButtonDirection.West);
        verify(wrapper, times(1)).readVariable("countButton4");
    }

    @Test
    public void testResetButtonCounters() throws Exception {
        impl.resetButtonCounters();
        verify(wrapper, times(1)).callMethod("reset", null);
    }

    @Test
    public void testGetXValue() throws Exception {
        impl.getXValue();
        verify(wrapper, times(1)).readVariable("xValue");
    }

    @Test
    public void testGetYValue() throws Exception {
        impl.getYValue();
        verify(wrapper, times(1)).readVariable("yValue");
    }

    @Test
    public void testGetZValue() throws Exception {
        impl.getZValue();
        verify(wrapper, times(1)).readVariable("zValue");
    }
}