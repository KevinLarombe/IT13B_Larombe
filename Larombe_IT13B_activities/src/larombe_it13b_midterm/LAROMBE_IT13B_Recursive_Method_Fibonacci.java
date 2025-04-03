
package larombe_it13b_midterm;

public class LAROMBE_IT13B_Recursive_Method_Fibonacci {
    public static void main(String[] args){
        int n = 10;
        System.out.print ("The Fibonacci Sequence is: ");
        for (int i = 0; i < n; i++){
            System.out.print(fibonacci(i) + " ");
           
            
        }
    }
    public static int fibonacci(int n){
        if (n <= 1){
            return  n;
            
        }
        return fibonacci(n-1)+ fibonacci(n-2);
    
    }
}

