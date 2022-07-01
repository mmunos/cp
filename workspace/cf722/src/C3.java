import java.util.*;
import java.io.*;
public class C3 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			n = sc.nextInt();
			g1 = new LinkedList[n];
			for(int i = 0; i < n; i++) {
				g1[i] = new LinkedList<>();
			}
			for(int i = 1; i < n; i++) {
				int u = sc.nextInt()-1;
				g1[u].add(i);
			}
			g2 = new LinkedList[n];
			for(int i = 0; i < n; i++) {
				g2[i] = new LinkedList<>();
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
			stset = new TreeSet<>();
			dfs(0);
			System.out.println(res);
		}

	}
	static int[] starr;
	static TreeSet<Integer> stset;
	static int n;
	static LinkedList<Integer>[] g1, g2;
	static int t;
	static int res, curr;
	static int[] op, cl;
	static void build(int u) {
		op[u] = t; t++;
		for(int v: g2[u]) {
			build(v);
		}
		cl[u] = t; t++;
	}
	static void dfs(int u) {
		starr[op[u]] = 1;
		starr[cl[u]] = -1;
		stset.add(op[u]);
		stset.add(cl[u]);
//		System.out.println(st);
		boolean add = false;
		if(u == 0) {
			add = true;
		}
		else {
			//add if parent is not leaf
			//this happens if and only if rightmost nonzero value to the left is 1
			// and if leftmost nonzero value to the right is -1
			int posl = stset.lower(op[u]);
			int posr = stset.higher(cl[u]);
			if(starr[posl] != 1 || starr[posr] != -1) add = true;
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
		starr[op[u]] = 0;
		starr[cl[u]] = 0;
		stset.remove(op[u]);
		stset.remove(cl[u]);
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
