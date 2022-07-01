import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		Integer[] h = new Integer[n];
		TreeMap<Integer, Integer> ts = new TreeMap<>();
		for(int i = 0; i < n; i++) {
			h[i] = sc.nextInt();
			ts.put(h[i], i);
		}
		long[] b = new long[n];
		for(int i = 0; i < n; i++) {
			b[i] = sc.nextLong();
		}
		long res = 0;
		while(!ts.isEmpty()) {
			Integer minh = ts.firstKey();
			Integer x = ts.get(minh);
			res += b[x];
			for(int i = x+1; i < n && b[i] < 0; i++) {
				b[i] = 1;
				ts.remove(h[i]);
			}
			for(int i = x-1; i >= 0 && b[i] < 0; i--) {
				b[i] = 1;
				ts.remove(h[i]);
			}
			ts.remove(minh);
		}
		System.out.println(res);

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
