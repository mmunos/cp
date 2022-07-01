import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		TreeMap<Long, TreeSet<Long>> bs = new TreeMap<>();
		for(int i = 0; i < m; i++) {
			long x = sc.nextInt();
			long y = sc.nextInt();
			if(!bs.containsKey(x)) bs.put(x, new TreeSet<>());
			bs.get(x).add(y);
		}
		TreeSet<Long> rows = new TreeSet<>();
		rows.add((long)n);
		for(long x: bs.keySet()) {
			if(x == 0) continue;
			TreeSet<Long> ts = bs.get(x);
			TreeSet<Long> toadd = new TreeSet<>();
			for(long y: ts) {
				if(rows.contains(y+1)) toadd.add(y);
				if(rows.contains(y-1)) toadd.add(y);
			}
			for(long y: ts) {
				rows.remove(y);
			}
			for(long y: toadd) {
				rows.add(y);
			}
		}
		System.out.println(rows.size());
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
