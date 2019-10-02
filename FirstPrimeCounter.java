
public class FirstPrimeCounter {
	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < n - 1; i++) {
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
				System.out.println(i);
				primes++;
			}
		}
		return primes;
	}
	
	public static void main(String[] args) {
		FirstPrimeCounter p = new FirstPrimeCounter();
//		
//		System.out.println(p.isPrime(7));
		
		System.out.println(p.countPrimes(100));
	}
}
