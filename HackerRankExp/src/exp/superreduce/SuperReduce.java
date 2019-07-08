package exp.superreduce;

import java.util.Scanner;

public class SuperReduce {
    static String super_reduced_string(String input){
        int len = input.length();
       int i = 0;
       while (i < len - 1) {
           char current = input.charAt(i);
           char next = input.charAt(i+1);

           if (current == next) {
               input = input.substring(0, i) + input.substring(i+2);
               len = input.length();
               i = 0;
               continue;
           }
           i++;
       }
       if (input.length() == 0) {
           return "Empty String";
       }
       return input;
   }

   public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       String s = in.next();
		String result = super_reduced_string(s);
       System.out.println(result);
   }

}
