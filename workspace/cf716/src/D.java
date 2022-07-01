import java.util.*;
import java.io.*;
public class D { //this is all wrong

	static int sqn = 560;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		SegmentTree st = new SegmentTree(arr);
		StringBuilder sb = new StringBuilder();
		for(int qi = 0; qi < q; qi++) {
			int L = sc.nextInt()-1;
			int R = sc.nextInt()-1;
			int d = R - L + 1;
			Node node = st.rmq(L, R);
			int res = Math.max(node.w, 1);
			sb.append(res+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static class SegmentTree {
		private Node[] nodes; private int[] A;
		private int n;
		private int left (int p) { return p << 1; }
		private int right(int p) { return (p << 1) + 1; }
		
		private void build(int p, int L, int R) {
			if (L == R) {
				nodes[p] = new Node(A[L], 1);
			}
			else {
				build(left(p) , L              , (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R          );
				Node nl = nodes[left(p)];
				Node nr = nodes[right(p)];
				if(nl.v == nr.v) {
					nodes[p] = new Node(nl.v, nl.w + nr.w);
				}
				else {
					if(nl.w > nr.w) {
						nodes[p] = new Node(nl.v, nl.w - nr.w);
					}
					else {
						nodes[p] = new Node(nr.v, nr.w - nl.w);
					}
				}
			} 
		}

		private Node rmq(int p, int L, int R, int i, int j) {
			if (i >  R || j <  L) return null;
			if (L >= i && R <= j) return nodes[p];

			Node nl = rmq(left(p) , L              , (L+R) / 2, i, j);
			Node nr = rmq(right(p), (L+R) / 2 + 1, R          , i, j);
			
			if(nl == null) return nr;
			else if(nr == null) return nl;
			else if(nl.v == nr.v) {
				return new Node(nl.v, nl.w + nr.w);
			}
			else {
				if(nl.w > nr.w) {
					return new Node(nl.v, nl.w - nr.w);
				}
				else {
					return new Node(nr.v, nr.w - nl.w);
				}
			}
		}

		public SegmentTree(int[] _A) {
			A = _A; n = A.length;
			nodes = new Node[4 * n];
			build(1, 0, n - 1);
		}

		public Node rmq(int i, int j) { return rmq(1, 0, n - 1, i, j); }
		
		public String toString() {
			return Arrays.toString(A);
		}
	}
	static class Node{
		int w, v;
		public Node(int v, int w) {
			this.w = w; this.v = v;
		}
		public String toString() {
			return v+" "+w;
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
