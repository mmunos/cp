import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			char[][] s = new char[3][2*n];
			for(int i = 0; i < 3; i++) {
				s[i] = sc.next().toCharArray();
			}
			String res = solve(s, n);
			sb.append(res+"\n");
		}	
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static String solve(char[][] s, int n) {
		for(int i = 0; i < 3; i++){
			for(int j = i+1; j < 3; j++){
				if(match(s[i], s[j], 0, n)) return merge(s[i], s[j], 0, n);
				else if(match(s[i], s[j], 1, n)) return merge(s[i], s[j], 1, n);
			}
		}
		return null;
	}
	static String merge(char[] s, char[] t, int v, int n) {
		StringBuilder[] sects = new StringBuilder[n+1];
		for(int i = 0; i <= n; i++) {
			sects[i] = new StringBuilder();
		}
		int c = 0;
		for(int i = 0; i < 2*n; i++) {
			if(s[i] != (char)('0'+v)) sects[c].append(s[i]);
			else c++;
			if(c == n) {
				i++;
				while(i < 2*n) {
					sects[c].append(s[i++]);
				}
			}
		}
		c = 0;
		for(int i = 0; i < 2*n; i++) {
			if(t[i] != (char)('0'+v)) sects[c].append(t[i]);
			else c++;
			if(c == n) {
				i++;
				while(i < 2*n) {
					sects[c].append(t[i++]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(sects[i]);
			sb.append((char)('0'+v));
		}
		sb.append(sects[n]);
		return sb.toString();
	}
	static boolean match(char[] s, char[] t, int v, int n) {
		int c1 = 0;
		for(char c: s) {
			if(c == (char)('0'+v)) c1++;
		}
		if(c1 < n) return false;
		int c2 = 0;
		for(char c: t) {
			if(c == (char)('0'+v)) c2++;
		}
		if(c2 < n) return false;
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
