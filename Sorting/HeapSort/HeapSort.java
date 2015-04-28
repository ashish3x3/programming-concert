import java.util.Scanner;


public class HeapSort {
	
	private static int left;
	private static int right;
	private static int max;
	private static int [] arr;
	private static int n;
	private static int len;
	
	
	public static void main(String [] args){
		
		System.out.println("Enter the Nukmber of Element you want in an array");
		
		//Scanner scan = new Scanner(System.in);
		Scanner scan = new Scanner( System.in );
		 n=scan.nextInt();
		 
		 arr= new int[n];
		 
		 for(int i=0;i<n;++i){
			 arr[i]= scan.nextInt();
		 }
		 Heapsort(arr);
		 
		 System.out.println("after sorting");
		 
		 for(int i=0;i<n;++i){
			 
			 System.out.println(""+ arr[i]);
		 }
		 
		
	} // end of main
	
	public static void Heapsort(int [] arr){
		
		BuildHeap(arr);
		int len=arr.length-1;
		for(int i=len ;i>0;--i ){
			
			swap(arr,0,i);
			len=len-1;
			MaxHeapify(arr,0);
		}
		
		
	} // heapsort

	
	public static void BuildHeap(int [] arr){
		len=arr.length-1;
		for(int i=len/2;i>=0;--i)
			MaxHeapify(arr,i);
		
		
	} // BuildHeap
	
	public static void MaxHeapify(int [] arr, int i){
		left=2*i;
		right=2*i+1;
		 max=i;
		if(left <=len && arr[left]>arr[i])
			max=left;
		if(right<=len && arr[right]>arr[max])
			max=right;
		
		if(max!=i){
			swap(arr,i,max);
		MaxHeapify(arr,max);
		}
		
		
	} //end of heapify
	
	public static void swap(int [] arr,int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		
	} //end of swap
	
	
	
}// class
