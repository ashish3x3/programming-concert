/*
 * Longest substring without repeating characters
 * . However, the time complexity is higher - O(n^3).
 */


import java.util.HashMap;



public class LengthOfLongestSubstring{
	
	public static void main(String [] args){
		
		String str="GeeksForGeeks";    //o/p 7
		int res=lengthOfLongestSubstring(str);
		System.out.println(""+res);
		
		
	}
	

public static int lengthOfLongestSubstring(String s) {
 
	char[] arr = s.toCharArray();
	int pre = 0;
 
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
 
	for (int i = 0; i < arr.length; i++) {
		if (!map.containsKey(arr[i])) {
			map.put(arr[i], i);
		} else {
			pre = Math.max(pre, map.size());
			//System.out.println(""+map);
			i = map.get(arr[i]);  //will get the previous index of repeated character
			//System.out.println(""+i);
			map.clear();  //empty map and enetr new chaaracter from begining  from break point
		}
	}
	
	System.out.println(""+map);
 
	return Math.max(pre, map.size());
}

}