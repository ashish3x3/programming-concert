import java.util.ArrayList;
import java.util.List;

public class MinSumFibbnoci {
	
	public static int minFiboSum(int n) {
		List<Integer> fiboNums = new ArrayList<Integer>();
		int a=1,b=1,c=1;
		while(true) {
			c = a+b;
			if(c<=n)
				fiboNums.add(c);
			else break;
			a = b;
			b = c;
		}
		int minSum[] = new int[n+1];
		minSum[0] = 0;
		for(int i = 1;i<=n;i++) {
			minSum[i] = n; 
			for(Integer fibo : fiboNums) {
				int k = fibo;
				int steps = 0;
				if(k<=i) {
					steps = minSum[i-k] + 1;
					System.out.println("minSum[i-k]"+minSum[i-k]);
					minSum[i] = Math.min(minSum[i], steps);
					System.out.println("minSum[i]"+minSum[i]);
						
				}
				else break;
			}
		}
		return minSum[n];
	}
	public static void main(String args[]) {
		System.out.println(minFiboSum(7));
		System.out.println(minFiboSum(70));
	}
}