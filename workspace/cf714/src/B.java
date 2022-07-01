import java.util.*;
import java.io.*;
public class B {

	static long mod = 1000000007;
	public static void main(String[] args) {
		long[] fac = new long[200001];
		fac[0] = 1; 
		for(int i = 1; i <= 200000; i++) {
			fac[i] = (fac[i-1] * i) % mod;
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			if(n == 1) {
				sb.append("1\n"); continue;
			}
			for(int k = 0; k < 30; k++) {
				boolean valid = true;
				for(int i = 0; i < n; i++) {
					if((arr[i] & (1 << k))==0) {
						valid = false;
					}
				}
				if(valid) {
					for(int i = 0; i < n; i++) {
						arr[i] = arr[i] ^ (1 << k);
					}
				}
			}
			long c = 0;
			for(int i = 0; i < n; i++) {
				if(arr[i] == 0) c++;
			}
			long a = c * (c-1) % mod;
			long b = fac[n-2];
			sb.append((a * b) % mod + "\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
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
