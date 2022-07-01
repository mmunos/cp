import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			long[] arr = new long[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			if(n == 1) {
				System.out.printf("Case #%d: %f\n", caso++, (k-1)*1.0/k); continue;
			}
			Arrays.sort(arr);
			long[] ds = new long[n-1];
			for(int i = 0; i < n-1; i++) {
				ds[i] = arr[i+1] - arr[i];
			}
			Arrays.sort(ds);
			//pick separate
			long[] vs = new long[n+1];
			for(int i = 0; i < n-1; i++) {
				vs[i] = ds[i]/2;
			}
			vs[n-1] = arr[0]-1;
			vs[n] = k-arr[n-1];
			Arrays.sort(vs);
			long op1 = vs[n]+vs[n-1];
			//pick same
			long op2 = ds[n-2]-1;
			long res = Math.max(op1, op2);
			System.out.printf("Case #%d: %f\n", caso++, res*1.0/k);
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
