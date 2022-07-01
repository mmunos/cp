import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			n = sc.nextInt();
			g1 = new ArrayList[n];
			for(int i = 0; i < n; i++) {
				g1[i] = new ArrayList<>();
			}
			for(int i = 1; i < n; i++) {
				int u = sc.nextInt()-1;
				g1[u].add(i);
			}
			g2 = new ArrayList[n];
			for(int i = 0; i < n; i++) {
				g2[i] = new ArrayList<>();
			}
			for(int i = 1; i < n; i++) {
				int u = sc.nextInt()-1;
				g2[u].add(i);
			}
			t = 0;
			op = new int[n];
			cl = new int[n];
			build(0);	
			res = 0; curr = 0;
			starr = new int[2*n];
			st = new Node(0, 2*n-1);
			dfs(0);
			System.out.println(res);
		}

	}
	static int n;
	static ArrayList<Integer>[] g1, g2;
	static int t;
	static int res, curr;
	static int[] op, cl;
	static Node st;
	static void build(int u) {
		op[u] = t; t++;
		for(int v: g2[u]) {
			build(v);
		}
		cl[u] = t; t++;
	}
	static void dfs(int u) {
		st.update(0, 2*n-1, op[u], 1);
		st.update(0, 2*n-1, cl[u], -1);
//		System.out.println(st);
		boolean add = false;
		if(u == 0) {
			add = true;
		}
		else {
			//add if parent is not leaf
			//this happens if and only if rightmost nonzero value to the left is 1
			// and if leftmost nonzero value to the right is -1
			int posminleft = st.minright(0, 2*n-1, 0, op[u]-1);
			int posmaxleft = st.maxright(0, 2*n-1, 0, op[u]-1);
			if(getmax(posmaxleft) < 1) add = true; //there is no 1 to the left (never happens)
			else { 
				if(getmin(posminleft) == -1 && posminleft > posmaxleft) add = true; //compare pos of -1 and pos of 1 but only if there is a -1
				else {
					int posminright = st.minleft(0, 2*n-1, cl[u]+1, 2*n-1);
					int posmaxright = st.maxleft(0, 2*n-1, cl[u]+1, 2*n-1);
					if(getmin(posminright) > -1) add = true;
					if(getmax(posmaxright) == 1 && posmaxright < posminright) add = true;
				}
			}
		}
		if(add) {
			curr++;
			res = Math.max(curr, res);
		}
		for(int v: g1[u]) {
			dfs(v);
		}
		if(add) {
			curr--;
		}
		st.update(0, 2*n-1, op[u], 0);
		st.update(0, 2*n-1, cl[u], 0);
//		System.out.println(st);
	}
	static int[] starr;
	static int getmin(int ind) {
		if(ind < 0) return Integer.MAX_VALUE;
		else return starr[ind];
	}
	static int getmax(int ind) {
		if(ind < 0) return Integer.MIN_VALUE;
		else return starr[ind];
	}
	static class Node {
		Node left, right;
		int posminleft, posminright, posmaxleft, posmaxright;
		public Node(int L, int R) {
			if(L == R) {
				posminleft = posminright = posmaxleft = posmaxright = L;
			}
			else {
				left = new Node(L, (L+R)/2);
				right = new Node((L+R)/2+1, R);
				update();
			}
		}
		public int min() {
			return starr[posminleft];
		}
		public int max() {
			return starr[posmaxleft];
		}
		private void update() {
			if(left.min() < right.min()) {
				posminleft = left.posminleft;
				posminright = left.posminright;
			}
			else if(left.min() > right.min()) {
				posminleft = right.posminleft;
				posminright = right.posminright;
			}
			else { //equal
				posminleft = left.posminleft;
				posminright = right.posminright;
			}
			
			if(left.max() > right.max()) {
				posmaxleft = left.posmaxleft;
				posmaxright = left.posmaxright;
			}
			else if(left.max() < right.max()) {
				posmaxleft = right.posmaxleft;
				posmaxright = right.posmaxright;
			}
			else { //equal
				posmaxleft = left.posmaxleft;
				posmaxright = right.posmaxright;
			}
		}
		void update(int L, int R, int ind, int val) {
			if(ind < L || ind > R) return;
			if(L == R) {
				starr[L] = val;
			}
			else {
				left.update(L, (L+R)/2, ind, val);
				right.update((L+R)/2 + 1, R, ind, val);
				update();
			}
		} 
		int minleft(int L, int R, int l, int r) {
			if(r < L || l > R) return -1;
			if(l <= L && R <= r) {
				return posminleft;
			}
			int resl = left.minleft(L, (L+R)/2, l, r);
			int resr = right.minleft((L+R)/2+1, R, l, r);
			if(getmin(resl) <= getmin(resr)) {
				return resl;
			}
			else {
				return resr;
			}
		}
		int minright(int L, int R, int l, int r) {
			if(r < L || l > R) return -1;
			if(l <= L && R <= r) {
				return posminright;
			}
			int resl = left.minright(L, (L+R)/2, l, r);
			int resr = right.minright((L+R)/2+1, R, l, r);
			if(getmin(resr) <= getmin(resl)) {
				return resr;
			}
			else {
				return resl;
			}
		}
		int maxleft(int L, int R, int l, int r) {
			if(r < L || l > R) return -1;
			if(l <= L && R <= r) {
				return posmaxleft;
			}
			int resl = left.maxleft(L, (L+R)/2, l, r);
			int resr = right.maxleft((L+R)/2+1, R, l, r);
			if(getmax(resl) >= getmax(resr)) {
				return resl;
			}
			else {
				return resr;
			}
		}
		int maxright(int L, int R, int l, int r) {
			if(r < L || l > R) return -1;
			if(l <= L && R <= r) {
				return posmaxright;
			}
			int resl = left.maxright(L, (L+R)/2, l, r);
			int resr = right.maxright((L+R)/2+1, R, l, r);
			if(getmax(resr) >= getmax(resl)) {
				return resr;
			}
			else {
				return resl;
			}
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
