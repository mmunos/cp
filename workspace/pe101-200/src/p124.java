import java.util.*;
public class p124 {

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
		int n = N;
		Pair[] ps = new Pair[n+1];
		ps[0] = new Pair(0, 0);
		for(int i = 1; i <= N; i++) {
			ps[i] = new Pair(i, rad(i));
		}
		Arrays.sort(ps);
		int m = 10000;
		System.out.println(ps[m]);
	}
	static int[] sieve;
	static long rad(int n) {
		long res = 1;
		while(n > 1) {
			int p = sieve[n];
			res *= p;
			while(n % p == 0) n /= p;
		}
		return res;
	}
	static class Pair implements Comparable<Pair>{
		int u; long w;
		public Pair(int u, long w) {
			this.u = u; this.w = w;
		}
		public int compareTo(Pair p) {
			if(w == p.w) return u - p.u;
			else return Long.compare(w, p.w);
		}
		public String toString() {
			return u+" w:"+w;
		}
	}

}
