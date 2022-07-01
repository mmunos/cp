import java.util.*;
import java.io.*;
public class Dgen {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[][] check = new boolean[k][k];
		int[] c = new int[k];
		char[] patt = new char[k*k];
		patt[0] = 'a';
		if(k > 1) {
			patt[1] = 'c';
			c[0]++;
			check[0][1] = true;
		}
		int lastj = 0;
		for(int i = 2; i < k*k; i++) {
			int minj = -1, minv = k+1;
			for(int j = 0; j < k; j++){
				if(!check[lastj][j]) {
					if(c[j] < minv) {
						minv = c[j]; minj = j;
					}
				}
			}
			patt[i] = (char)(minj+'a');
			check[lastj][minj] = true;
			c[lastj]++;
			lastj = minj;
		}
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