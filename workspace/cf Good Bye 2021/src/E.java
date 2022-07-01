import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = s[i];
			}
			TreeSet<Integer>[] poss = new TreeSet[26];
			for(int i = 0; i < 26; i++) {
				poss[i] = new TreeSet<Integer>();
			}
			for(int i = 0; i < n; i++) {
				poss[s[i]-'a'].add(i);
			}
			SegmentTreeMin stm = new SegmentTreeMin(arr);
			int[] brr = new int[n];
			SegmentTreeSum sts = new SegmentTreeSum(brr);
			char[] t = sc.next().toCharArray();
			long res = Long.MAX_VALUE;
			long curr = 0;
			for(int i = 0; i < n; i++) {
				char ch = t[i];
				
				//option 1 pick a smaller one
				int a = 0, b = n;
				while(b - a > 1) {
					int c = (a+b)/2;
					if(stm.rmq(0, c) < ch) {
						b = c;
					}
					else {
						a = c;
					}
				}
				if(b < n) {
					long add = b - sts.rmq(0, b);
					res = Math.min(res, curr + add);
				}
				
				
				//option 2 pick an equal one
				if(!poss[ch-'a'].isEmpty()) {
					int p = poss[ch-'a'].pollFirst();
					curr += p - sts.rmq(0, p);
					sts.update_point(p, 1);
					stm.update_point(p, 'z'+1);
				}
			}
			if(res == Long.MAX_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(res);
			}
			
		}

	}
	
	static class SegmentTreeMin {
		private int[] st; private int[] A;
		private int n;
		private int left (int p) { return p << 1; }
		private int right(int p) { return (p << 1) + 1; }
		
		static int neutral = Integer.MAX_VALUE;					//MIN
		static int op(int x, int y) { return Math.min(x, y); }
//		static int neutral = Integer.MIN_VALUE;					//MAX
//		static int op(int x, int y) { return Math.max(x, y); }
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

		public SegmentTreeMin(int[] _A) {
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
	
	static class SegmentTreeSum {
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

		public SegmentTreeSum(int[] _A) {
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
