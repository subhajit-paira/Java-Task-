import java.io.*;

public class FileIOProgram {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("1. Read from a file");
            System.out.println("2. Write to a file");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        readFromFile();
                        break;
                    case 2:
                        writeToFile();
                        break;
                    case 3:
                        System.out.println("Exiting program.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the name of the file to read from: ");
        String fileName = reader.readLine();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    private static void writeToFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the name of the file to write to: ");
        String fileName = reader.readLine();

        System.out.println("Enter text to write to the file (type 'exit' to finish):");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data written to file successfully.");
        }
    }
}
