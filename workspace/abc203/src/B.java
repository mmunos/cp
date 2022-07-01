import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		int[] sum = new int[10];
		for(int i = 1; i < 10; i++) {
			sum[i] = sum[i-1]+i;
		}
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(sum[n]*100*k+sum[k]*n);

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
