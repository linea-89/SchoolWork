package com.sdu.main;

import services.IAssemblyStation;
import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONException;
import org.json.JSONObject;

public class AssemblyStationClient implements IAssemblyStation {

    private MqttClient client;
    private int lastOperation;
    private int currentOperation;
    private String state = "";
    private String timestamp;
    private boolean constructing = false;
    private boolean done = false;
    private boolean lastProductWasHealthy = true;
    private int batchID = 0;
    private JSONObject wholeStatus;
    private String healthStatus = "";

    public AssemblyStationClient() {
        // Establish connection
        Thread t = new Thread(()-> {
            try {
                this.client = new MqttClient("tcp://localhost:1883", "1");
                // Establish connection with mqtt client
                client.connect();
                // Subscribes to status and defines function to do with published data
                client.subscribe("emulator/status", (topic, msg) -> {
                    // Maps mqtt message into a Json object
                    JSONObject obj = new JSONObject(msg.toString());
                    wholeStatus = obj;
                    // Maps current state to this object

                    switch ((int) obj.get("State")) {
                        case 0:
                            state = "Idle";
                            break;
                        case 1:
                            state = "Executing";
                            break;
                        case 2:
                            state = "Error";
                            break;
                    }
                    // Maps last id to this object
                    lastOperation = (int) obj.get("LastOperation");

                    // Maps current machine state to this object
                    currentOperation = (int) obj.get("CurrentOperation");

                    // Maps current time to this object
                    timestamp = (String) obj.get("TimeStamp");
                });
                // Subscribes to check health and execute the lambda function to see if the produced product is healthy
                client.subscribe("emulator/checkhealth", (topic, msg) -> {
                    // Interprets the json file
                    healthStatus = msg.toString();
                    String[] jsonResponse = msg.toString().replaceAll("[{}' \"]", "").split(":");
                    lastProductWasHealthy = jsonResponse[1].equals("true");
                    done = true;
                    constructing = false;
                });
            } catch (MqttException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();

        Thread assemblyStationPublisherThread = new Thread(new AssemblyStationPublisher(this));
        assemblyStationPublisherThread.start();
        AssemblyStationEventHandler stationEventHandler = new AssemblyStationEventHandler(this, "MES");
    }


    @Override
    public void construct() {
        try {
            client.publish("emulator/operation",
                    new MqttMessage(new JSONObject()
                            .put("ProcessID", batchID++).toString().getBytes()));
            constructing = true;
            System.out.println(constructing);
            done = false;
        } catch (MqttException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkProductHealth() {
        return lastProductWasHealthy;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public boolean isConstructing() {
        return constructing;
    }

    @Override
    public String getState() {
        return state;
    }

    public boolean isLastProductWasHealthy() {
        return lastProductWasHealthy;
    }

    public JSONObject getWholeStatus() {
        return wholeStatus;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public static void main(String[] args) throws InterruptedException {
        AssemblyStationClient assemblyStationClient = new AssemblyStationClient();
    }

}
