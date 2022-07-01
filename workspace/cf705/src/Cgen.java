import java.util.*;
import java.io.*;
public class Cgen {

	public static void main(String[] args) {
		int T = 2000;
		Random r = new Random();
		System.out.println(T);
		while(T-->0) {
			int n = r.nextInt(6)+1;
			char[] s = new char[n];
			for(int i = 0; i < n; i++) {
				s[i] = (char)(r.nextInt(26)+'a');
			}
			int k = r.nextInt(n)+1;
			System.out.printf("%d %d\n%s\n", n, k, new String(s));
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
