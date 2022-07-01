import java.util.*;
import java.io.*;

public class E2 {

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
			HashMap<Integer, TreeSet<Integer>> group = new HashMap<>();
			for(int k: ms.map.keySet()) {
				int v = ms.count(k);
				if(!group.containsKey(v)) {
					group.put(v, new TreeSet<Integer>(Collections.reverseOrder()));
				}
				group.get(v).add(k);
			}
			long res = 0;
			for(int c1: group.keySet()) {
				for(int c2: group.keySet()) {
					if(c1 < c2) continue;
					for(int x: group.get(c1)) {
						for(int y: group.get(c2)) {
							if(x == y) continue;
							long tot = (long)(c1 + c2) * (long)(x + y);
							if(tot < res) break;
							if(!ps.contains(new Pair(x, y))) {
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
				this.a = b; this.b = a;
			}
			else {
				this.a = a; this.b = b;
			}
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
