package dk.sdu.mmmi.testapplication.Sensor;

import dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor;

public class AdapterCO2Sensor implements ISensor {

    final CO2Sensor sensor;
    final String id;

    //Constructor
    public AdapterCO2Sensor(String id) {
        this.id = id;
        sensor = new CO2Sensor(id);
        sensor.start();

    }


    @Override
    public String getName() {
        return "CO2 ";
    }

    //Parsing the Integer value into a Double
    @Override
    public Double getValue() {
        return Double.valueOf(sensor.getValue());
    }
}
