import java.util.*;
import java.io.*;
public class F {

	static int P = 20;
	static int[] ps = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71};
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		long a = sc.nextLong();
		long b = sc.nextLong();
		int n = (int)(b-a+1);
		long[][] dp = new long[n+1][(1 << P)];
		dp[0][0] = 1;
		for(int i = 0; i < n; i++) {
			int cm = 0;
			for(int p = 0; p < P; p++) {
				if((a+i)%ps[p] == 0) cm += (1 << p);
			}
			for(int mask = 0; mask < (1 << P); mask++) {
				dp[i+1][mask] += dp[i][mask];
				if((mask & cm) == 0) {
					dp[i+1][mask | cm] += dp[i][mask];
				}
			}
		}
		long res = 0;
		for(int i = 0; i < (1 << P); i++) {
			res += dp[n][i];
		}
		System.out.println(res);
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
