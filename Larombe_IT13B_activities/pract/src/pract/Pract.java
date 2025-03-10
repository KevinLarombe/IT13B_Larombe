/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pract;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Pract {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);
       
       int numbers[] = new int[5];
       
       System.out.println("Enter 5 numbers:"); 
       for (int i = 0;i < numbers.length;i++) {
           System.out.println("Enter number"+(i+1)+":");
           numbers[i]= scanner.nextInt();
       }
       
       int mostfrequent=numbers[0];
       
       for (int i = 0;i < numbers.length;i++){
           int count=1;
       }
         System.out.println("\nThe most frequent number is " + mostfrequent + " .");
         
          scanner.close();
    }
   
}


        
    
    

