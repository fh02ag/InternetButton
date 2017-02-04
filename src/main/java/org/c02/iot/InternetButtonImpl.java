package org.c02.iot;

import java.awt.Color;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.api.ParticleException;
import org.c02.iot.cloud.examples.DemoConstants;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonCounter(ButtonDirection button) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}
}
