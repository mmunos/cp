import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		boolean valid = true;
		for(int i = 1; i < n-1; i++) {
			if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
				int a = i-1;
				while(a >= 0 && arr[a] < arr[a+1]) a--;
				a++;
				int b = i+1;
				while(b < n && arr[b] < arr[b-1]) b++;
				b--;
				int x = i-a+1;
				int y = b-i+1;
				if(x > max) {
					max = x; valid = false;
					if(x == y && x % 2 == 1) {
						valid = true; continue;
					}
				}
				else if(x == max) {
					valid = false;
				}
				
				if(y > max) {
					max = y; valid = false;
				}
				else if(y == max) {
					valid = false;
				}
			}
		}
		if(valid) System.out.println(1);
		else System.out.println(0);
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
