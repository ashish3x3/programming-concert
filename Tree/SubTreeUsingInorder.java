import java.util.ArrayList;
import java.util.Stack;



public class BinaryTree {
	
	char val;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(char x){
		
		val=x;
	}
	

}



public class SubTreeUsingInorder {
	
	public static boolean isSubTree(BinaryTree t1,BinaryTree t2){
		
		if(t2==null)
			return true;
		
		if(t1==null)
			return false;
		
		
		
	
		ArrayList<Character> inT1=new ArrayList<Character>();
		ArrayList<Character> inT2=new ArrayList<Character>();
		
		storeInorder(t1,inT1);
		
		 System.out.println("inside inT1");
		
		for (int i = 0; i < inT1.size(); i++) {
			
		System.out.print(""+ inT1.get(i).toString());	
			
		}
		System.out.println("");
		
		
		storeInorder(t2,inT2);
		
		  System.out.println("inside inT2");
		
		for (int i = 0; i < inT2.size(); i++) {
		
			System.out.print(""+ inT2.get(i));	
				
			}
		System.out.println("");
		
		//for (int i = 0; i < inT1.size(); i++) {
			//   if (inT1.contains(inT2.get(i))
		
		char[] cs = new char[inT1.size()];

		for(int i = 0; i < cs.length; i++) {
		    cs[i] = inT1.get(i);
		}

		String output = new String(cs);
		
		char[] cs1 = new char[inT2.size()];

		for(int i = 0; i < cs1.length; i++) {
		    cs1[i] = inT2.get(i);
		}

		String output1 = new String(cs1);
		
		
		
		
		if(output.toLowerCase().contains(output1.toLowerCase())==false  )
			return false;
			
		ArrayList<Character> preT1=new ArrayList<Character>();
		ArrayList<Character> preT2=new ArrayList<Character>();
		
		storePreOrder(t1,preT1);
		
		 System.out.println("inside preT1");
			
			for (int i = 0; i < preT1.size(); i++) {
				
			System.out.print(""+ preT1.get(i).toString());	
				
			}
			System.out.println("");
		
		storePreOrder(t2,preT2);
		
		 System.out.println("inside preT2");
			
			for (int i = 0; i < preT2.size(); i++) {
				
			System.out.print(""+ preT2.get(i).toString());	
				
			}
			System.out.println("");
		
		
		
		
		char[] precs = new char[preT1.size()];

		for(int i = 0; i < precs.length; i++) {
		    precs[i] = preT1.get(i);
		}

		String preoutput = new String(precs);
		
		char[] precs1 = new char[preT2.size()];

		for(int i = 0; i < precs1.length; i++) {
		    precs1[i] = preT2.get(i);
		}

		String preoutput1 = new String(precs1);
		
		
		
		
		if(preoutput.toLowerCase().contains(preoutput1.toLowerCase()))
			return true;
		else
		return false;
		
	}
	
	public static void storeInorder(BinaryTree root,ArrayList<Character> T){
		
		if(root == null){
            return ; 
		}
 
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        //define a pointer to track nodes
        BinaryTree p = root;
 
        while(!stack.empty() || p != null){
 
            // if it is not null, push to stack
            //and go down the tree to left
            if(p != null){
                stack.push(p);
                p = p.left;
 
            // if no left child
            // pop stack, process the node
            // then let p point to the right
            }else{
            	BinaryTree t = stack.pop();
                T.add(t.val);
                p = t.right;
            }
        }
        
    /*    System.out.println("inside function");
        
        for (int i = 0; i < T.size(); i++) {
			
    		System.out.print(""+ T.get(i));	
    			
    		}
        System.out.println("");
      */
 
       // return T;
    }
	
	public static void storePreOrder(BinaryTree root,ArrayList<Character> T){
	
		if(root == null)      //key is to push right child first before left in stack so that left 
			 return ;         // child gets executed first as it is stack the one inserted later will be on the top
								// at the time of pop
		
		
           
 
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        stack.push(root);
 
        while(!stack.empty()){
        	BinaryTree n = stack.pop();
            T.add(n.val);
 
            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
 
        }	
		
		
	}
	
	
	public static void main(String [] args){
		BinaryTree t1=new BinaryTree('1');
		t1.left=new BinaryTree('2');
		t1.right=new BinaryTree('3');
		t1.right.left=new BinaryTree('4');
		t1.right.right=new BinaryTree('5');
		
		
		BinaryTree t2=new BinaryTree('3');
		t2.left=new BinaryTree('4');
		t2.right=new BinaryTree('5');
		
		if(isSubTree(t1,t2))
			System.out.println("contains subtree");
		else 
			System.out.println(" Does not contains subtree");
		
		
		
	}
		
		
		
	}


