import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;


public class Sum2Problem {

	public static void main(String[] args) {
		int arr[] ={4,0,1,3,2,6,9,21,10,11,5,7,2};
		
		int sum=8;
		
		Sum2Problem(arr,sum);
		
		System.out.println("---------------------");
		
		Sum2ProblemLoop(arr,sum);
		
		System.out.println("--------------------");
		int [] a=arrayPairSumIndices(arr,sum);
		
		System.out.println(" "+Arrays.toString(a) );
		
		
		
		
		
		

	}
	
	public static void Sum2Problem(int [] arr,int num){
		
		HashSet<Integer> ht=new HashSet<Integer>();
		
		for(int i=0;i<arr.length;++i){
			
		if(ht.contains(num-arr[i])){
			System.out.println(""+arr[i]+""+(num-arr[i]));
			
		}
		ht.add(arr[i]);
		
		
		
		}
		
		printHashSet(ht);
		
	}
	
	public static void printHashSet(HashSet<Integer> ht){
		
		Iterator<Integer> it=ht.iterator();
		while(it.hasNext())
			System.out.print("-"+it.next());
		
		
		
		
	}
	
	public static void Sum2ProblemLoop(int [] arr,int num){
		
		Arrays.sort(arr);
		System.out.println(""+Arrays.toString(arr));
		int i=0;
		int j=arr.length-1;
		
		while(j>i){
			
			if(arr[i]+arr[j]==num){
				//System.out.println(" "+arr[i]+" "+arr[j] );
    			System.out.println(arr[i]+"("+i+"),"+arr[j]+"("+j+")");

				int j1=j--;
				
				while((arr[j1]==arr[j]) && (j>i)){
					System.out.println(" "+arr[i]+""+arr[j1] );
					j--;
				}
				
				j=j1;
				i++;
				
				
				
			}
			
			else if(arr[i]+arr[j]>num)
				j--;
			
			else
				i++;
	
		}
	
		
	}
	
	/* 
	 * Let arr be the given array.
	And T be the given sum
 
	for (i=0 i<arr.length - 1 ;i++)
	{
  	hash(arr[i]) = i  // key is the element and value is its index.
	}
 
	for (i=0 i<arr.length - 1; i++)
	{
  	if (hash(T - arr[i]) != i ) // if T - else exists and is different we found a pair
    print "pair i , hash(T - arr[i]) has sum T"
   
	}
	 *  */
	
	
	public static int[] arrayPairSumIndices(int[] a, int k)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++)
        {
            if (hashMap.containsKey(k - a[i]))
            {
                return new int[]{hashMap.get(k - a[i]), i};  //index of K-a[i]
            }
            hashMap.put(a[i], i);
        }
        return null;
       
    }

}
