import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		PriorityQueue<Pair> q = new PriorityQueue<>();
		long res = 0;
		for(int i = 0; i < n; i++) {
			long a = sc.nextLong();
			long c = sc.nextLong();
			q.add(new Pair(a, a+c));
			res += c;
		}
		Pair u0 = q.poll();
		long max = u0.b;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			if(p.a > max) {
				res += p.a - max;
			}
			max = Math.max(max, p.b);
		}
		System.out.println(res);
				
	}
	static class Pair implements Comparable<Pair>{
		long a, b;
		public Pair(long a, long b) {
			this.a = a; this.b = b;
		}
		public String toString() {
			return a+" "+b;
		}
		@Override
		public int compareTo(Pair p) {
			return Long.compare(a, p.a);
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
