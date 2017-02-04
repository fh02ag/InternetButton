package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonApi;

import java.awt.*;

/**
 * Created by Andre on 04.02.2017.
 */
public class CountAndShowLedSound extends AbstractBehaviour {

    public CountAndShowLedSound(InternetButtonApi buttonInstance) {
        super(buttonInstance);
    }

    @Override
    public void run() {
        int buttonCounter = getButtonCount();
        button.setLed(buttonCounter, Color.GREEN);
    }

    public int getButtonCount() {
        int buttonCounter = button.getButtonCounter(InternetButtonApi.ButtonDirection.North);
        if (buttonCounter % 12 == 0) {
            button.allLedsOff();
        }
        if (buttonCounter > 12) {
            buttonCounter %= 12;
        }
        return buttonCounter;
    }
}