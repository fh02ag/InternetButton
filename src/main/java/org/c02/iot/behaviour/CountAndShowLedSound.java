package org.c02.iot.behaviour;

import org.c02.iot.InternetButtonApi;

/**
 * Created by Andre on 04.02.2017.
 */
public class CountAndShowLedSound extends AbstractBehaviour {

    public CountAndShowLedSound(InternetButtonApi buttonInstance) {
        super(buttonInstance);
    }

    @Override
    public void run() {
        int buttonCounterNorth = button.getButtonCounter(InternetButtonApi.ButtonDirection.North);
        int buttonCounterSouth = button.getButtonCounter(InternetButtonApi.ButtonDirection.South);
        int buttonCounterEast = button.getButtonCounter(InternetButtonApi.ButtonDirection.East);
        int buttonCounterWest = button.getButtonCounter(InternetButtonApi.ButtonDirection.West);
        int buttonCounter = buttonCounterNorth + buttonCounterSouth + buttonCounterEast + buttonCounterWest;

        if (isPlayingSoundNecessary(buttonCounter)) {
            button.playSound();
            button.resetButtonCounters();
        }
    }

    public boolean isPlayingSoundNecessary(int buttonCounter) {
        return buttonCounter > 0 ? buttonCounter % 10 == 0 : false;
    }
}