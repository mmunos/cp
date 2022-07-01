import java.util.*;
public class p094 {

	public static void main(String[] args) {
		long tot = 0;
		int N = 333333333;
		for(int i = 2; i <= N; i++) {
			tot += check(i);
		}
		System.out.println(tot);
	}
	static long check(long a) {
		long res = 0;
		//a = b = c - 1
		long rad = (3 * a + 1) * (a - 1);
		if(issq(rad)) {
			long sqrad = (long)Math.sqrt(rad);
			if(sqrad * (a + 1) % 4 == 0) {
				res += a + a + a + 1; 
			}
		}
		//a = b = c + 1
		rad = (3 * a - 1) * (a + 1);
		if(issq(rad)) {
			long sqrad = (long)Math.sqrt(rad);
			if(sqrad * (a - 1) % 4 == 0) {
				res += a + a + a - 1; 
			}
		}
		return res;
	}
	static boolean issq(long x) {
		long sqx = (long)Math.sqrt(x);
		return sqx * sqx == x;
	}

}
