import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 0;
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] mat = new int[n+1][m];
			for(int i = 0; i < n+1; i++) {
				for(int j = 0; j < m; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			LinkedList<Integer> qclean = new LinkedList<>();
			LinkedList<Integer> qdirty = new LinkedList<>();
			int res = 0;
			for(int i = 0; i < m; i++) {
				qclean.add(mat[0][i]);
			}
			for(int i = 1; i < n+1; i++) {
				Multiset ms = new Multiset();
				for(int j = 0; j < m; j++) {
					ms.add(mat[i][j]);
				}
				LinkedList<Integer> qcleannew = new LinkedList<>();
				LinkedList<Integer> qdirtynew = new LinkedList<>();
				for(int a: qdirty) {
					if(ms.contains(a)) {
						ms.remove(a);
						qdirtynew.add(a);
					}
					else {
						res++;
					}
				}
				for(int a: qclean) {
					if(ms.contains(a)) {
						ms.remove(a);
						qcleannew.add(a);
					}
					else {
						//res++;
					}
				}
				qclean = qcleannew;
				qdirty = qdirtynew;
				for(int a: ms.map.keySet()) {
					int k = ms.count(a);
					while(k-- > 0) qdirty.add(a);
				}
			}

			System.out.printf("Case #%d: %d\n", ++caso, res);
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
//		public boolean equals(Multiset ms) {
//			for(int k: map.keySet()) {
//				if(count(k) != ms.count(k)) return false;
//			}
//			return true;
//		}
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
