import java.util.*;
import java.io.*;
public class Cslow {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			char[] s = sc.next().toCharArray();
			if(n % k != 0) {
				System.out.println(-1);
			}
			else {
				while(!check(s, n, k)) s = next(s);
				System.out.println(s);
			}
		}
		pw.print(sb.toString());
		pw.flush();

	}
	static char[] next(char[] s) {
		int i = s.length-1;
		while(i > 0 && s[i] == 'z') s[i--] = 'a';
		s[i]++;
		return s;
	}
	static boolean check(char[] s, int n, int k) {
		int[] c = new int[26];
		for(int i = 0; i < n; i++) {
			c[s[i]-'a']++;
		}
		for(int h = 0; h < 26; h++) {
			if(c[h] % k != 0) {
				return false;
			}
		}
		return true;
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
