import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] s = new char[n][m];
		for(int i = 0; i < n; i++) {
			s[i] = sc.next().toCharArray();
		}
		long res = 0;
		for(int i = 0; i < n; i++) {
			LinkedList<Integer> list = new LinkedList<>();
			for(int j = 0; j < m; j++) {
				if(s[i][j] == '<') list.add(0);
				else if(s[i][j] == '>') list.add(1);
				else {
					res += count(list);
					list.clear();
				}
			}
			res += count(list);
		}
		for(int j = 0; j < m; j++) {
			LinkedList<Integer> list = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				if(s[i][j] == '^') list.add(0);
				else if(s[i][j] == 'v') list.add(1);
				else {
					res += count(list);
					list.clear();
				}
			}
			res += count(list);
		}
		System.out.println(res);
	}
	static long count(LinkedList<Integer> list) {
		long res = 0;
		int c = 0, p = 0;
		for(int x: list) {
			if(x == 0) {
				res += p-c;
				c++;
			}
			p++;
		}
		return res;
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
