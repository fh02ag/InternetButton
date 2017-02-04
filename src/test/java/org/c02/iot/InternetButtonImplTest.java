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
    }

    @Test
    public void testSetLedValid() throws Exception {
        impl.setLed(1, new Color(255,255,255));
        verify(wrapper, times(1)).callMethod("led", "01255255255");
    }
}