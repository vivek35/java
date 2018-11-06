import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class TimeServerdemo
{
	public static void main(String[] args) throws Exception
	{
	    System.out.println("Server is started");
		ServerSocket ss=new ServerSocket(9923);
		System.out.println("Server is waiting for client request");

	    while(true){
	    	Socket s=null;
	    	 try
            {
                // socket object to receive incoming client requests
                s = ss.accept();
                
                System.out.println("New Client is connected");
                 
                // obtaining input and out streams
                /*BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());*/
               

                System.out.println("Creating new thread for client");

 	
                // create a new thread object
                Thread t = new ThreadCreator(s);
                // Invoking the start() method
                t.start();
                t.join();

            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
	    }
	}
}
class ThreadCreator extends Thread{
	Socket s;
	static int clientno=0;
	ThreadCreator(Socket s){
		this.s=s;
	}
	public synchronized void run(){
		try{


		clientno++;
		System.out.println("Client "+clientno+" is connected ");
		Date d1 = new Date();
		OutputStreamWriter os=new OutputStreamWriter(s.getOutputStream());
        PrintWriter out=new PrintWriter(os);
		out.println(d1);
		out.flush();
		}catch(Exception e){}
		/*System.out.println("Client "+clientno+" : Date: "+d1);*/
	}

}