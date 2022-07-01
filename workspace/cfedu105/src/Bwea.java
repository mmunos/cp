import java.util.*;
import java.io.*;
public class Bwea {

	public static void main(String[] args) {
		int max = 1 << 9;
		HashSet<String> poss = new HashSet<String>(); 
		for(int i = 0; i < max; i++) {
			int[][] map = new int[3][3];
			for(int k = 0; k < 9; k++) {
				if((i & (1 << k))>0) map[k%3][k/3] = 1;
			}
			int[] vals = new int[4];
			for(int j = 0; j < 3; j++) {
				vals[0] += map[0][j];
			}
			for(int j = 0; j < 3; j++) {
				vals[1] += map[j][2];
			}
			for(int j = 0; j < 3; j++) {
				vals[2] += map[2][j];
			}
			for(int j = 0; j < 3; j++) {
				vals[3] += map[j][0];
			}
			poss.add(Arrays.toString(vals));
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt(); //3
			int[] arr = new int[4];
			for(int i = 0; i < 4; i++) {
				arr[i] = sc.nextInt();
			}
			if(poss.contains(Arrays.toString(arr))) System.out.println("YES");
			else System.out.println("NO");
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
