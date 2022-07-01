import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int caso = 1;
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			long x = sc.nextLong();
			long a = 0, b = 2000000000;
			while(b - a > 1) {
				long c = (a + b)/2;
				long p = floorp(c);
				long q = nextp(c);
				if(p * q <= x) {
					a = c;
				}
				else {
					b = c;
				}
			}
			long p = floorp(a);
			long q = nextp(a);
			sbres.append(String.format("Case #%d: %d\n", caso++, p * q));
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
		pw.flush();
	}
	static long nextp(long x) {
		x++;
		while(!isPrime(x)) x++;
		return x;
	}
	static long floorp(long x) {
		if(x <= 2) return 2L;
		else while(!isPrime(x)) x--;
		return x;
	}
	static boolean isPrime(long x) {
		for(long i = 2; i*i <= x; i++) {
			if(x % i == 0) return false;
		}
		return true;
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
