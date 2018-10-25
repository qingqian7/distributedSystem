import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CliSocket extends Thread{
	private Socket socket;
	public CliSocket(Socket socket) {
		this.socket = socket;
	}
	
	public void communicate(String mes) {
		try {
			socket.getOutputStream().write(mes.getBytes());
			System.out.println(mes);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		while(true) {
		 try {
	            //接收数据
	            BufferedReader br = new BufferedReader(
	                    new InputStreamReader(
	                            socket.getInputStream(), "UTF-8"));
	            String line=null;
	            //发送读到的内容
	            while ((line = br.readLine())!=null) {
	                System.out.println(line);
	            }
	            br.close();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		}
		}
}
	
