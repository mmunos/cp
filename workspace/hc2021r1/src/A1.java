import java.util.*;
import java.io.*;
public class A1 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 0;
		while(T-->0) {
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			int hand = 0;
			int res = 0;
			for(char c: s) {
				if(c == 'X') {
					if(hand == 1) res++;
					hand = -1;
				}
				else if(c == 'O') {
					if(hand == -1) res++;
					hand = 1;
				}
			}
			System.out.printf("Case #%d: %d\n", ++caso, res);
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
