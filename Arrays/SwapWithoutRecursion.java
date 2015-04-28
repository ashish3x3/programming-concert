import java.util.Arrays;


public class SwapWithoutRecursion {

	public static void main(String[] args) {
		int [] array= {1,2,4,5,6};
		System.out.println(Arrays.toString(array));
		int [] rev=reverse(array,0,array.length-1);
		//System.out.println(Arrays.toString(rev));
		for(int i:rev)
            System.out.print(i+" ");
	}
	
	public static int[] reverse(int [] array,int start,int end){
		
		if(start<end){
			 int temp = array[start];
			array[start]=array[end];
			array[end]=temp;
			reverse(array,start+1,end-1);
		}
		
	
		return array;
}
}
