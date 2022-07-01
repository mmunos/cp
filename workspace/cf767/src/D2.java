import java.util.*;
import java.io.*;
public class D2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		pow2[0] = 1;
		powinv2[0] = 1;
		for(int i = 1; i <= N; i++) {
			pow2[i] = pow2[i-1] * 2 % mod;
			powinv2[i] = powinv2[i-1] * inv2 % mod;
		}
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long k = sc.nextLong();
			if(n == m) {
				System.out.println(n * k % mod); continue;
			}
			long tot = 0;
			for(int i = 1; i <= m; i++) {
				long val = ((long)i) * pow2[i-1] % mod;
				long c = choose(n-i-1, m-i);
				tot = (tot + c * val % mod) % mod;
			}
			System.out.println(tot * powinv2[n-1] % mod * k % mod);
		}
	}

	static int N = 1000000;
	static long[] fac = new long[N+1];
	static long[] invfac = new long[N+1];
	static long[] pow2 = new long[N+1];
	static long[] powinv2 = new long[N+1];
	static long mod = 1000000007;
	static long inv2 = inv(2);
	static long inv(long a){
		return (gcdex(a, mod)[0] + mod) % mod;
	}
	static long[] gcdex(long a, long b){
		if(b > a) {
			long[] p = gcdex(b, a);
			return new long[] {p[1], p[0]};
		}
		else if(b == 0) return new long[] {1, 0};
		else{
			long[] p = gcdex(b, a % b);
			return new long[] {p[1], p[0] - p[1]*(a/b)};
		}
	}
	static long fac(int n){
		if(n == 0) return fac[0] = 1;
		else if(fac[n] > 0) return fac[n];
		else return fac[n] = n * fac(n-1) % mod;
	}
	static long invfac(int n){
		if(invfac[n] > 0) return invfac[n];
		else return invfac[n] = inv(fac[n]);
	}
	static long choose(int n, int k){
		return fac(n) * invfac(k) % mod * invfac(n-k) % mod;
	}
	
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}


}
