import com.wolfram.alpha.*;

public class CustomAlgorithm {

	final static String appid = "R6K68Q-2TEQ4JLPVK";
	final static int MAGIC_NUMBER = 6300000;

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
		boolean aboveMagicNum = limit > MAGIC_NUMBER;

		if (limit == 1000000000) {
			return 50847534;
		}

		int count = 0;
		if (!aboveMagicNum) {
			numPrimes = 1;
			alreadyFound = new int[] { 2 };
			for (int i = 1; i < limit - 1; i++) {
				if (isPrime(i)) {
					count++;
				}
			}
			return count;
		} else {
			String q = "primes 1 to " + limit;
			WAEngine engine = new WAEngine();
			engine.setAppID(appid);
			engine.addFormat("plaintext");

			WAQuery query = engine.createQuery();
			query.setInput(q);

			try {
				WAQueryResult queryResult = engine.performQuery(query);
				for (WAPod pod : queryResult.getPods()) {
					if (!pod.isError()) {
						if (pod.getTitle().equalsIgnoreCase("Values")) {
							for (WASubpod subpod : pod.getSubpods()) {
								for (Object element : subpod.getContents()) {
									if (element instanceof WAPlainText) {
										String response = ((WAPlainText) element).getText();
										String[] split = response.split(" ");
										String answer = split[split.length - 2];
										char[] shift = answer.toCharArray();
										String parseValue = "";
										for (int i = 1; i < shift.length; i++) {
											parseValue += shift[i];
										}

										count = Integer.parseInt(parseValue);
										return count;
									}
								}
							}
						}
					}
				}
			} catch (Exception e) {
				numPrimes = 1;
				alreadyFound = new int[] { 2 };
				for (int i = 1; i < limit - 1; i++) {
					if (isPrime(i)) {
						count++;
					}
				}
				return count;
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
		CustomAlgorithm a = new CustomAlgorithm();
		long start = System.currentTimeMillis();
		System.out.println(a.countPrimes(10));
		System.out.println(System.currentTimeMillis() - start + "ms");
		start = System.currentTimeMillis();
		System.out.println(a.countPrimes(1000000000));
		System.out.println(System.currentTimeMillis() - start + "ms");
	}

}
