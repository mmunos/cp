import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int q = sc.nextInt();
		char[] s = sc.next().toCharArray();
		long[][] acc = new long[n][26];
		int[] a = new int[26];
		for(int i = 0; i < n; i++) {
			a[s[i]-'a']++;
			for(int c = 0; c < 26; c++) {
				acc[i][c] = a[c];
			}
		}
		while(q-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			long res = 0;
			for(int c = 0; c < 26; c++) {
				long x = acc[r-1][c];
				if(l > 1) x -= acc[l-2][c];
				res += x * (c+1);
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
