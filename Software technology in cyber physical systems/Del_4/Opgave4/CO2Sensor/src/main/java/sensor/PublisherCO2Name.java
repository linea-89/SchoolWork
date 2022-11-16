package sensor;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;

/**
 * Title: Topic
 * Author: Hazelcast
 * Date : 19.01.2021 (last updated according to github)
 * Code version: 4.2
 * Availability: https://docs.hazelcast.com/imdg/4.2/data-structures/topic
 */

public class PublisherCO2Name {

    public static void main(String[] args) {

        ISensor co2Sensor = new CO2SensorAdapter("CO2 name");
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        ITopic<Object> topic = hz.getTopic("CO2Sensor2");


        while (true) {
            topic.publish(co2Sensor.getName());
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
