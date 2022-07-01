import java.util.*;
import java.io.*;
public class Dtests {

	static int r = 4;
	public static void main(String[] args) {
		int N = 20;
		for(int i = 1; i < N; i++) {
			int n = (int)Math.pow(r, i);
			TreeMap<Integer, String> costs = new TreeMap<>();
			for(int mask = 0; mask < n; mask++) {
				char[] s = toString(mask, i);
				int c = cost(s);
				if(!costs.containsKey(c)) costs.put(c, new String(s));
			}
			System.out.println(costs.firstEntry());
		}
	}
	static char[] toString(int mask, int N) {
		char[] res = new char[N];
		for(int i = 0; i < N; i++) {
			res[N-i-1] = (char)('a'+(mask%r));
			mask /= r;
		}
		return res;
	}
	static int cost(char[] s) {
		int n = s.length;
		int res = 0;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n-1; j++){
				if(s[i] == s[j] && s[i+1] == s[j+1]) res++;
			}
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
