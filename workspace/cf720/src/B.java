import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		PrintWriter pw = new PrintWriter(System.out);
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int minv = Integer.MAX_VALUE, mini = -1;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				if(arr[i] < minv) {
					minv = arr[i]; mini = i;
				}
			}
			StringBuilder sb = new StringBuilder();
			int res = 0;
			if(mini != 0) {
				sb.append(String.format("%d %d %d %d\n", 1, mini+1, minv, minv+1)); res++;
				arr[0] = minv; arr[mini] = minv+1;
			}
			for(int i = 1; i < n; i++) {
				sb.append(String.format("%d %d %d %d\n", 1, i+1, minv, minv+i)); res++;
				arr[i] = minv+i;
			}
			pw.print(res+"\n");
			pw.print(sb.toString());
		}
		pw.flush();
	}
	
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
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
