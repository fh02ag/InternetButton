package org.c02.iot.behaviour.examples;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.behaviour.CountAndShowLed;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

/**
 * Created by Andre on 04.02.2017.
 */
public class CountAndShowLedDemo {

    static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
            DemoConstants.accessToken);

    public static void main(String[] args) {
        InternetButtonApi button = new InternetButtonImpl(api);
        CountAndShowLed countAndShowLed = new CountAndShowLed(button);
        while(true) {
            countAndShowLed.run();
        }
    }
}
