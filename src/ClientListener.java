import java.util.Observable;
import java.util.Observer;

public class ClientListener implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("刚才线程挂掉，现在重启");
		ClientSocket cs = null;
		try {
			cs = new ClientSocket();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cs.addObserver(this);
		new Thread(cs).start();
		System.out.println("已经重启");
	}

}
