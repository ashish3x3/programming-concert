import java.util.Arrays;


public class ProductSumOfReaminingArray {

	public static void main(String[] args) {
		int [] arr={2,2,3,4,5,6};
		System.out.println(""+Arrays.toString(arr));
		int[] ans=product(arr);
		System.out.println(""+Arrays.toString(ans));
		
	}
	
	public static int[] product(int [] arr){
		int [] pro=new int[arr.length];
		int p=1;
		int aboveArr[]=new int[arr.length];
		for(int i=0;i<arr.length;++i){
			aboveArr[i]=p;
			p*=arr[i];
		}
		
		for(int i=0;i<arr.length;++i){
			
			System.out.print("  "+aboveArr[i]);
		}
		int [] belowArr=new int[arr.length];
		p=1;
		for(int i=arr.length-1;i>=0;--i){
			belowArr[i]=p;
			p*=arr[i];
		}
		
		for(int i=0;i<arr.length;++i){
			
			pro[i]=aboveArr[i]*belowArr[i];
			
		}
		
		
		return pro;
	}

}
