import java.util.*;
import java.io.*;
public class C {

	static long mod = 1000000007;
	public static void main(String[] args) {
		int N = 200010;
		long[][] prec = new long[N+1][10];
		prec[0] = new long[] {1L,0L,0L,0L,0L,0L,0L,0L,0L,0L};
		long[] fact = new long[N+1];
		for(int i = 1; i <= N; i++){
			for(int j = 0; j <= 8; j++){
				prec[i][j+1] = prec[i-1][j];
			}
			prec[i][0] = prec[i-1][9];
			prec[i][1] = (prec[i][1] + prec[i-1][9]) % mod;
			for(int d = 0; d < 10; d++) {
				fact[i] += prec[i][d];
				fact[i] %= mod;
			}
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long[] vec = new long[10];
			while(n > 0) {
				vec[n % 10]++;
				n /= 10;
			}
			long ans = 0;
			for(int i = 0; i < 10; i++) {
				ans += vec[i] * fact[m+i] % mod;
				ans %= mod;
			}
			sb.append(ans+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
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
