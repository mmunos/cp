import java.util.*;
import java.io.*;
public class B {

	static long inv2 = 499122177;
	static long mod = 998244353;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long[] powinv2 = new long[n]; powinv2[0] = 1;
		long[] pow2 = new long[n]; pow2[0] = 1;
		for(int i = 1; i < n; i++) {
			pow2[i] = pow2[i-1] * 2 % mod;
			powinv2[i] = powinv2[i-1] * inv2 % mod;
		}
		long[] suff = new long[n+1];
		for(int i = n-1; i >= 0; i--) {
			long val = arr[i] * pow2[i] % mod;
			suff[i] = (suff[i+1] + val) % mod;
		}
		long res = 0;
		for(int i = 0; i < n; i++) {
			long vala = arr[i] * powinv2[i] % mod;
			long val = vala * suff[i+1] % mod;
			res += val; res %= mod;
		}
		res *= inv2; res %= mod;
		for(int i = 0; i < n; i++) {
			res += arr[i] * arr[i] % mod;
			res %= mod;
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
