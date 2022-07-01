import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			boolean yes = false;
			// iterate over all the masks
			for (int mask = 1; mask < (1<<n); mask++){
			    // iterate over all the subsets of the mask
			    for(int mm = mask; mm > 0; mm = (mm-1) & mask){
			    	long a = 0;
			    	for(int i = 0; i < n; i++) {
						if(((1 << i) & mm) > 0) a += arr[i];
						else if(((1 << i) & mask) > 0) a -= arr[i];
					}
			    	if(a == 0) yes = true;
			    }
			}
			if(yes) System.out.println("YES");
			else System.out.println("NO");
		}

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
