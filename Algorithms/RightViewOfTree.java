
public class RightViewOfTree {

	public static void main(String[] args) {
		
		TreeNode t1=new TreeNode(1);
		/*
		 t1.left=new TreeNode(2);
		 
		t1.right=new TreeNode(3);
		t1.right.left=new TreeNode(4);
		t1.right.right=new TreeNode(5);
		t1.right.right.left=new TreeNode(6);
		*/
		
		t1.left=new TreeNode(2);
		 
		t1.left.left=new TreeNode(3);
		t1.left.right=new TreeNode(4);
		t1.left.right.left=new TreeNode(5);
		
		
		boolean [] visitedLevel=new boolean[height(t1)];
		
		rightView(t1,0,visitedLevel);

	}//main
	
	public static void rightView(TreeNode t1,int L,boolean[] visitedLevel){
		
		if(t1==null)
			return;
		
		if(!visitedLevel[L]){
			
			visitedLevel[L]=true;
			System.out.println(""+t1.val);
			
		}
		
		rightView(t1.right,L+1,visitedLevel);
		rightView(t1.left,L+1,visitedLevel);
		
		
		
	}
	
	public static int height(TreeNode t){
		
		if(t==null)
			return 0;
		int l=1+height(t.left);
		int r=1+height(t.right);
		
		return Math.max(l,r);
	}

}
