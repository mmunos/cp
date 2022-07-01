import java.util.*;
import java.io.*;
public class E2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			if(n <= 5) {
				int N = (1 << n);
				int res = 0;
				for(int mask = 0; mask < N; mask++) {
					String s = String.format("%"+n+"s", Integer.toBinaryString(mask)).replaceAll(" ", "0");
					if(check(s.toCharArray())) {
						
					}
				}
			}
			else {
				//8 cases whoop
			}
		}
	}
	static boolean check(char[] s) {
		int n = s.length;
		int lastone = -1, lastd1 = -1;
		int lastzero = -1, lastd0 = -1;
		for(int i = 0; i < n; i++) {
			if(s[i] == '1') {
				if(lastone >= 0) {
					if(lastd1 >= 0) {
						if(i - lastone > lastd1) return false;
					}
					lastd1 = i - lastone;
				}
				lastone = i;
			}
			else {
				if(lastzero >= 0) {
					if(lastd0 >= 0) {
						if(i - lastzero < lastd0) return false;
					}
					lastd0 = i - lastzero;
				}
				lastzero = i;
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
