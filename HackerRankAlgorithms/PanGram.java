/*
 * 

Problem Statement

Roy wanted to increase his typing speed for programming contests. So, his friend advised him to type the sentence "The quick brown fox jumps over the lazy dog" repeatedly because it is a pangram. ( pangrams are sentences constructed by using every letter of the alphabet at least once. )

After typing the sentence several times, Roy became bored with it. So he started to look for other pangrams.

Given a sentence s, tell Roy if it is a pangram or not.

Input Format

Input consists of a line containing s.

Constraints
Length of s can be atmost 103 (1≤|s|≤103) and it may contain spaces, lowercase and uppercase letters. Lowercase and uppercase instances of a letter are considered same.

Output Format

Output a line containing pangram if s is a pangram, otherwise output not pangram.

Sample Input #1

We promptly judged antique ivory buckles for the next prize    

Sample Output #1

pangram

Sample Input #2

We promptly judged antique ivory buckles for the prize    

Sample Output #2

not pangram

Explanation

In the first testcase, the answer is pangram because the sentence contains all the letters.
Suggest Edits


 */


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.*;

public class PanGram {

    public static void main(String[] args) {
       char [] pan=new char[26];
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        checkPan(str);
        
        
        
    }
    public static void checkPan(String str){
        int [] ch=new int[26];
       for(int i=0;i<str.length();++i){
    	   if(str.charAt(i)!=' '){
    		  // System.out.print(str.charAt(i));
    		   //System.out.print(str.toLowerCase().charAt(i)-97);
           ch[str.toLowerCase().charAt(i)-97]++;
    	   }
           
       
       }
       //for(int i=0;i<ch.length;++i)
    	 //  System.out.print(" "+ch[i]);
       
       int flag=0; 
      for(int i=0;i<ch.length;++i){
    	 // System.out.println("pangram inside loop");
          if(ch[i]==0){
              flag=1;
          break;
      }
      }
        
         if(flag==0)
        System.out.println("pangram");
    else
        System.out.println("not pangram");
          
      }  
       
        
        
    }
    
    
    
    
    
