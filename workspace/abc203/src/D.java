import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] map = new int[n][n];
		TreeSet<Integer> vals = new TreeSet<Integer>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				vals.add(map[i][j]);
			}
		}
		HashMap<Integer, Integer> code = new HashMap<>();
		HashMap<Integer, Integer> decode = new HashMap<>();
		int N = 0;
		for(int v: vals) {
			code.put(v, N);
			decode.put(N, v); N++;
		}
		int[] arr = new int[N];
		int qind = k*k/2+1;
		Node st = new Node(0, N-1, arr);
		int res = Integer.MAX_VALUE;
		for(int col = 0; col+k <= n; col++) {
			for(int i = 0; i < k; i++) {
				for(int j = 0; j < k; j++) {
					int ind = code.get(map[i][j+col]);
					st.update(0, N-1, ind, 1);
				}
			}
//			System.out.println(st.toString(0, N-1));
			int r = st.posk(0, N-1, qind);
			res = Math.min(res, r);
			for(int i = 0; i+k < n; i++) {
				for(int j = 0; j < k; j++) {
					int inddn = code.get(map[i][j+col]);
					st.update(0, N-1, inddn, -1);
					int indup = code.get(map[i+k][j+col]);
					st.update(0, N-1, indup, 1);
				}
//				System.out.println(st.toString(0, N-1));
				r = st.posk(0, N-1, qind);
				res = Math.min(res, r);
			}
		}
		System.out.println(decode.get(res));
	}

	static class Node {
		Node left, right;
		int sum;
		public Node(int L, int R, int[] arr) {
			if(L == R) {
				sum = arr[L];
			}
			else {
				left = new Node(L, (L+R)/2, arr);
				right = new Node((L+R)/2+1, R, arr);
				update();
			}
		}
		private void update() {
			sum = left.sum + right.sum;
		}
		void update(int L, int R, int ind, int d) {
			if(ind < L || ind > R) return;
			if(L == R) {
				sum += d;
			}
			else {
				left.update(L, (L+R)/2, ind, d);
				right.update((L+R)/2 + 1, R, ind, d);
				update();
			}
		} 
		int getsum(int L, int R, int l, int r) {//min pos
			if(r < L || l > R) return 0;
			if(l <= L && R <= r) {
				return sum;
			}
			int resl = left.getsum(L, (L+R)/2, l, r);
			int resr = right.getsum((L+R)/2+1, R, l, r);
			return resl + resr;
		}
		int posk(int L, int R, int k) {
			if(L == R) return L;
			if(k <= left.sum) {
				return left.posk(L, (L+R)/2, k);
			}
			else {
				return right.posk((L+R)/2 + 1, R, k - left.sum);
			}
		}
		public String toString(int L, int R) {
			if(L == R) {
				return sum+"";
			}
			else return left.toString(L, (L+R)/2)+" "+right.toString((L+R)/2+1, R);
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
