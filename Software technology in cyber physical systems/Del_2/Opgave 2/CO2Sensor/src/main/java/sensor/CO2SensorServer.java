package sensor;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Title: Socket programming in Java
 * Author: GeeksforGeeks
 * Date: 08.11.2021
 * Availability: https://www.geeksforgeeks.org/socket-programming-in-java/
 */

public class CO2SensorServer {

    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private ISensor co2Sensor = new CO2SensorAdapter("CO2");


    // constructor with port
    public CO2SensorServer(int port) {

        // starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for client..");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            output = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String line = input.readUTF();
                System.out.println("Client input is " + line);
                switch (line) {
                    case "Name":
                        output.writeUTF(co2Sensor.getName());
                        output.flush();
                        break;
                    case "Value":
                        output.writeDouble(co2Sensor.getValue());
                        output.flush();
                        break;
                }
            }
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        CO2SensorServer server = new CO2SensorServer(5001);
    }
}