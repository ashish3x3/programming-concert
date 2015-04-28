/*
 * Remove duplicate characters in a string
 */

//Time Complexity : O(N) with extra space
//without having extra space has O(n^2)
public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		String str = "RGBBGBGR";          //output RGB     
		removeDuplicates(str);

	}
	
	public static void removeDuplicates(String str){
		
		if(str.length()==0)
			return;
		if(str.length()<2)
			System.out.println(str);
		int tail=0;
		boolean hit[]=new boolean[256];
		char ch[]=str.toCharArray();
		
		for(int i=0;i<ch.length;++i){
			
			if(hit[ch[i]]==false){
				hit[ch[i]]=true;
				ch[tail]=ch[i];
				tail++;
				
			}
			
		}
		
		System.out.println(new String(ch).substring(0,tail)); 
		
		
		
		
	}

}
