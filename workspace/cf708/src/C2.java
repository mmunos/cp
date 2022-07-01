import java.util.*;
import java.io.*;
public class C2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] res = solve(n-(k-3));
			sb.append(res[0]+" "+res[1]+" "+res[2]);
			for(int i = 0; i < k-3; i++) {
				sb.append(" 1");
			}
			sb.append("\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static int[] solve(int n) { //k == 3
		if(2*3 >= n) {
			int[] res = new int[3];
			Arrays.fill(res, 1);
			for(int i = 0; i < n-3; i++) {
				res[i]++;
			}
			return res;
		}
		else if(n % 2 == 0) {
			int[] res = solve(n / 2);
			for(int i = 0; i < 3; i++) {
				res[i] *= 2;
			}
			return res;
		}
		else {
			int[] res = new int[3];
			res[0] = n/2;
			res[1] = n/2;
			res[2] = 1;
			return res;
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
