/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package larombe_it13b_activities;

import java.util.Scanner;
public class Lab_act1_Arithmetics {
    public static void main (String args []){
                
    int x;
    int y;
    int z;
    Scanner in = new Scanner (System.in);
    System.out.println("Enter num1: ");
    x= in.nextInt();
    System.out.println("Enter num2: ");
    y= in.nextInt();
    System.out.println("Enter num3: ");
    z= in.nextInt();    
    System.out.println(x + " * " + y + " + " + z + " = " + (x * y + z));
    System.out.println("(" + x + " - " + y + ")" + " % " + z + " = " + ((x - y) % z));
    System.out.println("(" + x + " + " + y + " + " + z + " ) " + " / " + 3 + " = " + (( x + y + z) / 3));
    System.out.println(x + " * " + z + " - " + "(" + y + " * " + y + ")" + " = " + (x * z - ( y * y )));
    
    }
}
