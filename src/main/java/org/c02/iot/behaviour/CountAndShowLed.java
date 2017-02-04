package org.c02.iot.behaviour;

import java.awt.Color;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;

public class CountAndShowLed extends AbstractBehaviour {

    public CountAndShowLed(InternetButtonApi buttonInstance) {
        super(buttonInstance);
    }

    @Override
    public void run() {
        int buttonCounter = getButtonCount();
        button.setLed(buttonCounter, Color.GREEN);
    }

    public int getButtonCount() {
        int buttonCounter = button.getButtonCounter(ButtonDirection.North);
        if (buttonCounter % 12 == 0) {
            button.allLedsOff();
        }
        if (buttonCounter > 12) {
            buttonCounter %= 12;
        }
        return buttonCounter;
    }

}
