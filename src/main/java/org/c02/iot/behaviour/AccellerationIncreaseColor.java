package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonApi;

import java.awt.*;

/**
 * Created by Andre on 04.02.2017.
 */
public class AccellerationIncreaseColor extends AbstractBehaviour {

    int colorRed = 0;
    int colorGreen = 0;
    int colorBlue = 0;
    int oldXValue = 0;
    int oldYValue = 0;
    int oldZValue = 0;

    public AccellerationIncreaseColor(InternetButtonApi buttonInstance) {
        super(buttonInstance);
    }

    @Override
    public void run() {
        int xValue = button.getXValue();
        int yValue = button.getYValue();
        int zValue = button.getZValue();

        Color color = new Color(getColorRed(xValue), getColorGreen(yValue), getColorBlue(zValue));
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

    public int getColorGreen(int yValue) {
        if (oldYValue != yValue) {
            oldYValue = yValue;
            colorGreen += 10;
            if (colorGreen > 255) {
                colorGreen = 0;
            }
        }
        return colorGreen;
    }

    public int getColorBlue(int zValue) {
        if (oldZValue != zValue) {
            oldZValue = zValue;
            colorBlue += 10;
            if (colorBlue > 255) {
                colorBlue = 0;
            }
        }
        return colorBlue;
    }
}
