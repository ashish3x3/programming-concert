import java.util.*;

public class GridMatrix{
    
    public static int rows;
    public static int cols;
    public static Integer [][] arr=null;
    public static Integer [] arr1=null;
    

     public static void main(String []args){
    	 /*
       arr = new Integer[][]{ 
                        {1,1,0,0,0},
                        {0,1,1,0,0},
                        {0,0,1,0,1},
                        {1,0,0,0,1},
                        {0,1,0,1,1}
            
                    };
                    */
       arr = new Integer[][]{ 
               {1,0,1,1},
               {1,0,1,0},
               
   
           };
         /*           
        arr = new Integer[][]{ 
                {1,1,0,0,1},
                {1,0,0,1,0},
                {1,1,0,1,0},
                {0,0,1,0,0}
                
    
            };*/
                    rows=arr.length;
                    cols=arr[0].length;
                    
        int k=0;
       arr1=new Integer[rows*cols];
        for(int i=0;i<rows;++i)
         { for(int j=0;j<cols;++j){
             arr1[k++]=arr[i][j];
            System.out.print(""+arr[i][j]);
          }
          System.out.println("");
     }
        
        for(int i=0;i<arr1.length;++i)
        	System.out.print("  "+arr1[i]);
        
        System.out.println("  ");
     
     int count=0;
     for(int i=0;i<rows*cols;++i){
         if(arr1[i]==1){
             count++;
             flip(arr1,(Integer)i);
         }
         
         
     }
     System.out.println("\n"+count);
     
     System.out.println("\n");
     System.out.println("\n");
     
     
     }//main
     
     public static void flip(Integer [] arr1,Integer index){
         Integer row=index/cols;
         Integer col=index%cols;
        // System.out.print(", "+row+"-"+col +",");
         arr[row][col]=0;
         
         Stack<Integer> stack=new Stack<Integer>();
         
         stack.push(arr1[index]);
         Integer top=0;
         
         while(!stack.isEmpty()){
             top=stack.peek();
             stack.pop();
           if(top==0){
               continue;
           }
           
           
         
         //up
        
         if(row>0 && arr1[(row - 1) * cols + col]==1){
             stack.push(arr1[(row - 1) * cols + col]);
             arr1[(row - 1) * cols + col]=0;
         }
         
             
        //down
         
        if(row<rows-1 && arr1[(row + 1) * cols + col]==1){
             stack.push(arr1[(row + 1) * cols + col]);
             arr1[(row + 1) * cols + col]=0;
     }
   
    
             
        //left
        if(col>0 && arr1[index-1]==1){
             stack.push(arr1[index-1]);
             arr1[index-1]=0;
        }
        
        //right
        if(col<cols-1 && arr1[index+1]==1){
             stack.push(arr1[index+1]);
             arr1[index+1]=0;
        }
        
        //Right Top diagonal
        if(row>0 && col<cols-1 && arr1[(row - 1) * cols + col+1]==1){
            stack.push(arr1[(row - 1) * cols + col+1]);
            arr1[(row - 1) * cols + col+1]=0;
       }
        
      //Right Bottom diagonal
        if(row<rows-1 &&col>cols-1 && arr1[(row + 1) * cols + col+1]==1){
            stack.push(arr1[(row + 1) * cols + col+1]);
            arr1[(row + 1) * cols + col+1]=0;
       }
        
      //Left Bottom diagonal
        if(row<rows-1 &&col>0 && arr1[(row + 1) * cols + col-1]==1){
            stack.push(arr1[(row + 1) * cols + col-1]);
            arr1[(row + 1) * cols + col-1]=0;
       }
        
      //Left Top diagonal
        if(row>0 &&col>0 && arr1[(row - 1) * cols + col-1]==1){
            stack.push(arr1[(row - 1) * cols + col-1]);
            arr1[(row - 1) * cols + col-1]=0;
       }
         
         }//stack.isEmpty
         
     }
     
     
     
}
