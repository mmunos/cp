import java.util.*;
import java.io.*;
public class F {

	public static void main(String[] args) {
		int m = 200;
		int[] c = new int[200];
		for(int i = 1; i < m; i++) {
			c[i] = c[i-1]+i;
		}
//		System.out.println(Arrays.toString(c));
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			int ind = m-1;
			int val = 0;
			while(n > 0) {
				while(c[ind] > n) ind--;
				for(int i = 0; i < ind; i++) {
					sb.append((char)(val+'a'));
				}
				n -= c[ind];
				val = (val+1)%3;
			}
			sbres.append(sb);
			sbres.append("\n");
		}	
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
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
