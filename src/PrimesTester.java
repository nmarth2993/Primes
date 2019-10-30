public class PrimesTester {
  PrimesFinder p;
  public PrimesTester(PrimesFinder p) {
    this.p = p;
  }

  public void runBenchmark() {
    for (int i = 3; i < 6) {
      long start = System.currentTimeMilis();
      p.countPrimes(Math.pow(10, i));
      System.out.println
    }
  }
}
