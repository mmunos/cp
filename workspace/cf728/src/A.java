import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			sort(arr);
			long[] brr = new long[n-1];
			for(int i = 0; i < n-1; i++) {
				brr[i] = arr[i+1] - arr[i];
			}
			long res = 0;
			long fac = n-1;
			long k = n-3;
			for(int i = 0; i < (n-1)/2; i++) {
				res += (brr[i] + brr[n-i-2]) * fac;
				fac += k; k -= 2;
			}
			if(n % 2 == 0) {
				res += brr[n/2-1] * fac;
			}
			System.out.println(-res + arr[n-1]);
		}	
		
	}
	static void sort(int[] arr) {
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) {
			int ind = r.nextInt(arr.length);
			int aux = arr[ind]; arr[ind] = arr[i]; arr[i] = aux; 
		}
		Arrays.sort(arr);
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
