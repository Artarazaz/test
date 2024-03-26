import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class test {
    public static void main(String[] args) {
        // Prompt for user input and handle invalid input cases
        Scanner userInputScanner = new Scanner(System.in);
        String filePath;
        do {
            System.out.print("Enter the file path (or 'exit' to quit): ");
            filePath = userInputScanner.nextLine().trim();
            if (filePath.equalsIgnoreCase("exit")) {
                // User wants to exit, close scanner and terminate
                userInputScanner.close();
                System.out.println("Exiting program.");
                System.exit(0);
            }
        } while (filePath.isEmpty());  // Ensure non-empty input

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            System.out.println("Words in the file:");
            while (fileScanner.hasNext()) {
                // Process each word (e.g., print or store)
                System.out.println(fileScanner.nextLine());
            }

            fileScanner.close();  // Close the file scanner
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + filePath);
        }

        userInputScanner.close();  // Close the scanner used for user input
    }
}
