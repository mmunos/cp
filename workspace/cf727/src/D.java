import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		Pair[] ps = new Pair[n];
		for(int i = 0; i < n; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			ps[i] = new Pair(a, b);
		}
		Arrays.sort(ps);
		int l = 0, r = n-1;
		long res = 0;
		long prs = 0;
		while(r > l) {
			if(prs >= ps[l].b) {
				res += ps[l].a;
				prs += ps[l].a;
				l++;
			}
			else if(prs + ps[r].a >= ps[l].b) {
				long d = ps[l].b - prs;
				res += d * 2;
				prs += d;
				ps[r].a -= d;
			}
			else {
				res += ps[r].a * 2;
				prs += ps[r].a; r--;
			}
		}
		//l == r
		if(prs >= ps[l].b) {
			res += ps[l].a;
			prs += ps[l].a;
		}
		else if(prs + ps[r].a >= ps[l].b) {
			long d = ps[l].b - prs;
			res += d * 2 + ps[r].a-d;
			prs += ps[r].a;
		}
		else {
			res += ps[r].a * 2;
			prs += ps[r].a; r--;
		}
		System.out.println(res);
	}
	static class Pair implements Comparable<Pair>{
		long a, b;
		public Pair(long u, long w) {
			this.a = u; this.b = w;
		}
		public int compareTo(Pair p) {
			return Long.compare(b, p.b);
		}
		public String toString() {
			return a+" "+b;
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
