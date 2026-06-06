import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a temperature (or 'stop' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("stop")) {
                running = false;
            } else {
                Scanner inputParser = new Scanner(input);

                if (inputParser.hasNextDouble()) {
                    double temp = inputParser.nextDouble();

                    if (!inputParser.hasNext()) {
                        System.out.print("Enter the unit (C or F): ");
                        String unit = scanner.nextLine().trim().toUpperCase();

                        if (unit.equals("C") || unit.equals("F")) {
                            double convertedTemp = convertTemperature(temp, unit);

                            if (unit.equals("C")) {
                                System.out.printf("%.2f°C is equal to %.2f°F%n", temp, convertedTemp);
                            } else {
                                System.out.printf("%.2f°F is equal to %.2f°C%n", temp, convertedTemp);
                            }
                        } else {
                            System.out.println("Error: Unrecognized unit label. Please enter C or F.");
                        }
                    } else {
                        System.out.println("Error: Invalid temperature input. Please enter a valid number.");
                    }
                } else {
                    System.out.println("Error: Invalid temperature input. Please enter a valid number.");
                }
            }
        }
        scanner.close();
    }

    public static double convertTemperature(double temperature, String unit) {
        double result = 0.0;

        if (unit.equalsIgnoreCase("C")) {
            result = (temperature * 9.0 / 5.0) + 32.0;
        } else if (unit.equalsIgnoreCase("F")) {
            result = (temperature - 32.0) * 5.0 / 9.0;
        }

        return result;
    }
}