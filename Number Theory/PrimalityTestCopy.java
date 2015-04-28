import java.io.*;
	import java.util.*;
	public class PrimalityTestCopy {
	 
    /**
     * @param args
	     * @throws IOException
	     */
	    public static void main(String[] args) throws IOException {	        // TODO Auto-generated method stub	 
	        BufferedReader reader;
	        reader = new BufferedReader(new InputStreamReader(System.in));
	         
	        //Declare variables
        String input ;
	        int UserNumber = 0;
	        int prime = 0;
	        boolean yes = false;
	        int n1 = 0;
	        int n2 = 0;
	        //Prompt user.
	        System.out.println("Please enter an integer");
	         
	         
	         // Get input from user, change to integer
	        input = reader.readLine();
	        UserNumber = Integer.parseInt(input);
	         
	        prime = UserNumber;
	         
	         Random rand = new Random();
	 
	         int randomNum = rand.nextInt((prime -1) +1) + 1;
	          
	        while (yes != true) {
	         
	         
	              
	         
	        if (Math.pow(randomNum ,(prime -1)) == (1 % prime)){
	            yes = true ;
	             
	        }
	        else{
	            yes = false;
	            prime++;
	        }
	         
	 
	            }
	         
	        System.out.println("The first prime number greater than " + UserNumber +" is " + prime);
	         
	    }
	}