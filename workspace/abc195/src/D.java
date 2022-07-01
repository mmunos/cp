import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		Pair[] ps = new Pair[n];
		for(int i = 0; i < n; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			ps[i] = new Pair(w, v);
		}
		Arrays.sort(ps);
		int[] x = new int[m];
		for(int i = 0; i < m; i++) {
			x[i] = sc.nextInt();
		}
		while(q-->0) {
			int L = sc.nextInt()-1;
			int R = sc.nextInt()-1;
			TreeMap<Integer, Integer> ms = new TreeMap<>();
			for(int i = 0; i < m; i++) {
				if(i >= L && i <= R) continue;
				ms.put(x[i], ms.getOrDefault(x[i], 0)+1);
			}
			int tot = 0;
			for(int i = n-1; i >= 0; i--) {
				Integer size = ms.ceilingKey(ps[i].a);
				if(size == null) continue;
				else {
					tot += ps[i].b;
					ms.put(size, ms.get(size)-1);
					if(ms.get(size) == 0) ms.remove(size);
				}
			}
			System.out.println(tot);
		}
	}
	static class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int a, int b) {
			this.a = a; this.b = b;
		}
		@Override
		public int compareTo(Pair p) {
			if(b == p.b) return a - p.a;
			else return b - p.b;
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
