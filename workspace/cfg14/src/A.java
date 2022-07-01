import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] arr = new int[n];
			int tot = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				tot += arr[i];
			}
			if(tot == x) {
				System.out.println("NO"); continue;
			}
			Arrays.sort(arr);
			int curr = 0;
			for(int i = 0; i < n-1; i++) {
				curr += arr[i];
				if(curr == x) {
					curr -= arr[i];
					int aux = arr[i]; arr[i] = arr[i+1]; arr[i+1] = aux;
					break;
				}
			}
			System.out.println("YES");
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				sb.append(arr[i]+" ");
			}
			System.out.println(sb.toString().trim());
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
