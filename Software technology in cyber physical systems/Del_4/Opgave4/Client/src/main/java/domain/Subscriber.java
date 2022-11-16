package domain;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;
import com.hazelcast.topic.Message;
import com.hazelcast.topic.MessageListener;

/**
 * Title: Topic
 * Author: Hazelcast
 * Date : 19.01.2021 (last updated according to github)
 * Code version: 4.2
 * Availability: https://docs.hazelcast.com/imdg/4.2/data-structures/topic
 */


public class Subscriber {

    HazelcastInstance hz;
    ITopic<String> topic;
    ITopic<String> topic1;
    ITopic<String> topic2;
    ITopic<String> topic3;

    public Subscriber() {
        hz = Hazelcast.newHazelcastInstance();
        //ITopic<Object> topic = hz.getTopic("Sensor");
        topic = hz.getTopic("CO2Sensor");  //Value
        topic1 = hz.getTopic("CO2Sensor2"); //Name
        topic2 = hz.getTopic("TSensor"); //Value
        topic3 = hz.getTopic("TSensor2"); //Name
        topic.addMessageListener(new MessageListenerImpl());
        topic1.addMessageListener(new MessageListenerImpl());
        topic2.addMessageListener(new MessageListenerImpl());
        topic3.addMessageListener(new MessageListenerImpl());
        System.out.println("Subscribed");

    }


    private static class MessageListenerImpl implements MessageListener<String> {
        public void onMessage(Message<String> message) {
            System.out.println("Received: " + message.getMessageObject());
        }
    }


    public String getCO2SensorValue() {
        ITopic<String> topic = hz.getTopic("CO2Sensor");

        return topic.addMessageListener(new MessageListenerImpl()).toString();

    }


    public String getCO2SensorName() {
        ITopic<String> topic1 = hz.getTopic("CO2Sensor2");
        Object name = topic1.addMessageListener(new MessageListenerImpl());

        return name.toString();
    }


    public String getTempSensorValue() {

        ITopic<String> topic2 = hz.getTopic("TSensor");

        return topic2.addMessageListener(new MessageListenerImpl()).toString();

    }

    public String getTempSensorName() {

        ITopic<String> topic3 = hz.getTopic("TSensor2");
        Object name = topic3.addMessageListener(new MessageListenerImpl());

        return name.toString();
    }


}