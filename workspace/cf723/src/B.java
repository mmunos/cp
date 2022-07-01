import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		int N = 11*111;
		boolean[] poss = new boolean[N];
		poss[0] = true;
		for(int i = 0; i < N; i++) {
			if(poss[i]) {
				for(int j = i+11; j < N; j += 11) {
					poss[j] = true;
				}
				for(int j = i+111; j < N; j += 111) {
					poss[j] = true;
				}
			}
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			if(n >= N) System.out.println("YES");
			else {
				if(poss[n]) System.out.println("YES");
				else System.out.println("NO");
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
