import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] arr = new int[n];
		int tot = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			tot += arr[i];
		}
		if(tot % 2 == 1) {
			System.out.println("0"); return;
		}
		boolean[][] dp = new boolean[n+1][tot/2+1];
		dp[0][0] = true;
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= tot/2; j++){
				if(dp[i][j]) {
					dp[i+1][j] = true;
					if(j+arr[i] <= tot/2) dp[i+1][j + arr[i]] = true;
				}
			}
		}
		if(!dp[n][tot/2]) {
			System.out.println("0"); return;
		}
		while(process(arr));
		int ind = -1;
		for(int i = 0; i < n; i++) {
			if(arr[i] % 2 == 1) ind = i;
		}
		System.out.println("1\n"+(ind+1));
	}
	static boolean process(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			if(arr[i] % 2 == 1) return false;
		}
		for(int i = 0; i < n; i++) {
			arr[i] /= 2;
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
