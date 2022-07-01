import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		TreeSet<Long> list = new TreeSet<>();
		long res = 1;
		for(long i = 1; i < n; i++) {
			if(gcd(i, n) == 1) {
				res *= i; res %= n;
				list.add(i);
			}
		}
		if(res != 1) list.remove(res);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()+"\n");
		for(long v: list) {
			sb.append(v+" ");
		}
		sb.replace(sb.length()-1, sb.length(), "\n");
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
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
