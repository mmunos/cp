import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		TreeSet<Long> roaring = new TreeSet<>();
		for(int i = 3; i <= 18; i++){
			int j = 1;
			while(true){
				long x = gen(j, i);
				if(x < 0) break;
				roaring.add(x);
				j++;
			}
		}
		roaring.add(1234567891011121314L);
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			long n = sc.nextLong();
			long res = roaring.higher(n);
			res = Math.min(res, find(n));
			System.out.printf("Case #%d: %d\n", caso++, res);
		}

	}
	static long find(long n) {
		long a = 0, b = 1000000000;
		while(b - a > 1) {
			long c = (a+b)/2;
			StringBuilder sb = new StringBuilder();
			sb.append(c+""+(c+1));
			if(sb.length() >= 19) b = c;
			else {
				if(Long.parseLong(sb.toString()) > n) b = c;
				else a = c;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(b+""+(b+1));
		if(sb.length() >= 19) return Long.MAX_VALUE;
		else return Long.parseLong(sb.toString());
	}
	static long gen(long g, long k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append((g+i)+"");
		}
		if(sb.length() >= 19) return -1;
		else return Long.parseLong(sb.toString());
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
