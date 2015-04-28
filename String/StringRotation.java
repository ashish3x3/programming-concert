/* Check whether a String is a rotation of another String */


public class StringRotation {

	public static void main(String[] args) {
		String str="crazyforcode";
		String str2="forcodecrazy";
		String str3="forcodecrazya";
		
		boolean res=check(str,str2);   //result True
		
		checkWithConcat(str,str2);      //result true
	
		System.out.println(" result ="+res);
		
		res=check(str,str3);   //result False
		
		checkWithConcat(str,str3);      //result false
		
		System.out.println(" result ="+res);
		
		

	}
	
	public static boolean check(String str,String str2){
		boolean isRotation=false;
		
		if(str.length()!=str2.length())    //if length of both string not same return false
		     return false;
		
		for(int i=0;i<str.length();++i){
			//compare first character of string to be search with input string
			if(str.charAt(i)==str2.charAt(0)){   
				//if true set rotation =true
				isRotation=true;              
			
			for(int j=1;j<str2.length();++j){
				//compare rest of the search string  in input string
				
				//% operator in case input string gets over while characters in search string still remains 
				i=(i+1)%str.length();   //ensure circular traversal
				if(str.charAt(i)!=str2.charAt(j)){
					
					isRotation=false;
					break;
					
					
				}
			}
			return isRotation;
			
			}
				
		}
		
		return false;
		
	}
	
	public static boolean checkWithConcat(String str,String str2){
		
		
		if(str.length()!=str2.length())  {  //if length of both string not same return false
			System.out.println("False ");
			return false;
		}
		String temp=str.concat(str);    //Concatenation of input string with itself
		
		if(temp.toLowerCase().contains(str2)){
			System.out.println("True ");
			return true;
		}
		else{
			System.out.println("False");
			return false;
		}
		
	}
	
	

//NOTE:
	

//There is a contains() method! It was introduced in Java 1.5. If you are 
	//using an earlier version, then it's easy to replace it with this:

//       str.indexOf(substr) != -1   return true




	
	
	

}
