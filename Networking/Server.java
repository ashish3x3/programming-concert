import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
   public static void main(String[] args) {
		int serverPort = 4020;
		ServerSocket serverSocket = null;
		ObjectOutputStream toClient = null;
		ObjectInputStream fromClient = null;
		try {
			serverSocket = new ServerSocket(serverPort);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("Just connected to " + 
					socket.getRemoteSocketAddress());
				toClient = new ObjectOutputStream(
					new BufferedOutputStream(socket.getOutputStream()));
				fromClient = new ObjectInputStream(
					new BufferedInputStream(socket.getInputStream()));
				Message msgRequest = (Message) fromClient.readObject();
				int number = msgRequest.number;
				int timer=0;
				while(timer<5000){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("error");
						e.printStackTrace();
					}
					timer+=1000;
				toClient.writeObject(new Message(number*number));
				number++;
				//toClient.flush();
				}
				toClient.flush();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
   }
}