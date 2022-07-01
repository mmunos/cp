import java.util.*;
import java.io.*;

public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] brr = new int[n];
			long tot = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				tot += arr[i];
			}
			for(int i = 0; i < n; i++) {
				brr[i] = sc.nextInt();
				tot += brr[i];
			}
			if(n == 1) {
				System.out.println(0);
			}
			else {
				int off = 10000;
				int N = 20000;
				int[][] dp = new int[n][N+1];
				dp[0][arr[0]-brr[0]+off] = 1;
				dp[0][brr[0]-arr[0]+off] = -1;
				for(int i = 0; i < n-1; i++) {
					int d = arr[i+1] - brr[i+1];
					for(int k = 0; k <= N; k++) {
						if(dp[i][k] != 0) {
							dp[i+1][k+d] = 1;
							dp[i+1][k-d] = -1;
						}
					}
				}
				int dif = -1;
				for(int k = off; k <= N; k++) {
					if(dp[n-1][k] != 0) {
						dif = k-off; break;
					}
				}
				long a = (tot - dif) / 2;
				long b = tot - a;
				long res = a * a + b * b;
				for(int i = 0; i < n; i++) {
					long v = arr[i];
					res += v * v * (long)(n-2); 
				}
				for(int i = 0; i < n; i++) {
					long v = brr[i];
					res += v * v * (long)(n-2); 
				}
				System.out.println(res);
			}
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
