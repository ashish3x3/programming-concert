import java.util.*;

public class WordWrapDynamic{

     static String dictionary[] = {
                       "cat", "cats", "and", "sand", "dog" };

    static ArrayList<String> hm=new ArrayList<String>(Arrays.asList(dictionary));

	public static void main(String [] args){

		wordWrap("catsanddog");
		
		//System.out.println(""+wordWrapDP("catsanddog"));
	} //main

	

	public static boolean wordWrapDP(String str){

			int size=str.length();

			boolean [] dp=new boolean[size+1];

			//Arrays.fill(false,dp);

			for(int i=1;i<=size;++i){

				/*System.out.println(str.substring(0,i)+" i  " +
				 hm.contains(str.substring(0,i)));
				System.out.println();*/

				if(dp[i]==false && hm.contains(str.substring(0,i)))
					dp[i]=true;

				if(dp[i]==true ){

					if(i==size)
						return true;

					for(int j=i+1;j<=size;++j){

			/*System.out.println(str.substring(i,i+(j-i))
					+"  j   " + hm.contains(str.substring(i,j)));*/

					if(dp[j]==false && hm.contains(str.substring(i,j)))
							dp[j]=true;

						if(j==size && dp[j]==true)
							return true;

					} //j

				} //true


			} //i

			/*for(int i=1;i<dp.length;++i){
				System.out.println(" "+dp[i]);
			}*/
			return false;

	} //wordWrapDP

	public static void wordWrap(String str){
		wordWrapUtil(str,str.length(),"");
	}  //wordWrap

	public static void wordWrapUtil(String str,int size,String res){

			for(int i=1;i<=size;++i){

				String pref=str.substring(0,i);

				if(hm.contains(pref)){

				if(i==size){
					res+=pref;
					System.out.println(" "+ res);
					return;
				}
				wordWrapUtil(str.substring(i,size),size-i,res+pref+" ");
			}
/*
H:\Computer Scien
 cat sand dog
 cats and dog
*/
				
			}//i

	}//util

	/*
public static boolean wordBreak_dp(String s, Set<String> dict){
        if(s.isEmpty()||dict.isEmpty()) return false;
        int len = s.length();
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
         
        for(int i=1;i<=len;i++){
            for(int k=0;k<i;k++){
                dp[i] = dp[k]&&dict.contains(s.substring(k, i));
                if(dp[i]) break;  //if beome true break
            }
        }
        return dp[len];
    }
	*/

	
}	

/*

H:\Computer Science\Java\DP>j

H:\Computer Science\Java\DP>

System.out.println(""+wordWrapDP("catsanddog"));

c i  false

ca i  false

cat i  true

s  j   false
sa  j   false
san  j   false
sand  j   true
sandd  j   false
sanddo  j   false
sanddog  j   false
cats i  true

a  j   false
an  j   false
and  j   true
andd  j   false
anddo  j   false
anddog  j   false
catsa i  false

catsan i  false

catsand i  false

d  j   false
do  j   false
dog  j   true
true

H:\Computer Science\Java\DP>
*/