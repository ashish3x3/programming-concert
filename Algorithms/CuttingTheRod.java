

/*
 * Given a rod of length n units and price of all pieces smallerthan n find the most benificial way of cuttin the rod...

length  1   2   3   4    5   6   7   8
Price   1   5   8   9    10  17  17  20

		max{v[k]+b[i-k]}...k<=i...  v[k] is price of all given arr...1,5,8,9,10..
 */
public class CuttingTheRod {

	public static void main(String[] args) {
		int [] arr={1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println("Maximum Value is = " + cutRod(arr));

	}
	
	public static int cutRod(int [] arr){
		
		int [] b=new int[arr.length+1];
		
		b[0]=0;
		
		for(int i=1;i<=arr.length;++i){
			
			int q=Integer.MIN_VALUE;
			for(int j=0;j<i;++j){
				q=Math.max(q, arr[j]+b[i-j-1]);
				b[i]=q;
				
				
			}
			
			
		}
		
		return b[arr.length];   //best way of cutting rod into 8 pieces...length =8
		
	}

}
