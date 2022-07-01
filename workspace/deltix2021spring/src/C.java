import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int[] p = new int[n];
			int[] base = new int[n];
			p[0] = -1;
			base[0] = -1;
			boolean[] used = new boolean[n];
			for(int i = 1; i < n; i++) {
				if(arr[i] == 1) {
					p[i] = i-1;
					base[i] = i-1;
				}
				else {
					for(int j = i-1; j >= 0; j--) {
						if(used[j]) continue;
						if(arr[j] == arr[i]-1) {
							p[i] = j; used[j] = true; 
							base[i] = base[j]; break;
						}
						else used[j] = true;
					}
				}
			}
			StringBuilder[] res = new StringBuilder[n];
			res[0] = new StringBuilder("1");
			sb.append("1\n");
			for(int i = 1; i < n; i++) {
				if(base[i] == -1) { 
					res[i] = new StringBuilder();
				}
				else {
					res[i] = new StringBuilder(res[base[i]]);
					res[i].append(".");
				}
				res[i].append(arr[i]+"");
				sb.append(res[i]);
				sb.append("\n");
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
