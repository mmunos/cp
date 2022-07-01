import java.util.*;
import java.io.*;
public class C2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int[] brr = new int[k];
			for(int i = 0; i < k; i++) {
				brr[i] = sc.nextInt();
			}
			sort(arr);
			long res = 0;
			sort(brr);
			int c = n-1;
			for(int i = 0; i < k; i++) {
				long val = arr[c--];
				res += val;
				brr[i]--;
				if(brr[i] == 0) {
					res += val;
				}
			}
			for(int i = 0; i < k; i++) {
				if(brr[i] == 0) continue;
				for(int j = 0; j < brr[i]-1; j++) {
					c--;
				}
				res += arr[c--];
			}
			System.out.println(res);
		}		

	}
	static void sort(int[] arr) {
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) {
			int ind = r.nextInt(arr.length);
			int aux = arr[ind]; arr[ind] = arr[i]; arr[i] = aux; 
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
