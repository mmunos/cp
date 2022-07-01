import java.util.*;
import java.io.*;
public class Bgen { //SOLUTION

	public static void main(String[] args) {
		Random r = new Random();
		FastScanner sc = new FastScanner();
		int T = 1000;
		StringBuilder sb = new StringBuilder();
		sb.append(T+"\n");
		for(int t = 0; t < T; t++) {
			int n = 10;
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = r.nextInt(5);
			}
			sb.append(n+"\n");
			for(int i = 0; i < n; i++) {
				sb.append(arr[i]+" ");
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
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
