import java.util.*;
import java.io.*;

public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			if(n == 3) {
				if(arr[1] % 2 == 0) {
					System.out.println(arr[1] / 2);
				}
				else {
					System.out.println(-1);
				}
			}
			else {
				long res = 0;
				boolean allones = true;
				for(int i = 1; i < n-1; i++) {
					if(arr[i] % 2 == 0) {
						res += arr[i]/2;
					}
					else {
						res += arr[i]/2+1;
					}
					if(arr[i] != 1) allones = false;
				}
				if(allones) {
					System.out.println(-1);
				}
				else {
					System.out.println(res);
				}
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
