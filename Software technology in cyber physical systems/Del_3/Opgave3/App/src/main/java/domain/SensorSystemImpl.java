package domain;

import java.io.IOException;

public class SensorSystemImpl implements SensorSystem {


    Client client;

    public SensorSystemImpl() throws IOException {
         client = new Client();
    }

    public String getCo2SensorValue()
    {
        return client.getSensorValue("CO2");
    }

    public String getCo2SensorName()
    {
        return client.getSensorName("CO2");
    }

    public String getTemperatureSensorValue()
    {
        return client.getSensorValue("Temperature");
    }

    public String getTemperatureSensorName()
    {
        return client.getSensorName("Temperature");
    }


}
