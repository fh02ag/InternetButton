package org.c02.iot;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

import java.awt.*;
import java.io.IOException;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonCounter(ButtonDirection button) {
		int buttonCount = 0;
		switch(button) {
			case North:
				buttonCount = 1;
				break;
			case South:
				buttonCount = 2;
				break;
			case East:
				buttonCount = 3;
				break;
			case West:
				buttonCount = 4;
				break;
		}

		try {
			return wrapper.readVariable("countButton" + buttonCount);
		} catch (IOException e) {
			System.out.println("Could not get button count because the following error: " + e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	public void setLed(int position, Color color) {
		StringBuilder sb = new StringBuilder();
		if (position < 10) {
			sb.append("0");
		}
		sb.append(position).append(color.getRed()).append(color.getGreen()).append(color.getBlue());

		try {
			wrapper.callMethod("led", sb.toString());
		} catch (ParticleException e) {
			System.out.println("Could not turn leds off because of the following error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void allLedsOff() {
		try {
			wrapper.callMethod("ledsOff",null);
		} catch (ParticleException e) {
			System.out.println("Could not turn leds off because of the following error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void playSound() {
		try {
			wrapper.callMethod("play", null);
		} catch (ParticleException e) {
			System.out.println("Could not play sound because of the following error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void resetButtonCounters() {
		try {
			wrapper.callMethod("reset", null);
		} catch (ParticleException e) {
			System.out.println("Could not rest button counter because of the following error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
