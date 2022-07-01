import java.util.*;
import java.io.*;
public class B {

	static long mod = 998244353;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			int ps = 0, lones = 0;
			for(int i = 0; i < n; i++) {
				if(s[i] == '1') {
					if(i == n-1) lones++;
					else if(s[i+1] == '1') {
						ps++; i++;
					}
					else lones++;
				}
			}
			System.out.println(choose(n-lones-ps, ps));
		}

	}
	
	static int N = 100000;
	static long[] fac = new long[N+1];
	static long[] invfac = new long[N+1];
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
