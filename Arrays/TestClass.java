import java.util.*;
import java.*;

 class TestClass{

	public static int [][] arr=null;
	public static int [][] dp=null;
	
		static Scanner scan=new Scanner(System.in);

		public static void main(String [] args){

			int N,M,T;
			int min;
			int count=0;
			
		

			N=scan.nextInt();
			M=scan.nextInt();

			arr=new int[N][M];
			dp=new int[N+1][M+1];
			String str;

			for(int i=0;i<N;++i){
				str=scan.next();
				for(int j=0;j<M;++j){

					arr[i][j]=str.charAt(j)-'0';
					
					
				/*if(scan.hasNextInt())
					arr[i][j]=scan.nextInt();*/

				}
			}

			for(int i=0;i<M+1;++i)
				dp[0][i]=0;


			for(int i=0;i<N+1;++i)
				dp[i][0]=0;

			for(int i=1;i<N+1;++i){
				for(int j=1;j<M+1;++j){
					
					if(arr[i-1][j-1]==0){
					min=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
					dp[i][j]=min+1;
					}

					else
						dp[i][j]=0;

				}
			}


			count =0;
			for(int i=1;i<N+1;++i){
				for(int j=1;j<M+1;++j){
					if(dp[i][j]!=0)
						count+=dp[i][j];

				}
			}

			System.out.println(""+count);

	//	}//t





		}//main

}//class