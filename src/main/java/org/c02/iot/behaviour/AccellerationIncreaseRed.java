package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonApi;

import java.awt.*;

/**
 * Created by Andre on 04.02.2017.
 */
public class AccellerationIncreaseRed extends AbstractBehaviour {

    int colorRed = 0;
    int oldXValue = 0;

    public AccellerationIncreaseRed(InternetButtonApi buttonInstance) {
        super(buttonInstance);
    }

    @Override
    public void run() {
        int xValue = button.getXValue();
        Color color = new Color(getColorRed(xValue), 0, 0);
        button.setLed(1, color);
    }

    public int getColorRed(int xValue) {
        if (oldXValue != xValue) {
            oldXValue = xValue;
            colorRed += 10;
            if (colorRed > 255) {
                colorRed = 0;
            }
        }
        return colorRed;
    }
}