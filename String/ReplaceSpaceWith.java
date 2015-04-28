import java.util.Arrays;


public class ReplaceSpaceWith {

	public static void main(String[] args) {
		String str="My Name is Ashish";
		char [] ch=new char[str.length()];
		ch=str.toCharArray();
		
		convert(str);
		convertWithReplaceAll(str);
		convertWithoutExtraSpace(str);

	}
	
	public static void convert(String str){
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length();++i){
			if(str.charAt(i)==' '){
				
				sb.append("%20");
			}
			else
				sb.append(str.charAt(i)); 
			
		}
		
		
		System.out.println("  converted string "+sb);
		
		
	}
	
	public static void convertWithReplaceAll(String str){
		
		StringBuffer sb=new StringBuffer(str);
		 str=str.replaceAll(" ", "%20");
		
		System.out.println("  converted string "+str);
		
	}
	
	public static void convertWithoutExtraSpace(String str){
		
		//char [] ch=new char[str.length()];
		//ch=str.toCharArray();
		int count=0;
		for(int i=0;i<str.length();++i){
			
			if(str.charAt(i)==' '){
				
				count++;
			}
			
		}
			
			int newLen=str.length()+count*3;
			char [] ch=new char[newLen+1];
			
		 ch[newLen]='\0';
			
			for(int i=str.length()-1;i>=0;--i){
				
				if(str.charAt(i)==' '){
					ch[newLen-1]='0';
					ch[newLen-2]='2';
					ch[newLen-3]='%';
					
					
					newLen-=3;
					
				}
				
				else{
					ch[newLen-1]=str.charAt(i);		
					newLen-=1;
				}
				
			}
			
			System.out.println(" withOut Space "+new String(ch)); 
			//String str1=Arrays.toString(ch);
			//System.out.println(" withOut Space "+str1); 
			
			
			
	}
	
	


}
