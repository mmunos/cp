import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sbres = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean[] mids = new boolean[n];
			int[][] arr = new int[m][3];
 			for(int i = 0; i < m; i++) {
				arr[i][0] = sc.nextInt()-1;
				arr[i][1] = sc.nextInt()-1;
				arr[i][2] = sc.nextInt()-1;
				mids[arr[i][1]] = true;
			}
 			int hub = -1;
			for(int i = 0; i < n; i++) {
				if(!mids[i]) {
					hub = i; break;
				}
			}
			for(int i = 0; i < n; i++) {
				if(i != hub) {
					sbres.append((hub+1)+" "+(i+1)+"\n");
				}
			}
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
