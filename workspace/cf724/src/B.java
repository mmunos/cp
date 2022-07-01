import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			char[] s = sc.next().toCharArray();
			boolean[] check1 = new boolean[26];
			boolean[][] check2 = new boolean[26][26];
			boolean[][][] check3 = new boolean[26][26][26];
			for(int i = 0; i < n; i++) {
				check1[s[i]-'a'] = true;
			}
			for(int i = 0; i < n-1; i++) {
				check2[s[i]-'a'][s[i+1]-'a'] = true;
			}
			for(int i = 0; i < n-2; i++) {
				check3[s[i]-'a'][s[i+1]-'a'][s[i+2]-'a'] = true;
			}
			System.out.println(find(check1, check2, check3));
		}

	}
	static String find(boolean[] check1, boolean[][] check2, boolean[][][] check3) {
		for(int i = 0; i < 26; i++) {
			if(!check1[i]) {
				char c = (char)(i+'a');
				return c+"";
			}
		}
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < 26; j++) {
				if(!check2[i][j]) {
					char c = (char)(i+'a');
					char d = (char)(j+'a');
					return c+""+d;
				}
			}
		}
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < 26; j++) {
				for(int k = 0; k < 26; k++) {
					if(!check3[i][j][k]) {
						char c = (char)(i+'a');
						char d = (char)(j+'a');
						char e = (char)(k+'a');
						return c+""+d+""+e;
					}
				}
			}
		}
		return null;
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
