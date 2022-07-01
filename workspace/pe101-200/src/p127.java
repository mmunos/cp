import java.util.*;
public class p127 {

	static int N = 1000000;
	public static void main(String[] args) {
		
		long _t1 = System.currentTimeMillis();
		
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
		int n = 120000;
		long tot = 0;
		countfac = new int[n];
		rad = new int[n];
		Arrays.fill(rad, -1);
		for(int i = 1; i < n; i++) {
			long v = process(i);
			tot += v;
			if(v > 0) System.out.println(i);
		}
		System.out.println(tot);
		
		long _t2 = System.currentTimeMillis();
		System.out.print(_t2 - _t1);
		System.out.println(" ms");
	}
	static int[] sieve;
	static int[] countfac;
	static int countfacs(int x) {
		if(x == 1) return 0;
		if(countfac[x] > 0) return countfac[x];
		int p = sieve[x];
		int aux = x;
		while(x % p == 0) x /= p;
		return countfac[aux] = countfacs(x) + 1;
	}
	static int printfacs(int x) {
		int res = 0;
		while(x > 1) {
			int p = sieve[x];
			res++;
			while(x % p == 0) {
				System.out.print(p+" ");
				x /= p;
			}
		}
		System.out.println("");
		return res;
	}
	static long process(int c) {
		long res = 0;
		for(int a = 1; a <= c/2; a++) {
			int b = c - a;
			if(gcd(a, b) == 1) {
				long r = rad(a) * rad(b) * rad(c);
				if(r < c) {
					res += c;
				}
			}
		}
		return res;
	}
	static int[] rad;
	static long rad(int n) {
		if(rad[n] >= 0) return rad[n];
		int res = 1;
		int auxn = n;
		while(auxn > 1) {
			int p = sieve[auxn];
			res *= p;
			while(auxn % p == 0) auxn /= p;
		}
		return rad[n] = res;
	}
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}

}
