
import java.util.*;                     // for scanner class,no need in c :p


public class AntCollisionRakhi {
	static int i(String s)
	{ return Integer.parseInt(s); }
	
	
	public static void main(String[] args) throws Exception {
		
	    Scanner in = new Scanner(System.in);
		
			
			System.out.println("Enetr Total Number of Ants");
		
			int n = in.nextInt();
		
			// You can think it as a kind of dynamic array 
			
			// Ls  store index of those ant which will fall on left hand side of rod
			TreeSet<Integer> Ls = new TreeSet<Integer>();  
			
			// Rs  store index of those ant which will fall on Right hand side of rod
			TreeSet<Integer> Rs = new TreeSet<Integer>();
			
			
			// array to take input from user only store -1 for L and 1 for R
			int arr[]=new int[n];

			
			for(int i=0; i<n; i++) {
				arr[i] = in.nextInt();
				if(arr[i]== -1)              // self explanatory
					Ls.add(i);
				else
					Rs.add(i); 
				
				//System.out.println(Arrays.toString(arr));	
				
			}
			
			int nextL=Ls.pollLast();           //takes out the last entry in Ls
			int nextR=Rs.pollFirst();          //  takes out the first entry in Rs 
			
			//System.out.println(" "+ nextL);   // for debugging checking what is coming out
			//System.out.println(""+nextR);
			
			int diffL=arr.length-1-(arr.length-1-nextL); // calculating distance from 0th position
			int diffR=arr.length-1-nextR;    // calculating distance from 5th position 
			int z=0;
			int max=findMax(diffL,diffR);    //checking which is near to the edge, as that ant will fall Last
			if(max==0)
				z = Math.min(nextL,nextR);    // if both distance are same than output lowest index
			if(max==diffL)
				z=nextL;				// storing index of last ant's position
			else z=nextR;
			
			
			System.out.printf("Last Ant to fall is at "+ z );

			
    }
	
	
	public static int findMax(int lhs,int rhs){
		
		if(lhs==rhs)
			return 0;
		else
			return lhs>rhs?lhs:rhs;
		
	}
	
	
	
	
	
	
}
