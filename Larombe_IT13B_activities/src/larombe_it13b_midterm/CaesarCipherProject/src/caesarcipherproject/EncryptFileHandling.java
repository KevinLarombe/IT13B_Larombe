package caesarcipherproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptFileHandling {

    public static String encrypt(String plainText, int shift) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                int originalAlphabetPosition = currentChar - base;
                int shiftedAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                char encryptedChar = (char) (base + shiftedAlphabetPosition);
                cipherText.append(encryptedChar);
            } else {
                cipherText.append(currentChar);
            }
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\User\\Documents\\GitHub\\IT13B_Larombe\\Larombe_IT13B_activities\\src\\larombe_it13b_midterm\\CaesarCipherProject\\src\\caesarcipherproject\\input.txt";
        String outputFile = "encrypted.txt";
        int shift = 3; 

        try (Scanner reader = new Scanner(new File(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            System.out.println("Reading from: " + inputFile);
            System.out.println("Encrypting with shift: " + shift);
            System.out.println("Writing to: " + outputFile);
            System.out.println("----------------------");
            System.out.println("Encrypted Message:");

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String encryptedLine = encrypt(line, shift);
                System.out.println(encryptedLine); 
                writer.write(encryptedLine + System.lineSeparator()); 
            }

            System.out.println("----------------------");
            System.out.println("Encryption successful. Check " + outputFile + " for the encrypted message.");

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}