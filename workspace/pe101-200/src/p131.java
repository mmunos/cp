import java.util.*;
public class p131 {

	static int N = 1000000; 
	public static void main(String[] args) {
		int[] sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		int c = 0;
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == i && check(i)) c++;
		}
		System.out.println(c);
	}
	static boolean check(long p) {
		if(issq(12 * p - 3)) {
			long sqp = (long)Math.sqrt(12 * p - 3);
			return (sqp - 3) % 6 == 0;
		}
		return false;
	}
	static boolean issq(long x) {
		long sqx = (long)Math.sqrt(x);
		return sqx * sqx == x;
	}

}
