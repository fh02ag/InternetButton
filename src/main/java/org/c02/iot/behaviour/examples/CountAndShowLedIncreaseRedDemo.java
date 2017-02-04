package org.c02.iot.behaviour.examples;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.behaviour.CountAndShowLedIncreaseRed;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

/**
 * Created by Andre on 04.02.2017.
 */
public class CountAndShowLedIncreaseRedDemo {

    static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
            DemoConstants.accessToken);

    public static void main(String[] args) throws InterruptedException {
        InternetButtonApi button = new InternetButtonImpl(api);
        CountAndShowLedIncreaseRed countAndShowLed = new CountAndShowLedIncreaseRed(button);
        while(true) {
            countAndShowLed.run();
        }
    }
}
