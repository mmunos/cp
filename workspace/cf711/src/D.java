import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] seen = new boolean[m+1];
		seen[0] = true;
		int[] res = new int[m+1];
		Arrays.fill(res, -1);
		for(int i = 0; i < n; i++){
			int t = sc.nextInt();
			long x = sc.nextLong();
			long y = sc.nextLong();
			LinkedList<Integer> toadd = new LinkedList<Integer>();
			for(int ui = 0; ui <= m; ui++){
				if(seen[ui]) {
					long u = ui;
					long yt = y;
					while(yt-- > 0) {
						long v;
						if(t == 1) {
							v = u + (x+99999)/100000;
						}
						else {//t = 2
							v = (x * u + 99999)/100000;
						}
						if(v >= 0 && v <= m && !seen[(int)v]) {
							toadd.add((int)v);
							res[(int)v] = i+1;
						}
						else break;
						u = v;
					}
				}
			}
			for(int v: toadd) {
				seen[v] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= m; i++){
			sb.append(res[i]+" ");
		}
		sb.replace(sb.length()-1, sb.length(), "\n");
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
