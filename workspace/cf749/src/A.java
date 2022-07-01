import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			long sum = 0;
			HashSet<Integer> vals = new HashSet<>();
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
				vals.add(i);
			}
			StringBuilder sb = new StringBuilder();
			if(isprime(sum)) {
				for(int i = 0; i < n; i++) {
					if(arr[i] % 2 == 1) {
						vals.remove(i);
						break;
					}
				}
			}
			int res = 0;
			for(int val: vals) {
				sb.append((val+1)+" "); res++;
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
			System.out.println(res);
			System.out.print(sb);
		}	

	}
	static boolean isprime(long x) {
		for(int d = 2; d*d <= x; d++) {
			if(x % d == 0) return false;
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
