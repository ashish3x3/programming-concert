import java.util.*;


public class TreeNode {
	TreeNode left;
	TreeNode right;
	char data;
	
	
	 public TreeNode(char x){
		 
		 left=right=null;
		 data=x;
	 }

}

	
public class IsomorphicTree {
	
	public static void main(String [] args){
		
		TreeNode t1=new TreeNode('a');
		t1.left=new TreeNode('b');
		t1.left.left=new TreeNode('d');
		t1.left.right=new TreeNode('e');
		t1.left.right.left=new TreeNode('f');
		t1.right=new TreeNode('c');
		t1.right.left=new TreeNode('g');
		t1.right.left.left=new TreeNode('g');
		
		
		TreeNode t2=new TreeNode('a');
		t2.left=new TreeNode('b');
		t2.left.left=new TreeNode('d');
		t2.left.right=new TreeNode('e');
		t2.left.right.left=new TreeNode('f');
		t2.right=new TreeNode('c');
		t2.right.left=new TreeNode('g');
		t2.right.left.left=new TreeNode('g');
		
		
		boolean res;
		res=isIsomorphic(t1,t2);
		System.out.println("res = "+ res);
		
		if(res==true)
			System.out.println("It is Isomorphic");
		else
			System.out.println("It is NOTTTTTT Isomorphic");
		
	}
	
	public static boolean isIsomorphic(TreeNode t1,TreeNode t2){
		
		if(t1==null && t2==null)
			return true;
		
		if( (t1==null && t2!=null) || (t1!=null && t2==null) )
			return false;
		
		return ((isIsomorphic(t1.left,t2.left)) && (isIsomorphic(t1.right,t2.right)));
		
	}

}
