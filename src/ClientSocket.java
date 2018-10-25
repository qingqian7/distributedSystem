import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;

public class ClientSocket extends Observable implements Runnable {
	private volatile boolean isStopped = false;
	Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	
	public ClientSocket() throws Exception {
		socket = new Socket("127.0.0.1",6000);
	}
	public void doBusiness() {
		if(true) {
			super.setChanged();
		}
		notifyObservers();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream());
			System.out.println("debug.....");
			String line ;
			while(!isStopped) {
				while((line = br.readLine()) != null) {
					System.out.println(line);
					switch(line) {
					case "1":
						String address = socket.getInetAddress().toString();
						pw.write(address);
						pw.flush();
						break;
					case "2":
						isStopped = true;
						doBusiness();
						break;
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) throws Exception {
		ClientSocket cs = new ClientSocket();
		ClientListener listener = new ClientListener();
		cs.addObserver(listener);
		new Thread(cs).start();
	}

	
}
