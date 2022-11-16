package sensor;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Some of the code it borrowed from:
 * Title: Socket programming in Java
 * Author: GeeksforGeeks
 * Date: 08.11.2021
 * Availability: https://www.geeksforgeeks.org/socket-programming-in-java/
 */

public class TemperatureSensorServer
{

    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private ISensor temperatureSensor = new TemperatureSensorAdapter("Temperature");


    // constructor with port
    public TemperatureSensorServer(int port){

        // starts server and waits for a connection
        try
        {
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
                        output.writeUTF(temperatureSensor.getName());
                        output.flush();
                        break;
                    case "Value":
                        output.writeDouble(temperatureSensor.getValue());
                        output.flush();
                        break;
                }
            }

        }
        catch (IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args)
    {
        TemperatureSensorServer server = new TemperatureSensorServer(5000);
    }
}
