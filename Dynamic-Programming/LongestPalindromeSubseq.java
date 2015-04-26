/*
    A teacher play a interesting game in the class. He select some n students of the class and make a row of these n students(where 0<=n<=1000). He makes the row randomly. He puts a very interesting question to the remaining student of the class. He told them to select some of the student out of the row such that when we make the string using the first character of their names ( consider only the first name) that string becomes a palindrome (Palindrome is a string which is equal to the reverse of itself for example ASPDPSA) of the longest length possible. The condition is that the string which is constructed using the first character of students should be constructed in a way that the characters should come in the same order in which the students are standing in the row. You have to answer the length of longest possible palindrome. Input/Output Specifications

Input Specification:
a list of students
Output Specifications :
length of longest palindrome constructed using the first characters of students in any sublist of the input student list

Output:
Enetr the string name array
Bharti Bharat akash bahvya chand brijesh chetak arvind bhavna

res=5 
*/


import java.util.*;


public class LongestPalindromeSubseq{

		public static void main(String [] args){

			Scanner scan=new Scanner(System.in);
			//System.out.println("Enetr the string name array");

			String str1=scan.nextLine();   // ashish kumar singh

			String [] arr=str1.split("\\s+");

			char [] ch=new char[arr.length];

			for(int i=0;i<arr.length;++i){
				//System.out.println(""+arr[i]);
				ch[i]=arr[i].charAt(0);

			}

			String str=new String(ch);
			//System.out.println(""+str);
			int res=getLongestPalindromicSubSequenceSize(str);
			System.out.println(""+res);


		} //main

		public static int getLongestPalindromicSubSequenceSize(String source){
			int n = source.length();
			int[][] LP = new int[n][n];

    //All sub strings with single character will be a plindrome of size 1
			for(int i=0; i < n; i++){
				LP[i][i] = 1;
			}
    //Here gap represents gap between i and j.
			for(int gap=1;gap<n;gap++){
				for(int i=0;i<n-gap;i++ ){
					int j=i+gap;
					if(source.charAt(i)==source.charAt(j) && gap==1)
						LP[i][j]=2;
					else if(source.charAt(i)==source.charAt(j))
						LP[i][j]=LP[i+1][j-1]+2;
					else
						LP[i][j]= Math.max(LP[i][j-1], LP[i+1][j]);              
				}      
			}       
			return LP[0][n-1];  

			
				//Rebuilding string from LP matrix
			/*
			StringBuffer strBuff = new StringBuffer();
			int x = 0;
			int y = n-1;
			while(x < y){
				if(source.charAt(x) == source.charAt(y)){
					strBuff.append(source.charAt(x));
					x++;
					y--;
				} else if(LP[x][y-1] > LP[x+1][y]){
					y--;
				} else {
					x++;
				}
			}
			StringBuffer strBuffCopy = new StringBuffer(strBuff);
			String str = strBuffCopy.reverse().toString();
			if(x == y){          
				strBuff.append(source.charAt(x)).append(str);
			} else {
				strBuff.append(str);
			}
			return strBuff.toString();
			*/
			  
		}  //func
 

} //cllass