
package lab_exercise.pkg2_find.the.greatest.number;

import java.util.Scanner;

public class Lab_Exercise2_FindTheGreatestNumber {

  
   public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        
        
        System.out.println("enter first number: ");
        int A = in.nextInt();        
        
        System.out.println("enter second number: ");
        int B = in.nextInt();
        
        System.out.println("enter third number: ");
        int C = in.nextInt();
        
        
        int D = A;
        if (B > D) {
            D = B;
        }
        if (C > D) {
            D = C;
        }
        
        
        System.out.println("The greatest among the three numbers is: " + D);
        
        in.close();
        
    }
}