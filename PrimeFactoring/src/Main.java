import data.PrimeNumberSearcher;

public class Main {

	public static void main(String[] args) {
		// get prime numbers
		PrimeNumberSearcher pns = new PrimeNumberSearcher();
		pns.run();
		// start 
		
		for (int i= 3; i < 10; i+=3) {
			System.out.println(i);
		}
	}

}
