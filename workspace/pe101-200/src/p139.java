
public class p139 {

	public static void main(String[] args) {
		long n = 100000000L;
		long tot = 0;
		for(long c = 2; c <= n; c++) {
			long v = 2 * c * c - 1;
			if(issq(v)) {
				long a = (sqrt(v) - 1) / 2;
				long b = sqrt(c*c - a*a);
				long per = a + b + c;
				tot += n / per;
				System.out.println(a+" "+b+" "+c);
			}
		}
		System.out.println(tot);
	}
	static long sqrt(long x) {
		return (long)Math.sqrt(x);
	}
	static boolean issq(long x) {
		long sqx = (long)Math.sqrt(x);
		return sqx * sqx == x;
	}

}
