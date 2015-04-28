import java.util.Scanner;
import java.util.Stack;


public class TopologicalSorting {
	
	Stack<Integer> stack=null;
	//static int[] topo;
	static int pos;
	
	public TopologicalSorting(){
		
		stack=new Stack<Integer>(); 
		int[] topo =null;
		pos=1;
		
	}

	public static void main(String[] args) {
		
		System.out.println("Enetr size of matrix");
		Scanner scan=new Scanner(System.in);
		int n;
		n=scan.nextInt();
		int[] topo=null;
		
		
		int[][] mat=new int[n+1][n+1];
		
		System.out.println("Enetr martix elemets");
		
		for(int i=1;i<n+1;++i)
			 for(int j=1;j<n+1;++j)
				 mat[i][j]=scan.nextInt();
				 
		TopologicalSorting tps=new TopologicalSorting();
		topo = tps.topoSorting(mat,1);
		
		for(int i=topo.length-1;i>0;--i) 
			if(topo[i]!=0)
			System.out.print("-" + topo[i]);
		
		
		
		
		scan.close();
	}//main
	
	public int[] topoSorting(int [][] mat,int source){
		
		int N=mat.length;
		int topo1[]=new int[N+1];
		int ele=source;
		int i=source;
		boolean [] visited=new boolean[N+1];
		
		visited[source]=true;
		
		stack.push(source);
		
		while(!stack.isEmpty()){
			 
			int E=stack.peek();
			
			while(i<N){
				
				if(mat[E][i]==1 && visited[i]==false){
					
				  	stack.push(i);
				  	visited[i]=true;
				  	
				  	E=i;
				  	i=1;
					continue;
					
					
					
					
				}
				i++;
				
				
				
				
			}//while i<N
			
			int j=stack.pop();
			topo1[pos++]=j;
			i=++j;
			
			
		}//stack empty
		
		
		return topo1;
		
		
		
	}
	
	
	
	
	

}// class

/*
 5 2
 5 0
 4 0
 4 1
 2 3
 3 1
 * 
*/