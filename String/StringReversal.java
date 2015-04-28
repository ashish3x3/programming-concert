
public class StringReversal {

	
	String reverse="";
	
	public String reversal(String str){
		
		if(str.length()==1)
			return str;
		
		else{
			
			reverse += str.charAt(str.length()-1) + reversal(str.substring(0,str.length()-1));
			return reverse;

		}
			} 
	
	public static void main(String [] args){
		
		StringReversal rev=new StringReversal();
		System.out.println("reverse is "+ rev.reversal("ASHISH"));
		
	}
	
	
	
}
