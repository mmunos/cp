import java.util.*;
public class p074 {

	static int N = 1000000;
	public static void main(String[] args) {
		fac[0] = 1;
		for(int i = 1; i <= 9; i++) {
			fac[i] = fac[i-1] * i;
			System.out.println(fac[i]);
		}
		int tot = 0;
		for(int i = 0; i < N; i++) {
			if(count(i) == 60) tot++;
		}
		System.out.println(tot);
	}
	static int count(long x) {
		HashSet<Long> seen = new HashSet<Long>();
		while(!seen.contains(x)) {
			seen.add(x);
			x = next(x);
		}
		return seen.size();
	}
	static long[] fac = new long[10];
	static long next(long x) {
		long res = 0;
		while(x > 0) {
			res += fac[(int)(x%10)];
			x /= 10;
		}
		return res;
	}

}
