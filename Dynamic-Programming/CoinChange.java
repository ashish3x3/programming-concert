import java.util.*;

/*
H:\Computer Science\Java\MyHackerRank\Dynamic program
Enet N and M
4 3
Enetr M coins with space
1 2 3
4

H:\Computer Science\Java\MyHackerRank\Dynamic program
Enet N and M
10 4
Enetr M coins with space
2 3 5 6
5



    Example 1: For N=4 and C={1,2,3} there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}

    Example 2: For N=10 and C={2,5,3,6} there are five solutions: {2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5}.


*/


public class CoinChange{


	public static int [] arr=null;

	public static void main(String[] args){

		int N,M;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enet N and M");
		N=scan.nextInt();
		M=scan.nextInt();
		System.out.println("Enetr M coins with space");
		arr=new int[M];

		for(int i=0;i<M;++i)
			arr[i]=scan.nextInt();

		int res=find(N,M);
		System.out.println("" + res);
	}//main

	public static int find(int N,int M){


		int [] min=new int[N+1];
		Arrays.fill(min,0);
		int max=0;
		//Used to indicate that a solution exists when
        // a coin equal to current sum is used.
        // i.e. sums[sumK-coin] should return 1 when sumK equals coin
		min[0]=1;

		 // Pick all coins one by one and update the lookup 'sums'
        // to indicate the effect of introducing that coin
		for(int i=0;i<M;++i){
			// For sums less than current coin value, there would be
            // no effect of introducing this coin, hence we begin from  
            // the sum atleast equal in value to current coin
			for(int j=arr[i];j<=N;++j){
				min[j]=min[j]+  //// current coin is not used
					min[j-arr[i]];   //// current coin is used
			}
		}

		/*for(int i=1;i<min.length;++i){
			for(int j=0;j<M;++j){
				if(arr[j]>i)
					continue;

				max=Math.max(min[i-arr[j]],max);
			}
			min[i]=max+1;
		}*/

		return min[N];
	}
}