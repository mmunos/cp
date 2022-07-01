import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] map = new int[n][m];
			Pair[] ps = new Pair[n*m];
			int pi = 0;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					map[i][j] = sc.nextInt();
					ps[pi++] = new Pair(i, j, map[i][j]);
				}
			}
			Arrays.sort(ps);
			int[][] res = new int[n][m];
			for(int i = 0; i < m; i++) {
				res[ps[i].x][i] = ps[i].w;
			}
			int[] inds = new int[n];
			for(int i = m; i < n*m; i++) {
				while(res[ps[i].x][inds[ps[i].x]] != 0) inds[ps[i].x]++;
				res[ps[i].x][inds[ps[i].x]] = ps[i].w;
			}
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					sb.append(res[i][j]+" ");
				}
				sb.replace(sb.length()-1, sb.length(), "\n");
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static class Pair implements Comparable<Pair>{
		int x, y, w;
		public Pair(int x, int y, int w) {
			this.x = x; this.y = y; this.w = w;
		}
		@Override
		public int compareTo(Pair p) {
			return w - p.w;
		}
		public String toString() {
			return x+" "+y + " "+w;
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
