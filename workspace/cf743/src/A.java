import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			g = new LinkedList[n];
			LinkedList<Integer>[] ginv = new LinkedList[n];
			for(int i = 0; i < n; i++) {
				g[i] = new LinkedList<>();
				ginv[i] = new LinkedList<>();
			}
			for(int i = 0; i < n; i++) {
				int k = sc.nextInt();
				for(int j = 0; j < k; j++) {
					int u = sc.nextInt()-1;
					g[i].add(u);
					ginv[u].add(i);
				}
			}
			boolean cycle = false;
			state = new int[n];
			for(int i = 0; i < n; i++) {
				if(!dfs(i)) cycle = true;
			}
			if(cycle) {
				System.out.println(-1);
			}
			else{
				LinkedList<Integer> q = new LinkedList<>();
				int[] indeg = new int[n];
				for(int i = 0; i < n; i++) {
					if(g[i].size() == 0) q.add(i);
					indeg[i] = g[i].size();
				}
				int[] res = new int[n];
				while(!q.isEmpty()) {
					int u = q.removeFirst();
					int val = 0;
					for(int v: g[u]) {
						if(v > u) val = Math.max(val, res[v]+1);
						else val = Math.max(val, res[v]);
					}
					res[u] = val;
					for(int v: ginv[u]) {
						indeg[v]--;
						if(indeg[v] == 0) q.add(v);
					}
				}
				int ans = 0;
				for(int i = 0; i < n; i++) {
					ans = Math.max(ans, res[i]);
				}
				System.out.println(ans+1);
			}
		}

	}
	static LinkedList<Integer>[] g;
	static int[] state;
	static boolean dfs(int u) {
		if(state[u] == 2) return true;
		state[u]++;
		for(int v: g[u]) {
			if(state[v] == 1) return false;
			if(!dfs(v)) return false;
		}
		state[u]++;
		return true;
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
