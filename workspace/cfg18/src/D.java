import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		sb = new StringBuilder();
		while(T-->0) {
			n = sc.nextInt();
			int m = sc.nextInt();
			g = new LinkedList[n];
			for(int i = 0; i < n; i++) {
				g[i] = new LinkedList<>();
			}
			
			uf = new UnionFind(2*n);
			
			for(int i = 0; i < n-1; i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				int w = sc.nextInt();
				g[u].add(new Edge(v, w)); g[v].add(new Edge(u, w));
				
				if(w >= 0) {
					int c = Integer.bitCount(w);
					if(c % 2 == 0) {
						uf.union(u, v);
						uf.union(u+n, v+n);
					}
					else {
						uf.union(u, v+n);
						uf.union(u+n, v);
					}
				}
			}
			
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				int p = sc.nextInt();
				if(p == 0) {
					uf.union(a, b);
					uf.union(a+n, b+n);
				}
				else {
					uf.union(a, b+n);
					uf.union(a+n, b);
				}
			}
			boolean invalid = false;
			for(int i = 0; i < n; i++) {
				if(uf.find(i) == uf.find(i+n)) invalid = true;
			}
			if(invalid) {
				sb.append("NO\n");
			}
			else {
				sb.append("YES\n");
				dfs(0, -1);
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static int n;
	static LinkedList<Edge>[] g;
	static UnionFind uf;
	static StringBuilder sb;
	static void dfs(int u, int p) {
		for(Edge e: g[u]) {
			if(e.v == p) continue;
			if(e.w >= 0) {
				sb.append(String.format("%d %d %d\n", u+1, e.v+1, e.w));
			}
			else {
				if(uf.find(e.v) == uf.find(u)) {
					sb.append(String.format("%d %d %d\n", u+1, e.v+1, 0));
				}
				else if(uf.find(e.v+n) == uf.find(u)) {
					sb.append(String.format("%d %d %d\n", u+1, e.v+1, 1));
				}
				else {
					sb.append(String.format("%d %d %d\n", u+1, e.v+1, 0));
					uf.union(e.v, u);
					uf.union(e.v+n, u+n);
				}
			}
			dfs(e.v, u);
		}
	}
	static class Edge{
		int v, w;
		public Edge(int v, int w) {
			this.v = v; this.w = w;
		}
		public String toString() {
			return v+": "+w;
		}
	}
	
	static class UnionFind {
		//source: https://www.cs.waikato.ac.nz/~bernhard/317/source/graph/UnionFind.java
		private int[] _parent;
		private int[] _rank;

		public UnionFind(int max) {
			_parent = new int[max];
			_rank = new int[max];
			for (int i = 0; i < max; i++) {
				_parent[i] = i;
			}
		}

		public int find(int i) {
			int p = _parent[i];
			if (i == p) {
				return i;
			}
			return _parent[i] = find(p);
		}

		public void union(int i, int j) {
			int root1 = find(i), root2 = find(j);
			if (root2 == root1) return;
			if (_rank[root1] > _rank[root2]) {
				_parent[root2] = root1;
			} else if (_rank[root2] > _rank[root1]) {
				_parent[root1] = root2;
			} else {
				_parent[root2] = root1;
				_rank[root1]++;
			}
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
