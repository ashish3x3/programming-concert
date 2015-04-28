import java.util.Arrays;


public class IsPostOrderBST {
	
	static int [] temp;

	public static void main(String[] args) {
		BinaryTree t1=new BinaryTree(4);
		t1.left=new BinaryTree(2);
		t1.left.left=new BinaryTree(1);
		t1.left.left.left=new BinaryTree(0);
		t1.right=new BinaryTree(7);
		t1.right.left=new BinaryTree(5);
		
		int[]  arr={0,1,2,6,5,4};
		//int[]  arr={1,3,2};
		boolean res=isPostOrderBST(arr,arr.length);
		
		System.out.println(""+res);

	}
	
	public static boolean isPostOrderBST(int [] arr,int len){
		
		System.out.println("len="+len+""+Arrays.toString(arr)); 
		
		if(arr.length==0)
			return false;
		
		if(len<=0)
			return true;
		// nodes in left sub-tree are less than root node
		int i=0;
		for(;arr[i]<arr[len-1];++i);
		
		// nodes in right sub-tree are greater than root node
		for(int j=i+1;j+1<len;++j)
			if(arr[j]<arr[len-1])
				return false;
		// Is left sub-tree a binary search tree?
		// Is right sub-tree a binary search tree? 
		return (isPostOrderBST(arr,i) && isPostOrderBST(add(arr,i,len),len-1-i));
						//we can't write arr+i in java so we creat a new arry from 0 to i
						//using add(arr,i,len)
	}
	
	public static int [] add(int [] arr,int i,int len){
		
		temp=new int[len-i+1];
		for(int j=0;j<len-i+1 && i<len;++j){
			temp[j]=arr[i];
			i++;
		}
		return temp;
		
	}

}
