import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			int zeros = 0;
			for(char c: s) {
				if(c == '0') zeros++;
			}
			if(zeros % 2 == 1) {
				sb.append("NO\n"); continue;
			}
			if(s[0] == '0' || s[n-1] == '0') {
				sb.append("NO\n"); continue;
			}
			int ones = n - zeros;
			int thres = ones/2;
			char[] a = new char[n];
			char[] b = new char[n];
			int c = 0;
			for(int i = 0; i < n; i++) {
				if(s[i] == '1') {
					if(thres-- > 0) {
						a[i] = b[i] = '(';
					}
					else {
						a[i] = b[i] = ')';
					}
				}
				if(s[i] == '0') {
					if(c == 0) {
						a[i] = '('; b[i] = ')'; c = 1;
					}
					else if(c == 1) {
						a[i] = ')'; b[i] = '('; c = 0;
					}
				}
			}
			sb.append("YES\n");
			sb.append(a); sb.append("\n");
			sb.append(b); sb.append("\n");
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
