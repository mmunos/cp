import java.util.*;
import java.io.*;
public class B2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			long n = sc.nextLong();
			long res = 1234567891011121314L;
			for(int i = 2; i <= 18; i++) {
				long v = find(n, i);
				res = Math.min(res, v);
			}
			System.out.printf("Case #%d: %d\n", caso++, res);
		}

	}
	static long find(long n, int k) {
		long a = 0, b = 1000000000;
		while(b - a > 1) {
			long c = (a+b)/2;
			long g = gen(c, k);
			if(g > n) b = c;
			else a = c;
		}
		return gen(b, k);
	}
	static long gen(long g, long k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append((g+i)+"");
		}
		if(sb.length() >= 19) return Long.MAX_VALUE;
		else return Long.parseLong(sb.toString());
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
