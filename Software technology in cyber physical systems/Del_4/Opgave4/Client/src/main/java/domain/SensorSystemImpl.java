package domain;

import java.io.IOException;

public class SensorSystemImpl implements SensorSystem {


    Subscriber subscriber;

    public SensorSystemImpl() {
        subscriber = new Subscriber();
    }

    public String getCo2SensorValue() {
        return subscriber.getCO2SensorValue();
    }

    public String getCo2SensorName() {
        return subscriber.getCO2SensorName();
    }

    public String getTemperatureSensorValue() {
        return subscriber.getTempSensorValue();
    }

    public String getTemperatureSensorName() {
        return subscriber.getTempSensorName();
    }


}
