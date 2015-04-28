
public class RotateMatrix90 {

	public static void main(String[] args) {
		
		int [][] ar={
				
				{1,2,3,4},
				{5,6,7,8},
				{9,0,1,2},
				{3,4,5,6}
				
		};
		
		for(int i=0;i<ar.length;++i){
			for(int j=0;j<ar.length;++j){
		System.out.print("  "+ar[i][j]);
			}
			System.out.print("\n");
		}
		
		rotateAndPrintWithExtraSpace(ar);
		rotateAndPrintWithoutExtraSpace(ar);
	}
	
	public static void rotateAndPrintWithExtraSpace(int [][] ar){
		int [][] ar1=new int[ar.length][ar.length];
		System.out.println(""+ar.length);
		
		for(int i=0;i<ar.length;++i){
			for(int j=0;j<ar.length;++j){
				ar1[i][j]=ar[ar.length-1-j][i];
				
				
			}
			
		}
		
		for(int i=0;i<ar.length;++i){
			for(int j=0;j<ar.length;++j){
		System.out.print("  "+ar1[i][j]);
			}
			System.out.print("\n");
		}
		
		/* Time complexity - O(n^2)
		Space complexity - O(n^2) 
		*/
		
	}
	
	public static void rotateAndPrintWithoutExtraSpace(int [][] ar){
		
		int N=ar.length;
		int temp=0;
		
		for(int i=0;i<N/2;++i){
			for(int j=0;j<N/2;++j){
				temp=ar[i][j];
				ar[i][j]=ar[N-1-j][i];
				ar[N-1-j][i]=ar[N-1-i][N-1-j];
				ar[N-1-i][N-1-j]=ar[j][N-1-i];
				ar[j][N-1-i]=temp;
				
				
				
			}
			
			
		}
		System.out.print("\n");
		System.out.print("======================================\n");
		for(int i=0;i<ar.length;++i){
			for(int j=0;j<ar.length;++j){
		System.out.print("  "+ar[i][j]);
			}
			System.out.print("\n");
		}
		
		/* Time complexity - O(n^2)
		Space complexity - O(1) 
		*/
		
		
		
		
		
		
		
	}

}
