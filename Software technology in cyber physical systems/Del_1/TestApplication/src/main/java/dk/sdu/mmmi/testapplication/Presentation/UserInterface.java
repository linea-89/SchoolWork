package dk.sdu.mmmi.testapplication.Presentation;

import dk.sdu.mmmi.testapplication.Domain.DomainCO2Sensor;
import dk.sdu.mmmi.testapplication.Domain.DomainTemperatureSensor;

import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        //Classes from the domain layer is instantiated.
        DomainCO2Sensor co2Sensor = new DomainCO2Sensor("1");
        DomainTemperatureSensor temperatureSensor = new DomainTemperatureSensor();

        //new Scanner object
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press 1 for current CO2 level");
        System.out.println("Press 2 for current temperature");

        int input = scanner.nextByte();


        if (input == 1) {
            System.out.println("The current level of " + co2Sensor.getName() + " is: " + co2Sensor.getValue());
        } else {
            System.out.println("The current " + temperatureSensor.getName() + " is: " + temperatureSensor.getValue() + " degrees");
        }


    }
}



