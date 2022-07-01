import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[][] bycol = new int[n][2];
			for(int i = 0; i < a; i++) {
				int c = sc.nextInt()-1;
				bycol[c][0]++;
			}
			for(int i = 0; i < b; i++) {
				int c = sc.nextInt()-1;
				bycol[c][1]++;
			}
			for(int i = 0; i < n; i++) {
				int cmin = Math.min(bycol[i][0], bycol[i][1]);
				bycol[i][0] -= cmin; a -= cmin;
				bycol[i][1] -= cmin; b -= cmin;
			}
			int res = 0;
			if(a > b) {
				for(int i = 0; i < n; i++) {
					while(bycol[i][0] >= 2 && a > b) {
						bycol[i][0] -= 2;
						a -= 2; res++;
					}
				}
			}
			else if(a < b) {
				for(int i = 0; i < n; i++) {
					while(bycol[i][1] >= 2 && a < b) {
						bycol[i][1] -= 2;
						b -= 2; res++;
					}
				}
			}
			int d = Math.min(a, b);
			res += d;
			a -= d; b -= d;
			res += a + b;
			System.out.println(res);
		}

	}
	static class Pair implements Comparable<Pair>{
		int i; long w;
		public Pair(int i, long w) {
			this.i = i; this.w = w;
		}
		public String toString() {
			return i+" "+w;
		}
		@Override
		public int compareTo(Pair p) {
			return Long.compare(w, p.w);
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
