import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		n = sc.nextInt();
		m = sc.nextInt();
		int p = sc.nextInt();
		s = new char[n][m];
		for(int i = 0; i < n; i++) {
			s[i] = sc.next().toCharArray();
		}
		res = 0;
		sres = toString(new HashSet<>());
		for(int c = 0; c < m; c++) {
			HashSet<Integer> vs = new HashSet<>();
			for(int i = 0; i < n; i++) {
				if(s[i][c] == '1') vs.add(i);
			}
			if(vs.size() >= (n+1)/2) {
				HashSet<Integer> ss = new HashSet<>();
				ss.add(c);
				process(ss, vs, c+1);
			}
		}
		System.out.println(sres);
	}
	static void process(HashSet<Integer> ss, HashSet<Integer> vs, int c) {
		if(c == m) {
			if(ss.size() > res) {
				sres = toString(ss);
				res = ss.size();
			}
		}
		else {
			HashSet<Integer> newvs = new HashSet<>();
			for(int i: vs) {
				if(s[i][c] == '1') newvs.add(i);
			}
			if(newvs.size() >= (n+1)/2) {
				HashSet<Integer> sss = new HashSet<Integer>(ss);
				sss.add(c);
				process(sss, newvs, c+1);
			}
			process(ss, vs, c+1);
		}
	}
	static String toString(HashSet<Integer> vs) {
		char[] res = new char[m];
		Arrays.fill(res, '0');
		for(int v: vs) res[v] = '1';
		return new String(res);
	}
	static int res;
	static String sres;
	static int n, m;
	static char[][] s;
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
