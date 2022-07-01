import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int caso = 1;
		while(T-->0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			long[] arr = new long[n];
			int max = -1;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
				if(arr[i] > 0) max = Math.max(max, i);
			}
			int N = 400000;
			long[] state = new long[N];
			for(int i = 0; i < n; i++) {
				state[i] = arr[i];
			}
			boolean found = false;
			for(int i = 0; i < N; i++) {
				if(i + a >= N) break;
 				while(state[i] > 0) {
					if(state[i] == 1 && i == max) {
						found = true; break;
					}
					if(state[i + (b - a)] > 0) {
						state[i + b]++;
						max = Math.max(max, i+b);
						state[i]--; state[i + (b-a)]--;
					}
					else {
						state[i + a]++;
						max = Math.max(max, i+a);
						state[i]--;
					}
				}
			}
			if(found) {
				System.out.printf("Case #%d: %d\n", caso++, max+1);
			}
			else {
				System.out.printf("Case #%d: IMPOSSIBLE\n", caso++);
			}
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
