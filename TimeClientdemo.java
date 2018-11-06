import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;

public class TimeClientdemo{

	public static void main(String[] args) throws Exception
	{
		String ip="localhost";
		int port=9923;
		Socket s=new Socket(ip,port);

		String str="Requesting time";

		System.out.println(str);

	 	BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
	 	String time=br.readLine();

	 	System.out.println("Server Returned: "+time);




	}
}