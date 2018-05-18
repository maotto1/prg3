package data;

public class PrimeMultipleStriker extends PrimeNumberSearcher{
	
	final int prime;
	
	public PrimeMultipleStriker(int prime){
		this.prime = prime;
	}
	
	@Override
	public void run() {
		for (int i=2*prime; i < 10000; i += prime) {
			if (putDivisibleNumber(i)) {
				
			}
		}
	}
}
