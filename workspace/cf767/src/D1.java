import java.util.*;
import java.io.*;
public class D1 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		
		int N = 2000;
		long[][] dp = new long[N+1][N+1];
		dp[0][0] = 0;
		for(int i = 1; i <= N; i++) {
			dp[i][0] = 0;
			for(int j = 1; j < i; j++) { //j = how many of these i turns are forced to be sums
				dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % mod * inv2 % mod;
			}
			dp[i][i] = (dp[i-1][i-1] + 1) % mod;
		}
		
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long k = sc.nextLong();
			System.out.println(dp[n][m] * k % mod);
		}
	}
	
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
