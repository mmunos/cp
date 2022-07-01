import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		int N = (1 << 16);
		ArrayList<Integer>[] g = new ArrayList[N];
		g[0] = new ArrayList<>();
		g[0].add(1);
		for(int i = 1; i < N; i++) {
			int mask = (Integer.highestOneBit(i) << 1) - 1;
			g[i] = new ArrayList<Integer>();
			if((i << 1) < N) {
				g[i].add(i << 1);
			}
			g[i].add(i ^ mask);
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			String s = sc.next();
			String t = sc.next();
			if(s.length() > 8 || t.length() > 8) {
				System.out.printf("Case #%d: %d\n", caso++, -1); continue;
			}
			int[] dist = new int[N];
			Arrays.fill(dist, Integer.MAX_VALUE);
			int u0 = Integer.parseInt(s, 2);
			dist[u0] = 0;
			LinkedList<Integer> q = new LinkedList<>();
			q.add(u0);
			while(!q.isEmpty()) {
				int u = q.pollFirst();
				for(int v: g[u]) {
					if(dist[v] > dist[u] + 1) {
						dist[v] = dist[u] + 1;
						q.add(v);
					}
				}
			}
			int v0 = Integer.parseInt(t, 2);
			if(dist[v0] == Integer.MAX_VALUE) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", caso++); continue;
			}
			else {
				System.out.printf("Case #%d: %d\n", caso++, dist[v0]); continue;
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
