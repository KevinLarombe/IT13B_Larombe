package larombe_it13b_midterm;

public class LAROMBE_CUARTEROS_SINGLE_AND_MULTIDIMENSIONAL_ARRAY1 {

    public static void main(String[] args) {
       
       char letters[] = {'A','B','C','D','E','F','G'};
       
        for (char a = 0; a < letters.length; a++) {
           System.out.print(letters[a] + "," );
           
       }
        System.out.println();
        
       int numbers [][] = {
           {21, 22, 23, 24},
           {25, 26, 27, 28},
           {29, 30, 31, 32}
       };
       for (int a = 0; a< numbers.length; a++){
           System.out.print ("The Numbers in Row " + (a + 1) + ": ");
           for (int b = 0; b< numbers[a].length; b++){
             System.out.print(numbers[a][b] + " ");
           }
           System.out.println();
       }
    }
}
