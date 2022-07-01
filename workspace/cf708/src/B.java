import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] c = new int[m];
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				c[a%m]++;
			}	
			int res = 0;
			for(int i = 0; i <= m/2; i++) {
				if(i == 0) {
					if(c[i] > 0) res++;
				}
				else if(m % 2 == 0 && i == m/2) {
					if(c[i] > 0) res++;
				}
				else {
					if(c[i] + c[m-i] == 0);
					else if(Math.abs(c[i] - c[m-i]) <= 1) res++;
					else {
						res += Math.abs(c[i] - c[m-i]);
					}
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
