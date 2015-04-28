

public class PrintAllPath {

	private int pathLen;
	int [] path=null;
	
	public static void main(String[] args) {
		new PrintAllPath().execute();

	}//end of main
	
	public void execute(){
		
		BinaryTree t1=new BinaryTree(1);
		t1.left=new BinaryTree(1);
		t1.right=new BinaryTree(2);
		t1.right.left=new BinaryTree(2);
		t1.right.right=new BinaryTree(23);
		t1.left.left=new BinaryTree(1);
		t1.left.left.right=new BinaryTree(1);
		
		path=new int[depth(t1)];
		printAllPath(t1,path,pathLen);
		
		
		
		
		
		
	}//execute
	
	
	public void printAllPath(BinaryTree t1,int [] path,int pathLen){
		
		if(t1==null) 
			return ;
		
		path[pathLen++]=t1.value;
		
		if(t1.left==null && t1.right==null){
			
			printPath(path,pathLen);
			System.out.println("");
			
		}
		else{
			
			printAllPath(t1.left,path,pathLen);
			printAllPath(t1.right,path,pathLen);
			
		}
		
		
		
	}
	
	
	public void printPath(int[] path,int pathLen){
		
		for(int i=0;i<pathLen;++i){
			System.out.print(" "+ path[i]);
			
			
		}
		
		
	}
	
	public int depth(BinaryTree node){
		
		if(node==null) return 0;
		
		return (1+ Math.max(depth(node.left),depth(node.right)));
		
		
	}
	
	 private static class BinaryTree {
			int value;
			BinaryTree left;
			BinaryTree right;

			BinaryTree(int value) {
				this.value = value;
				left = right = null;
			}

		}
	    
	  //  private BinaryTree root;
	    

}
