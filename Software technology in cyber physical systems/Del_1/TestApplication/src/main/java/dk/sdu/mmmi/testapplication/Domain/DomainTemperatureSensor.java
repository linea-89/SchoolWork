package dk.sdu.mmmi.testapplication.Domain;

import dk.sdu.mmmi.testapplication.Sensor.AdapterTemperatureSensor;

public class DomainTemperatureSensor {

    final AdapterTemperatureSensor sensor;

    //Constructor
    public DomainTemperatureSensor() {
        sensor = new AdapterTemperatureSensor();
    }

    public String getName(){
        return sensor.getName();
    }

    public Double getValue(){
        return sensor.getValue();
    }
}
