import java.util.Arrays;


public class BinaryNumberSorting {
	
	public static void main(String[] args){
		
		int [] arr={0,1,0,0,1,1,0};
		System.out.println(""+Arrays.toString(arr));
		sort(arr);
		System.out.println(""+Arrays.toString(arr));
		
	}
	
	public static void sort(int [] arr){
		
		int begin=0;
		int end=arr.length-1;
		while(begin<end){
			
			if(arr[begin]==0)
				begin++;
			else if(arr[end]==1)
				end--;
			else{
				   arr[begin]=0;
				   arr[end]=1;
				
			 }
			}
			
			
		}
		
		
	

}
