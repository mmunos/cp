import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		long n = sc.nextLong();
		long res = 0;
		for(int i = 1; i <= 6; i++) {
			if(n < pows[i]) {
				res += (n - pows[i-1] + 1) * (i-1); break;
			}
			else {
				res += (pows[i] - pows[i-1]) * (i-1);
			}
		}
		System.out.println(res);
	}
	static long[] pows = {
			1, 1000, 1000000, 1000000000, 1000000000000L, 1000000000000000L, 1000000000000000000L
	};
	
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
