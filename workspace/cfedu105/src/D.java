import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < n; i++) {
			set.add(i);
		}
		sb = new StringBuilder();
		res = new int[2*n];
		for(int i = 0; i < n; i++) {
			res[i] = arr[i][i];
		}
		t = n;
		int r = process(set);
		StringBuilder sbres = new StringBuilder();
		sbres.append(t+"\n");
		for(int i = 0; i < t; i++) {
			sbres.append(res[i]+" ");
		}
		sbres.replace(sbres.length()-1, sbres.length(), "\n");
		sbres.append((r+1)+"\n");
		sbres.append(sb);
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(sbres.toString());
		pw.flush();
	}
	static int t;
	static int[] res;
	static StringBuilder sb;
	static int[][] arr;
	static int process(HashSet<Integer> set) {
		if(set.size() == 1) {
			int up = -1;
			for(int u: set) {
				up = u; break;
			}
			return up;
		}
		else {
			int u0 = t++;
			int max = 0;
			for(int u: set) {
				for(int v: set) {
					if(arr[u][v] > max) {
						max = arr[u][v];
					}
				}
			}
			res[u0] = max;
			HashSet<HashSet<Integer>> sets = new HashSet<>();
			while(!set.isEmpty()) {
				HashSet<Integer> cset = new HashSet<>();
				int ux = 0;
				for(int u: set) {
					ux = u; break;
				}
				for(int v: set) {
					if(arr[ux][v] != max) cset.add(v);
				}
				for(int v: cset) {
					set.remove(v);
				}
				sets.add(cset);
			}
			for(HashSet<Integer> s: sets) {
				int v = process(s);
				sb.append(String.format("%d %d\n", v+1, u0+1));
			}
			return u0;
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
