import java.util.*;
import java.io.*;
public class C {

	static long mod = 1000000007;
	static long[] arr = {-1, -1, 2, 3, 2, 5, -1, 7, 2, 3, -1, 11, -1, 13, -1, -1, 2, 17, -1, 19, -1, -1, -1, 23, -1, 5, -1, 3, -1, 29, -1, 31};
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			long n = sc.nextLong();
			long res = 0;
			long a = 1, b = 1;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] < 0) continue;
				b *= arr[i];
				long c = n/a - n/b;
				res += c * i % mod; res %= mod;
				a = b;
			}
			System.out.println(a);
			HashSet<Long> rem = new HashSet<>();
			while(a <= n) {
				rem.add(a);
				a += b;
			}
			for(long x: rem) {
				for(long d = 1; d < x; d++) {
					if(x % d != 0) {
						res += d; res %= mod; break;
					}
				}
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
