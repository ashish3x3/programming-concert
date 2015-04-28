
public class DiameterOfTree {

	public static void main(String[] args) {
		TreeNode t1=new TreeNode('a');
		t1.left=new TreeNode('b');
		t1.left.left=new TreeNode('d');
		t1.left.right=new TreeNode('e');
		t1.left.right.left=new TreeNode('f');
		t1.right=new TreeNode('c');
		t1.right.left=new TreeNode('g');
		t1.right.left.left=new TreeNode('g');
		
		System.out.println("Diameter of Tree = " + findDiameter(t1));

	}
	
	public static int findDiameter(TreeNode t1){
		
		
		
		if(t1==null)
			return 0;
		
		int lHeight=height(t1.left);
		int rHeight=height(t1.right);
		int lDiameter=findDiameter(t1.left);
		int rDiameter=findDiameter(t1.right);
		
		return(max((lHeight+rHeight+1),max(lDiameter,rDiameter)));
		
		
	}
	
	public static int max(int lhs,int rhs){
		
		
		return lhs>rhs?lhs:rhs;
	}
	
	public static int height(TreeNode t1){
		
		if(t1==null)
			return 0;
		
		return(1+max(height(t1.left),height(t1.right)));
		
		
		
	}

}
