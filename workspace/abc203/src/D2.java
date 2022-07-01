import java.util.*;
import java.io.*;
public class D2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] map = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int a = -1, b = 2000000000;
		while(b - a > 1) {
			int c = (a + b)/2;
			if(check(map, n, k, c)) b = c;
			else a = c;
		}
		System.out.println(b);
	}
	static boolean check(int[][] map, int n, int k, int thres) {
		int[][] count = new int[n][n];
		for(int i = 0; i < n; i++) {
			int c = 0;
			for(int j = 0; j < n; j++) {
				if(map[i][j] > thres) c++;
				count[i][j] = c;
			}
		}
		int[][] ccount = new int[n][n];
		for(int j = 0; j < n; j++) {
			int c = 0;
			for(int i = 0; i < n; i++) {
				c += count[i][j];
				ccount[i][j] = c;
			}
		}
		for(int i = 0; i+k <= n; i++) {
			for(int j = 0; j+k <= n; j++) {
				int val = ccount[i+k-1][j+k-1];
				if(i > 0) val -= ccount[i-1][j+k-1];
				if(j > 0) val -= ccount[i+k-1][j-1];
				if(i > 0 && j > 0) val += ccount[i-1][j-1];
				if(val < k*k/2+1) return true;
			}
		}
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
