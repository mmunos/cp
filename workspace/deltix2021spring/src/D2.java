import java.util.*;
import java.io.*;
public class D2 {

	public static void main(String[] args) {
		Random r = new Random();
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int _p = sc.nextInt();
		char[][] s = new char[n][m];
		for(int i = 0; i < n; i++) {
			s[i] = sc.next().toCharArray();
		}
		int iter = 20;
		int vres = 0;
		char[] res = new char[m];
		while(iter-- > 0) {
			int u = r.nextInt(n);
//			u = 4;
			TreeSet<Integer> ps = new TreeSet<>();
			int[] code = new int[m];
			int ord = 0;
			for(int p = 0; p < m; p++) {
				if(s[u][p] == '1') {
					ps.add(p);
					code[ord++] = p;
				}
			}
			int k = ps.size();
			int[] count = new int[(1 << k)];
			for(int i = 0; i < n; i++) {
				int val = 0;
				for(int p: ps) {
					val <<= 1;
					val += (s[i][p]-'0');
				}
				count[val]++;
			}
			int[] dp = new int[(1 << k)];
			for(int mask = (1 << k)-1; mask >= 0; mask--) {
				for(int i = mask; i > 0; i = (i-1) & mask){
			    	dp[i] += count[mask];
			    }
			}
			for(int mask = 0; mask < (1 << k); mask++) {
				if(dp[mask] >= (n+1)/2) {
					if(Integer.bitCount(mask) > vres) {
						vres = Integer.bitCount(mask);
						Arrays.fill(res, '0');
						int aux = mask;
						for(int i = k-1; i >= 0; i--) {
							if(aux % 2 == 1) {
								res[code[i]] = '1';
							}
							aux /= 2;
						}
					}
				}
			}
		}
		System.out.println(new String(res));
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
