import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			if(n == 1) {
				sb.append(s[0]+""+s[0]+"\n");
			}
			else if(s[0] == s[1]) {
				sb.append(s[0]+""+s[0]+"\n");
			}
			else {
				int ind = n;
				for(int i = 0; i < n-1; i++) {
					if(s[i] < s[i+1]) {
						ind = i+1; break;
					}
				}
				for(int i = 0; i < ind; i++) {
					sb.append(s[i]);
				}
				for(int i = ind-1; i >= 0; i--) {
					sb.append(s[i]);
				}
				sb.append('\n');
			}
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
