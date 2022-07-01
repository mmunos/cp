import java.util.*;

import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if(k == 0) {
				for(int i = 0; i < n/2; i++) {
					sb.append(i+" "+(n-1-i)+"\n");
				}
			}
			else if(k < n-1) {
				sb.append(k+" "+(n-1)+"\n");
				sb.append((n-1-k)+" "+0+"\n");
				for(int i = 1; i < n/2; i++) {
					if(i == k || n-1-i == k) continue;
					sb.append(i+" "+(n-1-i)+"\n");
				}
			}
			else {//k == n-1
				if(n == 4) {
					sb.append("-1\n");
				}
				else {
					sb.append((n-2)+" "+(n-1)+"\n");
					sb.append((n-3)+" "+1+"\n");
					sb.append(0+" "+2+"\n");
					for(int i = 3; i < n/2; i++) {
						sb.append(i+" "+(n-1-i)+"\n");
					}
				}
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
