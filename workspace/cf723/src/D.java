import java.util.*;
import java.io.*;
public class D {

	static int[][] ps = { {0, 1, 2, 3},
			{0, 1, 3, 2},
			{0, 2, 1, 3},
			{0, 2, 3, 1},
			{0, 3, 1, 2},
			{0, 3, 2, 1},
			{1, 0, 2, 3},
			{1, 0, 3, 2},
			{1, 2, 0, 3},
			{1, 2, 3, 0},
			{1, 3, 0, 2},
			{1, 3, 2, 0},
			{2, 0, 1, 3},
			{2, 0, 3, 1},
			{2, 1, 0, 3},
			{2, 1, 3, 0},
			{2, 3, 0, 1},
			{2, 3, 1, 0},
			{3, 0, 1, 2},
			{3, 0, 2, 1},
			{3, 1, 0, 2},
			{3, 1, 2, 0},
			{3, 2, 0, 1},
			{3, 2, 1, 0} };

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			char[] s = code(sc.next().toCharArray());
			int n = s.length;
			int[] c = new int[4];
			for(int i = 0; i < n; i++) {
				c[s[i]-'A']++;
			}
			long maxd = -1;
			char[] res = null;
			for(int[] arr: ps) {
				char[] t = gen(c, arr, n);
				long d = dist(s, t);
				if(d > maxd) {
					maxd = d;
					res = t;
				}
			}
			sb.append(decode(res));
			sb.append("\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static char[] code(char[] s) {
		char[] res = new char[s.length];
		for(int i = 0; i < s.length; i++) {
			if(s[i] == 'A') res[i] = 'A';
			if(s[i] == 'N') res[i] = 'B';
			if(s[i] == 'T') res[i] = 'C';
			if(s[i] == 'O') res[i] = 'D';
		}
		return res;
	}
	static char[] decode(char[] s) {
		char[] res = new char[s.length];
		for(int i = 0; i < s.length; i++) {
			if(s[i] == 'A') res[i] = 'A';
			if(s[i] == 'B') res[i] = 'N';
			if(s[i] == 'C') res[i] = 'T';
			if(s[i] == 'D') res[i] = 'O';
		}
		return res;
	}
	static long dist(char[] s, char[] t) {
		int n = s.length;
		long res = 0;
		LinkedList<Integer>[] q = new LinkedList[4];
		for(int i = 0; i < 4; i++) {
			q[i] = new LinkedList<Integer>();
		}
		for(int i = 0; i < n; i++) {
			q[s[i]-'A'].add(i);
		}
		int[] arr = new int[n];
		SegmentTree st = new SegmentTree(arr);
		for(int i = 0; i < n; i++) {
			int u = q[t[i]-'A'].removeFirst();
			int ru = u + st.rmq(u, n-1);
			st.update_point(u, 1);
			res += ru-i;
		}
		return res;
	}
	static char[] gen(int[] c, int[] p, int n) {
		char[] res = new char[n];
		int ind = 0;
		for(int k = 0; k < 4; k++) {
			for(int i = 0; i < c[p[k]]; i++) {
				res[ind++] = (char)(p[k]+'A');
			}
		}
		return res;
	}
	
	static class SegmentTree {
		private int[] st; private int[] A;
		private int n;
		private int left (int p) { return p << 1; }
		private int right(int p) { return (p << 1) + 1; }
		
//		static int neutral = Integer.MAX_VALUE;					//MIN
//		static int op(int x, int y) { return Math.min(x, y); }
//		static int neutral = Integer.MIN_VALUE;					//MAX
//		static int op(int x, int y) { return Math.max(x, y); }
		static int neutral = 0;									//SUM
		static int op(int x, int y) { return x + y; }

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
