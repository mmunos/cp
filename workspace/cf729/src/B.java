import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			long n = sc.nextLong();
			long a = sc.nextLong();
			long b = sc.nextLong();
			if(a == 1) {
				if(n >= 1 && (n-1)%b==0) System.out.println("Yes");
				else System.out.println("No");
				continue;
			}
			long p = 1;
			boolean yes = false;
			while(p <= n) {
				if((n-p)%b == 0) {
					yes = true; break;
				}
				p *= a;
			}
			if(yes) System.out.println("Yes");
			else System.out.println("No");
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
