package domain;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class Client {

    private HazelcastInstance client;

    // constructor to put ip address and port
    public static void main(String[] args) {
        Client client = new Client();
    }

    public Client() {

        ClientConfig cfg = new ClientConfig();
        cfg.setClusterName("dev");
        client = HazelcastClient.newHazelcastClient(cfg);
    }


    public String getSensorValue(String mapName) {

        Map<String, String> mapCo2 = client.getMap(mapName);
        String value = mapCo2.get("Value");

        return value;
    }

    public String getSensorName(String mapName) {

        Map<String, String> mapCo2 = client.getMap(mapName);
        String name = mapCo2.get("Name");

        return name;
    }
}
