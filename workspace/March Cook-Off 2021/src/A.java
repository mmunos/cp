import java.util.*;
import java.io.*;
public class A { //https://www.codechef.com/COOK127A/problems/CONDEL

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			int[] acc = new int[n+1];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				acc[i+1] = arr[i] + acc[i];
			}
			long min = Integer.MAX_VALUE;
			for(int i = 0; i+k <= n; i++) {
				min = Math.min(min, acc[i+k] - acc[i]);
			}
			long res = min*(min+1)/2 + acc[n]-min;
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
