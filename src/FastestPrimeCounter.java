public class FastestPrimeCounter implements PrimesFinder {
	private int[] alreadyFound;
	private int numPrimes;

	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int i = 0; i < alreadyFound.length && alreadyFound[i] <= Math.sqrt(n); i++) {
//			System.out.println(alreadyFound[i]);
			if (n % alreadyFound[i] == 0) {
				return false;
			}
		}
		addToArray(n);
		numPrimes++;
		return true;
	}

	public int countPrimes(int limit) {
		int count = 0;
		numPrimes = 1;
		alreadyFound = new int[] { 2 };
//		alreadyFound[0] = 2;
		for (int i = 1; i < limit - 1; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	public void addToArray(int n) {
		if (numPrimes >= alreadyFound.length) {
			int[] result = new int[alreadyFound.length * 2];
			System.arraycopy(alreadyFound, 0, result, 0, alreadyFound.length);
			alreadyFound = result;
		}
		alreadyFound[numPrimes] = n;
	}

	public static void main(String[] args) {
		FastestPrimeCounter p = new FastestPrimeCounter();
		System.out.println(p.countPrimes(10000));

	}
}
