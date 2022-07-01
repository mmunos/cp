
import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			long k = sc.nextLong()-1;
			char[] s = Long.toBinaryString(k).toCharArray();
			if(s[0] != '0' && s.length > n-1) {
				sb.append(-1+"\n");
			}
			else {
				char[] t = new char[n];
				Arrays.fill(t, '0');
				if(s[0] != '0') {
					for(int i = 0; i < s.length; i++) {
						t[n - 2 - i] = s[s.length - i - 1];
					}
				}
				int[] res = new int[n];
				int p = 0; int v = 1;
				for(int i = 0; i < n; i++) {
					if(t[i] == '0') {
						int b = i;
						while(b >= p) res[b--] = v++;
						p = i+1;
					}
				}
				for(int i = 0; i < n; i++) {
					sb.append(res[i]+" ");
				}
				sb.replace(sb.length()-1, sb.length(), "\n");
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
