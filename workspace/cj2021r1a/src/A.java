import java.util.*;
import java.math.*;
import java.io.*;
public class A {

	static BigInteger nine = BigInteger.valueOf(9);
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			int n = sc.nextInt();
			BigInteger last = BigInteger.ZERO;
			int res = 0;
			for(int num = 0; num < n; num++) {
				String s = sc.next();
				BigInteger a = new BigInteger(s);
				int count = 0;
				while(a.compareTo(last) <= 0) {
					a = a.multiply(BigInteger.TEN);
					a = a.add(nine);
					count++; res++;
				}
				char[] v = a.toString().toCharArray();
				for(int i = count; i > 0; i--) {
					int m = v.length;
					while(v[m-i] > '0') {
						v[m-i]--;
						BigInteger test = new BigInteger(new String(v));
						if(test.compareTo(last) <= 0) {
							v[m-i]++; break;
						}
					}
				}
				last = new BigInteger(new String(v));
			}
			System.out.printf("Case #%d: %d\n", caso++, res);
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
