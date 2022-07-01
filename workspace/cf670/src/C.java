import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			g = new LinkedList[n];
			for(int i = 0; i < n; i++) {
				g[i] = new LinkedList<>();
			}
			for(int i = 0; i < n-1; i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				g[u].add(v); g[v].add(u);
			}
			par = new int[n];
			s = new int[n];
			dfs(0, -1);
			int minv = n;
			LinkedList<Integer> centrs = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				int maxc = 0;
				for(int v: g[i]) {
					if(v == par[i]) {
						maxc = Math.max(maxc, s[0] - s[i]);
					}
					else {
						maxc = Math.max(maxc, s[v]);
					}
				}
				if(maxc < minv) {
					minv = maxc;
					centrs = new LinkedList<>();
					centrs.add(i);
				}
				else if(maxc == minv) {
					centrs.add(i);
				}
			}
			if(centrs.size() == 1) {
				System.out.printf("%d %d\n", 2, par[1]+1);
				System.out.printf("%d %d\n", 2, par[1]+1);
			}
			else {
				int a = centrs.getFirst();
				int b = centrs.getLast();
				int c = -1;
				for(int v: g[a]) {
					if(v != b) {
						c = v; break;
					}
				}
				System.out.printf("%d %d\n", a+1, c+1);
				System.out.printf("%d %d\n", b+1, c+1);
			}
		}

	}
	static LinkedList<Integer>[] g;
	static int[] s, par;
	static void dfs(int u, int p) {
		par[u] = p;
		for(int v: g[u]) {
			if(v != p) {
				dfs(v, u);
				s[u] += s[v];
			}
		}
		s[u]++;
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
