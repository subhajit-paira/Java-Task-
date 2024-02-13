package task;

import java.security.SecureRandom;
import java.util.Scanner;

public class passwordgenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Password Generator!");

        // Get user input for password criteria
        int length = getLengthFromUser(scanner);
        boolean includeUppercase = getYesOrNoFromUser(scanner, "Include Uppercase letters? (y/n): ");
        boolean includeLowercase = getYesOrNoFromUser(scanner, "Include Lowercase letters? (y/n): ");
        boolean includeNumbers = getYesOrNoFromUser(scanner, "Include Numbers? (y/n): ");
        boolean includeSpecialChars = getYesOrNoFromUser(scanner, "Include Special characters? (y/n): ");

        // Generate and display the password
        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);
        System.out.println("\nYour generated password is: " + password);

        // Close the scanner
        scanner.close();
    }

    private static int getLengthFromUser(Scanner scanner) {
        int length;
        while (true) {
            try {
                System.out.print("Enter the length of the password: ");
                length = Integer.parseInt(scanner.nextLine());
                if (length <= 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid positive integer for password length.");
            }
        }
        return length;
    }

    private static boolean getYesOrNoFromUser(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("y") || response.equals("yes")) {
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                           boolean includeNumbers, boolean includeSpecialChars) {
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String numberChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        StringBuilder validChars = new StringBuilder();
        if (includeUppercase) validChars.append(uppercaseChars);
        if (includeLowercase) validChars.append(lowercaseChars);
        if (includeNumbers) validChars.append(numberChars);
        if (includeSpecialChars) validChars.append(specialChars);

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
