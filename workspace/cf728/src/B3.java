import java.util.*;
import java.io.*;
public class B3 {

	static long mod = 1000000007;
	static long inv2 = inv(2);
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		n = sc.nextInt();
		ll = 11;
		dp = new long[n+1][n+1];
		for(int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		g = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			g[i] = new LinkedList<>();
		}
		for(int i = 0; i < n-1; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			g[u].add(v);
			g[v].add(u);
		}
		long res = 0;
		for(int u0 = 0; u0 < n; u0++) {
			anc = new int[n][ll+1];
			for(int i = 0; i < n; i++) {
				Arrays.fill(anc[i], -1);
			}
			h = new int[n];
			dfs(u0, u0);
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					int lca = lca(i, j);
					int a = h[i] - h[lca];
					int b = h[j] - h[lca];
					long p = calc(a, b);
					res += p; res %= mod;
				}
			}
		}
		long invn = inv(n);
		res *= invn; res %= mod;
		System.out.println(res);
	}
	static long[][] dp;
	static long calc(int a, int b) {
		if(a == 0) return 0;
		if(b == 0) return 1;
		
		if(dp[a][b] >= 0) return dp[a][b];
		
		long val = calc(a-1, b) * inv2 % mod + calc(a, b-1) * inv2 % mod;
		return dp[a][b] = val % mod;
	}
	static LinkedList<Integer>[] g;
	static int n, ll;
	static int[][] anc;
	static int[] h;
	static void dfs(int u, int p){ //se llama desde la raiz
	    anc[u][0] = p;
	    if (p >= 0) {
	        h[u] = h[p] + 1;
	        //val[u][0] = value(u, p); //calcular valor inicial
	    }
	    for (int i = 1; i < ll; ++i) {
	        if (anc[u][i - 1] >= 0) {
	            anc[u][i] = anc[anc[u][i - 1]][i - 1];
	            //val[u][i] = max(val[anc[u][i-1]][i-1], val[u][i-1]);
	        }
	    }
	    for (int v: g[u]){
	        if (v != p) dfs(v, u);
	    }
	}
	 
	static int lca(int v, int u){
	    if (h[v] < h[u]) {
	    	int aux = v; v = u; u = aux;
	    }
	    for (int i = ll-1; i >= 0; --i) {
	        if ((anc[v][i] + 1) > 0 && h[anc[v][i]] >= h[u]) {
	            //val_ans = max(val_ans, val[v][i]);
	            v = anc[v][i];
	        }
	    }
	    if (v == u) return v;
	    //return val_ans;
	    for (int i = ll-1; i >= 0; --i) {
	        if (anc[v][i] != anc[u][i]) {
	            //val_ans = max({val_ans, val[v][i], val[u][i]});
	            v = anc[v][i];
	            u = anc[u][i];
	        }
	    }
	    //val_ans = max({val_ans, val[v][0], val[u][0]});
	    //return val_ans;
	    return anc[v][0];
	}
    static long inv(long a){
		return (gcdex(a, mod)[0] + mod) % mod;
	}
	static long[] gcdex(long a, long b){
		if(b > a) {
			long[] p = gcdex(b, a);
			return new long[] {p[1], p[0]};
		}
		else if(b == 0) return new long[] {1, 0};
		else{
			long[] p = gcdex(b, a % b);
			return new long[] {p[1], p[0] - p[1]*(a/b)};
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
