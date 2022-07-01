import java.util.*;
import java.io.*;
public class G2 {

	public static void main(String[] args) {
		int[] mins = {0, 0, 1, 7, 4, 2, 6, 8, 10, 18, 22, 20, 28, 68, 88};
		int[] mm = {108, 188, 200, 208, 288, 688, 888};
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			//min
			if(n <= 14) {
				sb.append(mins[n]);
			}
			else {
				int d = (n-1)/7+1;
				sb.append(mm[(n-1)%7]+"");
				for(int i = 0; i < d-3; i++) {
					sb.append('8');
				}
			}
			sb.append(" ");
			//max
			if(n == 1) sb.append("1");
			else {
				if(n % 2 == 0) sb.append('1');
				else sb.append("7");
				for(int i = 0; i < n/2-1; i++) {
					sb.append('1');
				}
			}
			sb.append('\n');
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
