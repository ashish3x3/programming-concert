import java.util.*;


public class AnaGram {

	public static void main(String[] args) {
		String str1="ashish";
		String str2="hsihsa";
		String str3="ajay";
		
		anagram(str1,str3);     // //print not  anagram
		anagram(str1,str2);   //print  anagram

	}
	
	public static void anagram(String str1,String str2){
		
		Set<Character> set1=new TreeSet<Character>();
		Set<Character> set2=new TreeSet<Character>();
		
		for(int i=0;i<str1.length();++i){
			set1.add(str1.charAt(i));
			
			
		}
		//System.out.println("set1= "+set1.toString());
		
		for(int i=0;i<str2.length();++i){
			set2.add(str2.charAt(i));
			
			
			
		}
		//System.out.println("set2= "+set2.toString());
		
		int x=sum(set1);
		int y=sum(set2);
		//System.out.println("x= "+x);
		//System.out.println("y= "+y);
		
		if(x==y)
			System.out.println("yes Anagram");
		else
			System.out.println("Not Anagram");
			
		
		
	}
	
	public static int sum(Set<Character> set1){ 
		System.out.println("set= "+set1.toString());
		Iterator it=null;
		
		it=set1.iterator();
		int sum=0;
		Character n=null;
		while(it.hasNext()){
			n=(Character) it.next();
			//System.out.println(""+(int)n);
			sum+=(int)n;
			
		}
		
		return sum;
	}

}
