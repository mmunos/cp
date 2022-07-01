import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] map = new char[n][m];
		for(int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}
		int[][] dp = new int[n][m];
		for(int i = 0; i < n; i++) {
			if(map[i][0] == '.') dp[i][0] = 0;
			else dp[i][0] = m;
		}
		int[] thing = new int[m];
		for(int j = 1; j < m; j++) {
			for(int i = 1; i < n; i++) {
				if(map[i][j] == 'X' && map[i-1][j] == 'X' && map[i][j-1] == 'X') {
					thing[j]++; break;
				}
			}
		}
		int[] thing2 = new int[m];
		for(int i = 1; i < m; i++) {
			thing2[i] = thing[i] + thing2[i-1];
		}
		for(int j = 1; j < m; j++) {
			if(map[0][j] == '.') dp[0][j] = 0;
			else dp[0][j] = m;
			for(int i = 1; i < n; i++) {
				if(map[i][j] == '.') {
					dp[i][j] = j;
					if(i > 0) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
					dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
				}
				else {
					dp[i][j] = m;
				}
			}
		}
		int[] max = new int[m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '.') {
					max[j] = Math.max(max[j], dp[i][j]);
				}
			}
		}
		SegmentTree st = new SegmentTree(max);
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(q-- > 0) {
			int l = sc.nextInt()-1;
			int r = sc.nextInt()-1;
			int v = st.rmq(l, r);
			if(v <= l && (l==0?thing2[r]==0:thing2[r]-thing2[l]==0)) sb.append("YES\n");
			else sb.append("NO\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	
	static class SegmentTree {
		private int[] st; private int[] A;
		private int n;
		private int left (int p) { return p << 1; }
		private int right(int p) { return (p << 1) + 1; }
		
//		static int neutral = Integer.MAX_VALUE;					//MIN
//		static int op(int x, int y) { return Math.min(x, y); }
		static int neutral = Integer.MIN_VALUE;					//MAX
		static int op(int x, int y) { return Math.max(x, y); }
//		static int neutral = 0;									//SUM
//		static int op(int x, int y) { return x + y; }

		private void build(int p, int L, int R) {
			if (L == R)
				st[p] = A[L];
			else {
				build(left(p) , L              , (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R          );
				int v1 = st[left(p)], v2 = st[right(p)];
				st[p] = op(v1, v2);
			} }

		private int rmq(int p, int L, int R, int i, int j) {
			if (i >  R || j <  L) return neutral;
			if (L >= i && R <= j) return st[p];

			int v1 = rmq(left(p) , L              , (L+R) / 2, i, j);
			int v2 = rmq(right(p), (L+R) / 2 + 1, R          , i, j);

			return op(v1, v2);
		}

		private int update_point(int p, int L, int R, int idx, int new_value) {
			int i = idx, j = idx;
			if (i > R || j < L)
				return st[p];

			if (L == i && R == j) {
				A[i] = new_value;													// += IF DELTA
				return st[p] = A[L];
			}

			int v1, v2;
			v1 = update_point(left(p) , L              , (L + R) / 2, idx, new_value);
			v2 = update_point(right(p), (L + R) / 2 + 1, R          , idx, new_value);

			return st[p] = op(v1, v2);
		}

		public SegmentTree(int[] _A) {
			A = _A; n = A.length;
			st = new int[4 * n];
			for (int i = 0; i < 4 * n; i++) st[i] = 0;
			build(1, 0, n - 1);
		}

		public int rmq(int i, int j) { return rmq(1, 0, n - 1, i, j); }

		public int update_point(int idx, int new_value) {
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