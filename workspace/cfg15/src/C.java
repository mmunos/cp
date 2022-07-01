import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] c = new int[2*n];
			Arrays.fill(c, -1);
			for(int i = 0; i < k; i++) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				c[u] = v; c[v] = u;
			}
			int m = n-k;
			int[] d = new int[2*m]; int j = 0;
			for(int i = 0; i < 2*n; i++) {
				if(c[i] < 0) d[j++] = i;
			}
			for(int i = 0; i < m; i++) {
				c[d[i]] = d[i+m];
				c[d[i+m]] = d[i];
			}
			long res = 0;
			HashSet<Integer> seen = new HashSet<>();
			for(int i = 0; i < 2*n; i++) {
				if(c[i] > i) {
					seen.add(i);
				}
				else {
					for(int u: seen) {
						if(u > c[i]) res++;
					}
					seen.remove(c[i]);
				}
			}
			System.out.println(res);
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
