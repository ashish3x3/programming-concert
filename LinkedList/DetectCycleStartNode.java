import java.util.*;

/*class LL{

	LL next;
	int val;

	public LL(int x){

		this.val=x;
		this.next=null;



	}
} //class
*/

public class DetectCycleStartNode{
	
	private static  class LL{

		LL next;
		int val;

		public LL(int x){

			this.val=x;
			this.next=null;



		}
	} //class

		public static LL head=null;


	public static void main(String [] args){

		 head =new LL(1);
		head.next=new LL(2);
		head.next.next=new LL(3);
		head.next.next.next=new LL(4);
		LL p=head.next.next.next;
		head.next.next.next.next=new LL(5);
		head.next.next.next.next.next=new LL(6);
		head.next.next.next.next.next.next=new LL(7);
		head.next.next.next.next.next.next.next=new LL(8);
		head.next.next.next.next.next.next.next.next=new LL(9);
		head.next.next.next.next.next.next.next.next.next=new LL(10);
		head.next.next.next.next.next.next.next.next.next.next=p; //p=4
		//head.next.next.next.next.next.next.next.next.next.next=new LL(11); //no cycle
		

		findStartNode(head);



	} //main

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void findStartNode(LL head){

		Hashtable ht=new Hashtable();
		LL curr=head;

		while(true && curr!=null){

			if(ht.containsKey(curr)){
				//System.out.println("---inside curr");
				System.out.println("---"+curr.val);
				break;
			}
			//System.out.println("---"+curr.val);
			ht.put(curr,true);
			curr=curr.next;


		}
		
		if(curr==null)
		System.out.println("---No Cycle--");





	}

	//create


	  
	



	


} //class