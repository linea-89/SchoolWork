package sensor;

import com.hazelcast.com.google.common.util.concurrent.Service;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.net.Socket;
import java.util.Map;

public class TemperatureSensorServer {

    private ISensor temperatureSensor = new TemperatureSensorAdapter("Temperature");


    public TemperatureSensorServer() {

        Config cfg = new Config();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);

        Map<String, String> mapCo2 = instance.getMap("Temperature");
        mapCo2.put("Name", temperatureSensor.getName());
        mapCo2.put("Value", String.valueOf(temperatureSensor.getValue()));
    }

    public static void main(String[] args) {
        TemperatureSensorServer server = new TemperatureSensorServer();
    }
}
