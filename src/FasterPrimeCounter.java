
public class FasterPrimeCounter implements PrimesFinder {
	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < n / 2; i++) {
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
		FasterPrimeCounter p = new FasterPrimeCounter();
//		
//		System.out.println(p.isPrime(7));

		System.out.println(p.countPrimes(100));
	}
}
