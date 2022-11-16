package sensor;


import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.lang.module.Configuration;
import java.util.Map;

public class CO2SensorServer {


    private ISensor co2Sensor = new CO2SensorAdapter("CO2");

    public CO2SensorServer() {

        Config cfg = new Config();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);


        Map<String, String> mapCo2 = instance.getMap("CO2");
        mapCo2.put("Name", co2Sensor.getName());
        mapCo2.put("Value", String.valueOf(co2Sensor.getValue()));
    }

    public static void main(String[] args) {
        CO2SensorServer server = new CO2SensorServer();

    }
}