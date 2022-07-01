import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			LinkedList<Pair> st = new LinkedList<>();
			long res = 1;
			st.add(new Pair(0, arr[0]));
			st.add(new Pair(1, arr[1]));
			for(int i = 2; i < n; i++) {
				Pair r = new Pair(i, arr[i]);
				Pair q = st.removeLast();
				Pair p = st.removeLast();
				while( (r.y - q.y)*(q.x - p.x) >= (q.y - p.y)*(r.x - q.x) ) {
					q = null;
					if(!st.isEmpty()) {
						Pair aux = st.removeLast();
						q = p; p = aux;
					}
					else {
						break;
					}
				}
				if(q == null) {
					res = Math.max(res, r.x - p.x);
					st.add(p); st.add(r);
				}
				else {
					res = Math.max(res, r.x - q.x);
					st.add(p); st.add(q); st.add(r);
				}
			}
			sb.append(res+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static class Pair{
		long x, y;
		public Pair(long x, long y) {
			this.x = x; this.y = y;
		}
		public String toString() {
			return x+" "+y;
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
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
