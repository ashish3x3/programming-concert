/*
You are given a tree (a simple connected graph with no cycles). You have to remove as many edges from the tree as possible to obtain a forest with the condition that : Each connected component of the forest should contain an even number of vertices.

To accomplish this, you will remove some edges from the tree. Find out the number of removed edges.

Input Format
The first line of input contains two integers N and M. N is the number of vertices and M is the number of edges.
The next M lines contain two integers ui and vi which specifies an edge of the tree. (1-based index)

Output Format
Print the answer, a single integer.

Constraints
2 <= N <= 100.

Note: The tree in the input will be such that it can always be decomposed into components containing even number of nodes. 

*/



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class EvenTree{

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int N,M;    //m=edges   n=vertex
        N=scan.nextInt();
        M=scan.nextInt();
        int [][] arr=new int[M][2];

        for(int i=0;i<M;++i){
        	arr[i][0]=scan.nextInt();
        	arr[i][1]=scan.nextInt();

        }

        int [] count=new int[N+1];

        Arrays.fill(count,1);

        for(int i=0;i<M;++i){		//M=edges

        	count[arr[i][1]]=0;
        }
        int total=0;
        int first,f,answer=0;

       // Queue<Integer> q=new Queue<Integer>();
        Queue<Integer> q = new PriorityQueue<Integer>();

        for(int i=N;i>=0;--i){
    

        if(count[i]==0)
        {
            //q.add((Integer)i);
            q.add(i);
            total=0;

            while(!q.isEmpty())
            {
                // first=(int)q.peek();
                first=q.peek();
                q.poll();
                f=0;
                if(count[first]!=0)
                {
                    total+=count[first];
                    f=1;
                }
                else
                {
                    total++;
                }

                if(f==0)
                for(int j=0;j<M;++j)
                {
                    if(arr[j][1]==first)
                    q.add(arr[j][0]);
                }

            }
            count[i]=total;

        }
      } //for

      for(int i=2;i<=N;++i)
    {
        if(count[i]%2==0)
        ++answer;
    }
    System.out.println(""+answer);

    
    
    


        
    }  //main
}

/*

H:\Computer Science\Java\Tree>java EvenTree
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
2
*/