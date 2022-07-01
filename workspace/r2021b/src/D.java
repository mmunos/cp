import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int caso = 1;
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			g = new ArrayList[n];
			for(int i = 0; i < n; i++) {
				g[i] = new ArrayList<>();
			}
			for(int i = 0; i < n-1; i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				long l = sc.nextLong();
				long a = sc.nextLong();
				g[u].add(new Edge(v, a, l));
				g[v].add(new Edge(u, a, l));
			}
			p = new int[n];
			load = new long[n];
			a = new long[n];
			seen = new boolean[n];
			dfs(0);
			StringBuilder sb = new StringBuilder();
			while(q-- > 0) {
				int c = sc.nextInt()-1;
				long w = sc.nextLong();
				long res = 0;
				while(c > 0) {
					if(w >= load[c]) res = gcd(res, a[c]);
					c = p[c];
				}
				sb.append(" "+res);
			}
			sbres.append(String.format("Case #%d:", caso++));
			sbres.append(sb);
			sbres.append("\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
		pw.flush();
	}
	static ArrayList<Edge>[] g;
	static boolean[] seen;
	static int[] p;
	static long[] load;
	static long[] a;
	static void dfs(int u) {
		for(Edge e: g[u]) {
			if(!seen[e.v]) {
				seen[e.v] = true;
				p[e.v] = u;
				load[e.v] = e.load;
				a[e.v] = e.a;
				dfs(e.v);
			}
		}
	}
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}
	static class Edge{
		int v; long a, load;
		public Edge(int v, long a, long load) {
			this.v = v; this.a = a; this.load = load;
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
