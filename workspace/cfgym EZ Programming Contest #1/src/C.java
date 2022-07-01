import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			char[] s = sc.next().toCharArray();
			int n = s.length;
			int pe = 0, pz = 0, pp = 0, pc = 0;
			for(int i = 0; i < n; i++) {
				if(s[i] == 'e') pe = i;
				if(s[i] == 'z') pz = i;
				if(s[i] == 'p') pp = i;
				if(s[i] == 'c') pc = i;
			}
			if(pe > pc) System.out.println("NO");
			else if(pz > pp || pz > pc) System.out.println("NO");
			else if(pp > pc) System.out.println("NO");
			else System.out.println("YES");
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
