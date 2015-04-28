
public class MinLengthAnagramSubsequence {

	public static void main(String[] args) {
		String str1="This is a Test String";
		String str2="tist";
		findLengthAndSequence(str1,str2);

	}//main
	
	public static void findLengthAndSequence(String str1,String str2){
		
		int begin=0,biginWith=0,endWith=0,count=0,minLen=Integer.MAX_VALUE,len=0;
		int l=0;
		
		int [] hasFound=new int[256];
		int [] toFound=new int[256];
		
		//for(int j=0;j<256;++j)
			//System.out.print(""+toFound[j]);     //print all 0
		
		for(int i=0;i<str2.length();++i){
			
			toFound[(int)str2.charAt(i)]++;
			//System.out.print(""+toFound[(int)str2.charAt(i)]); //all fine 1 1 2
			
		}
		
		//for(int j=0;j<256;++j)
			//System.out.print(""+toFound[j]);   //all fine 1 1 2
		
		for(int end=0;end<str1.length();++end){
			
			if(toFound[(int)str1.charAt(end)]==0)
				continue;
			
			hasFound[(int)str1.charAt(end)]++;
			
			if(hasFound[(int)str1.charAt(end)]<=toFound[(int)str1.charAt(end)]){
				count++;
				//System.out.println(" "+hasFound[(int)str1.charAt(end)]+" "+str1.charAt(end) ); 
			}
			
			if(count==str2.length()){
				
				l++;		//add this to find number of such anagram in string
				System.out.println("l= "+l+" "+begin+" "+end); 
				
				//System.out.print("count "+count+" "+str1.charAt(end)+" "+end); 
				
				while(toFound[(int)str1.charAt(begin)]==0 || hasFound[(int)str1.charAt(begin)]>toFound[(int)str1.charAt(begin)]  )
				{
					if(hasFound[(int)str1.charAt(begin)]>toFound[(int)str1.charAt(begin)]){
						hasFound[(int)str1.charAt(begin)]-=1;
						//System.out.println(" reduce "+str1.charAt(begin)); 
					}
					
					//System.out.println(" reduce "+str1.charAt(begin)); 
					begin++;
					
					//for(int j=0;j<256;++j){
						//if(hasFound[j]!=0)
					//System.out.print(""+hasFound[j]);     //print all 0
					//}
					
					
				}//while
				
				
			
			
			len=end-begin+1;
			if(minLen>len){
				minLen=len;
				endWith=end;
				biginWith=begin;
				
				
			}
		}//if	
			
			
		}//end
		
		//System.out.println("bigin= "+biginWith+" EndWith= "+endWith);
		
		for(int i=biginWith;i<=endWith;++i){
			System.out.print(""+str1.charAt(i));
			//System.out.println("INNNN= ");
			
			
		}
		
		//System.out.println("length= "+str1);
		
		
		
	}

}
