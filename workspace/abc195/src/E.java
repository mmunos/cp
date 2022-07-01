import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();
		int[][] dp = new int[n][7];
		if(t[n-1] == 'T') {
			for(int d = 0; d < 7; d++) {
				if(d * 10 % 7 == 0 || (d * 10 + s[n-1]-'0') % 7 == 0) dp[n-1][d]++;
				else dp[n-1][d]--;
			}
		}
		else {
			for(int d = 0; d < 7; d++) {
				if(d * 10 % 7 != 0 || (d * 10 + s[n-1]-'0') % 7 != 0) dp[n-1][d]--;
				else dp[n-1][d]++;
			}
		}
		for(int i = n-2; i >= 0; i--) {
			if(t[i] == 'T') {
				for(int d = 0; d < 7; d++) {
					if(dp[i+1][d * 10 % 7] > 0 || dp[i+1][(d * 10 + s[i]-'0') % 7] > 0) dp[i][d]++;
					else dp[i][d]--;
				}
			}
			else {
				for(int d = 0; d < 7; d++) {
					if(dp[i+1][d * 10 % 7] < 0 || dp[i+1][(d * 10 + s[i]-'0') % 7] < 0) dp[i][d]--;
					else dp[i][d]++;
				}
			}
		}
		if(dp[0][0] > 0) System.out.println("Takahashi");
		else System.out.println("Aoki");
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
