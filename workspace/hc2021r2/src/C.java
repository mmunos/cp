import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 0;
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt()-1;
			char[][] map = new char[n+2][m];
//			int[] count = new int[n+2];
			for(int i = 1; i <= n; i++) {
				map[i] = sc.next().toCharArray();
//				for(int j = 0; j < m; j++) {
//					if(map[i][j] == 'X') count[i]++;
//				}
			}
			map[0] = new char[m];
			map[n+1] = new char[m];
			n += 2; 
			k++; //useless but symbolic
			int[][] acc = new int[n][m];
			for(int j = 0; j < m; j++) {
				for(int i = 1; i < n; i++) {
					acc[i][j] = acc[i-1][j];
					if(map[i][j] == 'X') acc[i][j]++;
				}
			}
			int res = Integer.MAX_VALUE;
			for(int i = 0; i < k; i++) {
				int curr = k-i; //shifts down	
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 'X') curr++;
					else {
						int a = acc[n-1][j] - acc[i][j];
						if(a > n-k-2) {
							curr++;
						}
					}
				}
				res = Math.min(res, curr);
			}
			int currmid = 0;
			for(int j = 0; j < m; j++) {
				if(map[k][j] == 'X') currmid++;
			}
			res = Math.min(res, currmid);
			for(int i = k+1; i < n; i++) {
				int curr = i-k; //shifts up	
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 'X') curr++;
					else {
						int a = acc[i-1][j];
						if(a > k-1) {
							curr++;
						}
					}
				}
				res = Math.min(res, curr);
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
