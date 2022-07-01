import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[][] arr = new int[n][5];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < 5; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			TreeSet<Integer> cands = new TreeSet<>();
			for(int i = 0; i < n; i++) {
				cands.add(i);
			}
			while(cands.size() >= 2) {
				int u = cands.pollFirst();
				int v = cands.pollFirst();
				int a = 0, b = 0;
				for(int j = 0; j < 5; j++) {
					if(arr[u][j] < arr[v][j]) a++;
					else b++;
				}
				if(a > b) cands.add(u);
				else cands.add(v);
			}
			int u = cands.first();
			boolean yes = true;
			for(int i = 0; i < n; i++) {
				if(i == u) continue;
				int a = 0, b = 0;
				for(int j = 0; j < 5; j++) {
					if(arr[u][j] < arr[i][j]) a++;
					else b++;
				}
				if(b > a) {
					yes = false; break;
				}
			}
			if(yes) System.out.println(u+1);
			else System.out.println(-1);
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
