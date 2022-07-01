import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		StringBuilder sb = new StringBuilder();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			long[] ds = new long[n-1];
			long coef = 0;
			for(int i = 0; i < n-1; i++) {
				ds[i] = arr[i+1] - arr[i];
				if(ds[i] > 0) coef += ds[i];
			}
			long a0 = arr[0];
			sb.append(half(a0+coef)+"\n");
			int q = sc.nextInt();
			while(q-- > 0) {
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				long d = sc.nextInt();
				if(a == 0) {
					a0 += d;
				}
				else {
					if(ds[a-1] > 0) coef -= ds[a-1];
					ds[a-1] += d;
					if(ds[a-1] > 0) coef += ds[a-1];
				}
				if(b != n-1) {
					if(ds[b] > 0) coef -= ds[b];
					ds[b] -= d;
					if(ds[b] > 0) coef += ds[b];
				}
				sb.append(half(a0+coef)+"\n");
			}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static long half(long x) {
		if(x % 2 == 0) return x/2;
		else return (x-1)/2+1;
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
