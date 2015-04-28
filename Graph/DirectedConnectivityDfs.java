    import java.util.InputMismatchException;

    import java.util.Scanner;

    import java.util.Stack;

  //same as for undirected just no i->j then j->i
    //onlycheck for weakely connected directed graph

    public class DirectedConnectivityDfs

    {

        private Stack<Integer> stack;

     

        public DirectedConnectivityDfs() 

        {

            stack = new Stack<Integer>();

        }
       /*
        * recursive implementation 
        
        public void dfs(int i)
        {
           int j;

           visited[i] = true;

           printNode(i);

           for ( j = 0; j < NNodes; j++ )
           {
     	 if ( adjMatrix[i][j] > 0 && !visited[j] )
                 dfs(j);
           }
        }
        */

     

        public boolean dfs(int adjacency_matrix[][], int source)

        {

            int number_of_nodes = adjacency_matrix[source].length - 1;

            int visited[] = new int[number_of_nodes + 1];		

            int element = source;		

            int i = source;	

            visited[source] = 1;		

            stack.push(source);

     

            while (!stack.isEmpty())

            {	element = stack.peek();
            	
            	if(source==number_of_nodes){
            	       i=1;
            }
            else {

                i = element;	
            }

    	    while (i <= number_of_nodes)

    	    {

         	        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)

    	        {

                        stack.push(i);

                        visited[i] = 1;

                        element = i;

                        i = 1;

    	            continue;

                    }

                    i++;

    	    }

                stack.pop();	

            }

            boolean connected = false;

     

            for (int vertex = 1; vertex <= number_of_nodes; vertex++)

            {

                if (visited[vertex] == 1) 

                {

                    connected = true;

                }

                else

                {

                    connected = false;

                    break;

                }

            }

     

            if (connected)

            {

                return true;

            }else

            {

                return false;

            }

        }
        
        public static boolean allFalse(boolean [] connect){
        	
        	for(int i=1;i<=connect.length-1;++i){
            	if(connect[i]==true)
            		return false;
        	
        	
        }
        	return true;
      }
        
        public static boolean allTrue(boolean [] connect){
        	
        	for(int i=1;i<=connect.length-1;++i){
            	if(connect[i]==false)
            		return false;
        	
        	
        }
        	return true;
      }

        public static boolean atLeastOneTrue(boolean [] connect){
        	
        	for(int i=1;i<=connect.length-1;++i){
            	if(connect[i]==true)
            		return true;
        	
        	
        }
        	return false;
      }

        public static void main(String...arg)

        {

            int number_of_nodes, source;

            Scanner scanner = null;

     	try

            {

    	    System.out.println("Enter the number of nodes in the graph");

                scanner = new Scanner(System.in);

                number_of_nodes = scanner.nextInt();

     

    	    int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];

    	    System.out.println("Enter the adjacency matrix");

    	    for (int i = 1; i <= number_of_nodes; i++)

    	       for (int j = 1; j <= number_of_nodes; j++)

                       adjacency_matrix[i][j] = scanner.nextInt();			

     

    	   // System.out.println("Enter the source for the graph");

           //     source = scanner.nextInt(); 

    	    	boolean [] connect=new boolean[number_of_nodes+1];;

                DirectedConnectivityDfs directedConnectivity= new DirectedConnectivityDfs();
                
                for(int i=1;i<=number_of_nodes;++i){
                    
                	connect[i]=directedConnectivity.dfs(adjacency_matrix, i);
                	System.out.println(""+connect[i]);
                	
               
                
                }
                
                if(allFalse(connect)){
                	System.out.println("all false :  Disconnected graph");
                }
                else if(allTrue(connect)){
                	System.out.println("all True : Strongly connected graph");
                	
                }else if(atLeastOneTrue(connect))
                	System.out.println("at Least one  True : weakely connected graph");
            	
                /*
                boolean b=false;
               // boolean atLeast=false;
                //boolean atLast=false;
                for(int i=1;i<=number_of_nodes;++i){
                	if(connect[i]==true){
                		atLeast=true;
                		b=true;
                		continue;
                	}
                	else{
                		b=false;
                		atLast=true;
                		//break;
                		
                	}
                	
                	
                }
                */
                
                
                /*
                if(b==false && atLeast==true){
                	System.out.println(" graph is weakely connected");
                }
                else if(b==true && atLast!=true) {
                	System.out.println("graph is  strongly connected");
                } else
                
                */
               

     

            }catch(InputMismatchException inputMismatch)

            {

                System.out.println("Wrong Input format");

            }	

            scanner.close();	

        }
        
        
        
        
        /*  
         * Enter the number of nodes in the graph
5
Enter the adjacency matrix
0 1 0 1 0
0 0 1 0 0
0 0 0 0 0
0 1 0 0 0
0 0 0 0 0
Enter the source for the graph
1
The graph is disconnected
         *  
         *  */

    }
    
    
    
    
    