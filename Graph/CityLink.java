import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CityLink
{
	
	static Scanner scan=new Scanner(System.in);
	public static void main(String [] args){
		new CityLink().calculate();
		
	}
	
	public void calculate(){
		System.out.println("Enter N");
		int N=scan.nextInt();
		int [] x=new int[N];
		int [] y=new int[N];
		
		System.out.println("enetr number in array");
		
		for(int i=0;i<N;++i){
			
			x[i]=scan.nextInt();
			
		}
		
		for(int i=0;i<N;++i){
			
			y[i]=scan.nextInt();
			
		}
		
		int res=timeTaken(x,y);
		System.out.println("result is = "+ res);
		
		
	}
 
 public int timeTaken(int[] x, int[] y)
 {
  int N = x.length;
  int[][] dist = new int[N][N];
  for(int i=0; i<N; i++) 
   for(int j=0; j<N; j++) 
    dist[i][j] = Integer.MAX_VALUE;
  for(int i=0; i<N; i++) 
   for(int j=0; j<N; j++) {
    dist[i][j] = distance(x[i], y[i], x[j], y[j]);
    System.out.print("  dist = "+ dist[i][j]);
   }
  System.out.println("");
  
  
        // Floyd Graph Algorithms, calculate the minimum time(distance) between any two cities.
  for(int k=0; k<N; k++){
   for(int i=0; i<N; i++){
    //if(i==k)continue;
    for(int j=0; j<N; j++){
     //if(j==k || j==i) continue;
                    //Here is the key. To connect the two cities through one, this is how we calculate the cost(distance).
     dist[i][j] = Math.min(dist[i][j], Math.max(dist[i][k], dist[k][j]));
     System.out.print("  dist = "+ dist[i][j]);
    }
    System.out.println("");
   }
  }
  int max = 0;
  for(int i=0; i<N; i++) 
   for(int j=0; j<N; j++){
    max = Math.max(max, dist[i][j]);
    System.out.print("  max = "+ max);
   
   }
  System.out.println("");
  
  return max;
 }
 
 private int distance(int x1, int y1, int x2, int y2){
  if(x1 == x2) return (Math.abs(y1-y2)+1)/2;
  if(y1 == y2) return (Math.abs(x1-x2)+1)/2;
  return Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
 }
}

/*
Problem Statement


There are various cities at points around the x-y plane that are separated by great geographical distances, and thus are hard to travel between. The mayors of the cities have decided that they will undertake a road-paving plan to connect all of the cities. However, they do not know how long this will take.

At time zero, the roads are of zero length. Each time unit, the roads leading out of each city in the four cardinal directions (north, east, south, and west) will be extended by one unit. When roads from two different cities both contain at least one point in common, their two cities are connected, and all cities connected to those two cities are also considered connected. Your job is to figure out how long the construction job will take.

You will be given a int[] x and a int[] y, where the location of the i-th city is at (x[i], y[i]). Given the locations of all the cities in the x-y plane, your method should return the first time unit at which all the cities are connected to each other.
 
Definition
    	
Class:	CityLink
Method:	timeTaken
Parameters:	int[], int[]
Returns:	int
Method signature:	int timeTaken(int[] x, int[] y)
(be sure your method is public)
    
 
Notes
-	Connectedness is transitive; i.e., if city A is connected to city B, and B is connected to C, then A is connected to C.
 
Constraints
-	x will contain between 1 and 50 elements, inclusive.
-	y will contain the same number of elements as x.
-	Each element of x will be between -1000000 and 1000000, inclusive.
-	Each element of y will be between -1000000 and 1000000, inclusive.
-	No two cities will be at the same coordinates.
 
Examples
0)	
    	
2
0 5

0 5	

Returns: 5

The road north from (0,0) will intersect the road west from (5,5) at t = 5.
1)	
    	
2
0 0

30 -59

Returns: 45

2)	
    	
50 

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26  
27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49	

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 
 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49}

Returns: 1

3)	
1    	

100000

-1000000

Returns: 0

4)	
12 
  	
1593 -88517 14301 3200 6 -15099 3200 5881 -2593 11 57361 -92990


99531 -17742 -36499 1582 46 34001 -19234 1883 36001 0 233 485

Returns: 73418
*/