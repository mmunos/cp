import java.util.*;
import java.io.*;
public class Etests2 {

	public static void main(String[] args) {
		Random r = new Random();
		int T = 100;
		int n = 100, m = 10000;
		int c = 0;
		while(T-->0) {
			char[][] map = getmap(r, n, m);
			int[][] prof = profile(map, n, m);
			Pair[] things = new Pair[n];
			for(int i = 0; i < n; i++) {
				things[i] = new Pair(i, prof[i][0]);
			}
			Arrays.sort(things);
			HashSet<Integer> candidates = new HashSet<Integer>();
			for(int i = 0; i < n; i++) {
				if(prof[i][0] >= 44) {
					candidates.add(i);
				}
			}
			int k = prof[0].length;
			HashMap<Integer, Integer> count = new HashMap<>();
			for(int ind: candidates) {
				count.put(ind, 0);
			}
			for(int i = 0; i < 50; i++) {
				int min = m, minj = -1;
				for(int j: candidates) {
					if(prof[j][i] < min) {
						min = prof[j][i];
						minj = j;
					}
				}
				count.put(minj, count.get(minj)+1);
			}
			int maxind = -1, max = 0;
			for(int ind: candidates) {
				if(count.get(ind) > max) {
					max = count.get(ind);
					maxind = ind;
				}
			}
			System.out.println(maxind+1);
			if(maxind+1 == 100) {
				c++;
			}
		}
		System.out.println("tot "+c);

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
	static char[][] getmap(Random r, int n, int m){
		double[] a = new double[n];
		for(int i = 0; i < n; i++) {
			a[i] = r.nextDouble()*6-3;
		}
		double[] b = new double[m];
		for(int i = 0; i < m; i++) {
			b[i] = r.nextDouble()*6-3;
		}
		char[][] map = new char[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				double f = 1.0 / (1.0 + Math.exp(-a[i]+b[j]));
				double z = r.nextDouble();
				if(z > f) map[i][j] = '1';
				else map[i][j] = '0';
			}
		}
		for(int i = 0; i < m; i++) {
			double z = r.nextDouble();
			if(z > 0.5) map[n-1][i] = '1';
		}
		return map;
	}
	static TreeSet<Integer> poss(char[][] map, int n, int m, int k, int thres) {
		int[] tot = new int[m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '1') tot[j]++;
			}
		}
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		int candi = -1, minlow = m;
		for(int i = 0; i < n; i++){
			Pair[] probs = new Pair[m];
			for(int j = 0; j < m; j++) {
				probs[j] = new Pair(j, tot[j] - (map[i][j]-'0') );
			}
			Arrays.sort(probs);
			int d = 0;
			for(int j = 0; j < k; j++){
				if(map[i][probs[j].i] == '1') d++;
			}
			if(d >= thres) {
				
			}
		}
		return set;
	}
	static int calc(char[][] map, int n, int m, int k, int thres) {
		int[] tot = new int[m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '1') tot[j]++;
			}
		}
		int candi = -1, maxlow = 0;
		for(int i = 0; i < n; i++){
			Pair[] probs = new Pair[m];
			for(int j = 0; j < m; j++) {
				probs[j] = new Pair(j, tot[j] - (map[i][j]-'0') );
			}
			Arrays.sort(probs);
			int c = 0;
			for(int j = 0; j < k; j++){
				if(map[i][probs[j].i] == '1') c++;
			}
			if(c >= thres) {
				int d = 0;
				for(int j = 0; j < k; j++){
					if(map[i][probs[m-j-1].i] == '0') d++;
				}
				if(d > maxlow) {
					maxlow = d; candi = i;
				}
			}
		}
		return candi+1;
	}
	static char[] order(char[][] map, int n, int m, int ind) {
		int[] tot = new int[m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++) {
				if(map[i][j] == '1') tot[j]++;
			}
		}
		Pair[] probs = new Pair[m];
		for(int i = 0; i < m; i++) {
			probs[i] = new Pair(i, tot[i]);
		}
		char[] res = new char[m];
		for(int i = 0; i < m; i++) {
			res[i] = map[ind-1][probs[i].i];
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
