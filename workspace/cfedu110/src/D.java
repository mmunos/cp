import java.util.*;
import java.io.*;

public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int k = sc.nextInt();
		char[] s = sc.next().toCharArray();
		n = 1 << k;
		op = new char[n];
		vals = new int[2*n];
		for(int i = n; i < 2*n; i++) {
			vals[i] = 1;
		}
		for(int i = 0; i < n-1; i++) {
			op[n-i-1] = s[i];
		}
		create(1);
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(q-- > 0) {
			int x = sc.nextInt();
			char[] t = sc.next().toCharArray();
			op[n-x] = t[0];
			update(n-x);
			sb.append(vals[1]+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static int n;
	static char[] op;
	static int[] vals;
	static void update(int ind) {
		if(op[ind] == '1') vals[ind] = vals[2*ind];
		else if(op[ind] == '0') vals[ind] = vals[2*ind+1];
		else vals[ind] = vals[2*ind] + vals[2*ind+1];
		if(ind > 1) update(ind/2);
	}
	static void create(int ind) {
		if(ind < n) {
			create(2*ind);
			create(2*ind+1);
			if(op[ind] == '1') vals[ind] = vals[2*ind];
			else if(op[ind] == '0') vals[ind] = vals[2*ind+1];
			else vals[ind] = vals[2*ind] + vals[2*ind+1];
		}
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
