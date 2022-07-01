import java.util.*;
import java.io.*;
public class E {
	
	//case 1 :   - ... - - + ... - + + ... +
	//case 2 : + - ... - - + ... - + + ... +
	//case 3 :   - ... - - + ... - + + ... + -
	//case 4 : + - ... - - + ... - + + ... + -
	//case 5 :  + + ... + - - ... -

	static long mod = 998244353;
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			long tot = 0;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
				tot += arr[i];
			}
			if(n == 1) {
				sb.append(1+"\n"); continue;
			}
			//case 1
			long r1 = calc(arr, 0);
			long[] arr2 = new long[n-1];
			for(int i = 0; i < n-1; i++) {
				arr2[i] = arr[i+1];
			}
			long r2 = calc(arr2, -arr[0]);
			long[] arr3 = new long[n-1];
			for(int i = 0; i < n-1; i++) {
				arr3[i] = arr[i];
			}
			long r3 = calc(arr3, arr[n-1]);
			long[] arr4 = new long[n-2];
			for(int i = 0; i < n-2; i++) {
				arr4[i] = arr[i+1];
			}
			long r4 = calc(arr4, arr[n-1] - arr[0]);
			long curr = 0;
			long r5 = 0;
			for(int i = 0; i < n; i++) {
				curr += arr[i];
				if(curr > tot - curr) r5++;
			}
			long res = r1 + r2 + r3 + r4 + r5;
			sb.append(res%mod+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static long calc(long[] arr, long thres) {
		int n = arr.length;
		if(n == 0) return 0;
		// - + - + ... - + - + (+)
		long curr = 0;
		for(int i = 0; i < n; i++) {
			if(i % 2 == 1 || i == n-1) curr += arr[i];
			else curr -= arr[i];
		}
		long r1 = 0;
		int b = n-n%2;
		for(int a = 0; a < b; a += 2) {
			while(a < b && curr <= thres) {
				curr += 2*arr[b-2];
				b -= 2;
			}
			if(curr > thres) {
				r1 += (b-a)/2;
			}
			curr -= 2*arr[a+1];
		}
		// - - + - + ... - + - + (+)
		curr = -arr[0];
		for(int i = 1; i < n; i++) {
			if(i % 2 == 0 || i == n-1) curr += arr[i];
			else curr -= arr[i];
		}
		long r2 = 0;
		b = n-1+n%2;
		for(int a = 1; a < b; a += 2) {
			while(a < b && curr <= thres) {
				curr += 2*arr[b-2];
				b -= 2;
			}
			if(curr > thres) {
				r2 += (b-a)/2;
			}
			curr -= 2*arr[a+1];
		}
		return r1 + r2;
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
