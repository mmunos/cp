import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int p = sc.nextInt();
		int caso = 1;
		while(T-- > 0) {
			int n = 100, m = 10000;
			char[][] map = new char[n][m];
			int[] tot = new int[m];
			for(int i = 0; i < n; i++){
				map[i] = sc.next().toCharArray();
				for(int j = 0; j < m; j++) {
					if(map[i][j] == '1') tot[j]++;
				}
			}
			int[][] prof = profile(map, n, m);
			HashSet<Integer> candidates = new HashSet<Integer>();
			for(int i = 0; i < n; i++) {
				if(prof[i][0] >= 45) {
					candidates.add(i);
				}
			}
			int k = prof[0].length;
			int maxind = -1, maxstat = 0;
			for(int ind: candidates) {
				int stat = 0;
				for(int i = 0; i < k/2; i++) {
					for(int j: candidates) {
						stat += Math.abs(prof[j][i] - prof[ind][i]);
					}
				}
				if(stat > maxstat) {
					maxind = ind;
					maxstat = stat;
				}
			}
			System.out.printf("Case #%d: %d\n", caso++, maxind+1);
		}

	}

	static int[][] profile(char[][] map, int n, int m){
		int[] tot = new int[m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '1') tot[j]++;
			}
		}
		int k = 100;
		int[][] res = new int[n][k];
		for(int i = 0; i < n; i++){
			Pair[] probs = new Pair[m];
			for(int j = 0; j < m; j++) {
				probs[j] = new Pair(j, tot[j] - (map[i][j] - '0'));
			}
			Arrays.sort(probs);
			for(int r = 0; r < k; r++){
				for(int j = 0; j < m/k; j++){
					if(map[i][probs[r*m/k + j].i] == '1') res[i][r]++;
				}
			}
		}
		return res;
	}
	static class Pair implements Comparable<Pair>{
		int i, w;
		public Pair(int a, int b) {
			this.i = a; this.w = b;
		}
		public String toString() {
			return i+" "+w;
		}
		@Override
		public int compareTo(Pair p) {
			return w - p.w;
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
