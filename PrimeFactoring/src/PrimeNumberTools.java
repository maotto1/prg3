/**
 * Hilfsklasse fuer Primzahlfunktionen
 * @author probably Prof. Dr.-Ing. Volodymyr Brovkov or Prof. Dr. Ralf Vandenhouten
 */
public class PrimeNumberTools {

	/**
	 * Gibt die Primfaktorzerlegung einer ganzen Zahl aus
	 * @param num - die Zahl, die zerlegt werden soll
	 */
	public void printPrimeFactors(final int num) {
		int number = num;
		int whichprime = 1;
		int prime;
		String prefix;

		prefix = "primeFactors(" + number + ")= ";

		while (number > 1) {
			prime = getPrime(whichprime);

			if ((number % prime) == 0) {
				System.out.print(prefix + prime);
				prefix = " ";
				number /= prime;
			} else {
				++whichprime;
			}
		}

		System.out.println();
	}

	/**
	 * Gibt die n-te Primzahl zurueck
	 * @param n
	 * @return die n-te Primzahl
	 */
	public int getPrime(final int n) {
		int i = 1;
		int ret = 2;

		while (i < n) {
			++ret;

			if (isPrime(ret)) {
				++i;
			}
		}

		return ret;
	}

	/**
	 * testet, ob num Primzahl ist
	 * @param num
	 * @return true, falls num eine Primzahl ist
	 */
	private boolean isPrime(int num) {
		for (int i = 2; i < num; ++i) {
			if ((num % i) == 0) {
				return false;
			}
		}

		return true;
	}
}
