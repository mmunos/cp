import java.util.*;
import java.io.*;
public class B {

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
			if(n == 1) {
				sb.append("0\n"); continue;
			}
			int difup = -1, difdn = -1;
			boolean dead = false;
			for(int i = 0; i < n-1; i++) {
				if(arr[i] <= arr[i+1]) {
					if(difup < 0) {
						difup = arr[i+1] - arr[i];
					}
					else if(arr[i+1] - arr[i] != difup) {
						dead = true; break;
					}
				}
				else {
					if(difdn < 0) {
						difdn = arr[i] - arr[i+1];
					}
					else if(difdn != arr[i] - arr[i+1]){
						dead = true; break;
					}
				}
			}
			if(dead) {
				sb.append("-1\n"); continue;
			}
			if(difdn < 0 || difup < 0) {
				sb.append("0\n"); continue;
			}
			int m = difup + difdn;
			for(int i = 0; i < n; i++) {
				if(arr[i] >= m) {
					dead = true; break;
				}
			}
			if(dead) {
				sb.append("-1\n");
			}
			else {
				sb.append(String.format("%d %d\n", m, difup));
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
