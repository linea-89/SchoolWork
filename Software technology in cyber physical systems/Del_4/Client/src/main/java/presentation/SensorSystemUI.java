package presentation;

import domain.SensorSystem;
import java.util.Scanner;
import domain.SensorSystemImpl;

public class SensorSystemUI {


    public static void main(String[] args) {

        SensorSystem system = new SensorSystemImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please select an option.");
            System.out.println("1>Read CO2 Sensor Value");
            System.out.println("2>Read Temperature Sensor Value");
            System.out.println("3>Exit");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.printf("%s Value: ", system.getCo2SensorName().toString());
                    System.out.println(system.getCo2SensorValue().toString() + " PPM");
                    break;
                case 2:
                    System.out.printf("%s Value: ", system.getTemperatureSensorName().toString()
                    );
                    System.out.println(system.getTemperatureSensorValue().toString() + " Degrees Celsius");
                    break;
                case 3:
                    System.out.println("Goodbye.");
                    System.exit(0);
            }
        }
    }
}

