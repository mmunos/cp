import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			char[] s = sc.next().toCharArray();
			int n = s.length;
			boolean yes = false;
			for(int code = 0; code < 8; code++) {
				char[] t = convert(s, code);
				if(check(t)) {
					yes = true;
				}
			}
			if(yes) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
	static char[] convert(char[] s, int code) {
		char[] c = new char[3];
		for(int i = 0; i < 3; i++) {
			c[i] = (char)('('+code%2);
			code /= 2;
		}
		int n = s.length;
		char[] res = new char[n];
		for(int i = 0; i < n; i++) {
			res[i] = c[s[i]-'A'];
		}
		return res;
	}
	static boolean check(char[] arr) {
		int sum = 0;
		for(char c: arr) {
			if(c == '(') sum++;
			else sum--;
			if(sum < 0) return false;
		}
		return sum == 0;
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
