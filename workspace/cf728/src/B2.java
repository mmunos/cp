import java.util.*;
import java.io.*;
public class B2 {

	static long mod = 1000000007;
	static long inv2 = inv(2);
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		n = sc.nextInt();
		ll = log2(n);
		dp = new long[n+1][n+1];
		ddp = new double[n+1][n+1];
		long[] inv2pow = new long[n+1];
		double[] powm2 = new double[n+1];
		inv2pow[0] = 1;
		powm2[0] = 1;
		for(int i = 1; i <= n; i++) {
			inv2pow[i] = inv2pow[i-1] * inv2 % mod;
			powm2[i] = powm2[i-1]/2; 
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
		double dres = 0;
		for(int u0 = 0; u0 < n; u0++) {
			tin = new int[n];
			tout = new int[n];
			timer = 0;
			up = new int[n][ll+1];
			dist = new int[n];
			dfs(u0, u0);
			for(int i = 0; i < n; i++) {
				for(int j = i+1; j < n; j++) {
					int lca = lca(i, j);
					int a = dist[i] - dist[lca];
					int b = dist[j] - dist[lca];
					long p = calc(a, b);
					double dp = dcalc(a, b);
					res += p; res %= mod;
					dres += dp;
				}
			}
		}
		long invn = inv(n);
		res *= invn; res %= mod;
		System.out.println(res);
//		System.out.println(dres/n);
	}
	static long[][] dp;
	static long calc(int a, int b) {
		if(a == 0) return 0;
		else if(b == 0) return 1;
		
		if(dp[a][b] > 0) return dp[a][b];
		
		long val = calc(a-1, b) * inv2 % mod + calc(a, b-1) * inv2 % mod;
		return dp[a][b] = val % mod;
	}
	static double[][] ddp;
	static double dcalc(int a, int b) {
		if(a == 0) return 0;
		else if(b == 0) return 1;
		
		if(ddp[a][b] > 0) return ddp[a][b];
		
		double val = dcalc(a-1, b) + dcalc(a, b-1)/2;
		return ddp[a][b] = val;
	}
	static LinkedList<Integer>[] g;
	static int n, ll;
	static int timer;
	static int[] tin, tout;
	static int[][] up;
	static int[] dist;
	static void dfs(int v, int p) {
	    tin[v] = ++timer;
	    up[v][0] = p;
	    for (int i = 1; i <= ll; ++i) {
	        up[v][i] = up[up[v][i-1]][i-1];
	    }
	    for (int u : g[v]) {
	        if (u != p) {
	        	dist[u] = dist[v] + 1;
	            dfs(u, v);
	        }
	    }

	    tout[v] = ++timer;
	}
	static boolean is_ancestor(int u, int v) {
	    return tin[u] <= tin[v] && tout[u] >= tout[v];
	}
	static int lca(int u, int v) {
	    if (is_ancestor(u, v))
	        return u;
	    if (is_ancestor(v, u))
	        return v;
	    for (int i = ll; i >= 0; --i) {
	        if (!is_ancestor(up[u][i], v))
	            u = up[u][i];
	    }
	    return up[u][0];
	}
    static int log2(int N) {
        int result = (int)(Math.log(N) / Math.log(2));
        return result+1;
    }
	static long pow(long a, long b) {
		long res = 1;
		while(b > 0) {
			if(b % 2 == 1) {
				res = res * a % mod;
			}
			a = a * a % mod;
			b /= 2;
		}
		return res;
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
