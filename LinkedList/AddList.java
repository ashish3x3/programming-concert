import java.util.Scanner;

/*
  class Node{
	 Node next;
	 int val;
	 
	 public Node(int x){
		 val=x;
		 next=null;
		 
	 }
}
*/
 
	
	 
	 
	
	


 class AddList{
	
     public Node head;
     
     public AddList(){
    	 head=null;
    	 
     }
  
    	 
     
 public Node add(){
		 Scanner scan=new Scanner(System.in);
	 System.out.println("Entern the Number");
	 int N=scan.nextInt();
	 Node curr=head;
	 while(N>0){
		 Node n=new Node(scan.nextInt());
		 if(head==null)
			 head=n;
		 else{
			 curr=head;
			 while(curr.next!=null)
				 curr=curr.next;
			 
			 curr.next=n;
		 }
		
		 N--;
	 }
		return head; 
		 
	 }
 
 public void printList(){
	 
	 Node curr=this.head;
	 while(curr!=null){
		 System.out.print(" "+curr.data);
		 curr=curr.next;
		 
	 }
	 System.out.println(" ");
		 
	 
 }
	
	public static Node add(AddList l1,AddList l2){
		
		int carry=0;
		Node newHead = new Node(0);
        Node p1 = l1.head, p2 = l2.head, p3=newHead;
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.data;
                p1 = p1.next;
            }
 
            if(p2 != null){
                carry += p2.data;
                p2 = p2.next;
            }
 
            p3.next = new Node(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
 
        if(carry==1) 
            p3.next=new Node(1);
 
        return newHead.next;
    
		
		
	}
	
	public void exec(AddList l1,AddList l2){
		head=add(l1,l2);
		Node curr=head;
		while(curr!=null){
			 System.out.print(" "+curr.data);
			 curr=curr.next;
			
		}
		
		
	}
	
	public static void main(String [] args){
		AddList l1=new AddList();
		l1.add();
		AddList l2=new AddList();
		l2.add();
		l1.printList();
		l2.printList();
		
		AddList l3=new AddList();
		l3.exec(l1,l2);
		
		
		
	}
	
	
}















/*
 * public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int carry =0;
 
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }
 
            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
 
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
 
        if(carry==1) 
            p3.next=new ListNode(1);
 
        return newHead.next;
    }
}
 */

/*

public class AddList {
 
private SLinkedList sum;
private int carry;
 
public AddList() {
sum = new SLinkedList();
carry = 0;
}
 
private class Node {
private int val;
private Node next;
 
public Node() {
next = null;
val = 0;
}
 
public Node(int val) {
this.val = val;
this.next = null;
}
}
 
private class SLinkedList {
private Node head;
private int count;
 
public int size() {
return count;
}
 
public SLinkedList() {
head = null;
count = 0;
}
 
public SLinkedList(int[] arr) {
head = new Node(arr[0]);
Node cNode = head;
for (int i = 1; i < arr.length; ++i) {
Node tNode = new Node(arr[i]);
cNode.next = tNode;
cNode = tNode;
}
count = arr.length;
}
 
public void printList() {
Node tNode = head;
while (tNode != null) {
System.out.print(tNode.val + " ");
tNode = tNode.next;
}
System.out.println("");
}
}
 
public void printSum() {
sum.printList();
}
 
public int getLen() {
return sum.size();
}
 
private void swap(SLinkedList a, SLinkedList b) {
Node tNode = a.head;
a.head = b.head;
b.head = tNode;
}
 
public void add(int[] arr, int[] brr) {
 
SLinkedList aList = new SLinkedList(arr);
SLinkedList bList = new SLinkedList(brr);
 
if (aList.size() == 0) {
sum.head = bList.head;
return;
} else if (bList.size() == 0) {
sum.head = aList.head;
return;
}
 
int aSize = aList.size();
int bSize = bList.size();
 
if (aSize == bSize)
sum.head = addSameSize(aList.head, bList.head, carry);
else {
int diff = Math.abs(aSize - bSize);
 
if (aSize < bSize) {
swap(aList, bList);
}
 
Node cNode = aList.head;
while (diff > 0) {
cNode = cNode.next;
diff--;
}
 
sum.head = addSameSize(cNode, bList.head, carry);
sum.head = addCarryToRemaining(aList.head, cNode, carry);
}
 
if (carry > 0) {
Node nNode = new Node(carry);
sum.count++;
nNode.next = sum.head;
sum.head = nNode;
}
 
}
 
private Node addSameSize(Node a, Node b, int c) {
if (a == null)
return null;
 
Node result = new Node();
sum.count++;
result.next = addSameSize(a.next, b.next, carry);
int sumVal = a.val + b.val + carry;
carry = sumVal / 10;
sumVal %= 10;
result.val = sumVal;
return result;
}
 
private Node addCarryToRemaining(Node a, Node b, int c) {
if (a == b)
return sum.head;
Node result = new Node();
sum.count++;
result.next = addCarryToRemaining(a.next, b, carry);
int sumVal = a.val + carry;
carry = sumVal / 10;
sumVal %= 10;
result.val = sumVal;
return result;
}
 
public static void main(String[] args) {
 
int arr1[] = { 5, 6, 3, 5, 6, 7, 8, 6, 9, 8, 7, 6, 4, 3, 2, 4, 5, 3, 6,
4, 7, 8, 7, 8, 6, 5, 2 };
int arr2[] = { 8, 4, 2, 8, 7, 6, 8, 7, 9, 4, 3, 2, 6, 6, 7, 6, 7, 8, 6,
7, 8, 6, 2, 1, 5, 8, 7, 6 };
 
AddList sList = new AddList();
sList.add(arr1, arr2);
System.out.print("Printing sum:");
sList.printSum();
}
 
}

*/
