import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String [] args) throws IOException {
		ServerSocket server = new ServerSocket(6000);
		while(true) {
			Socket socket = server.accept();
			new TestSocket(socket).start();
			
		}
	}
}
