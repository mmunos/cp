import java.util.*;
import java.io.*;

public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int[][] c = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				int dx = Math.abs(x[i] - x[j]);
				int dy = Math.abs(y[i] - y[j]);
				c[i][j] = ((int)gcd(dx, dy)/2) % 2;
			}
		}
		int res = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if((c[i][j] + c[i][j] + c[j][k]) % 2 == 0) res++;
				}
			}
		}
		System.out.println((res - n*n) / 12);
	}
	
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}
	
	static class SegmentTree {
		private long[] st; private long[] A;
		private int n;
		private int left (int p) { return p << 1; }
		private int right(int p) { return (p << 1) + 1; }
		
		static long neutral = 0;
		static long op(long x, long y) { return gcd(x, y); }

		private void build(int p, int L, int R) {
			if (L == R)
				st[p] = A[L];
			else {
				build(left(p) , L              , (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R          );
				long v1 = st[left(p)], v2 = st[right(p)];
				st[p] = op(v1, v2);
			} }

		private long rmq(int p, int L, int R, int i, int j) {
			if (i >  R || j <  L) return neutral;
			if (L >= i && R <= j) return st[p];

			long v1 = rmq(left(p) , L              , (L+R) / 2, i, j);
			long v2 = rmq(right(p), (L+R) / 2 + 1, R          , i, j);

			return op(v1, v2);
		}

		private long update_point(int p, int L, int R, int idx, long new_value) {
			int i = idx, j = idx;
			if (i > R || j < L)
				return st[p];

			if (L == i && R == j) {
				A[i] = new_value; 													// += IF DELTA
				return st[p] = A[L];
			}

			long v1 = update_point(left(p) , L              , (L + R) / 2, idx, new_value);
			long v2 = update_point(right(p), (L + R) / 2 + 1, R          , idx, new_value);

			return st[p] = op(v1, v2);
		}

		public SegmentTree(long[] _A) {
			A = _A; n = A.length;
			st = new long[4 * n];
			for (int i = 0; i < 4 * n; i++) st[i] = 0;
			build(1, 0, n - 1);
		}

		public long rmq(int i, int j) { return rmq(1, 0, n - 1, i, j); }

		public long update_point(int idx, long new_value) {
			return update_point(1, 0, n - 1, idx, new_value); }
		
		public String toString() {
			return Arrays.toString(A);
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
