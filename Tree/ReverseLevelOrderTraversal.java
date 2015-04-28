import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseLevelOrderTraversal {
    
    public static void main(String args[] ) throws Exception {
        
        
        BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = sysIn.readLine();
        
        int N = Integer.parseInt(firstLine);

        String secondLine = sysIn.readLine();
		String[] inputString = secondLine.split("\\s+");  
										//s+ is regex for a space between char
        								// ([A-Z]{2})-(\d+)          
									// The first part is exactly two capital letters,
        							// the second consists of digits
        if(inputString.length != N) {
			throw new RuntimeException("Number of elements can't be more than "+N);
		}
        
        int [] array = new int[inputString.length];
		for(int i=0;i<inputString.length;i++){
			array[i] = Integer.parseInt(inputString[i]);
		}
        
		ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();
        tree.buildTree(array);
        tree.levelOrderTraversal();
        

        
    }
    
    private static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
			left = right = null;
		}

	}
    
    private Node root;
    
    ReverseLevelOrderTraversal(){
		root = null;
	}
	

    public  void buildTree(int[] array) {

		root = findRoot(array);
		buildTree(array, root);
	}
	
	private Node findRoot(int [] array) {
		Node node = null;
		for(int i=0;i<array.length;i++) {
			if(array[i] == -1){
				
				node =  new Node(i);
			}
		}
		
		return node;
	}

	private void buildTree(int[] array, Node node) {
		
		if(node == null) {
			return;
		}
		
		boolean leftChild = false;
		
		for(int i=0;i<array.length;i++) {
			
			if(array[i]  == node.value) {    //index matching with the element 
				
				if(!leftChild) {
					node.left = new Node(i);
					buildTree(array, node.left );
					leftChild = true;
				} else {
					node.right = new Node(i);
					buildTree(array,node.right);
				}
			}
		}

	}

    
  	public void levelOrderTraversal() throws IOException {
		levelOrderTraversal(root);
	}

    
    private void levelOrderTraversal(Node node) throws IOException {
		
		BufferedWriter sysOut = new BufferedWriter(new OutputStreamWriter(
				System.out));
		List<List<Node>> result = new ArrayList<List<Node>>();
		
		List<Node> current = new LinkedList<Node>();
		if(node != null) {
			current.add(node);
		}
		
		while(current.size() > 0) {
			result.add(current);
			List<Node> parents = current;
			current = new LinkedList<Node>();
			
			for(Node parent: parents) {
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
			
		}
		
		
		for(int i = result.size() - 1; i>=0;i--){
			List<Node> level = result.get(i); 
			StringBuilder buff = new StringBuilder();
			for(Node levelNode: level) {
				buff.append(levelNode.value+ " ");
			}
			sysOut.write(buff.toString().trim());
			sysOut.write("\n");
			sysOut.flush();
			
		}
		
	}
}


/* 
 * 9
 * 8 7 0 5 5 8 7 0 -1
	1 6
	2 7 3 4
	0 5
	8
 *  
 *  
 *  5
-1 0 0 1 1 
3 4
1 2
0
 *  
 *  
 *  
  */
 