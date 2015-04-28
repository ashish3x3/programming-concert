import java.util.*;

public class KStacks {

    int [] array; // Array of size n to store actual content to be stored

    int [] top; // Array of size k to store indexes of top elements of stacks

    int [] next;//store the previous top[i].e top-1 for each K stack 
//so in case of pop() from a stack we know what would be our new top for that stack

// and free list

    int n, k;

    int free; // To store beginning index of free list.. //tells the next free index..initially 0

    public KStacks(int k1, int n1) {

    	// Initialize n and k, and allocate memory for all arrays

    		this.n = n1;

    		this.k = k1;

    		array = new int[n];

    		top = new int[k];

    		next = new int[n];

// Initialize all stacks as empty

    		for (int i = 0; i < k ; i++) {

    			top[i] = -1;

    		}

    		free = 0;

    		// Initialize all spaces as free

    		for (int i = 0; i < n-1; i++) {

    			next[i] = i+1;

    		}

// -1 is used to indicate end of free list

    		next[n-1] = -1;

    }

    	public boolean isFull() {

    		return free == -1;

    	}

// To push an item in stack number 'sn' where sn is from 0 to k-1

    	void push(int item, int sn)

    	{

// Overflow check

    		if (isFull())

    		{

    			System.err.format("\nStack Overflow\n");

    			return;

    		}

    		int i = free; // Store index of first free slot

// Update index of free slot to index of next slot in free list

    		free = next[i];

// Update next of top and then top for stack number 'sn'

    		next[i] = top[sn];   //for every new stack its first entry will 
    		//contain -1 in next array..

    		top[sn] = i;

// Put the item in array

	    		array[i] = item;
	    		System.out.println(" ---Stored at   "+i + "for sn= "+ sn);
	
    	}

// To pop an from stack number 'sn' where sn is from 0 to k-1

    	public int pop(int sn) {

// Underflow check

    		if (isEmpty(sn))

    		{

    			System.err.format("\nStack Underflow\n");

    			return Integer.MAX_VALUE;

    		}

// Find index of top item in stack number 'sn'

    		int i = top[sn];

    		top[sn] = next[i]; // Change top to store next of previous top

// Attach the previous top to the beginning of free list

    		next[i] = free;
    		System.out.println(" -----------fre  "+free);

    		free = i;
    		System.out.println(" free after  "+free);

// Return the previous top item

    		return array[i];

    	}

// To check whether stack number 'sn' is empty or not

    	public boolean isEmpty(int sn) {

    		return (top[sn] == -1);

    	}

    	public void printNaxt(){
	
	for(int i=0;i<next.length;++i){
		System.out.print("  "+next[i]);
		
	}
	
	
}

    	public static void main(String[] args) {

// Let us create 3 stacks in an array of size 10

    		int k = 3, n = 10;

    		KStacks ks = new KStacks(k, n);

// Let us put some items in stack number 2

    		ks.push(15, 2);

    		ks.push(45, 2);

// Let us put some items in stack number 1

    		ks.push(17, 1);

    		ks.push(49, 1);

    		ks.push(39, 1);

// Let us put some items in stack number 0

    		ks.push(11, 0);

    		ks.push(9, 0);

    		ks.push(7, 0);

    		ks.printNaxt();



    		System.out.format("Popped element from stack 2 is %d \n",ks.pop(2));

    		System.out.format("Popped element from stack 1 is %d \n",ks.pop(1));

    		System.out.format("Popped element from stack 0 is %d \n",ks.pop(0));

    		ks.push(11, 1);

    		ks.push(9, 2);

    		ks.push(7, 0);

    		ks.printNaxt();

    	}

}