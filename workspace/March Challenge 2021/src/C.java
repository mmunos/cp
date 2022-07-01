import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int x = sc.nextInt();
			long[][] a = new long[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					a[i][j] = sc.nextInt();
				}
			}
			long[][] b = new long[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					b[i][j] = sc.nextInt();
				}
			}
			ArrayList<Integer> vmods = new ArrayList<>();
			for(int k = 1; k < x; k++) {
				if(gcd(k, x) == 1) vmods.add(k);
			}
			boolean valid = true;
			for(int k: vmods) {
				long[] val = new long[x];
				for(int i = 0; i < n; i++){
					for(int j = 0; j < m; j++){
						val[(i+k*j)%x] += a[i][j] - b[i][j];
					}
				}
				Arrays.sort(val);
				if(val[0] != val[x-1]) {
					valid = false; break;
				}
			}
			if(valid) sb.append("Yes\n");
			else sb.append("No\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static long gcd(long a, long b) {
		if(a < b) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
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
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
