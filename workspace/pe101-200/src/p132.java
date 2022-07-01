import java.util.*;
public class p132 {

	static int N = 100000;
	public static void main(String[] args) {
		sieve = new int[N+1];  //is prime iff sieve[i] == i
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
		int c = 1;
		long tot = 0;
		long res = 2 + 3 + 5;
		for(int p = 7; p <= N; p++) {
			if(sieve[p] == p) {
				if(check(p)) {
					tot += p;
					System.out.println((c++)+" "+p);
				}
				else {
					res += p;
				}
			}
		}
		System.out.println(tot);
		System.out.println(res);
	}
	static long n = 1000000000000000000L;
	static boolean check(long p) {//
		long r = n % (p-1);
		long a = 1;
		long s = 0;
		while(r-->0) {
			s = (s + a) % p; 
			a = a * 10 % p;
		}
		return s == 0;
	}
	static int[] sieve;

}
