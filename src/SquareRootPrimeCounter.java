
public class SquareRootPrimeCounter implements PrimesFinder {

	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int countPrimes(int limit) {
		int primes = 0;

		for (int i = 0; i < limit; i++) {
			if (isPrime(i)) {
				primes++;
			}
		}
		return primes;
	}

	public static void main(String[] args) {
		SquareRootPrimeCounter p = new SquareRootPrimeCounter();
		System.out.println(p.isPrime(47));
//		System.out.println(p.countPrimes(100));
	}
}
