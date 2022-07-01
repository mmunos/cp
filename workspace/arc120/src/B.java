import java.util.*;

import java.io.*;
import java.math.BigInteger;
public class B {

	static long mod = 998244353;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] map = new char[n][m];
		for(int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}
		int[][] c = new int[n+m][3];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '.') c[i+j][0]++;
				else if(map[i][j] == 'R') c[i+j][1]++;
				else c[i+j][2]++;
			}
		}
		long res = 1;
		for(int i = 0; i <= n+m-2; i++) {
			if(c[i][1] == 0 && c[i][2] == 0) res = (res * 2) % mod;
			else if(c[i][1] > 0 && c[i][2] > 0) res = 0;
		}
		System.out.println(res);
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
