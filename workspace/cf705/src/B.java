import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out);
		while(T-->0) {
			int h = sc.nextInt();
			int m = sc.nextInt();
			String[] s = sc.next().split(":");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			while(!check(a, b, h, m)) {
				b++;
				if(b >= m) {
					b = 0;
					a++;
					if(a >= h) {
						a = 0;
					}
				}
			}
			String res = String.format("%2d:%2d",a, b).replaceAll(" ","0");
			System.out.println(res);
		}
	}
	static int[] inv = {0, 1, 5, -1, -1, 2, -1, -1, 8, -1};
	static boolean check(int a, int b, int h, int m) {
		if(inv[a/10] < 0) return false;
		if(inv[a%10] < 0) return false;
		if(inv[b/10] < 0) return false;
		if(inv[b%10] < 0) return false;
		int newb = 10*inv[a%10]+inv[a/10];
		int newa = 10*inv[b%10]+inv[b/10];
		return newa < h && newb < m;
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
