import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int d = sc.nextInt();
		UnionFind uf = new UnionFind(n);
		Multiset inside = new Multiset();
		inside.add(1);
		Multiset outside = new Multiset();
		for(int i = 0; i < n-1; i++) {
			outside.add(1);
		}
		int k = 1;
		StringBuilder sb = new StringBuilder();
		while(d-->0) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			int rootu = uf.find(u);
			int rootv = uf.find(v);
			if(rootu != rootv) {
				int a = uf.count[rootu];
				int b = uf.count[rootv];
				if(inside.contains(a)) {
					inside.remove(a);
				}
				else {
					outside.remove(a);
				}
				if(inside.contains(b)) {
					inside.remove(b);
				}
				else {
					outside.remove(b);
				}
				uf.union(rootu, rootv);
				int c = a + b;
				if(inside.isEmpty() || c > inside.map.firstKey()) {
					inside.add(c);
				}
				else {
					outside.add(c);
				}
			}
			else {
				k++;
			}
			while(inside.size > k) {
				int a = inside.map.firstKey();
				inside.remove(a);
				outside.add(a);
			}
			while(inside.size < k) {
				int a = outside.map.lastKey();
				outside.remove(a);
				inside.add(a);
			}
			sb.append((inside.sum-1)+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	
	static class Multiset{
		TreeMap<Integer, Integer> map;
		int size = 0;
		int sum = 0;
		public Multiset() {
			map = new TreeMap<>();
		}
		public void add(int a) {
			if(!map.containsKey(a)) map.put(a, 1);
			else map.put(a, map.get(a)+1);
			size++;
			sum += a;
		}
		public void remove(int a) {
			map.put(a, map.get(a)-1);
			if(map.get(a) == 0) map.remove(a);
			size--;
			sum -= a;
		}
		public boolean contains(int a) {
			return map.containsKey(a);
		}
		public int count(int a) {
			if(!map.containsKey(a)) return 0;
			else return map.get(a);
		}
		public boolean isEmpty() {
			return map.isEmpty();
		}
		public boolean equals(Multiset ms) {
			for(int k: map.keySet()) {
				if(count(k) != ms.count(k)) return false;
			}
			return true;
		}
		public String toString() {
			return map.toString();
		}
	}
	
	static class UnionFind {
		//source: https://www.cs.waikato.ac.nz/~bernhard/317/source/graph/UnionFind.java
		private int[] _parent;
		private int[] _rank;
		int[] count;

		public UnionFind(int max) {
			_parent = new int[max];
			_rank = new int[max];
			count = new int[max];
			for (int i = 0; i < max; i++) {
				_parent[i] = i;
				count[i] = 1;
			}
		}

		public int find(int i) {
			int p = _parent[i];
			if (i == p) {
				return i;
			}
			return _parent[i] = find(p);
		}

		public void union(int i, int j) {
			int root1 = find(i), root2 = find(j);
			if (root2 == root1) return;
			if (_rank[root1] > _rank[root2]) {
				_parent[root2] = root1;
				count[root1] += count[root2];
			} else if (_rank[root2] > _rank[root1]) {
				_parent[root1] = root2;
				count[root2] += count[root1];
			} else {
				_parent[root2] = root1;
				count[root1] += count[root2];
				_rank[root1]++;
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
