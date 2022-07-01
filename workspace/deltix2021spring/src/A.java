import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			char[] s = sc.next().toCharArray();
			HashSet<Integer> zeros = new HashSet<Integer>();
			for(int i = 0; i < n; i++) {
				if(s[i] == '0') zeros.add(i);
			}
			while(k-->0) {
				TreeSet<Integer> torem = new TreeSet<>();
				for(int i: zeros) {
					int c = 0;
					if(i > 0 && s[i-1] == '1') c++;
					if(i < n-1 && s[i+1] == '1') c++;
					if(c == 1) torem.add(i);
				}
				if(torem.size() == 0) break;
				for(int i: torem) {
					zeros.remove(i);
					s[i] = '1';
				}
			}
			System.out.println(new String(s));
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
