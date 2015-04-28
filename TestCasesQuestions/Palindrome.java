
public class Palindrome {

	public static void main(String[] args) {
		
		LinkedNode head=new LinkedNode(1);
		head.next=new LinkedNode(2);
		head.next.next=new LinkedNode(2);
		head.next.next.next=new LinkedNode(1);
		//head.next.next.next.next=new LinkedNode(1);
		
		
		
		boolean res=isPalindrome(head);
		System.out.println("isPalindrome--->" +res);
		
	}
		
	public static boolean isPalindrome(LinkedNode head){
		if(head==null) return false;
		
		if(head.next==null) return true;
		
		LinkedNode middle=findMiddle(head);
		
		System.out.println(""+middle.val);
		middle.next=reverseList(middle.next);
		System.out.println(""+middle.next.val);
		
		LinkedNode firstHalf=head;
		LinkedNode secondHalf=middle.next;
		
		while(secondHalf!=null){
			
			if(firstHalf.val==secondHalf.val){
				
				firstHalf=firstHalf.next;
				secondHalf=secondHalf.next;
			}
			else{
				
				middle.next=reverseList(middle.next);
				    return false;
			}
				
				
			
		}
		
		middle.next=reverseList(middle.next);
	    return true;
		
	}	
		
		

	
	
	public static LinkedNode reverseList(LinkedNode t){
		
		if(t==null) return null;
		if(t.next==null) return t;
		
		LinkedNode curr=t;
		//LinkedNode next=curr.next;
		LinkedNode prev=null;
		LinkedNode head=t;
		
		while(curr!=null){
			LinkedNode next=curr.next;
			
			curr.next=prev;
			prev=curr;
			head=curr;
			curr=next;
			
			//next=curr.next;    NPE error
			
			
		}
		
		return head;
		
	}
	
	public static LinkedNode findMiddle(LinkedNode t){
		
		if(t==null) return null;
		if(t.next==null) return null;
		
		int n=0;
		if(t!=null) n=1;
		LinkedNode slow=t;
		LinkedNode fast=t.next.next;
		
		while(fast!=null){
			n++;
			if(fast.next==null)
				break;
			
			slow=slow.next;
			fast=fast.next.next;
			
			
		}
		if(n%2==0)
		return slow;
		
		return slow.next;
		
		
	}

}

 class LinkedNode{
	
	LinkedNode next;
	int val;
	public LinkedNode(int x){
		
		val=x;
		next=null;
		
		
		
	}
	
}
 
 
 /*   
  * Complexity of the code
This is what we are doing:
1. Finding middle element of the list. O(N/2) time.
2. Reversing the list from middle position. O(N/2) time.
3. Comparing the first half of the list with other half. O(N/2) time.
4. Reversing the list from middle position again to restore the list to original list. O(N/2) time.
So total time is O(2N).
  * 
  * 
  * TESTED AGAINST ALL OF THESE
  * 
  * Fun time - Breaking the code
1. Null list.
2. List with one node.
3. List with even number of nodes.
4. List with odd number of nodes.
Also verify that after the operation the original list is maintained.
  * 
  */
 
 