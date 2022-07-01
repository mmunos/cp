import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				sc.nextInt();
			}
			sb.append(3*n+"\n");
			for(int i = 0; i < n; i += 2) {
				sb.append(String.format("1 %d %d\n", i+1, i+2));
				sb.append(String.format("2 %d %d\n", i+1, i+2));
				sb.append(String.format("2 %d %d\n", i+1, i+2));
				sb.append(String.format("1 %d %d\n", i+1, i+2));
				sb.append(String.format("2 %d %d\n", i+1, i+2));
				sb.append(String.format("2 %d %d\n", i+1, i+2));
			}
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
