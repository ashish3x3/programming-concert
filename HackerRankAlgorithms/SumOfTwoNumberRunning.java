import java.util.*;
public class SumOfTwoNumberRunning {
	
	public static void main(String [] args){
	
	Scanner scan=new Scanner(System.in);
	
	int N=scan.nextInt();
	int [] arr=new int[N];
	int a,b;
	
	System.out.println("Enetr the number pair");
	
	
	for(int i=0;i<N;++i){
		
		a=scan.nextInt();
		b=scan.nextInt();
		arr[i]=a+b;
		
		
	}
	
	for(int i=0;i<N;++i){
		System.out.println(""+arr[i]);
		
	}
	}
}
/*
You are given two numbers a and b. Your task is to find the sum of two numbers.

Input
The first line contains an integer t, denoting the number of test cases. Next t lines contain two integers, a and b separated by a space.

 Sample Input (Plaintext Link)
1
1 2
Sample Output (Plaintext Link)
3
*/

/*
if(t>=1&&t<=1000000000)
{
int t1[]=new int[t];
for(i=0;i<t;i++)
{
a=s.nextInt();
b=s.nextInt();
if(a>=1&&a<=1000000000&&b>=1&&b<=1000000000)
{
t1[i]=a+b;
}
}
*/