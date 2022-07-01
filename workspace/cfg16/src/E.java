import java.util.*;
import java.io.*;
public class E {

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
			chs = 0;
			ps = new int[n];
			cch = new int[n];
			dfs(0, -1);//count children
			pchild(0, -1);
			System.out.println(chs);
		}
	}
	static int chs;
	static LinkedList<Integer>[] g;
	static int[] ps;
	static int[] cch;
	static boolean pchild(int u, int p) {
		boolean res = true;
		for(int v: g[u]) {
			if(v != p) {
				if(pchild(v, u)) res = false;
			}
		}
		if(!res && u != 0) {
			chs--; //one will be removed eventually
			cch[ps[u]]--;
			if(cch[ps[u]] == 0) chs++;
		}
		return res;//if res is false then is a bud or potential bud
	}
	static void dfs(int u, int p) {
		boolean child = true;
		for(int v: g[u]) {
			if(v != p) {
				child = false;
				ps[v] = u;
				dfs(v, u);
				cch[u]++;
			}
		}
		if(child) chs++;
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
