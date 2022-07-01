import java.util.*;
import java.io.*;
public class D { // this does not work

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			 g = new ArrayList[n];
			for(int i = 0; i < n; i++) {
				g[i] = new ArrayList<>();
			}
			for(int i = 0; i < n-1; i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				g[u].add(v);
				g[v].add(u);
			}
			root = -1;
			for(int i = 0; i < n; i++) {
				if(g[i].size() > 2) {
					root = i; break;
				}
			}
			if(root < 0) {
				sbres.append("0\n"); continue;
			}
			sb = new StringBuilder();
			seen = new boolean[n];
			leaf = -1;
			res = 0;
			dfs(root);
			sbres.append(res+"\n");
			sbres.append(sb);
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
		pw.flush();
	}
	static int leaf;
	static int root;
	static StringBuilder sb;
	static ArrayList<Integer>[] g;
	static boolean[] seen;
	static LinkedList<Integer> leaves;
	static int res = 0;
	static void dfs(int u) {
		seen[u] = true;
		int ch = 0;
		for(int v: g[u]) {
			if(seen[v]) continue;
			ch++;
			if((u != root && ch > 1) || (u == root && ch > 2)) {
				if(leaf < 0) {
					// should not happen
				}
				sb.append(String.format("%d %d %d %d\n", u+1, v+1, leaf+1, v+1)); res++;
				leaf = -1;
			}
			dfs(v);
		}
		if(ch == 0 && leaf < 0) {
			leaf = u;
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
