/* DP Problem #2: Maximum number of apples
        A table composed of NxM cells, each having a certain quantity of apples, 
        is given. You start from the upper-left corner. 
        At each step you can go down or right one cell.
         Find the maximum number of apples you can collect.
         */
public class MaxAppleDPinNXM {

	public static void main(String[] args) {
		/*int [][] ar={
			
			{1,2,3},
			{4,6,2},
			{1,3,7}    // ans =21--1,2,6,3,7
			
		};
		*/
		int [][] ar= {    
			 {1,2,3,4,5,6,7,8,9,0},
             {2,4,6,8,0,1,3,5,7,9},
             {1,1,1,1,1,1,1,1,1,1},
             {3,5,7,9,2,4,6,7,4,3},
             {3,3,3,6,4,6,2,3,4,6},
             {4,9,1,3,1,8,8,1,5,2},
             {2,1,0,3,9,2,4,3,6,7},
             {0,0,6,9,8,9,6,1,0,9},
             {9,4,4,5,1,5,6,6,6,5},
             {9,8,4,1,0,1,0,1,4,1}};  //ans==99
		
		maxApple(ar);

	}
	
	public static void maxApple(int [][] ar){
		
		int N=10,M=10;
		int s[][]=new int[10][10];
		
		for(int i=0;i<N;++i){
			
			for(int j=0;j<M;++j){
				
				s[i][j]=0;
				s[i][j]=ar[i][j]+Math.max(i>0?s[i-1][j]:0, j>0?s[i][j-1]:0);
				
			}
		}
		
		System.out.println("max Apple="+s[N-1][M-1]);
		
	}

}
