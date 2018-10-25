import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestSocket extends Thread {
	private Socket socket;
	public TestSocket(Socket s) {
		socket = s;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			socket.getOutputStream().write("hello".getBytes());
			while(true) {
			 BufferedReader br = new BufferedReader(
	                    new InputStreamReader(
	                            socket.getInputStream(), "UTF-8"));
	            String line=null;
	            //发送读到的内容
	            while ((line = br.readLine())!=null) {
	                System.out.println(line);
	            }
	            br.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
