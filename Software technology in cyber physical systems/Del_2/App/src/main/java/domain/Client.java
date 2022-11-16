package domain;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Title: Socket programming in Java
 * Author: GeeksforGeeks
 * Date: 08.11.2021
 * Availability: https://www.geeksforgeeks.org/socket-programming-in-java/
 */

public class Client {

    // initialize socket and input output streams
    private Socket socket;
    private String line;
    private DataInputStream in;
    private DataOutputStream out;

    // constructor to put ip address and port
    public Client(String address, int port) throws IOException {

        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from server socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public double getSensorValue() {
        double value = 0;

        try {
            out.writeUTF("Value");
            out.flush();
            while (value == 0.0) {
                value = in.readDouble();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return value;
    }

    public String getSensorName() {
        String name = "";

        try {
            out.writeUTF("Name");
            out.flush();
            while (name == "") {
                name = in.readUTF();
            }

        } catch (IOException i) {
            System.out.println(i);
        }
        return name;
    }
}
