import java.util.Arrays;
import java.util.Scanner;


public class NextLexo {

	public static void main(String[] args) {
		int [] arr;
		System.out.println("enter size of N");
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		arr=new int[N];
		
		System.out.println("Enetr elememts space separated");
		
		for(int i=0;i<arr.length;++i){
			
			arr[i]=scan.nextInt();
			
		}
		
		System.out.println("Original Array = " + Arrays.toString(arr)); 
		
		boolean b=nextLexoPermutation(arr);
		
		if(b==true){
			
			System.out.println("Next Lexo order = " + Arrays.toString(arr)); 
		}
		else
			System.out.println("It is the last lexo order");
		
		
	}
	
	public static boolean nextLexoPermutation(int [] arr){
		//step 1
		
		//Arrays.sort(arr);
		//System.out.println(" "+ arr.toString());
		
		// step 2
		//look for i a[i]<a[i+1]
		
		int i=arr.length-2;
		//serach for elemnt smaller than previous so to intchang them
		while(i>=0 && arr[i]>arr[i+1])   
			i--;
		
		if(i== -1)
			return false;
		else{
		// step 2
		// search for k>i such that arr[i]<arr[k] and arr[k]<arr[peak]
		//search forelemnt that is gratr than i  between i+1 to n...which is least 
			//and amx then a[i]
		int j=arr.length-1;
		
		while(arr[j] < arr[i] )    //&& j>i
			j--;
		
		swap(arr,i,j);
		reverse(arr,i+1);     //basically sort to make it least after swap point
		
		}
		return true;
	}
	public static void swap(int [] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		
	}
	
	public static void reverse(int [] arr,int n){
		
		
		
		for(int i=n,j=arr.length-1;j>i ;++i,--j ){
			
			swap(arr,i,j);
					
		}
		
		
	}

}
