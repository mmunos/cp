import java.util.*;
import java.io.*;

public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] indeg = new int[n];
		int res = n;
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt()-1;
			int v = sc.nextInt()-1;
			if(u > v) {
				int aux = u; u = v; v = aux;
			}
			indeg[u]++;
			if(indeg[u] == 1) res--;
		}
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(q-->0) {
			int t = sc.nextInt();
			if(t == 1) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				if(u > v) {
					int aux = u; u = v; v = aux;
				}
				indeg[u]++;
				if(indeg[u] == 1) res--;
			}
			else if(t == 2) {
				int u = sc.nextInt()-1;
				int v = sc.nextInt()-1;
				if(u > v) {
					int aux = u; u = v; v = aux;
				}
				indeg[u]--;
				if(indeg[u] == 0) res++;
			}
			else {
				sb.append(res+"\n");
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
