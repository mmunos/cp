import java.util.*;
import java.io.*;
public class B2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[4];
			for(int i = 0; i < 4; i++) {
				arr[i] = sc.nextInt();
			}
			if(check(arr, n)) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
	static boolean check(int[] arr, int n) {
		int m = 1 << 4;
		for(int mask = 0; mask < m; mask++) {
			int[] esq = new int[4];
			for(int k = 0; k < 4; k++) {
				if((mask & (1 << k))>0) esq[k] = 1;
			}
			boolean yes = true;
			for(int i = 0; i < 4; i++) {
				int a = esq[i];
				int b = esq[(i+1)%4];
				if(a + b == 0) {
					if(arr[i] > n-2) {
						yes = false; break;
					}
				}
				if(a + b == 1) {
					if(arr[i] == n || arr[i] == 0) {
						yes = false; break;
					}
				}
				if(a + b == 2) {
					if(arr[i] < 2) {
						yes = false; break;
					}
				}
			}
			if(yes) {
				return true;
			}
		}
		return false;
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
