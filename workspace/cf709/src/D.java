import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			TreeSet<Integer> available = new TreeSet<>();
			TreeSet<Integer> uncool = new TreeSet<>();
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				available.add(i);
			}
			for(int i = 0; i < n; i++) {
				if(gcd(arr[i], arr[(i+1)%n]) == 1) {
					uncool.add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			Integer y = -1;
			int res = 0;
			while(!uncool.isEmpty()) {
				Integer x = uncool.higher(y);
				if(x == null) x = uncool.first();
				y = available.higher(x);
				if(y == null) y = available.first();
				if(gcd(arr[x], arr[y]) == 1) {
					available.remove(y);
					if(uncool.contains(y)) uncool.remove(y);
					res++;
					sb.append(" "+(y+1));
				}
				else {
					uncool.remove(x);
					y = x;
				}
			}
			sbres.append(res);
			sbres.append(sb);
			sbres.append("\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
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
