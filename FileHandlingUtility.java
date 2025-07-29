import java.io.*;
import java.util.Scanner;
public class FileHandlingUtility {

    // Method to write to a file
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter
        (filename))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read from a file
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("File content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to modify a file (replaces a word with another)
    public static void modifyFile(String filename, String oldWord, String newWord) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();

            // Read all content and replace word
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileContent.append(line.replaceAll(oldWord, newWord)).append("\n");
            }
            scanner.close();

            // Write modified content back to file
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(fileContent.toString());
            writer.close();

            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filename = "sample.txt";

        // Write content to file
        writeToFile(filename, "Hello Java Intern!\nThis is your file handling task.");

        // Read content from file
        readFromFile(filename);

        // Modify file content: replace "Java" with "EliteTech"
        modifyFile(filename, "Java", "EliteTech");

        // Read content again after modification
        readFromFile(filename);
    }
}


