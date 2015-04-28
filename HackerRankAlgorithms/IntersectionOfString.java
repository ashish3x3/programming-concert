import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntersectionOfString {
	
	public static int finalVal;

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		int N;
		System.out.println("Enter N");
		N=scan.nextInt();
		String [] list=new String[N];
		
		// String patter = "(.*)(\\s+)(.*)";
		
		String pattern = "[a-z?\\s]{0,99}";
		System.out.println("Enter the Keys");
		for(int i=0;i<N;++i){
			list[i]=scan.next();
			
			/*try {
				list[i]=buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			//scan.nextLine(); 
			//if(!list[i].matches(pattern)){ //write regular exp for a-z,?
				//System.out.println("No");
			//	 System.exit(-1); 
			
		//}
		}
		//String pattern = "(([a-z? ]).{0,100})";
		for(int i=0;i<N;++i){
				if(!list[i].matches(pattern)){ //write regular exp for a-z,?
			//System.out.println("No");
			  System.exit(-1); 
		}
		
		}
		
		intersection(list,N);
		
		
		scan.close();
		
	}//main
	
	//@SuppressWarnings({ "null", "null" })
	public static void intersection(String [] list,int N){
		
		HashMap<Character,Integer> mapA=new HashMap<Character,Integer>();
		HashMap<Character,Integer> mapB=new HashMap<Character,Integer>();
		
		Iterator iterator=null;
		Iterator iteratorA=null;
		Iterator iteratorB=null;
		Iterator iteratorC=null;
		Set<Character> keys=null;
		Set<Character> keysA=null;
		Set<Character> keysC=null;
		Set<Character> keysB=null;
		boolean flag=false;
		boolean mayBe=false;
		int isSpecial=0;
		int nonSpecial=0;
		int count=0;
		Character ch='?';
		//ArrayList<String> l=new ArrayList<String>(Arrays.asList(list[0]));
		
		Character[] arr=new Character[list[0].length()]; 
		
		for(int L=0;L<list[0].length();++L)
			arr[L]=list[0].charAt(L);
		System.out.println(""+Arrays.toString(arr)); 
		
		for(int i=1;i<=N-1;++i){
			
			if(finalVal!=0 || i==1){
				System.out.println("i=  "+i); 
				System.out.println(" "+i+"  "+Arrays.toString(arr));
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
				System.out.println("  "+mapA);
				System.out.println("  "+mapB);
				
				arr=new Character[list[0].length()];
				keys=mapB.keySet();
				iterator=keys.iterator();
				
				int m=0;
				//Character ch='?';
				boolean compare=false;
				
				
				if((mapA.containsKey(ch) && i==1)||mapB.containsKey(ch)){
					System.out.println("inside if map ?");
					compare=true;
					
					if(mapA.containsKey(ch) && mapB.containsKey(ch)){
						isSpecial++;
						isSpecial++;
						
						System.out.println("inside if both map ?");
						keysA=null;
						keysA=mapA.keySet();
						iteratorA=null;
						iteratorA=keysA.iterator();
						
						keysB=null;
						
						keysB=mapB.keySet();
						iteratorB=null;
						iteratorB=keysB.iterator();
						Character cmn=null;
						
 						while(iteratorA.hasNext()){
 							cmn=(Character)iteratorA.next();
 							System.out.println("cmn = "+cmn);
 							if(mapB.containsKey(cmn) && cmn.charValue()!=ch) 
 							{   
 								System.out.println("mapB= "+mapB);
 								arr[m]=cmn.charValue();
 								m++;
  								mayBe=true;
 							}
 							
 						}
 						
 						if(m!=0)
 							count++;
						
						
					}//if both
					else
					if(mapA.containsKey(ch)){
						isSpecial++;
						System.out.println("inside if mapA ?");
						keys=null;
						keys=mapB.keySet();
						iterator=null;
						iterator=keys.iterator();
						Character ca=null;
						while(iterator.hasNext()){
							
							//if(iterator.next()!=ch){
							ca=(Character)iterator.next();
							if(mapA.containsKey(ca) && ca.charValue()!=ch){
								arr[m]=ca.charValue();;
								m++;
								mayBe=true;
							}
						//	}//if
							
						}//while
						
						if(m!=0)
							count++;
						
					}//if mapA
					else{
						
						isSpecial++;
						System.out.println("inside if mapB ?");
						keys=null;
						keys=mapA.keySet();
						iterator=null;
						iterator=keys.iterator();	
						Character cb=null;
						while(iterator.hasNext()){
							
							//if(iterator.next()!=ch){
							cb=(Character)iterator.next();
							if(mapA.containsKey(cb) && cb.charValue()!=ch){
								arr[m]=cb.charValue();;
								m++;
								mayBe=true;
							}
							
						}//while
						if(m!=0)
							count++;
						
						
					}//else mapB
					
					
				}//if mapA or mapB
				
				else{
					System.out.println("inside no map ?");
					//compare=true;
					nonSpecial++;
					//keys=null;
					keys=mapB.keySet();
					//iterator=null;
					iterator=keys.iterator();
					//while(iterator.hasNext()){
					//	System.out.print("  iterator= ::"+(Character)iterator.next());
						
					//}
					
					while(iterator.hasNext()){
						System.out.println("inside while of iterator"); 
						Character common=(Character)iterator.next();
						
						if(mapA.get(common)!=null && common!=ch){
							
							arr[m]=common.charValue();
							System.out.println("char geting stored  "+m+"  "+arr[m]); 
							m++;
							
							flag=true;
							
						}//if common
						
					}//while
					
					if(m!=0)
						count++;
					System.out.println("outside iterator next"+Arrays.toString(arr));
					
				}//else if not mapA||mapB
				if(nonSpecial!=0 && m==0){
					
					finalVal=0;
				}
				else if(flag==true||mayBe==true){
					//l=null;
					System.out.println("inside temp arr print  ");
					System.out.println("arr ="+Arrays.toString(arr)); 
					finalVal=m;
					//m--;
					//arr=new Character[m];
					//if(arr.length!=0){
					// l.add(Arrays.toString(arr));
					}
				else{
					if(compare==true && m==0 && isSpecial!=0){
						if(mapA.containsKey(ch)){
						keysC=null;
						keysC=mapA.keySet();
						iteratorC=null;
						iteratorC=keysC.iterator();
						Character cd=null;
						int z=0;
						while(iteratorC.hasNext()){
							cd=(Character)iteratorC.next();
							if(cd.charValue()!=ch){
							arr[z]=cd.charValue();
							z++;
							}
							
						}
					}
						finalVal=arr.length;
					}
					//arr=new Character[0];
					//finalVal=0;
				}
				
			
				
				
			}//if list[0] not null
			
			else{
				System.out.println("break");
				
				break;
			} //break
			
			
			
			
		}//for i to N
		System.out.println("");
		System.out.println("outside"+finalVal);
		
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
