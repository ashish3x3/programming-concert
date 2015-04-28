import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;


public class DFSTraversalGraphUsingStack {
	
	private Stack<Integer> stack;
	//int NNNodes;
	
	public DFSTraversalGraphUsingStack(){
		
		stack=new Stack<Integer>();
	}
	
	public void dfs(int adjMat[][],int source){
		
		int number_of_nodes=adjMat[source].length-1;   // because we have created matrix
											  // in main of noOfNodes+1
											// adjMat[source].length will be useful 
												//in case of non square matrix
		System.out.println(""+number_of_nodes);
		int [] visited=new int[adjMat.length+1];
		//NNNodes=adjMat.length;
		
		int ele=source;
		int i=source;
		
		System.out.println(" ** "+ele);
		visited[source]=1;
		
		stack.push(source);
		
		while(!stack.isEmpty()) {
			
			
			 ele=stack.peek();
			 
			// int n=getUnvisitedNode(ele);
			 
			 i=ele;
			 while(i<=number_of_nodes){
				 
				 if(adjMat[ele][i]==1 && visited[i]==0){
					 
					 stack.push(i);
					 visited[i]=1;
					 
					 
					 ele=i;
					 i=1;
					 
					 System.out.print(" -- "+ele);
					 continue;
				 }
				 i++;
				 
			 }
			 
			 stack.pop();
			 
		}
	}	
					 
					 
	
	
	/*
	public static int getUnvisitedNode(int n){
		
		int j;
		for(j=0;j<NNNodes;++j){
		  if(adjMat[n][j]>0 && visited[j]==0)
			  return j;
		}
		
		
		
		return -1;
		
	}
	*/
	
	
	

	public static void main(String...args ) {
		
		int number_of_nodes,source;
		Scanner scan=null;
		
		try{
			
			System.out.println("Enter number of Nodes in Graph");
			scan=new Scanner(System.in);
			number_of_nodes=scan.nextInt();
			
			int adjMat[][] = new int[number_of_nodes+1][number_of_nodes+1];
			
			System.out.println("Enter adjMat[][] :=  \n");
			for(int i=1;i<=number_of_nodes;++i){    // we start index at index 1
													// so we could have 11,22,33,44 no 0,1 etc
				
				for(int j=1;j<=number_of_nodes;++j){
					
					adjMat[i][j]=scan.nextInt();
					
				}
			}
			
			System.out.println("Enter Source node :=  \n\n");
			source=scan.nextInt();
			
			System.out.println("DFS Traversal of grah is given By :=  \n");
			
			DFSTraversalGraphUsingStack dfs=new DFSTraversalGraphUsingStack();
			
			dfs.dfs(adjMat, source); 
			
			
			
		}catch(InputMismatchException inputmismatchException){
			
			System.out.println("Wrong Input");
			
			
		}
		scan.close();
		
			

	}

}
