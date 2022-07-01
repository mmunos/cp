import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int[] res = new int[n];
		int last = n+1;
		for(int i = n-1; i >= 0; i--) {
			if(res[i] > 0) continue;
			int val = 1;
			LinkedList<Integer> responses = new LinkedList<>();
			while(true) {
				String s = build(i, val, n).toString();
				System.out.println(s);
				int r = sc.nextInt();
				if(r == 0 || r == i+1) break;
				responses.add(r);
				val++;
				if(val == n) break;
			}
			res[i] = last-val;
			int add = 1;
			for(int r: responses) {
				res[r-1] = res[i]+add;
				add++;
			}
			last = res[i];
//			System.out.println(Arrays.toString(res));
		}
		StringBuilder sb = new StringBuilder();
		sb.append("! ");
		for(int i = 0; i < n; i++) {
			sb.append(" "+res[i]);
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString());
		pw.flush();
	}
	static StringBuilder build(int pos, int val, int n) {
		StringBuilder sb = new StringBuilder("? ");
		for(int i = 0; i < n; i++) {
			if(i == pos) sb.append(" "+(val+1));
			else sb.append(" 1");
		}
		return sb;
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
