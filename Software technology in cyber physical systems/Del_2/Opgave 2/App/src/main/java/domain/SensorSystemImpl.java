package domain;

import java.io.IOException;

public class SensorSystemImpl implements SensorSystem {


    Client temperatureClient;
    Client co2Client;

    public SensorSystemImpl() throws IOException {
         co2Client = new Client("127.0.0.1", 5001);
         temperatureClient = new Client("127.0.0.1", 5000);
    }

    public double getCo2SensorValue()
    {
        return co2Client.getSensorValue();
    }

    public String getCo2SensorName()
    {
        return co2Client.getSensorName();
    }

    public double getTemperatureSensorValue()
    {
        return temperatureClient.getSensorValue();
    }

    public String getTemperatureSensorName()
    {
        return temperatureClient.getSensorName();
    }


}
