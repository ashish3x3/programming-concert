import java.util.*;
public class FrequencyNumberOfString {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String str="ababcd";
		
		//String str="acacbf";
		
		int i=0,count=0;
		//boolean [] vis=new boolean[26];
		
		for(i=0;i<str.length();++i){
			count=0;
			for(int j=0;j<str.length();++j){
				if(j<i && str.charAt(i)==str.charAt(j)){
					break;
				}
				if(str.charAt(i)==str.charAt(j))
					count++;
				
				if(j==str.length()-1){
					
					System.out.print(""+str.charAt(i)+""+count);
				}
			
			}
			
			
			
		}
		
		
		/*
		 * 
		 * public static int findFreq(String[] arr,char c) {
    Map<Character,Integer> map  = new HashMap<Character,Integer>();
    for(int i=0;i<arr.length;i++) {
        for(Character ch : arr[i].toCharArray()){
            if(map.containsKey(ch)) 
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch, 1);
        }
    }
    return map.get(Character.valueOf(c));
 }
		 */
		
		
		
		//scan.close();
	}

}
