import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			String ss = sc.next();
			char[] s = (new StringBuilder(ss)).reverse().toString().toCharArray();
			int n = s.length;
			String ts = sc.next();
			char[] t = (new StringBuilder(ts)).reverse().toString().toCharArray();
			int m = t.length;
			int b = 0;
			for(int i = 0; i < n; i++) {
				if((i+b)%2==0 && s[i] == t[b]) b++;
				if(b >= m) break;
			}
			if(b == m) System.out.println("YES");
			else System.out.println("NO");
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
