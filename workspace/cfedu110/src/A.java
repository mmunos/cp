import java.util.*;
import java.io.*;

public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int[] a = new int[4];
			for(int i = 0; i < 4; i++) {
				a[i] = sc.nextInt();
			}
			int[] b = a.clone();
			Arrays.sort(b);
			int[] fins = new int[2];
			fins[0] = Math.max(a[0], a[1]);
			fins[1] = Math.max(a[2], a[3]);
			Arrays.sort(fins);
			if(fins[0] == b[2] && fins[1] == b[3]) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
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
