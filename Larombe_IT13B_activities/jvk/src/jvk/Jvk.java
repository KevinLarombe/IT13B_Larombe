/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jvk;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Jvk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        
        // Declare an array to store 5 numbers
        int[] numbers = new int[5];
        
        // Ask the user to input 5 numbers
        System.out.println("Please enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        // Initialize variables to keep track of the most frequent number
        int mostFrequent = numbers[0];
        int maxCount = 1;
        
        // Find the frequency of each number and track the most frequent one
        for (int i = 0; i < numbers.length; i++) {
            int count = 1;  // Start counting the occurrences of numbers[i]
            
            // Count how many times numbers[i] appears in the array
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;  // Increment count if numbers match
                    numbers[j] = -1;  // Mark the number as counted
                }
            }
            
            // Update the most frequent number if necessary
            if (count > maxCount) {
                mostFrequent = numbers[i];
                maxCount = count;
            }
        }
        
        // Output the result
        System.out.println("\nThe most frequent number is " + mostFrequent + " which appeared " + maxCount + " times.");
        
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}

        
 