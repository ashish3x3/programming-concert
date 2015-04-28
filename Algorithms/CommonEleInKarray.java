
public class CommonEleInKarray {

	public static void main(String[] args) {
		
		//HashTable ht=new HashTable(60);
		int arr[] ={4,0,1,3,2,6,9,21,10,11,5,7,2};
		
		int arr1[] ={4,0,1,7,2,5,9,14,10,34,5,7,2};
		
		int arr2[] ={4,0,1,7,2,5,10,16,17,37,55,74,2};
		
		int arr3[] ={4,0,1,17,21,25,29,34,40,54,15,17,12};
		
		int n=4;
		commonElement(arr,arr1,arr2,arr3, n);

	}
	
	public static void commonElement(int [] arr,int [] arr1,int [] arr2,int [] arr3,int n){
		
		int num=1;
		HashTable ht=new HashTable(60);
		
		ht.printTable();
		
		for(int i=0;i<arr.length;++i){
			if((ht.count(arr[i]))== num-1){
			   //int m=ht.valueOf(arr[i]);	
			 ht.insert(ht.count(arr[i])+1, arr[i]);	 
			 
			}
		}
		num++;
		//ht.printTable();
		
		
		for(int i=0;i<arr1.length;++i){
			if((ht.count(arr1[i]))== num-1){
			   //int m=ht.valueOf(arr[i]);	
			 ht.insert(ht.count(arr1[i])+1, arr1[i]);	 
			 
			}
		}
		num++;
		//ht.printTable();
		
		for(int i=0;i<arr2.length;++i){
			if((ht.count(arr2[i]))== num-1){
			   //int m=ht.valueOf(arr[i]);	
			 ht.insert(ht.count(arr2[i])+1, arr2[i]);	 
			 
			}
		}
		num++;
		//ht.printTable();
	
		 
		for(int i=0;i<arr3.length;++i){
			if((ht.count(arr3[i]))== num-1){
			   //int m=ht.valueOf(arr[i]);	
			 ht.insert(ht.count(arr3[i])+1, arr3[i]);	 
			 
			}
		}
		
		ht.printTable();
		
		System.out.println("--------------------------------------------------");
		
		for(int i=0;i<arr.length;++i){
			if(ht.count(arr[i])==n){
				
				System.out.println(""+arr[i]);
				}
		
	}

	
		
	}

}
 