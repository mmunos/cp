import java.util.*;
import java.io.*;
public class robotopia {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			long l1 = sc.nextLong();
			long a1 = sc.nextLong();
			long l2 = sc.nextLong();
			long a2 = sc.nextLong();
			long lt = sc.nextLong();
			long at = sc.nextLong();
			int csol = 0;
			long xsol = -1, ysol = -1;
			for(long x = 1; x <= 10000; x++) {
				long lr = lt - x * l1;
				long ar = at - x * a1;
				if(lr % l2 == 0 && ar % a2 == 0 && lr / l2 == ar / a2 && lr / l2 >= 1) {
					xsol = x; ysol = lr / l2;
					csol++;
				}
			}
			if(csol == 1) {
				System.out.println(xsol+" "+ysol);
			}
			else {
				System.out.println("?");
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
