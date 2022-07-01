import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		long k = sc.nextLong();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] brr = new int[m];
		for(int i = 0; i < m; i++) {
			brr[i] = sc.nextInt();
		}
		d = gcd(n, m);
		long a = 0, b = Long.MAX_VALUE;
		while(b - a > 1) {
			long c = (a+b)/2;
			if(check(arr, brr, k, c)) a = c;
			else b = c;
		}
		System.out.println(a);
	}
	static int d;
	static boolean check(int[] arr, int[] brr, long k, long t) {
		int n = arr.length;
		int m = brr.length;
		int[] posa = new int[2*(n+m)+1];
		Arrays.fill(posa, -1);
		for(int i = 0; i < n; i++) {
			posa[arr[i]] = i;
		}
		int[] posb = new int[2*(n+m)+1];
		Arrays.fill(posb, -1);
		for(int i = 0; i < m; i++) {
			posb[brr[i]] = i;
		}
		
	}
	static int gcd(int a, int b) {
		if(a < b) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
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
