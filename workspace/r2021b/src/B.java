import java.util.*;
import java.io.*;
public class B { //SOLUTION

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int caso = 1;
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			if(n <= 3) {
				sbres.append(String.format("Case #%d: %d\n", caso++, n)); continue;
			}
			long[] d = new long[n-1];
			for(int i = 0; i < n-1; i++) {
				d[i] = arr[i+1] - arr[i];
			}
//			System.out.println(Arrays.toString(d));
			long[] pref = new long[n-1];
			long[] suff = new long[n-1];
			pref[0] = 0;
			for(int i = 1; i < n-1; i++) {
				if(d[i] == d[i-1]) {
					pref[i] = pref[i-1];
				}
				else pref[i] = i;
			}
			suff[n-2] = n-2;
			for(int i = n-3; i >= 0; i--) {
				if(d[i] == d[i+1]) suff[i] = suff[i+1];
				else suff[i] = i;
			}
//			System.out.println(Arrays.toString(pref));
//			System.out.println(Arrays.toString(suff));
			long res = Math.max(suff[1]+2, n-pref[n-3]);
			for(int i = 0; i < n-3; i++) {
				if(i < n-4 && d[i] == d[i+3] && d[i+2] + d[i+1] == 2*d[i]) {
					long curr = suff[i+3] - pref[i] + 2;
					res = Math.max(res, curr);
				}
				else if(d[i+2] + d[i+1] == 2 * d[i]) {
					long curr = i - pref[i] + 4;
					res = Math.max(res, curr);
				}
				else if(d[i+1] + d[i] == 2 * d[i+2]) {
					long curr = suff[i+2] - i + 2;
					res = Math.max(res, curr);
				}
			}
			if(suff[0] < n-2) {
				for(int i = 0; i < n-1; i++) {
					res = Math.max(res, i - pref[i] + 3);
				}
			}
			sbres.append(String.format("Case #%d: %d\n", caso++, res));
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sbres.toString().trim());
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
