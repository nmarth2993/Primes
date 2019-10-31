public class PrimesTester {
	PrimesFinder p;

	public PrimesTester(PrimesFinder p) {
		this.p = p;
	}

	public void runBenchmark() {
		for (int i = 3; i < 6; i++) {
			long start = System.currentTimeMillis();
			System.out.println("limit: " + (int) Math.pow(10, i));
			System.out.println(p.countPrimes((int) Math.pow(10, i)));
			System.out.println(System.currentTimeMillis() - start + "ms");
		}
	}

	public static void main(String[] args) {
		PrimesFinder[] finders = { new FirstPrimeCounter(), new FasterPrimeCounter(), new SquareRootPrimeCounter(),
				new FastestPrimeCounter() };

		for (PrimesFinder f : finders) {
			System.out.println(f.getClass().toString().substring(6));
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			new PrimesTester(f).runBenchmark();
		}
	}
}
