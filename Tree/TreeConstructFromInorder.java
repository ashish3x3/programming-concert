

public class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int x){
		
		val=x;
	}
	
	
	
} 

public class TreeConstructFromInorder {
	
	public static int preIndex= 0;
	
	public static TreeNode BuildTree(int [] in,int [] post){
		int inStart=0;
		int inEnd=in.length-1;
		int poStart=0;
		int poEnd=post.length-1;
		return BuildTree(in,inStart,inEnd,post,poStart,poEnd);
		
	}

	
	public static TreeNode BuildTree(int [] in,int inStart,int inEnd,int [] post,int poStart,int poEnd){
		if(inStart>inEnd||poStart>poEnd)
			return null;
		
		int  rootVal=post[poEnd];
		
				
		TreeNode root=new TreeNode(rootVal);
		
		int k=0;
		for(int i=0;i<in.length;++i){
			
			if(in[i]==rootVal){
				k=i;
				break;
			}
			
		}
		
		//root.left=BuildTree(in,inStart,k-1,post,poStart,poStart+k-(inStart+1));
		// Becuase k is not the length, it it need to -(inStart+1) to get the length
		root.right=BuildTree(in,k+1,inEnd,post,poStart+k-inStart,poEnd-1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1
		root.left=BuildTree(in,inStart,k-1,post,poStart,poStart+k-(inStart+1));
		
		return root;
		
	} //end of overloaded biildtree
	
	//public static int [] preIndex={0};
	
	//static int preIndex= 0;
	
	public static TreeNode BuildTree(int [] pre,int [] post,int size){
		//int preIndex=0;
		return BuildTree(pre,post,preIndex,0,size-1,size);
		
	}
	
public static TreeNode BuildTree(int [] pre,int [] post,int preIndex,int start,int end,int size){
		
		if(preIndex>=size || start>end)
			return null;
		
		
		int rootval=pre[preIndex];
		preIndex++;
		
		TreeNode root=new TreeNode(rootval);
		
		if(start==end)
			return root;
		
		int i;
		for(i=0;i<post.length;++i){
			if(preIndex<size){
			if(post[i]==pre[preIndex])
				break;
			}
		}
				

		if(start<=end && preIndex<size){
		root.left=BuildTree(pre,post,preIndex,0,i,size);
		root.right=BuildTree(pre,post,preIndex,i+1,end,size);
		}
		
		return root;
		
		
		
		
	}
	
	
	
	
	/*
	 public static TreeNode BuildTree(int [] pre,int [] post,int [] preIndex,int start,int end,int size){
		
		if(preIndex[0]>=size || start>end)
			return null;
		
		
		int rootval=pre[preIndex[0]];
		preIndex[0]=preIndex[0]+1;
		
		TreeNode root=new TreeNode(rootval);
		
		if(start==end)
			return root;
		
		int i;
		for(i=0;i<post.length-1;++i){
			if(post[i]==rootval)
				break;
		}
				

		if(start<=end){
		root.left=BuildTree(pre,post,preIndex,0,i,size);
		root.right=BuildTree(pre,post,preIndex,i+1,end,size);
		}
		
		return root;
		
		
		
		
	}
	*/
	
	public static TreeNode buildBinarytreefromPostOrder(int[] post, int start, int end)
	{
	    if (end < start)
	        return null;

	    TreeNode root = new TreeNode(post[end]);

	    if (end == start)
	        return root;

	    int i;
	    for (i = end; i >= start; i--)
	        if (post[i] < root.val)
	            break;

	    root.left = buildBinarytreefromPostOrder(post, start, i);
	    root.right = buildBinarytreefromPostOrder(post, i + 1, end - 1);

	    return root;
	}
	
	
	
	public static void printNode(TreeNode tree){
		
		if(tree!=null){
			printNode(tree.left);
			System.out.println(""+ tree.val);
			
			printNode(tree.right);
			
			
		}
		
	}
	
	public static void main(String [] args){
		
		//int [] post={4,5,2,6,7,8,3,1};
		//int [] in={4,2,5,1,6,7,3,8};
		
	    int pre [] = {1, 2, 4, 8, 9, 5, 3, 6, 7};
	    int post [] = {8, 9, 4, 5, 2, 6, 7, 3, 1};
	    
	   int size=pre.length;
	  // TreeNode root= buildBinarytreefromPostOrder(post,0, post.length-1);
	// int postIndex=post.length-1;
		 
		 //TreeNode root=BuildTree(in,post);
	    TreeNode root=BuildTree(pre,post,size);
		 printNode(root);
		
		
	}
	
	

}  //end of class
