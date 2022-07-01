import java.util.*;
import java.io.*;
public class C { //https://www.codechef.com/COOK127A/problems/WATRA

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			cap = new int[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					cap[i][j] = sc.nextInt();
				}
			}
			map = new char[n][m];
			for(int i = 0; i < n; i++) {
				map[i] = sc.next().toCharArray();
			}
			long a = 0, b = 1000000001;
			while(b - a > 1) {
				long c = (a + b)/2;
				if(check(c)) a = c;
				else b = c;
			}
			sb.append(a+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static int n, m, k;
	static int[][] cap;
	static char[][] map;
	static String ds = "URDL";
	static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean check(long thres) {
		int[][] dist = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				dist[i][j] = 1000000001;
			}
		}
		LinkedList<Pair>[] q = new LinkedList[4];
		for(int i = 0; i < 4; i++) {
			q[i] = new LinkedList<>();
		}
		q[0].add(new Pair(0, 0));
		dist[0][0] = 0;
		int c = 0, seg = 0;
		while(seg < 4) {
			while(!q[c].isEmpty()) {
				seg = 0;
				Pair p = q[c].pollFirst();
				int d = ds.indexOf(map[p.a][p.b]);
				for(int i = 0; i < 4; i++) {
					if(cap[p.a][p.b] - i < thres) break; 
					int x = p.a + dirs[(d+i)%4][0];
					int y = p.b + dirs[(d+i)%4][1];
					if(x >= 0 && x < n && y >= 0 && y < m && dist[x][y] > dist[p.a][p.b] + i) {
						dist[x][y] = dist[p.a][p.b] + i;
						q[(c+i)%4].add(new Pair(x, y));
					}
				}
			}
			c = (c + 1) % 4;
			seg++;
		}
		return dist[n-1][m-1] <= k;
	}
	static class Pair{
		int a, b;
		public Pair(int a, int b) {
			this.a = a; this.b = b;
		}
		public String toString() {
			return a+" "+b;
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
