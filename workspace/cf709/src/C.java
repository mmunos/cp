import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] f = new int[m][];
			for(int i = 0; i < m; i++){
				int k = sc.nextInt();
				f[i] = new int[k];
				for(int j = 0; j < k; j++){
					f[i][j] = sc.nextInt()-1;
				}
			}
			int[] res = new int[m];
			Arrays.fill(res, -1);
			int[] count = new int[n];
			for(int i = 0; i < m; i++) {
				if(f[i].length == 1) {
					res[i] = f[i][0];
					count[f[i][0]]++;
				}
			}
			boolean dead = false;
			for(int i = 0; i < n; i++) {
				if(count[i] > m/2 + m%2) {
					dead = true; break;
				}
			}
			if(dead) {
				sb.append("NO\n"); continue;
			}
			for(int i = 0; i < m; i++){
				if(f[i].length == 1) continue;
				int minj = -1, minc = m;
				for(int j = 0; j < f[i].length; j++){
					if(count[f[i][j]] < minc) {
						minc = count[f[i][j]];
						minj = f[i][j];
					}
				}
				res[i] = minj;
				count[minj]++;
			}
			sb.append("YES\n");
			for(int i = 0; i < m; i++) {
				sb.append((res[i]+1)+" ");
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
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
