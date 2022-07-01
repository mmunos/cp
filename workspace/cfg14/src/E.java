import java.util.*;
import java.io.*;
public class E {

	static int N = 400;
	static long mod;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		mod = sc.nextLong();
		c = new long[N+1][N+1];
		c[0][0] = 1;
		for(int i = 0; i < n; i++){
			c[i][0] = 1;
			for(int j = 1; j <= i; j++){
				c[i][j] = (c[i-1][j] + c[i-1][j-1]) % mod;
			}
		}
		dpcl = new long[N+1][N+1];
		dpop = new long[N+1][N+1];
		for(int i = 0; i <= N; i++){
			for(int j = 0; j <= N; j++){
				dpcl[i][j] = -1;
				dpop[i][j] = -1;
			}
		}
		long res = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= n-1; j++){
				for(int a = 0; a <= j; a++) {
					long leftv = dpop(i, a);
					long rightv = dpop(n-i-1, j-a);
					long curr = leftv * rightv % mod;
					long fac = c[j][a];
					long v = curr * fac % mod;
					res = (res + v) % mod;
				}
			}
		}
		System.out.println(res);
	}
	static long[][] c, dpcl, dpop;
	static long dpcl(int n, int k) {
		if(dpcl[n][k] >= 0) return dpcl[n][k];
		if(n == 0 || n == 1) {
			if(k == 0) {
				return dpcl[n][k] = 1;
			}
			else {
				return dpcl[n][k] = 0;
			}
		}
		if(k == 0) { // n > 1
			return dpcl[n][k] = 0;
		}
		long res = 0;
		for(int i = 0; i < n; i++){
			for(int a = 0; a <= k-1; a++) {
				long leftv = dpcl(i, a);
				long rightv = dpcl(n-i-1, k-1-a);
				long curr = leftv * rightv % mod;
				long fac = c[k-1][a];
				long v = curr * fac % mod;
				res = (res + v) % mod;
			}
		}
		return dpcl[n][k] = res;
	}
	static long dpop(int n, int k) {
		if(dpop[n][k] >= 0) return dpop[n][k];
		if(n == 0) {
			if(k == 0) {
				return dpop[n][k] = 1;
			}
			else {
				return dpop[n][k] = 0;
			}
		}
		if(k == 0) { // n > 0
			return dpop[n][k] = 0;
		}
		long res = 0;
		for(int i = 0; i < n; i++){
			for(int a = 0; a <= k-1; a++) {
				long leftv = dpcl(i, a);
				long rightv = dpop(n-i-1, k-1-a);
				long curr = leftv * rightv % mod;
				long fac = c[k-1][a];
				long v = curr * fac % mod;
				res = (res + v) % mod;
			}
		}
		return dpop[n][k] = res;
	}
	static class Pair implements Comparable<Pair>{
		int i; long w;
		public Pair(int i, long w) {
			this.i = i; this.w = w;
		}
		public String toString() {
			return i+" "+w;
		}
		@Override
		public int compareTo(Pair p) {
			return Long.compare(w, p.w);
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
