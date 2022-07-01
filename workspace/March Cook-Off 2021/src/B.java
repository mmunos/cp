import java.util.*;
import java.io.*;
public class B { //https://www.codechef.com/COOK127A/problems/CHEFSORT

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int c = 0;
			for(int i = 0; i < n-1; i++) {
				if(arr[i] > arr[i+1]) c++;
			}
			int res = 0;
			StringBuilder sb = new StringBuilder();
			if(c > n/2) {
				sb.append(String.format("%d %d %d\n", 3, n, 1073741823)); res++;
				for(int i = 0; i < n; i++) {
					arr[i] = 1073741823 ^ arr[i];
				}
			}
			for(int i = 0; i < n-1; i++) {
				if(arr[i] > arr[i+1]) {
					sb.append(String.format("%d %d %d\n", 2, i+2, 1073741823)); res++;
				}
			}
			sbres.append(res+"\n");
			sbres.append(sb);
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
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
