import java.util.Arrays;


public class MergeSortedArray {
	
	 static public int NILL = -1;

	public static void main(String[] args) {
		int [] array1= {2,-1,7,-1,9,-1};
		int [] array2={3,6,10};
		System.out.println(""+ Arrays.toString(array2));
		
		sorted(array1,array2);

	}
	
	public static void sorted(int [] array1,int [] array2){
		
		shift(array1);
		int i=array2.length;
		int j= 0;
		int l=array1.length + array2.length;
		System.out.println(""+l +"\t" + i);
		
		for(int k=0;k< l;++k){
			if((i< array1.length && array1[i]<=array2[j]) || (array2.length==j)) {
				if(i< array1.length){
				array1[k]=array1[i];
				i++;
				}
				
			}
			else{
				array1[k]=array2[j];
				j++;
				
				
			}
				
			
			
			
		}
		
		System.out.println(""+ Arrays.toString(array1));
		
		
		
		
	}
	
	public static void shift(int [] array1){
		int i;
		int j=array1.length-1;
		
		for(i=array1.length-1;i>=0;--i){
			if(array1[i]!=-1){
			{ array1[j]=array1[i];
			j--;
			}
			
			}
		}
		System.out.println(""+ Arrays.toString(array1));
		
	}

}
