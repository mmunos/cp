import java.util.*;
import java.io.*;
public class D1 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			Pair[] ps = new Pair[m];
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				ps[i] = new Pair(i, a);
			}
			Arrays.sort(ps);
			int res = 0;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < i; j++) {
					if(ps[j].ind < ps[i].ind) res++;
				}
			}
			System.out.println(res);
		}
	}
	static class Pair implements Comparable<Pair>{
		int ind, w;
		public Pair(int ind, int w) {
			this.ind = ind; this.w = w;
		}
		public int compareTo(Pair p) {
			if(w == p.w) return -ind + p.ind;
			else return w - p.w;
		}
		public String toString() {
			return ind+" "+w;
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
