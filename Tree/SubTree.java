import java.util.*;


public class BinaryTree {
	
	int val;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int x){
		
		val=x;
	}
	

}



public class SubTree {

	public static boolean isSubTreeRef(BinaryTree t1,BinaryTree t2){
		
		
		if(t2==null)		//should be the first case
			return true;
		if(t1==null)
			return false;
		
		
		
		
		
		return (t1==t2) 
				|| isSubTreeRef(t1.left,t2) 
				|| isSubTreeRef(t1.right,t2) ;
		
	}
		
		
		
	

	public static boolean isSubTreeValue(BinaryTree t1,BinaryTree t2){
		
		if(t2==null)           //should be comming first case
			return true;
		
		if(t1==null)
			return false;
		
		
		
		if(t1.val==t2.val){
			
			if(isSubTreeValue(t1.left,t2.left) && isSubTreeValue(t1.right,t2.right))
				return true;
			
		}
		return isSubTreeValue(t1.left,t2) || isSubTreeValue(t1.right,t2);
		
		
	}
	
	public static void main(String args[]){
		BinaryTree t1=new BinaryTree(1);
		t1.left=new BinaryTree(2);
		t1.right=new BinaryTree(3);
		t1.right.left=new BinaryTree(4);
		t1.right.right=new BinaryTree(5);
		
		
		BinaryTree t2=new BinaryTree(3);
		t2.left=new BinaryTree(4);
		t2.right=new BinaryTree(6);
		
		if(isSubTreeRef(t1,t2))
			System.out.println("contains subtree(reference)");
		else 
			System.out.println(" Does not contains subtree(refernce)");
		
		
		if(isSubTreeValue(t1,t2))
			System.out.println("contains subtree(value)");
		else
			System.out.println(" Does not contain subtree(value)");
		
		
		
		
		
	}
	
	
}
