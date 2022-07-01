import java.util.*;

public class p129 {
	
	public static void main(String...strings) {
		int n = 100000;
		int[] vals = {1, 3, 7, 9};
		long maxy = 1;
		int[] ths = {1, 10, 100, 1000, 10000, 100000, 1000000};
		int t = 0;
		for(long i = n; i < 2*n; i++) {
			for(int v: vals) {
				long x = 10 * i + v;
				long y = calc(x);
				if(y > ths[t]) {
					t++;
					System.out.println(x+" "+y);
				}
			}
		}
		System.out.println();
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
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}

}
