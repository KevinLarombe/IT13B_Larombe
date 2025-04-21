package Restaurant_Ordering_System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Restaurant_Ordering_System {
    private static final String USERS_FILE = "C:\\Users\\User\\Documents\\GitHub\\IT13B_Larombe\\Larombe_IT13B_activities\\src\\Restaurant_Ordering_System\\input.txt";
    private static final int SHIFT = 3;
    private static final String[] MENU_ITEMS = {"Pizza", "Burger", "Fries"}; // single
    private static final double[] MENU_PRICES = {120.0, 80.0, 50.0};  // single
    private static final int MAX_ITEMS = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWELCOME TO THE KEVZEL ORDERING SYSTEM!");
            System.out.println("[1] Login");
            System.out.println("[2] Create Account");
            System.out.println("[3] Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> login(scanner);
                case 2 -> createAccount(scanner);
                case 3 -> {
                    System.out.println("THANK YOU AND COME AGAIN!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.println("\nCreate New Account");
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();

        String encryptedPassword = encrypt(password, SHIFT);
        saveCredentials(username, encryptedPassword);
        System.out.println("Account created successfully!");
    }

    private static void saveCredentials(String username, String encryptedPassword) {
        try (FileWriter writer = new FileWriter(USERS_FILE, true)) {
            writer.write(username + "," + encryptedPassword + "\n");
        } catch (IOException e) {
            System.err.println("Error saving credentials to file: " + e.getMessage());
        }
    }

    private static void login(Scanner scanner) {
        System.out.println("\nLogin");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            System.out.println("Login successful!");
            showMenuAndTakeOrder(scanner);
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private static boolean authenticateUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    String storedEncryptedPassword = parts[1];
                    String decryptedPassword = decrypt(storedEncryptedPassword, SHIFT);
                    return decryptedPassword.equals(password);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user file: " + e.getMessage());
        }
        return false;
    }

    private static String encrypt(String text, int shift) {   // encrypt password
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) (((c - base + shift) % 26) + base));
            } else if (Character.isDigit(c)) {
                sb.append((char) (((c - '0' + shift) % 10) + '0'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String decrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) (((c - base - shift + 26) % 26) + base));
            } else if (Character.isDigit(c)) {
                sb.append((char) (((c - '0' - shift + 10) % 10) + '0'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static void showMenuAndTakeOrder(Scanner scanner) {
        int[] quantities = new int[MENU_ITEMS.length];
        int totalItems = 0;
        double totalBill = 0.0;
        boolean ordering = true;

                // MENU
        do {
            System.out.println("\n---Here our Kevzel Menu ---");
            for (int i = 0; i < MENU_ITEMS.length; i++) {
                System.out.println((i + 1) + ". " + MENU_ITEMS[i] + " - *" + String.format("%.2f", MENU_PRICES[i]));
            }
            System.out.println((MENU_ITEMS.length + 1) + ". Exit");
            System.out.print("Choose an item: ");
            int itemChoice = scanner.nextInt();

            if (itemChoice >= 1 && itemChoice <= MENU_ITEMS.length) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                if (totalItems + quantity <= MAX_ITEMS) {
                    quantities[itemChoice - 1] += quantity;
                    totalItems += quantity;
                    System.out.println(quantity + " " + MENU_ITEMS[itemChoice - 1] + "(s) added to your order.");
                } else {
                    System.out.println("You have reached the maximum number of items in your order (" + MAX_ITEMS + ").");
                }
            } else if (itemChoice == MENU_ITEMS.length + 1) {
                ordering = false;
            } else {
                System.out.println("Invalid item choice. Please try again.");
            }
        } while (ordering);

        System.out.println("\n--- Order Summary ---");
        for (int i = 0; i < MENU_ITEMS.length; i++) {
            if (quantities[i] > 0) {
                double itemTotal = quantities[i] * MENU_PRICES[i];
                System.out.println(quantities[i] + " x " + MENU_ITEMS[i] + " - *" + String.format("%.2f", itemTotal));
                totalBill += itemTotal;
            }
        }
        System.out.println("Total: *" + String.format("%.2f", totalBill));
        System.out.println("Exiting menu...");
    }
}
