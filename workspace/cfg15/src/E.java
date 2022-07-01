import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		StringBuilder sb = new StringBuilder();
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] p = new int[n];
			Arrays.fill(p, -1);
			int[][] res = new int[n][2];
			for(int i = 0; i < n; i++) {
				Arrays.fill(res[i], -1);
			}
			int iter = ceil(n, k);
			for(int i = 0; i < n*k; i++) {
				int c = sc.nextInt()-1;
				if(p[c] >= 0 && res[c][0] < 0) {
					res[c][0] = p[c];
					res[c][1] = i;
					iter--;
				}
				if(iter == 0) {
					Arrays.fill(p, -1);
					iter = ceil(n, k);
				}
				else {
					p[c] = i;
				}
			}
			for(int i = 0; i < n; i++) {
				sb.append(String.format("%d %d\n", res[i][0]+1, res[i][1]+1));
			}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static int ceil(int n, int k) {
		int res = n / (k-1);
		if(n % (k-1) != 0) res++;
		return res;
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
