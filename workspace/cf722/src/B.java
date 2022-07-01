import java.util.*;
import java.io.*;
public class B {

	static long mod = 998244353;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] ds = new int[n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = i; j <= n; j += i) {
				ds[j]++;
			}
		}
		long[] f = new long[n+1];
		f[1] = 1;
		long[] F = new long[n+1];
		F[1] = 1;
		for(int i = 2; i <= n; i++) {
			f[i] = (F[i-1] + ds[i]) % mod;
			F[i] = (f[i] + F[i-1]) % mod;
		}
		System.out.println(f[n]);
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
