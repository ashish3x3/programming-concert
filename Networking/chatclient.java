import java.io.*;
import java.net.Socket;

public class  chatclient
{
	public static void main(String args[]) throws Exception
	{
		Socket sk=new Socket("127.0.0.1",2004);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		int n;
		int i=0;
		String [] ar={"Mumbai","Nagaland","Chennai","Delhi","Sikkim"};
	
		while (  true )
		{
			try{
			s=sin.readLine();
			System.out.print("Server Your New IP Address in :"+ar[i]+"  "+s+"\n");
			i++;
  			
			if(s.endsWith("120"))
				break;
			}
			catch (Exception e) {
		           System.out.println("No more Element ");
			}
		}
		 sk.close();
		 sin.close();
		 sout.close();
 		stdin.close();
	}
}