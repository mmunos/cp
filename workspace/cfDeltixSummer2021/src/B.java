import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int od = 0, ev = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt()%2;
				if(arr[i] == 0) ev++;
				else od++;
			}
			if(Math.abs(od - ev) > 1) System.out.println(-1);
			else {
				if(n % 2 == 0) {
					System.out.println(Math.min(calc(arr, 0), calc(arr, 1)));
				}
				else {
					if(ev > od) System.out.println(calc(arr, 0));
					else System.out.println(calc(arr, 1));
				}
			}
		}
		
	}
	static long calc(int[] arr, int d) {
		long c = 0;
		long res = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == d) {
				res += Math.abs(i - c); c += 2;
			}
		}
		return res;
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
