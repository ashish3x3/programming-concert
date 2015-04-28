
public class AnagramPalindrome {

	public static void main(String[] args) {
		
		
		//String str="aaaaccad";
		//String str="abcd";
		String str="abba";
		
		palindrome(str);

	}
	
	public static void palindrome(String str){
		
		int [] num=new int[26];
		
		for(int i=0;i<str.length();++i){
			num[str.charAt(i)-'a']++;
			
		}
			
			int count=0;
			
			for(int i=0;i<num.length;++i){
				
				
				if(count>1){
					//System.out.println(" Not a palindrome");
				       break;
				}
				
				       else if(num[i]%2!=0)  
					count++;
				
				
		}
			
			if(count>1)
				System.out.println("Not a plinadrome");
			
			else 
				System.out.println("Yes a plinadrome");
						
	}

}
