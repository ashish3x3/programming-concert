
public class MinCoinToS {

	public static void main(String[] args) {
		int [] v={2,2,1};     //2,2,2 s=11 not posible 1,3,5 s=11 ==3(5,5,1)
		int s=11;
		minCoin(v,s);

	}

	public static void minCoin(int [] v,int sum){
		
		Integer [] S=new Integer[sum+1];
		
		for(int i=0;i<S.length;++i)
			S[i]=Integer.MAX_VALUE;
		
		S[0]=0;
		
		for(int s=1;s<=sum;++s ){   //to make sum=1 how many of v[n] will be required..
			for(int n=0;n<v.length;++n){     //--sim for s=2,3...if sum=1 and v[n] >1..
							//continue as this v[n] cannot be used to make up coin s=1..
				if(v[n]>s)continue;
			 if(v[n]<=s && S[s-v[n]]+1<S[s]){
					S[s]=S[s-v[n]]+1;
					
				}
				
				
			}
			System.out.println(" \n");
			
			for(int i=0;i<S.length;++i)
				System.out.print(" "+S[i]);
				
			if(S[s]==Integer.MAX_VALUE)
				System.out.println("not possible");
			
		}
		
		System.out.println(" S["+sum+"]="+S[sum]);
		
		
		
	}
}
