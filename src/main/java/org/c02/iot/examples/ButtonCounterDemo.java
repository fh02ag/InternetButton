package org.c02.iot.examples;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

import java.io.IOException;

/**
 * Created by Andre on 04.02.2017.
 */
public class ButtonCounterDemo {

    static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
            DemoConstants.accessToken);

    public static void main(String[] args) throws IOException {
        InternetButtonApi button = new InternetButtonImpl(api);
        System.out.println("Button count north: " + button.getButtonCounter(InternetButtonApi.ButtonDirection.North));
        System.out.println("Button count south: " + button.getButtonCounter(InternetButtonApi.ButtonDirection.South));
        System.out.println("Button count west: " + button.getButtonCounter(InternetButtonApi.ButtonDirection.West));
        System.out.println("Button count east: " + button.getButtonCounter(InternetButtonApi.ButtonDirection.East));
        button.resetButtonCounters();
    }

}
