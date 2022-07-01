import java.util.*;
import java.math.*;

public class p104 {
	
	static long mod = 1000000000;
	public static void main(String...strings) {
		int n = 100000;
		long[] fib = new long[n];
		fib[1] = 1; fib[2] = 1;
		for(int i = 3; i < n; i++) {
			fib[i] = (fib[i-1] + fib[i-2]) % mod;
			if(check(fib[i])) {
				System.out.println(i + " " + fib[i]);
			}
		}
	}
	static boolean check(long x) {
		HashSet<Long> set = new HashSet<>();
		while(x > 0) {
			if(x % 10 == 0) return false;
			set.add(x % 10); x /= 10;
		}
		return set.size() == 9;
	}

}
