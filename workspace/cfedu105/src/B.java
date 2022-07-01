import java.util.*;
import java.io.*;
public class B {

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
