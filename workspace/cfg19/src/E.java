import java.util.*;
import java.io.*;

public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			HashSet<Pair> ps = new HashSet<>();
			for(int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				ps.add(new Pair(a, b));
			}
			Multiset ms = new Multiset();
			for(int i = 0; i < n; i++) {
				ms.add(arr[i]);
			}
			HashMap<Integer, HashSet<Integer>> group = new HashMap<>();
			for(int k: ms.map.keySet()) {
				int v = ms.count(k);
				if(!group.containsKey(v)) {
					group.put(v, new HashSet<Integer>());
				}
				group.get(v).add(k);
			}
			int c = group.size();
			long[] sizes = new long[c];
			ArrayList<Integer>[] vals = new ArrayList[c];
			int ind = 0;
			for(int k: group.keySet()) {
				sizes[ind] = k;
				vals[ind] = new ArrayList<Integer>();
				for(int j: group.get(k)) {
					vals[ind].add(j);
				}
				Collections.sort(vals[ind], Collections.reverseOrder());
				ind++;
			}
			long res = 0;
			for(int i = 0; i < c; i++) {
				for(int j = i; j < c; j++) {
					int na = vals[i].size();
					int nb = vals[j].size();
					for(int u = 0; u < na; u++) {
						for(int v = 0; v < nb; v++) {
							int x = vals[i].get(u);
							int y = vals[j].get(v);
							if(x == y) continue;
							if(!ps.contains(new Pair(x, y))) {
								long tot = (sizes[i] + sizes[j]) * ((long)x + (long)y);
								res = Math.max(res, tot);
								break;
							}
						}
					}
				}
			}
			System.out.println(res);
		}

	}
	static class Pair{
		int a, b;
		public Pair(int a, int b) {
			if(a > b) {
				int aux = b; b = a; a = aux;
			}
			this.a = a; this.b = b;
		}
		@Override
		public int hashCode() {
			return a + b;
		}
		@Override
		public boolean equals(Object o) {
			Pair p = (Pair)o;
			return a == p.a && b == p.b;
		}
		public String toString() {
			return a+" "+b;
		}
	}
	static class Multiset{
		HashMap<Integer, Integer> map;
		public Multiset() {
			map = new HashMap<>();
		}
		public void add(int a) {
			if(!map.containsKey(a)) map.put(a, 1);
			else map.put(a, map.get(a)+1);
		}
		public void remove(int a) {
			map.put(a, map.get(a)-1);
			if(map.get(a) == 0) map.remove(a);
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
