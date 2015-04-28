
public class UniqueElementInSortedArray {

	public static void main(String[] args) {
		
		int[] array={2,2,3,4,55,55,66,77,77,77,77,88,88};
		//int[] array={1,2,3,3,4,5,5};
		int res;
		res=numberOfUniqueElement(array);
		
		System.out.println("no of unique element = \t" + res);

	}
	
	public static int numberOfUniqueElement(int[] array){
		
		if(array.length<2)
			return array.length;
		
		int j=0;
		int i=1;
	    while(i<array.length){
	    	if(array[i]==array[j]){
	    		i++;
	    	}else
	    		array[++j]=array[i++];     //check for ++j and i++ pre and post
	  
	    }
		
		
		return j+1;
	}

}
