import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			char[] s = sc.next().toCharArray();
			char[] s1 = teama(s);
			int va = calc(s1);
			char[] s2 = teamb(s);
			int vb = calc(s2);
			System.out.println(Math.min(va, vb));
		}

	}
	static int calc(char[] s) {
		int n = s.length;
		int a = 0, b = 0;
		int ra = 5, rb = 5;
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0) {
				if(s[i] == '1') a++;
				ra--;
			}
			else {
				if(s[i] == '1') b++;
				rb--;
			}
			if(a > b+rb) return i+1;
			if(b > a+ra) return i+1;
		}
		return n;
	}
	static char[] teama(char[] s) {
		char[] res = s.clone();
		int n = s.length;
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0 && s[i] == '?') res[i] = '1';
			if(i % 2 == 1 && s[i] == '?') res[i] = '0';
		}
		return res;
	}
	static char[] teamb(char[] s) {
		char[] res = s.clone();
		int n = s.length;
		for(int i = 0; i < n; i++) {
			if(i % 2 == 0 && s[i] == '?') res[i] = '0';
			if(i % 2 == 1 && s[i] == '?') res[i] = '1';
		}
		return res;
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
