package se.lexicon.data_access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {
    private final Scanner scanner;// Scanner object that will be injected

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println("Enter a String: ");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        System.out.println("Enter an integer: ");
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid integer, try again.");
            scanner.next(); // Discard the invalid input
        }
        return scanner.nextInt(); // Use the injected scanner to read an integer
    }
}
