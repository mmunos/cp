import java.util.*;

import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] min = new int[n+1];
		Arrays.fill(min, -1);
		int[] max = new int[n+1];
		for(int i = 0; i < n; i++) {
			if(min[arr[i]] < 0) {
				min[arr[i]] = i;
			}
			max[arr[i]] = i;
		}
		int ind = 0;
		int last = 0;
		int[] paint = new int[n];
		while(ind < n) {
			int forw = max[arr[ind]];
			int low = Math.max(ind, last);
			for(int i = low+1; i < forw; i++) {
				paint[i] = 1;
			}
			int maxmax = forw, maxi = ind;
			for(int i = low+1; i < forw; i++) {
				if(max[arr[i]] > maxmax) {
					maxmax = max[arr[i]]; maxi = i;
				}
			}
			if(maxi == ind) {
				ind = forw+1; last = ind;
			}
			else {
				ind = maxi; last = forw;
			}
		}
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			res += paint[i];
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
