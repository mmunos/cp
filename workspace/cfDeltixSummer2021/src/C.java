import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		if(n % 2 == 1) n--;
		long[] brr = new long[n+1];
		brr[0] = 0;
		TreeSet<Long> vals = new TreeSet<>();
		vals.add(0L);
		for(int i = 1; i <= n; i++) {
			if(i % 2 == 1) {
				brr[i] = brr[i-1] + arr[i-1];
			}
			else {
				brr[i] = brr[i-1] - arr[i-1];
			}
			vals.add(brr[i]);
		}
		long res = 0;
		for(long h: vals) {
			long count = 1;
			boolean start = false;
			for(int i = 0; i < n; i += 2) {
				if(brr[i] < h && brr[i+1] > h) {
					if(start) {
						res += count; count = 1;
					}
					start = true;
				}
				else if(brr[i] == h) {
					if(start) {
						res += count; count++;
					}
					start = true;
				}
				else {
					//nothing
				}
			}
			if(start && brr[n] <= h) {
				res += count;
			}
		}
		long gaps = 0;
		long prevh = Long.MIN_VALUE;
		for(long h: vals) {
			res += gaps * (h - prevh - 1);
			gaps = 0;
			for(int i = 0; i < n; i += 2) {
				if(brr[i] <= h && brr[i+1] > h) gaps++; 
			}
			if(brr[n] > h) gaps--;
			prevh = h;
		}
		System.out.println(res);
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
