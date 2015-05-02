import java.util.*;

/*
Merge Sort for Doubly Linked List

Given a doubly linked list, write a function to sort the doubly linked list in increasing order using merge sort.*/


/*number of elemrnt
6
10 30 3 4 20 5
n over
 5 20 4 3 30 10
 3 4 5 10 20 30
*/

 /*Lesson : always use while(null!=fast.next && null!=fast.next.next ) ,it eliminatenull pointer exception*/

public class MergeSortOnDoublyList{

		public static void main(String [] args){

				DoublyList l=new DoublyList();   //initialize the head of this
				l.insert();   //inset element in doubly list
				l.print();
				l.MergeSortCall();  //sort list
				l.print();

		}//main


}//class

class DoublyList{

	Scanner scan=new Scanner(System.in);

	public Node root=null;

	

	public DoublyList(){
		this.root=null;
	}

	public void insert(){
		System.out.println("number of elemrnt");
		int n=scan.nextInt();
		while(n-- > 0){
			root=insert(root,scan.nextInt());
		}
		System.out.println("n over");
	}  //insert

	public Node insert(Node root,int x){
			Node n=new Node(x);

			if(root==null){
				root=n;


			}
			else{
			n.next=root;
			root.prev=n;
			n.prev=null;
			root=n;
		}
		return root;



		}  //insert

	public void print(){
		

			if(root==null){
				
				System.out.println("root empty");
				return;
			}
			Node head=root;
			while(head!=null){

				System.out.print(" "+head.val);
				head=head.next;

			}
			System.out.println();

		
	} //print

	public void MergeSortCall(){
		if(root!=null)
			root=MergeSort(root);

	}
	public Node MergeSort(Node root){
		if(root==null || root.next==null){
			return root;
		}
		Node second=split(root);

		root=MergeSort(root);
		second=MergeSort(second);

		 return merge(root,second);
	} //mergeSort

	public Node split(Node head){

			if(head==null || head.next==null){
				return head;
			}

			Node fast,slow;
			fast=head;
			slow=head;
			while(null!=fast.next && null!=fast.next.next ){
				fast=fast.next.next;
				slow=slow.next;

			}
			Node temp=slow;
			slow=slow.next;
			temp.next=null;

			return slow;
	}//split

		 public Node merge(Node first,Node second){
		 	if(first==null){
		 		return second;
		 	}
		 	if(second==null){
		 		return first;
		 	}

		 	if(first.val<second.val){
		 		first.next=merge(first.next,second);
		 		first.next.prev=first;
		 		first.prev=null;
		 		return first;
		 	}
		 	else{
		 		second.next=merge(first,second.next);
		 		second.next.prev=second;
		 		second.prev=null;
		 		return second;
		 	}

		 	//return first;
		  } //merge


}  //DoublyList

 class Node{
		Node prev,next;
		int val;

		public Node(int x){
			this.val=x;
			
			next=prev=null;
		}

	
	} //Node class