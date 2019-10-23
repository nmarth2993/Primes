public class FastestPrimeCounter {
	private int[] alreadyFound;
	private int numPrimes;
	
	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 0; i < alreadyFound.length && alreadyFound[i] > Math.sqrt(n); i++) {
			if (n % alreadyFound[i] == 0) {
				return false;
			}
		}
		addPrime(n);
		numPrimes++;
		return true;
	}
	
	public int countPrimes(int limit) {
		int primeCount = 0;
		alreadyFound = new int[100];
		for (int i = 0; i < limit; i++) {
			if (isPrime(i)) {
				primeCount++;
			}
		}
		return primeCount;
	}
	
	private void addPrime(int n) {
		if (numPrimes >= alreadyFound.length) {
			int[] temp = new int[alreadyFound.length * 2];
			for (int i = 0; i < alreadyFound.length; i++) {
				temp[i] = alreadyFound[i];
			}
			temp[numPrimes] = n;
			alreadyFound = temp;
		}
		else {
			alreadyFound[numPrimes] = n;
		}
	}
	
	public static void main(String[] args) {
		FastestPrimeCounter p = new FastestPrimeCounter();
		System.out.println(p.countPrimes(100));
	}
}
