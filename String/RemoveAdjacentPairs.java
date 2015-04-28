/*
 * Eliminate the pairs (two same chars adjacent to each other) in string
 * You are given a string. You have to eliminate the pairs (two same chars adjacent to each other).

eg. input string RGBBGBGR –> RGGBGR–> RBGR (output)
 */

import java.util.Stack;


public class RemoveAdjacentPairs {

	public static void main(String[] args) {
		String str="RGBBGBGR ";
		remove(str);
		
		//O(n) space and O(n) complexity
		Stack<Character> st = new Stack<Character>();
		String inputString = "RGBBGBGR";
		for( int i=0 ; i < inputString.length() ; i++ )
		{
		char ch = inputString.charAt(i);
		char top ;
		
		if( !st.empty())
		{
		  top = st.peek();

		  if( top == ch)
		  st.pop();
		else
		  st.push(ch);
		}

		else
		  st.push(ch);
		}
		  String result = "";
		  
		while( !st.empty() )
		{
		  result = st.pop()+result;
		}
		  System.out.println(result);
		

	}
	public static void remove(String str){
		
		char[] ch=str.toCharArray();
		
		int len=ch.length;
		int j=0;
		for(int i=1;i<len;++i){
			
			while(j>=0 && ch[i]==ch[j]){
				
				i++;
				j--;
				
				
			}
			//System.out.println("j,i = "+j+""+ i+""+ch[++j]+""+ch[i]);
			ch[++j]=ch[i];
			//System.out.println(new String(ch));
			
			
			
		}
		//ch[++j]='\0';
		
		System.out.println(new String(ch).substring(0, j));
		
		
	}

}
