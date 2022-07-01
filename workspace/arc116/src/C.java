import java.util.*;
import java.io.*;
public class C { //I have given up

	static long mod = 998244353;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(m == 1) {
			System.out.println(1); return;
		}
		int K = 1;
		while((1L << K) < m) K++;
		long[][][] dp = new long[K][][];
		for(int k = 0; k < K; k++) {
			
		}
		
		TreeSet<Integer> divds = new TreeSet<>();
		for(int i = 1; i < m; i++) {
			divds.add(m / i);
		}
		int d = divds.size();
		int[] sizes = new int[d];
		for(int i = 0; i < n; i++) {
			sizes[i] = divds.pollLast();
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
