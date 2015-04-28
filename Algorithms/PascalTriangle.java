import java.util.Scanner;


public class PascalTriangle {
	
	
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		
		System.out.println("enter N ");
		int n=scan.nextInt();
		
		printPascal(n);
		
		//System.out.println("");
		scan.close();
		
		
	}
	
	public static void printPascal(int n){
		
	    for (int i = 0; i < n; i++)

	    { int val = 1;

	        for (int j = 1; j < (n - i); j++)

	        {

	        	System.out.print(" ");

	        }

	        for (int k = 0; k <= i; k++)

	        {

	           // cout << "      " << val;
	        	System.out.print(" "+ val);

	            val = val * (i - k) / (k + 1);

	        }

	       System.out.println(" ");

	    }

		
		
		
		int p[][]=new int[n][n];
		
		for(int i=0;i<n;++i){
			for(int j=0;j<=i;++j){
				
				if(i==j || j==0)
					p[i][j]=1;
				else
					p[i][j]=p[i-1][j]+p[i-1][j-1];
				
				System.out.print(" " + p[i][j]);
				
				
			}
			System.out.println("");
		
		}
		
		
	//}
	

}
}
