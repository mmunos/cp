import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 0;
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[][] res = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					res[i][j] = 1;
				}
			}
			res[n-1][m-1] = a - (n+m-2);
			res[n-1][0] = b - (n+m-2);
			if(res[n-1][m-1] <= 0 || res[n-1][0] <= 0) {
				System.out.printf("Case #%d: Impossible\n", ++caso);
			}
			else {
				System.out.printf("Case #%d: Possible\n", ++caso);
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < m; j++) {
						sb.append(res[i][j]+" ");
					}
					sb.replace(sb.length()-1, sb.length(), "\n");
				}
				System.out.print(sb.toString());
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
