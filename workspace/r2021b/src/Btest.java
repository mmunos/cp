import java.util.*;
import java.io.*;
public class Btest { //SOLUTION

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int caso = 1;
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int res = 0;
			for(int i = 0; i < n; i++) {
				long[] brr = new long[n];
				for(int j = 0; j < n; j++) {
					brr[j] = arr[j];
				}
				for(int a = -20; a <= 20; a++) {
					brr[i] = a;
					res = Math.max(res, calc(brr));
				}
			}
			sbres.append(String.format("Case #%d: %d\n", caso++, res));
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
		pw.flush();
	}
	static int calc(long[] arr) {
		int n = arr.length;
		long[] d = new long[n-1];
		for(int i = 0; i < n-1; i++) {
			d[i] = arr[i+1] - arr[i];
		}
		int res = 1, curr = 1;
		for(int i = 1; i < n-1; i++) {
			if(d[i] == d[i-1]) {
				curr++; res = Math.max(res, curr);
			}
			else curr = 1;
		}
		return res+1;
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
