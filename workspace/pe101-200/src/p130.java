import java.util.*;

public class p130 {
	
	public static void main(String...strings) {
		int n = 14911/10;
		int[] vals = {1, 3, 7, 9};
		long maxy = 1;
		int[] ths = {1, 10, 100, 1000, 10000, 100000, 1000000};
		int t = 0;
		long tot = 0;
		for(long i = 0; i < n; i++) {
			for(int v: vals) {
				long x = 10 * i + v;
				long y = calc(x);
				if(!isPrime(x) && (x-1) % y == 0) {
					tot += x;
					System.out.println(x+" "+y);
				}
			}
		}
		System.out.println(tot);
	}
	static long calc(long mod) {
		long p10 = 1;
		long c = 1;
		long curr = 1 % mod;
		while(curr != 0) {
			p10 = (p10 * 10) % mod;
			curr = (curr + p10) % mod;
			c++;
		}
		return c;
	}
	static boolean isPrime(long x) {
		if(x == 1) return false;
		for(long d = 2; d*d <= x; d++) {
			if(x % d == 0) return false;
		}
		return true;
	}
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}

}
