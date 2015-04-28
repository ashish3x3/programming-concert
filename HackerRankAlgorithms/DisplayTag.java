/* IMPORTANT: class must not be public. */


 //uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class DisplayTag {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        */

       // System.out.println("Hello World!");
       
       Scanner scan=new Scanner(System.in);
       int N=scan.nextInt();
       int [] arr=new int[N];
       
       for(int i=0;i<N;++i){
       	arr[i]=scan.nextInt();
       	
       	
       }
       int j=0;
       
       for(int i=0;i<N;++i){
    	   j=1;
    	   while(j<=arr[i]){
       	
       	 if(j%3==0 && j%5==0)
           	System.out.println("FizzBuzz");
       else if(j%5==0)
       	System.out.println("Buzz");
       	else if (j%3==0)
       	System.out.println("Fizz");
       	else
       	System.out.println(""+j);
       	j++;
       	
    	   }
       }
       
       
    }
}

/*
 * 
Input

2
3 15

Your Code's Output

1
2
Fizz
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
*/
/*
 * Write a program that prints the numbers in the given range. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”. Print a new line after each string or number.

Input Format First line will be the number of testcases, T. Next line will have T integers, denoted by N.

Output Format For each testcase, print the number from 1 to N. But follow the rules given in the problem statement.
*/
