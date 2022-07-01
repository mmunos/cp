import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			long x = sc.nextLong();
			boolean[] sel = new boolean[n];
			sel[0] = true;
			long points = arr[0] - x;
			for(int i = 1; i < n; i++) {
				if(!sel[i-1]) {
					sel[i] = true;
					points = arr[i] - x;
				}
				else {
					if(arr[i] + points >= x) {
						sel[i] = true;
						points += arr[i] - x;
						if(arr[i] - x < points) {
							points = arr[i] - x;
						}
					}
					else {
						sel[i] = false;
					}
				}
			}
			int res = 0;
			for(int i = 0; i < n; i++) {
				if(sel[i]) res++;
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
