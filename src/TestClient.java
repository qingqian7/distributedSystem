import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestClient {
	public static void main(String [] args) {
		try {
			Socket socket = new Socket("127.0.0.1",6000);
			socket.getOutputStream().write("client1".getBytes());
			 BufferedReader br = new BufferedReader(
	                    new InputStreamReader(
	                            socket.getInputStream(), "UTF-8"));
	            String line=null;
	            //发送读到的内容
	            while ((line = br.readLine())!=null) {
	                System.out.println(line);
	            }
	            br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
