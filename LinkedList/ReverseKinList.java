/*
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->80->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 

 */


public class ReverseKinList {
	
	private static Node head;
	
	public ReverseKinList(){
		head=null;
		
	}
	
	public void add(int x){
		appendToEnd(x);
		
		
	}
	
	public  void appendToEnd(int x){
		Node new1=new Node(x);
		
		if(head==null)
			head=new1;
		else{
		Node n=head;
		while(n.next!=null)
		  n=n.next;
		
		n.next=new1;
		//head=new1;
		}
	}
	
	public static void printList(){
		if(head==null)
			return;
		
		Node curr=head;
		while(curr!=null){
			System.out.print(" " +(int)curr.data);
			curr=curr.next;
		}
		
		
	}
	
	public static void reverseK(int k){
		
		head=  rev(head,k);
		System.out.println("\nReverse K list");
		printList();
		
		
	}
	
	public static Node rev(Node head,int k){
		
		if(head==null) return null;
		int count=0;
		Node curr=head;
		Node temp=null;
		Node prev=null;
		while(count<k && curr!=null){
			
			temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
			
			
		}
		
		if(temp!=null)
			head.next=rev(temp,k);
		
		
		return prev;
		
	}
	
	public static void removeDuplicates(){
		int n=countNodes();
		Node curr=null;
		Node temp=null;
		Node prev=null;
		curr=head;
		for(int i=1;i<=n;++i){
			if(curr==null)
				break;
			if(curr.next!=null)
			temp=curr.next;
			prev=curr;
		    for(int j=i+1;j<=n-i;++j){
		    	if(temp==null)
		    		break;
		    	if(temp.data==curr.data){
		    		temp=temp.next;
		    		prev.next=temp;
		    		//i++;
		    		//j++;
		    		
		    		
		    	}
		    	else{
		    		prev=temp;
		    		if(temp.next!=null)
		    		temp=temp.next;
		    	
		    		
		    	}
		    	
		    	
		    }
		    curr=curr.next;
			
		}
		/*
		 * public static void deleteDups(LinkedListNode n) {
2 Hashtable table = new Hashtable();
3 LinkedListNode previous = null;
4 while (n != null) {
5 if (table.containsKey(n.data)) previous.next = n.next;
6 else {
7 table.put(n.data, true);
8 previous = n;
9 }
10 n = n.next;
11 }
12 }
		 */
		
		
	}
	
	public static void NthFromLast(int k){
		int n=countNodes();
		if(k>n)
			return;
		Node curr=head;
		for(int i=0;i<n-k;++i){
			curr=curr.next;
			
		}
		System.out.println("\nkth from Last Data\n" +curr.data);
		
		
	}
	
	public static int countNodes(){
		if(head==null) return 0;
		
		else{
			int count=0;
			Node curr=head;
			while(curr!=null){
				
				count++;
				curr=curr.next;
			}
			return count;
			
			
		}
		
		
	}
	
	public static void main(String [] args){
		
		ReverseKinList x=new ReverseKinList();
		  x.add(1);
		  x.add(2);
		  x.add(3);
		  x.add(1);
		  x.add(2);
		  x.add(3);
		  x.add(1);
		  x.add(2);
		  x.add(3);
		  
		  printList();
		  int k=3;
		  reverseK(3);
		  
		  //Removal
		  
		  /*
		  removeDuplicates();
		  System.out.println("\nAfter removal");
		  printList();
		  */
		  
		  //Kth node frm Last
		  
		  /*
		  int k1=4;    //op=1
		  NthFromLast(k1);
		  */
		  
		 
		  
		  
		
	}
	
	

}

class Node{
	
	Node next;
	int data;
	
	public Node(int x){
		data=x;
		next=null;
		
	}
	
	
}