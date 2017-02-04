package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonApi;

import java.awt.*;

/**
 * Created by Andre on 04.02.2017.
 */
public class CountAndShowLedIncreaseRed extends AbstractBehaviour {

    int colorRed = 0;
    int clickCount = 0;

    public CountAndShowLedIncreaseRed(InternetButtonApi buttonInstance) {
        super(buttonInstance);
    }

    @Override
    public void run() {
        int buttonCounter = button.getButtonCounter(InternetButtonApi.ButtonDirection.North);
        Color color = new Color(getColorRed(buttonCounter), 0, 0);
        button.setLed(1, color);
    }

    public int getColorRed(int buttonCounter) {
        if (clickCount != buttonCounter) {
            clickCount = buttonCounter;
            colorRed += 10;
            if (colorRed > 255) {
                colorRed = 0;
            }
        }
        return colorRed;
    }
}
