import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyServerSocket {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,CliSocket> map = new TreeMap<String,CliSocket>();
		new ServerListener(map).start();
		Scanner sc = new Scanner(System.in);
		System.out.println("usage:\n \t 1: show_all (show all the online client) \n\t 2: restart_address (restart the client with the address)");
		while(true) {
			Set s = map.entrySet();
			Iterator it = s.iterator();
			CliSocket cs;
			String command = sc.nextLine();
			String[] coms = command.split("_");
			switch(command) {
			case "show_all":
				while(it.hasNext()) {
					Map.Entry entry = (Entry) it.next();
					cs = (CliSocket) entry.getValue();
					cs.communicate("1");
				}
				break;
			case "restart":
				cs = map.get(coms[1]);
				cs.communicate("2");
				break;
			
			default:
				System.out.println("ÊäÈë²ÎÊı´íÎó");	
				break;
			}
		}
	}

}
