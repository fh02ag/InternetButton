package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Andre on 04.02.2017.
 */
public class AccellerationIncreaseRedTest {

    AccellerationIncreaseRed accellerationIncreaseRed;
    InternetButtonImpl button;

    @Before
    public void setUp() throws Exception {
        button = mock(InternetButtonImpl.class);
        accellerationIncreaseRed = new AccellerationIncreaseRed(button);
    }


    @Test
    public void testGetColorRedXValueChanged() throws Exception {
        Assert.assertEquals(10, accellerationIncreaseRed.getColorRed(1));
    }

    @Test
    public void testGetColorRedXValueNotChanged() throws Exception {
        Assert.assertEquals(0, accellerationIncreaseRed.getColorRed(0));
    }
}