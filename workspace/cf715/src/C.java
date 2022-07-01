import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Edge>[] g = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
		}
		long tot = 0;
		HashSet<Edge> edges = new HashSet<>();
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			long w = sc.nextInt();
			g[u].add(new Edge(u, v, w));
			g[v].add(new Edge(v, u, w));
			tot ^= w;
			edges.add(new Edge(u, v, w));
			edges.add(new Edge(v, u, w));
		}
		HashSet<Integer> unseen = new HashSet<>();
		LinkedList<Integer> q = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			unseen.add(i);
		}
		unseen.remove(0);
		q.add(0);
		boolean[] seen = new boolean[n];
		seen[0] = true;
		long res = 0;
		int countzeros = 0;
		PriorityQueue<Edge> prim = new PriorityQueue<>();
		while(!unseen.isEmpty()) {
			while(!q.isEmpty()) {
				int u = q.removeFirst();
				HashSet<Integer> nextunseen = new HashSet<>();
				for(Edge e: g[u]) {
					if(seen[e.v]) continue;
					else {
						unseen.remove(e.v);
						nextunseen.add(e.v);
					}
					prim.add(e);
				}
				for(int v: unseen) {
					seen[v] = true;
					q.add(v);
					countzeros++;
				}
				unseen = nextunseen;
			}
			while(!prim.isEmpty()) {
				Edge e = prim.poll();
				if(seen[e.v]) {
					continue;
				}
				else {
					res += e.w;
					seen[e.v] = true;
					unseen.remove(e.v);
					edges.remove(e);
					edges.remove(new Edge(e.v, e.u, e.w));
					q.add(e.v); break;
				}
			}
		}
		long minw = Long.MAX_VALUE;
		for(Edge e: edges) {
			minw = Math.min(minw, e.w);
		}
		long totzeros = ((long)n) * (n-1) / 2 - m;
		if(totzeros == countzeros) {
			res += Math.min(tot, minw);
		}
		System.out.println(res);
	}
	static class Edge implements Comparable<Edge>{
		int u, v; long w;
		public Edge(int u, int v, long w) {
			this.u = u; this.v = v; this.w = w;
		}
		@Override
		public int hashCode() {
			return u+v;
		}
		@Override
		public boolean equals(Object o) {
			Edge e = (Edge)o;
			return u == e.u && v == e.v;
		}
		@Override
		public int compareTo(Edge e) {
			return Long.compare(w, e.w);
		}
		
		public String toString() {
			return u+" "+v+" ("+w+")";
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
