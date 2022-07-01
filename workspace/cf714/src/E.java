import java.util.*;
import java.io.*;
public class E {

	static long mod = 1000000007;
	public static void main(String[] args) {
		int N = 100000;
		long[] fac = new long[N+1];
		fac[0] = 1;
		for(int i = 1; i <= N; i++){
			fac[i] = fac[i-1] * i % mod;
		}
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		long sum = 0;
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			sum += a;
			set.add(a);
		}
		if(sum % 2 == 1) {
			System.out.println(0);
		}
		else {
			System.out.println(fac[set.size()]);
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
