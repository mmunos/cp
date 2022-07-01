import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		int N = 10000000;
		int[] sieve = new int[N+1];
		int sqN = 3200;
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt(); // k = 0
			int res = 1;
			HashSet<Integer> vals = new HashSet<>();
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = 1;
				while(a > 1) {
					if(a / sieve[a] % sieve[a] == 0) {
						a /= sieve[a] * sieve[a];
					}
					else {
						b *= sieve[a];
						a /= sieve[a];
					}
				}
				if(vals.contains(b)) {
					vals = new HashSet<>();
					vals.add(b);
					res++;
				}
				else vals.add(b);
			}
			System.out.println(res);
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
