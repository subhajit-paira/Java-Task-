package task;

import java.util.Scanner;

public class TemperatureConversionUtility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Temperature Conversion Utility!");

        // Get user input for temperature and unit
        double temperature = getTemperatureFromUser(scanner);
        String inputUnit = getTemperatureUnitFromUser(scanner, "Enter the input temperature unit (C/F/K): ");

        // Get user input for the desired output unit
        String outputUnit = getTemperatureUnitFromUser(scanner, "Enter the desired output temperature unit (C/F/K): ");

        // Convert and display the temperature
        double convertedTemperature = convertTemperature(temperature, inputUnit, outputUnit);
        System.out.println("\nConverted Temperature: " + convertedTemperature + " " + outputUnit);

        // Close the scanner
        scanner.close();
    }

    private static double getTemperatureFromUser(Scanner scanner) {
        double temperature;
        while (true) {
            try {
                System.out.print("Enter the temperature value: ");
                temperature = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid numeric value for temperature.");
            }
        }
        return temperature;
    }

    private static String getTemperatureUnitFromUser(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String unit = scanner.nextLine().toUpperCase();
            if (unit.equals("C") || unit.equals("F") || unit.equals("K")) {
                return unit;
            } else {
                System.out.println("Invalid input. Please enter 'C', 'F', or 'K'.");
            }
        }
    }

    private static double convertTemperature(double temperature, String inputUnit, String outputUnit) {
        switch (inputUnit) {
            case "C":
                return convertFromCelsius(temperature, outputUnit);
            case "F":
                return convertFromFahrenheit(temperature, outputUnit);
            case "K":
                return convertFromKelvin(temperature, outputUnit);
            default:
                return 0.0; // Default to 0.0 if an invalid input unit is provided
        }
    }

    private static double convertFromCelsius(double celsius, String outputUnit) {
        switch (outputUnit) {
            case "C":
                return celsius;
            case "F":
                return (celsius * 9 / 5) + 32;
            case "K":
                return celsius + 273.15;
            default:
                return 0.0;
        }
    }

    private static double convertFromFahrenheit(double fahrenheit, String outputUnit) {
        switch (outputUnit) {
            case "C":
                return (fahrenheit - 32) * 5 / 9;
            case "F":
                return fahrenheit;
            case "K":
                return (fahrenheit + 459.67) * 5 / 9;
            default:
                return 0.0;
        }
    }

    private static double convertFromKelvin(double kelvin, String outputUnit) {
        switch (outputUnit) {
            case "C":
                return kelvin - 273.15;
            case "F":
                return (kelvin * 9 / 5) - 459.67;
            case "K":
                return kelvin;
            default:
                return 0.0;
        }
    }
}
