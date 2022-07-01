import java.util.*;
import java.io.*;
public class D2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
			int[] arr = new int[n*m];
			for(int i = 0; i < n*m; i++) {
				int a = sc.nextInt();
				if(!map.containsKey(a)) map.put(a, new LinkedList<>());
				map.get(a).add(i);
				
				arr[i] = a;
			}
			int[][] seats = new int[n][m];
			int si = 0, sj = 0;
			for(int a: map.keySet()) {
				for(int p: map.get(a)) {
					seats[si][sj] = p;
					sj++;
					if(sj == m) {
						sj = 0; si++;
					}
				}
			}
			int res = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					for(int k = 0; k < j; k++) {
						if(seats[i][k] < seats[i][j] && arr[seats[i][k]] != arr[seats[i][j]]) res++;
					}
				}
			}
			System.out.println(res);
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
