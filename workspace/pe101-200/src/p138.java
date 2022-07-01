
public class p138 {

	public static void main(String[] args) {
		long n = 1000000000L;
		for(long a = 0; a <= n; a++) {
			long L2 = 5 * a * a - 4 * a + 1;
			if(issq(L2)) System.out.println((long)Math.sqrt(L2) + "-");
			long L22 = 5 * a * a + 4 * a + 1;
			if(issq(L22)) System.out.println((long)Math.sqrt(L22) + "+");
		}
	}
	
	static boolean issq(long x) {
		long sqx = (long)Math.sqrt(x);
		return sqx * sqx == x;
	}

}
