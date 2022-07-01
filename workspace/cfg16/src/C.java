import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			char[] t = sc.next().toCharArray();
			int res = 0; int q = 0;//0 means cut 1 means 00 3 means 11
			for(int i = 0; i < n; i++) {
				if(s[i] + t[i] == '0' + '0') {
					if(q == 0) {
						q = 1;
					}
					else if(q == 1) {
						res += 1;
						q = 1;
					}
					else if(q == 3) {
						res += 2;
						q = 0;
					}
				}
				else if(s[i] + t[i] == '0' + '1') {
					if(q == 1) res++;
					res += 2;
					q = 0;
				}
				else {
					if(q == 0) {
						q = 3;
					}
					else if(q == 1) {
						res += 2;
						q = 0;
					}
				}
			}
			if(q == 1) res++;
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
