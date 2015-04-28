import java.net.*;
import java.io.*;
 
public class  chatserver
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket ss=new ServerSocket(2004);
		Socket sk=ss.accept();
		BufferedReader cin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream cout=new PrintStream(sk.getOutputStream());
		
		StringBuffer s=new StringBuffer("168.32.34.");
		int n;
		n=100;
		while ( true )
		{
			
  			s=s.append(n);
			cout.println(s);
			s=new StringBuffer("168.32.34.");
			n=n+5;
			Thread.sleep(5000);
			 
			if(n>120)
				break;
		}
		ss.close();
 		sk.close();
 		cin.close();
		cout.close();
 		
	}
}