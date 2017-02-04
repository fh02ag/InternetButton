package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by Andre on 04.02.2017.
 */
public class AccellerationIncreaseColorTest {

    AccellerationIncreaseColor accellerationIncreaseColor;
    InternetButtonImpl button;

    @Before
    public void setUp() throws Exception {
        button = mock(InternetButtonImpl.class);
        accellerationIncreaseColor = new AccellerationIncreaseColor(button);
    }


    @Test
    public void testGetColorRedXValueChanged() throws Exception {
        Assert.assertEquals(10, accellerationIncreaseColor.getColorRed(1));
    }

    @Test
    public void testGetColorRedXValueNotChanged() throws Exception {
        Assert.assertEquals(0, accellerationIncreaseColor.getColorRed(0));
    }

    @Test
    public void testGetColorGreenYValueChanged() throws Exception {
        Assert.assertEquals(10, accellerationIncreaseColor.getColorGreen(1));
    }

    @Test
    public void testGetColorGreenYValueNotChanged() throws Exception {
        Assert.assertEquals(0, accellerationIncreaseColor.getColorGreen(0));
    }

    @Test
    public void testGetColorBlueZValueChanged() throws Exception {
        Assert.assertEquals(10, accellerationIncreaseColor.getColorBlue(1));
    }

    @Test
    public void testGetColorBlueZValueNotChanged() throws Exception {
        Assert.assertEquals(0, accellerationIncreaseColor.getColorBlue(0));
    }

}