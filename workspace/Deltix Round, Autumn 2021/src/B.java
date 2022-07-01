import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int qs = sc.nextInt();
		char[] s = sc.next().toCharArray();
		int count = 0;
		for(int i = 0; i < n-2; i++) {
			if(s[i] == 'a' && s[i+1] == 'b' && s[i+2] == 'c') count++;
		}
		StringBuilder sb = new StringBuilder();
		while(qs-->0) {
			int ind = sc.nextInt()-1;
			char t = sc.next().charAt(0);
			if(check(ind, s)) count--;
			s[ind] = t;
			if(check(ind, s)) count++;
			sb.append(count+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static boolean check(int i, char[] s) {
		int n = s.length;
		if(i >= 2) if(s[i-2] == 'a' && s[i-1] == 'b' && s[i] == 'c') return true;
		if(i >= 1 && i < n-1) if(s[i-1] == 'a' && s[i] == 'b' && s[i+1] == 'c') return true;
		if(i < n-2) if(s[i] == 'a' && s[i+1] == 'b' && s[i+2] == 'c') return true;
		return false;
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
