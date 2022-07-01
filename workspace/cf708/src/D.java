import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] t = new int[n];
			long[] b = new long[n];
			for(int i = 0; i < n; i++) {
				t[i] = sc.nextInt();
			}
			for(int i = 0; i < n; i++) {
				b[i] = sc.nextInt();
			}
			long res = 0;
			int pos = -1, ppos = -1;
			for(int i = 1; i < n; i++) {
				if(t[i] != t[0]) {
					pos = i; ppos = 0; res += Math.abs(b[i] - b[0]);
				}
			}
			if(pos < 0) System.out.println(0);
			else {
				while(pos < n-1) {
					int p = -1;
					long max = 0;
					for(int i = 0; i < ppos; i++) {
						if(t[i] != t[pos] && t[i] != t[pos+1]) {
							long v = Math.abs(b[i] - b[pos]) + Math.abs(b[i] - b[pos+1]);
							if(v > max) {
								max = v; p = i;
							}
						}
					}
				}
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
