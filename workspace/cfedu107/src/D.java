import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		int N = 26;
		char[] patt = new char[N*N];
		int s = 0;
		patt[s++] = 'a';
		for(int n = 1; n < N; n++) {
			int l = 0;
			for(int i = 0; i < 2*n+1; i++) {
				if(i % 2 == 0) patt[s++] = (char)(l++ + 'a');
				else patt[s++] = (char)(n + 'a');
			}
		}
		
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int k = sc.nextInt();
		char[] res = new char[n];
		for(int i = 0; i < n; i++) {
			res[i] = patt[i % (k*k)];
		}
		StringBuilder sb = new StringBuilder();
		sb.append(res);
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static int cost(char[] s) {
		int n = s.length;
		int res = 0;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n-1; j++){
				if(s[i] == s[j] && s[i+1] == s[j+1]) res++;
			}
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