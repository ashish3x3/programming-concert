import java.util.Scanner;


public class BinomialCoefficient {
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		
		System.out.println("enter N and K");
		int n=scan.nextInt();
		int k=scan.nextInt();
		System.out.println(""+nCk(n,k));
		scan.close();
		
		
	}
	
	static int nCk(int n, int k)
	{
	int dp[][] = new int[n+1][k+1];
	for(int i=0; i<=n; i++)
	for(int j=0; j<=Math.min(i,k); j++)
	{
	if(j==0 || j==i)
	dp[i][j] = 1;
	else
	//dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
		dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
	}
	/*for(int i=0; i<=n; i++)
	{
	for(int j=0; j<=k; j++)
	System.out.print(dp[i][j]+" ");
	 
	System.out.println();
	}*/
	 
	return dp[n][k];
	}
	/*
	public static long nCk(int n,int k){
		
		long[][] dp = new long[n+1][k+1];

        // base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= k; j++) {
            dp[0][j] = 0;
        }

        // bottom-up dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
            }
        
		
		
	}
        return dp[n][k];

}
*/
}

