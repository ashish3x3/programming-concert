
public class MaxSumSubMatrix {

	public static void main(String[] args) {
		new MaxSumSubMatrix().calculate();

	}
	
	public int x1,x2,max;
	
	public void calculate(){
		
		int [][] arr=new int[][]{   {9,7,-3,2},
									{5,8,2,-8},
									{0,-3,5,3},
									{-5,4,3,-7}
								};
		
		int maxSum=0;
		int finalX1,finalY1,finalX2,finalY2;
		finalX1=finalX2=finalY1=finalY2=0;
		
		int [] temp=new int[arr[0].length];
		
		for(int y1=0;y1<arr.length;++y1)
		{
			for(int k=0;k<arr[y1].length;++k)
				temp[k]=0;
			for(int y2=y1;y2<arr.length;++y2){   //will check for every possible position
				for(int j=0;j<arr[y1].length;++j)    // ---of y2 end as y1 is starting for 
					                                    //--this entire computation
					temp[j]+=arr[y2][j];
				for(int j=0;j<arr[y1].length;++j) 
					System.out.print("\t " + temp[j]);
				kadane(temp);
				
				if(max>maxSum){
					maxSum=max;
					finalX1=x1;
					finalX2=x2;
					finalY1=y1;
					finalY2=y2;
								
				}		
		//	System.out.print("max Sum = "+ maxSum);	
					
			}
	
		}
		
		System.out.println("max sum = " + maxSum);
        System.out.println("from: " + finalX1 + ", " + finalY1);
        System.out.println("to: " + finalX2 + ", " + finalY2);
		
		for(int i=finalX1;i<=finalX2;++i){
			for(int j=finalY1;j<finalY2;++j){
				System.out.print(" "+ arr[i][j] );
			}
			System.out.println("");	
			
			
		}
	}
	
	
	public void kadane(int [] input){
		
		int currSum=0;
		x1=x2=0;
		int startIndex=0;
		
		for(int i=0;i<input.length;++i){
			currSum+=input[i];
			
			if(currSum>max){
				
				max=currSum;
				x1=startIndex;
				x2=i;
				
				
			}
			if(currSum<0){   //if first element is -ve..-8,5,3,-6
				
				startIndex=i+1;
				currSum=0;
				
				
			}
			
			
			
		}
		
		
		
	}
		

}
