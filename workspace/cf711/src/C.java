import java.util.*;
import java.io.*;
public class C {

	static long mod = 1000000007;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if(k == 1) {
				System.out.println(1); continue;
			}
			else if(n == 1) {//k > 1
				System.out.println(2); continue;
			}
			long[][] dp = new long[k][n-1];
			Arrays.fill(dp[0], 1);
			long res = 2;
			for(int i = 1; i < k; i++){
				long acc = 0;
				for(int j = 0; j < n-1; j++){
					acc += dp[i-1][n-j-2]; acc %= mod;
					dp[i][j] = acc;
				}
				res += dp[i][n-2]; res %= mod;
			}
			System.out.println(res);
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
