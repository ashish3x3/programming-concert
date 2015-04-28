
public class BinaryTreeToDoublyList {
	
	
	public static TreeNode prev=null;
	public static  TreeNode head=null; 

	public static void main(String[] args){
		
		TreeNode t=new TreeNode(10);
		 t.left=new TreeNode(12);
		 t.right=new TreeNode(15);
		 t.left.left=new TreeNode(25);
		 t.left.right=new TreeNode(30);
		 t.right.left=new TreeNode(36);
		 
		 printTree(t);
		 
		 
	 
		 
		 BinaryTreeToDoubleLinkedList(t, head);
		 
		 printList(t);
		
		
		
	}
	
	public static void BinaryTreeToDoubleLinkedList(TreeNode t,TreeNode head){
		
		if(t==null)
			return;
		
		//prev=null;
		
		BinaryTreeToDoubleLinkedList(t.left,head);
		
		if(prev==null){
			head=t;
			System.out.println("\nReached to head=t"+head.val);
		}
		else{
			
			prev.right=t;
			t.left=prev;
			//System.out.println(" Reached inside else"+head.right.val );
			System.out.println(" Reached inside else"+prev.val + "" +t.val);
			
		}
		prev=t;
		
		BinaryTreeToDoubleLinkedList(t.right,head);
		
		
	}
	
	public static void printList(TreeNode t){
		
		if(t==null)
			System.out.println("\nNo data to print");
		while(t!=null){
			
			System.out.println(""+t.val);
			t=t.right;
			
			
			
		}
		
	}
	
public static void printTree(TreeNode t){
		
		if(t==null)
			return ;
		
			printTree( t.left);
			System.out.print("  "+t.val);
			printTree( t.right);
			
			
			
		
		
	
	
}	
	
}
