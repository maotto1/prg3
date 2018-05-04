
public class Deadlock extends Thread{
	
	private final static Object monitor1 = new Object();
	private final static Object monitor2 = new Object();
	private final static Object monitor3 = new Object();
	private final int number;
	
	Deadlock(int number){
		this.number = number;
	}

	public static void main(String[] args) {
		Thread t1 = new Deadlock(1);
		t1.start();
		Thread t2 = new Deadlock(2);
		t2.start();
		Thread t3 = new Deadlock(3);
		t3.start();
	}
	
	public void run() {

		switch(number) {
		case 1:
			synchronized (monitor2) {
				System.out.println(Thread.currentThread().getName() + " besitzt Ressource 2");
				try {
					this.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				synchronized (monitor3) {
					System.out.println(Thread.currentThread().getName() + " besitzt Ressource 2 und 3");
					try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(Thread.currentThread().getName() + " gibt Ressourcen frei");
			break;
		case 2:
			synchronized (monitor3) {
				System.out.println(Thread.currentThread().getName() + " besitzt Ressource 3");
				try {
					this.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				synchronized (monitor1) {
					System.out.println(Thread.currentThread().getName() + " besitzt Ressource 3 und 1");
					try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(Thread.currentThread().getName() + " gibt Ressourcen frei");
			break;
		case 3:
			synchronized (monitor1) {
				System.out.println(Thread.currentThread().getName() + " besitzt Ressource 1");
				try {
					this.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				synchronized (monitor2) {
					System.out.println(Thread.currentThread().getName() + " besitzt Ressource 1 und 2");
					try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(Thread.currentThread().getName() + " gibt Ressourcen frei");
			break;
		}
		

				

	}

}
