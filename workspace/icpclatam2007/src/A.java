import java.util.*;
import java.io.*;
public class A { //https://www.urionlinejudge.com.br/judge/en/problems/view/1386

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		while(true) {
			int n = sc.nextInt();
			if(n == 0) break;
			String[] s = new String[n];
			for(int i = 0; i < n; i++) {
				s[i] = sc.next();
			}
			HashMap<String, Integer> code = new HashMap<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j <= s[i].length(); j++) {
					String t = s[i].substring(j);
					if(!code.containsKey(t)) code.put(t, code.size());
				}
			}
			int m = code.size();
			LinkedList<Pair>[] g = new LinkedList[m+1];
			for(int i = 0; i <= m; i++) {
				g[i] = new LinkedList<>();
			}
			int u0 = code.get("");
			for(String t: code.keySet()) {
				int u = code.get(t);
				if(u == u0) {
					for(int i = 0; i < n; i++) {
						for(int j = 0; j < n; j++) {
							if(s[i].length() < s[j].length() && s[j].substring(0, s[i].length()).equals(s[i]) ){
								String tv = s[j].substring(s[i].length());
								int v = code.get(tv);
								g[u0].add(new Pair(v, s[i].length()));
							}
						}
					}
				}
				else {
					for(int i = 0; i < n; i++) {
						if(t.length() == s[i].length()) {
							if(t.equals(s[i])) {
								g[u].add(new Pair(m, t.length()));
							}
						}
						if(t.length() < s[i].length()) {
							if(s[i].substring(0, t.length()).equals(t)) {
								String tv = s[i].substring(t.length());
								int v = code.get(tv);
								g[u].add(new Pair(v, t.length()));
							}
						}
						else {//t.length() > s[i].length()
							if(t.substring(0, s[i].length()).equals(s[i])) {
								String tv = t.substring(s[i].length());
								int v = code.get(tv);
								g[u].add(new Pair(v, s[i].length()));
							}
						}
					}
				}
			}
			int[] dist = new int[m+1];
			Arrays.fill(dist, Integer.MAX_VALUE/2);
			PriorityQueue<Pair> q = new PriorityQueue<>();
			q.add(new Pair(u0, 0));
			dist[u0] = 0;
			while(!q.isEmpty()) {
				Pair p = q.poll();
				for(Pair e: g[p.u]) {
					if(dist[p.u] + e.w < dist[e.u]) {
						dist[e.u] = dist[p.u] + e.w;
						q.add(new Pair(e.u, dist[e.u]));
					}
				}
			}
			int res = -1;
			if(dist[m] < Integer.MAX_VALUE/2) res = dist[m];
			System.out.println(res);
		}
	}
	static class Pair implements Comparable<Pair>{
		int u, w;
		public Pair(int u, int w) {
			this.u = u; this.w = w;
		}
		public int compareTo(Pair p) {
			if(w == p.w) return u - p.u;
			else return w - p.w;
		}
		public String toString() {
			return u+" "+w;
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
