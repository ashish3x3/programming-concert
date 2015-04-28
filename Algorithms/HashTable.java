
public class HashTable {
	
	int [] arr;
	public int capacity;
	
	public HashTable(int x){
		this.capacity=nextPrime(x);
		arr=new int[this.capacity];
		this.initilizeHash();
		
	}
	
	public void initilizeHash(){
		
		for(int i=0;i<capacity;++i)
			arr[i]=0;
		
	}
	
	public static int nextPrime(int num){
		
		if(num%2==0)
			num++;
		
		for(;!isPrime(num);num=num+2);
		
		return num;
		
	}
	
	public static boolean isPrime(int num){
		
		if(num==2)
			return true;
		
		if(num==1)
			return false;
		
		for(int i=2;i<Math.sqrt(num);++i){
			if(num%i==0)
				return false;
			
			
		}
		return true;
		
	}
	
	public int valueOf(int ele){
		
		return arr[ele % capacity];
	}
	
	public  void insert(int count,int key){
		
		arr[key % this.capacity]=count;
		
		
	}
	
	public void clear(){
		
		arr=new int[capacity];
		
	}
	
	public boolean contains(int ele){
		
		return arr[ele % capacity]==ele;
		
	}
	
	public int count(int ele){
		
		return arr[ele % capacity];
		
	}
	
	public void delete(int ele){
		
		if(arr[ele % capacity]==ele)
			arr[ele % capacity]=0;
		else
			System.out.println("Element dose not found");
		
	}
	
	public void printTable(){
		
	System.out.println("Hash Table = ");
	for(int i=0;i<capacity;++i)
		System.out.print(arr[i]+" ");
	
	System.out.print(" ");
	
	}
	

}
