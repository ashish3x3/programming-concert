/*Suppose you have a string S which has length N and is indexed from 0 to N−1. String R is the reverse of the string S. The string S is funny if the condition |Si−Si−1|=|Ri−Ri−1| is true for every i from 1 to N−1.

(Note: Given a string str, stri denotes the ascii value of the ith character (0-indexed) of str. |x| denotes the absolute value of an integer x)

Input Format

First line of the input will contain an integer T. T testcases follow. Each of the next T lines contains one string S.

Constraints

    1<=T<=10
    2<=length of S<=10000

Output Format

For each string, print Funny or Not Funny in separate lines.

Sample Input

2
acxz
bcxz

Sample Output

Funny
Not Funny

Explanation

Consider the 1st testcase acxz

here

|c-a| = |x-z| = 2
|x-c| = |c-x| = 21
|z-x| = |a-c| = 2

Hence Funny.

Consider the 2st testcase bcxz

here

|c-b| != |x-z|
*/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FunnyString {

    public static void main(String[] args) {
        int T;
        Scanner scan=new Scanner(System.in);
        T=scan.nextInt();
        String str,rev;
        while(T-- >0){
            str=scan.next();
            int j,k,l,m,a,b,i=-1;
            rev=new StringBuffer(str).reverse().toString();
            for( i=1;i<str.length();++i){

                /*if((Math.abs(((int)(str.charAt(i))-(int)(str.charAt(i-1))) != Math.abs(((int)(rev.charAt(i))-(int)(rev.charAt(i-1)) )))))  
                            break;*/
                            j=str.charAt(i);
                             k=str.charAt(i-1);
                              l=rev.charAt(i);
                               m=rev.charAt(i-1);
                               a=j-k;
                               b=l-m;
                               if(Math.abs(a) != Math.abs(b))
                                break;






            }
                            if(i==str.length())
                            System.out.println("Funny");
                            
                            else
                            System.out.println("Not Funny"); 
                            
            
            
        }
    }
}