import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		int N = 200000;
		long[][] count = new long[N+1][30];
		for(int i = 1; i <= N; i++) {
			for(int k = 0; k < 30; k++) {
				if((i & (1 << k)) == 0) count[i][k] = 1;
				count[i][k] += count[i-1][k];
			}
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long min = N+1;
			for(int k = 0; k < 30; k++) {
				long curr = count[b][k] - count[a-1][k];
				min = Math.min(min, curr);
			}
			System.out.println(min);
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
