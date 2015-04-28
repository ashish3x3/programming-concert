import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Solution1 {
	
	public static int finalVal;

	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan=new Scanner(System.in);
		int N;
		
		N=scan.nextInt();
		String [] list=new String[N];
		//if(N<1 && N>50000){
            //System.out.println("No");
			//System.exit(-1);
        //}
		//if(N>1 && N<50000)
	   // list=new String[N];
		
		String pattern = "(([a-z?\\s+ ]).{0,99})";
		for(int i=0;i<N;++i){
			
			//list[i]=buf.readLine();
			//scan.nextLine();
			
			
				//scan.nextLine();
			
			list[i]=scan.next(); 
			
		}
		
		/*for(int i=0;i<N;++i){
			
			//list[i]=buf.readLine();
			//scan.nextLine();
			System.out.println(""+list[i]+""+i);
			
}
*/
      for(int i=0;i<N;++i){
				
		if(!list[i].matches(pattern)){ //write regular exp for a-z,?
			System.out.println("No");
			  System.exit(-1); 
		}
		}
		
		
		intersection(list,N);
		
		
		scan.close();
	}//main
	
	
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
		
		
		Character[] arr=new Character[list[0].length()]; 
		
		for(int L=0;L<list[0].length();++L)
			arr[L]=list[0].charAt(L);
		
		
		for(int i=1;i<=N-1;++i){
			
			if(arr.length!=0){
				
				mapA.clear();
				mapB.clear();
				for(int k=0,j=0;k<arr.length||j<list[i].length();++k,++j){
					
					if(k<arr.length){
						
						if(arr[k]!=null)
						mapA.put(arr[k], new Integer(k));
					}
					if(j<list[i].length()){
						
						mapB.put(list[i].charAt(j), new Integer(j));
					}
				}//for k,j
				
				
				arr=new Character[list[0].length()];
				keys=mapB.keySet();
				iterator=keys.iterator();
				
				int m=0;
				Character ch='?';
				if(mapA.containsKey(ch)||mapB.containsKey(ch)){
					
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
					
					if(mapA.containsKey(ch)){
						
						keys=null;
						keys=mapB.keySet();
						iterator=null;
						iterator=keys.iterator();
						
						while(iterator.hasNext()){
							
							
								
								arr[m++]=(Character) iterator.next();
								mayBe=true;
						
							
						}//while
						
					}//if mapA
					else{
						
						keys=null;
						keys=mapA.keySet();
						iterator=null;
						iterator=keys.iterator();	
						
						while(iterator.hasNext()){
							
							
								arr[m++]=(Character)iterator.next();
								mayBe=true;
							//}//if
							
						}//while
						
						
					}//else mapB
					
					
				}//if mapA or mapB
				
				else{
					
					
					keys=mapB.keySet();
					
					iterator=keys.iterator();
					
					
					while(iterator.hasNext()){
						
						Character common=(Character)iterator.next();
						
						if(mapA.get(common)!=null){
							
							arr[m]=common.charValue();
							
							m++;
							
							flag=true;
							
						}//if common
						 
						
					}//while
					
					
				}//else if not mapA||mapB
				
				if(flag==true||mayBe==true){
					
					
					finalVal=m;
					
					}
				else{
					
					arr=new Character[0];
				}
				
			
				
				
			}//if list[0] not null
			
			else{
				
				
				break;
			} //break
			
			
			
			
		}//for i to N
		
		
		if(finalVal>0 && mayBe==true){
			System.out.println("Maybe");
		}
		else if(finalVal<=0 ){
			System.out.println("No");
		}
		else
			System.out.println("Yes");
		
		
	}//intersection

}//class over
