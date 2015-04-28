import java.util.*;


public class SubstringQueries {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int Q;
		
		//System.out.println("entre TestCase");
		int T=scan.nextInt();
		
		String []str2;
		int [] res = null;
		ArrayList a=new ArrayList();
		int m=0;
		
		while(T > 0){
		//System.out.println("entre a String");
		String str=scan.next();
		
		//System.out.println("entre query number");
		// Q=scan.nextInt();
		//Q=scan.nextInt();
		Q=scan.nextInt();
		
		res=new int[Q];
		
		int z=0;
		int x=0;
		str2=new String[Q];
		while(z<Q){
		//System.out.println("entre query " + z);
		str2[x++]=scan.next();
		//res[z++]=findLengthAndSequence(str,str2);
		z++;
		
		}
		
		for(int i=0;i<str2.length;++i){
			a.add(m++,findLengthAndSequence(str,str2[i]));
			
		}
		T--;
	}//while
		
		for(int i=0;i<a.size();++i){
			System.out.println(" "+a.get(i));
			
		}
		

	}//main
	
	
	//Find the number of occurrences of a subsequence in a string
	
	public static int findLengthAndSequence(String str1,String str2){
		
		int [][] tb=new int[str1.length()+1][str2.length()+1];
		
		for(int i=0;i<tb.length;++i){
			
			for(int j=0;j<tb[i].length;++j){
				
				tb[i][j]=findRowCol(i,j,tb,str1,str2);
				
				
			}
			
		}
		
		return tb[str1.length()][str2.length()];
		
	}
	
	public static int findRowCol(int i,int j,int [][]tb,String str1,String  str2){
		
		int res=0;
		if(j==0)
			return 1;
		if(i==0)
			return 0;
		
		char ch=str1.charAt(str1.length()-i);
		char ch1=str2.charAt(str2.length()-j);
		
		
		
		if(ch==ch1)
			res+=tb[i-1][j-1];
		
		res+=tb[i-1][j];
		res+=tb[i][j-1];
		
		
		
		
		return res;
		
	}

}
