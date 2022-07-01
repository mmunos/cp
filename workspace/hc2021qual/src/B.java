import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 0;
		while(T-->0) {
			int n = sc.nextInt();
			char[][] s = new char[n][n];
			for(int i = 0; i < n; i++) {
				s[i] = sc.next().toCharArray();
			}
			//vert
			int min = n+1, count = -1;
			for(int i = 0; i < n; i++) {
				int curr = 0;
				boolean poss = true;
				for(int j = 0; j < n; j++) {
					if(s[i][j] == 'O') {
						poss = false; continue;
					}
					else if(s[i][j] == '.') curr++;
				}
				if(poss) {
					if(curr == min) count++;
					else if(curr < min) {
						min = curr; count = 1;
					}
				}
			}
			//hori
			for(int i = 0; i < n; i++) {
				int curr = 0;
				boolean poss = true;
				for(int j = 0; j < n; j++) {
					if(s[j][i] == 'O') {
						poss = false; continue;
					}
					else if(s[j][i] == '.') curr++;
				}
				if(poss) {
					if(curr == min) count++;
					else if(curr < min) {
						min = curr; count = 1;
					}
				}
			}
			if(min == 1) {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(s[i][j] == '.') {
							int c = 0;
							for(int k = 0; k < n; k++) {
								if(s[i][k] == 'X') c++;
								if(s[k][j] == 'X') c++;
							}
							if(c == 2*n-2) count--;
						}
					}
				}
			}
			if(min <= n) {
				System.out.printf("Case #%d: %d %d\n", ++caso, min, count);
			}
			else{
				System.out.printf("Case #%d: Impossible\n", ++caso);
			}
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
