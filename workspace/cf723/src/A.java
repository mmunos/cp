import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[2*n];
			for(int i = 0; i < 2*n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			StringBuilder sb = new StringBuilder();
			int[] brr = new int[2*n];
			for(int i = 0; i < n; i++) {
				brr[2*i] = arr[i];
			}
			for(int i = 0; i < n; i++) {
				brr[2*i+1] = arr[i+n];
			}
			for(int i = 0; i < 2*n; i++) {
				sb.append(brr[i]+" ");
			}
			System.out.println(sb.toString().trim());
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
