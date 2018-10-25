
public class Test extends Thread{

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("fdsfs");
			interrupted();
			System.out.println("dsdsdasd");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.start();
	}

}
