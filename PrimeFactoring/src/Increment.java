
public class Increment extends Thread {

	volatile static int cnt1=0, cnt2=0;
	private final static Object monitor1 = new Object();
	private final static Object monitor2 = new Object();
	
	public static void main(String[] args) {
		Thread t1 = new Increment();
		t1.start();
		Thread t2 = new Increment();
		t2.start();
		Thread t3 = new Increment();
		t3.start();
		Thread t4 = new Increment();
		t4.start();
	}
	
	public void run() {
		int c1, c2;
		//synchronized (monitor) {
			while (cnt1<5000) {
				synchronized (monitor1) {
					c1 = ++cnt1;
				}
				synchronized (monitor2) {
					c2 = ++cnt2;
				}
				System.out.println(Thread.currentThread().getName() + " " + c1 +" "+ c2);
			}
		//}
	}

}
