import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class ServerListener extends Thread{
	private Map<String,CliSocket> map;
	public ServerListener(Map<String,CliSocket> map) {
		this.map = map;
	}
	public void run() {
		try {
			ServerSocket server = new ServerSocket(6000);
			while(true) {
				Socket socket = server.accept();
				System.out.println(socket.getInetAddress().toString());
				map.put(socket.getInetAddress().toString(), new CliSocket(socket));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
