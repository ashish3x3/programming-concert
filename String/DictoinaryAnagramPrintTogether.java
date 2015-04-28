 /* print all anagram together  from dictionary  */
		//sort the string lexiography order of dictionary..
     //  char[] a=str.toCharArray();........Arrays.sort(a);..
		//if matching put together..
		//put the original string str[i] in hashmap at index "sorted string" 
		//all which match sorted string..anaMap.put(sorted, l);



import java.util.*;

public class DictoinaryAnagramPrintTogether {
	
	public static HashMap<String,ArrayList<String>>anaMap=
			                              new HashMap<String,ArrayList<String>>();
 
	public static void main(String[] args) {
		
		String [] dictionary={"bat", "labl", "rat", "xyz", "ball", "tab", "tar"};
		
		findAnagram(dictionary);
		

	}
	
	/* Scanner s = new Scanner(new File(args[0]));   //taking from a file
            while (s.hasNext()) {
                String word = s.next();
                String alpha = sorting(word);
                .......
                */
	
	public static void findAnagram(String[] dictionary){
		
		int len=dictionary.length;
		
		for(int i=0;i<len;++i){
			
		String sorted=sortLexi(dictionary[i]);
		
		ArrayList<String> l=anaMap.get(sorted); ///retrieving older stored value from map
												//and appending new l to it if not null
		if(l==null)
			l=new ArrayList<String>();
		
		
			l.add(dictionary[i]);
			anaMap.put(sorted, l);
		
		
		}//for
		
		
		Set<String> st=anaMap.keySet();
		
		Iterator<String> itr=st.iterator();
		while(itr.hasNext()){
			//System.out.println("  "+itr.next());
		  printAnagram(itr.next());
			
		}
		
		
	}
	
	public static void printAnagram(String str){
		
		if(str==null)
			System.out.println("null Input");
		
		else {
			
			ArrayList<String> wordList=getAnagram(str);
			Iterator<String> itr=wordList.iterator();
			
			while(itr.hasNext()){
				System.out.print(" "+itr.next());
				
				
			}
			
		}
		
		
		
		
	}
	
	public static ArrayList<String> getAnagram(String str){
		
		if(str==null)
			return null;
		
		return anaMap.get(str);
		
	}
	
	public static String sortLexi(String str){
	
		char[] a=str.toCharArray();
		Arrays.sort(a);
		return new String(a);
		
	
	}

}
