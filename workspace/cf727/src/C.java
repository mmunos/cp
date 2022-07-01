import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		long k = sc.nextLong();
		long x = sc.nextLong();
		long[] arr = new long[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		sort(arr);
		PriorityQueue<Long> q = new PriorityQueue<>();
		int res = 1;
		for(int i = 0; i < n-1; i++) {
			long d = arr[i+1] - arr[i];
			long b = (d-1)/x;
			if(b > 0) {
				q.add(b);
				res++;
			}
		}
		while(!q.isEmpty()) {
			long v = q.poll();
			if(v <= k) {
				k -= v; res--;
			}
		}
		System.out.println(res);
	}
	
	static void sort(long[] arr) {
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) {
			int ind = r.nextInt(arr.length);
			long aux = arr[ind]; arr[ind] = arr[i]; arr[i] = aux; 
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
