import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	
	public static int finalVal;

	public static void main(String[] args) throws IOException {
		Scanner scan=new Scanner(System.in);
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int N;
		
		N=scan.nextInt();
		String [] list=new String[N];
		
		// String patter = "(.*)(\\s+)(.*)";
		
		//String pattern = "[a-z?\\s]{0,99}";
		
		for(int i=0;i<N;++i){
			
			try {
				list[i]=buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//scan.nextLine(); 
			//if(!list[i].matches(pattern)){ //write regular exp for a-z,?
				//System.out.println("No");
			//	 System.exit(-1); 
			
		//}
		}
		
		
		//scan.nextLine(); 
		//if(!list[i].matches(pattern)){ //write regular exp for a-z,?
			//System.out.println("No");
		//	 System.exit(-1); 
		
	//}
	//}
		String pattern = "[a-z?\\s]{0,99}";
		for(int i=0;i<N;++i){
				if(!list[i].matches(pattern)){ //write regular exp for a-z,?
			//System.out.println("No");
			  System.exit(-1); 
		}
		
		}
		
		intersection(list,N);
		
		buf.close();
		scan.close();
		
	}//main
	
	//@SuppressWarnings({ "null", "null" })
	public static void intersection(String [] list,int N){
		
		HashMap<Character,Integer> mapA=new HashMap<Character,Integer>();
		HashMap<Character,Integer> mapB=new HashMap<Character,Integer>();
		
		Iterator iterator=null;
		Iterator iteratorA=null;
		Iterator iteratorB=null;
		Set<Character> keys=null;
		Set<Character> keysA=null;
		Set<Character> keysB=null;
		boolean flag=false;
		boolean mayBe=false;
		//ArrayList<String> l=new ArrayList<String>(Arrays.asList(list[0]));
		
		Character[] arr=new Character[list[0].length()]; 
		
		for(int L=0;L<list[0].length();++L)
			arr[L]=list[0].charAt(L);
		 
		
		for(int i=1;i<=N-1;++i){
			
			if(arr.length!=0){
				
				
				mapA.clear();
				mapB.clear();
				for(int k=0,j=0;k<arr.length||j<list[i].length();++k,++j){
					
					if(k<arr.length){
						//System.out.println("  "+Arrays.toString(arr)); 
						if(arr[k]!=null)
						mapA.put(arr[k], new Integer(k));
					}
					if(j<list[i].length()){
						//System.out.println("  "+list[i]);
						//if(arr[j]!=null)
						mapB.put(list[i].charAt(j), new Integer(j));
					}
				}//for k,j
				//System.out.println("  "+mapA);
				//System.out.println("  "+mapB);
				
				arr=new Character[list[0].length()];
				keys=mapB.keySet();
				iterator=keys.iterator();
				
				int m=0;
				Character ch='?';
				if(mapA.containsKey(ch)||mapB.containsKey(ch)){
					//System.out.println("inside if map ?");
					if(mapA.containsKey(ch) && mapB.containsKey(ch)){
						keysA=null;
						keysA=mapA.keySet();
						iteratorA=null;
						iteratorA=keys.iterator();
						
						keysB=null;
						keysB=mapB.keySet();
						iteratorB=null;
						iteratorB=keysB.iterator();
						Character cmn=null;
 						while(iteratorA.hasNext()){
 							cmn=(Character)iteratorA.next();
 							if(mapB.containsKey(cmn) && cmn!=ch) 
 							{
 								arr[m]=(Character) iteratorA.next();
 								m++;
  								mayBe=true;
 							}
 							
 						}
						
						
					}//if both
					else
					if(mapA.containsKey(ch)){
						//System.out.println("inside if mapA ?");
						keys=null;
						keys=mapB.keySet();
						iterator=null;
						iterator=keys.iterator();
						
						while(iterator.hasNext()){
							
							//if(iterator.next()!=ch){
								
								arr[m++]=(Character) iterator.next();
								mayBe=true;
						//	}//if
							
						}//while
						
					}//if mapA
					else{
						//System.out.println("inside if mapB ?");
						keys=null;
						keys=mapA.keySet();
						iterator=null;
						iterator=keys.iterator();	
						
						while(iterator.hasNext()){
							
							//if(iterator.next()!=ch){
							//	System.out.println(""+(Character)iterator.next());
								arr[m++]=(Character)iterator.next();
								mayBe=true;
							//}//if
							
						}//while
						
						
					}//else mapB
					
					
				}//if mapA or mapB
				
				else{
					//System.out.println("inside no map ?");
					//keys=null;
					keys=mapB.keySet();
					//iterator=null;
					iterator=keys.iterator();
					//while(iterator.hasNext()){
					//	System.out.print("  iterator= ::"+(Character)iterator.next());
						
					//}
					
					while(iterator.hasNext()){
						//System.out.println("inside while of iterator"); 
						Character common=(Character)iterator.next();
						
						if(mapA.get(common)!=null && common!=ch){
							
							arr[m]=common.charValue();
							System.out.println("char geting stored  "+m+"  "+arr[m]); 
							m++;
							
							flag=true;
							
						}//if common
						 
						
					}//while
					//System.out.println("outside iterator next"+Arrays.toString(arr));
					
				}//else if not mapA||mapB
				
				if(flag==true||mayBe==true){
					//l=null;
					System.out.println("inside arr print  ");
					System.out.println(""+Arrays.toString(arr)); 
					finalVal=m;
					//m--;
					//arr=new Character[m];
					//if(arr.length!=0){
					// l.add(Arrays.toString(arr));
					}
				else{
					
					arr=new Character[0];
				}
				
			
				
				
			}//if list[0] not null
			
			else{
				//System.out.println("break");
				
				break;
			} //break
			
			
			
			
		}//for i to N
		//System.out.println("");
		//System.out.println("outside"+finalVal);
		
		if(finalVal>0 && mayBe==true){
			System.out.println("May Be");
		}
		else if(finalVal<=0 ){
			System.out.println("NO");
		}
		else
			System.out.println("Yes");
		
		
	}//intersection

}//class over
