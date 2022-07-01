import java.util.*;
import java.io.*;
public class Bgen {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(3*3*3*3);
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				for(int k = 0; k <= n; k++) {
					for(int l = 0; l <= n; l++) {
						System.out.printf("3 %d %d %d %d\n",i, j, k, l);
					}
				}
			}
		}
	}
	static int[][] vals = {
			{0,0,0,0},{1,1,0,0},{1,1,1,1},{2,2,1,1},{2,2,2,2},{0,1,2,1}
	};
	static boolean check(int[] arr, int n) {
		if(n == 2) {
			for(int off = 0; off < 4; off++) {
				for(int[] v: vals) {
					boolean fit = true;
					for(int i = 0; i < 4; i++) {
						if(arr[(off+i)%4] != v[i]) {
							fit = false; break;
						}
					}
					if(fit) return true;
				}
			}
			return false;
		}
		for(int off = 0; off < 4; off++) {
			int a = arr[off];
			int b = arr[(off+3)%4];
			int c = arr[(off+1)%4];
			if(a == n) {
				if(b == 0) return false;
				if(c == 0) return false;
			}
			if(a == n-1) {
				if(b == 0 && c == 0) return false;
			}
			if(a == 1) {
				if(b == n && c == n) return false;
			}
			if(a == 0) {
				if(b == n) return false;
				if(c == n) return false;
			}
		}
		return true;
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
