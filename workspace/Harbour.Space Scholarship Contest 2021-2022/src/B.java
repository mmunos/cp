import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			char[] s = sc.next().toCharArray();
			int n = s.length;
			String ts = sc.next();
			char[] t = ts.toCharArray();
			char[] tinv = (new StringBuilder(ts)).reverse().toString().toCharArray();
			int m = t.length;
			int[] fit = new int[n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m & i+j < n; j++) {
					if(s[i+j] == t[j]) fit[i]++;
					else break;
				}
			}
			int[] fitinv = new int[n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m & i+j < n; j++) {
					if(s[i+j] == tinv[j]) fitinv[i]++;
					else break;
				}
			}
			boolean yes = false;
			for(int i = 0; i < n; i++) {//start position
				for(int j = 0; j < m; j++) {//steps to the right
					if(fit[i] < j+1) break;
					int p = i + j - (m-1-j);
					if(p < 0) continue;
					if(fitinv[p] >= m-j) {
						yes = true; break;
					}
				}
				if(yes) break;
			}
			if(yes) System.out.println("YES");
			else System.out.println("NO");
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
