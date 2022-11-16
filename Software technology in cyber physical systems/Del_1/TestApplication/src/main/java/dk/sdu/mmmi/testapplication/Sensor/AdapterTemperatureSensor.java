package dk.sdu.mmmi.testapplication.Sensor;

import dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor;

public class AdapterTemperatureSensor implements ISensor{

    final TemperatureSensor temperatureSensor;

    public AdapterTemperatureSensor(){
        temperatureSensor = new TemperatureSensor();
        temperatureSensor.start();
    }

    @Override
    public String getName() {
        return "temperature ";
    }

    @Override
    public Double getValue() {
        return (Double) temperatureSensor.value();
    }
}
