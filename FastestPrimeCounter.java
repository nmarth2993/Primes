public class FastestPrimeCounter {
	private int[] alreadyFound;
	private int numPrimes;
	
	public boolean isPrime(int n) {
		for (int i = 0; i < alreadyFound.length && alreadyFound[i] > Math.sqrt(n); i++) {
			if (n % alreadyFound.length == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int countPrimes(int limit) {
		alreadyFound = new int[100];
		for (int i = 0; i < limit; i++) {
			if (isPrime(i)) {
				
			}
		}
	}
	
	private void addPrime(int n) {
		if (numPrimes > alreadyFound.length) {
			int[] temp = new int[alreadyFound.length * 2];
			for (int i = 0; i < alreadyFound.length; i++) {
				temp[i] = alreadyFound[i];
			}
			alreadyFound = temp;
		}
	}
	
	public static void main(String[] args) {
	}
}
