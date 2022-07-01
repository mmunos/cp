import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		int N = 1000001;
		int[] sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int e = sc.nextInt();
			int[] arr = new int[n];
			long res = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i = 0; i < e; i++) {
				long ones = 0;
				long pones = 0;
				for(int k = i; k < n; k += e) {
					if(arr[k] == 1) {
						ones++;
						res += pones;
					}
					else if(sieve[arr[k]] == arr[k]) { //arr[k] is prime
 						res += ones;
 						pones = ones + 1; // including p
 						ones = 0;
					}
					else {//not prime
						pones = ones = 0;
					}
				}
			}
			sb.append(res+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
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
