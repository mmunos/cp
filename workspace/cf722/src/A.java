import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			a = new long[n]; b = new long[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
				b[i] = sc.nextLong();
			}
			g = new ArrayList[n];
			for(int i = 0; i < n; i++) {
				g[i] = new ArrayList<>();
			}
			for(int i = 0; i < n-1; i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				g[u].add(v); g[v].add(u);
			}
			dp = new long[n][2];
			for(int i = 0; i < n; i++) {
				Arrays.fill(dp[i], -1);
			}
			solve(0, -1);
			System.out.println(Math.max(dp[0][0], dp[0][1]));
		}

	}
	static long[] a, b;
	static long[][] dp;
	static ArrayList<Integer>[] g;
	static void solve(int u, int p) {
		for(int v: g[u]) {
			if(v == p) continue;
			solve(v, u);
		}
		//pick l
		dp[u][0] = 0;
		for(int v: g[u]) {
			if(v == p) continue;
			long vall = Math.abs(a[u] - a[v]) + dp[v][0];
			long valr = Math.abs(a[u] - b[v]) + dp[v][1];
			dp[u][0] += Math.max(vall, valr);
		}
		//pick r
		dp[u][1] = 0;
		for(int v: g[u]) {
			if(v == p) continue;
			long vall = Math.abs(b[u] - a[v]) + dp[v][0];
			long valr = Math.abs(b[u] - b[v]) + dp[v][1];
			dp[u][1] += Math.max(vall, valr);
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
