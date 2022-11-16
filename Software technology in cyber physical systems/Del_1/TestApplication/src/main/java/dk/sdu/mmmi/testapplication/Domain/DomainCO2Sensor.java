package dk.sdu.mmmi.testapplication.Domain;

import dk.sdu.mmmi.testapplication.Sensor.AdapterCO2Sensor;

public class DomainCO2Sensor {
    final AdapterCO2Sensor sensor;
    final String id;


    //Constructor
    public DomainCO2Sensor(String id) {
        this.id = id;
        sensor = new AdapterCO2Sensor(id);
    }

    public String getName() {
        return sensor.getName();
    }

    public Double getValue() {
        return sensor.getValue();
    }

}