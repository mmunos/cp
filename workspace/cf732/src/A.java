import java.util.*;
import java.io.*;
public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		int N = 100000;
		while(T-->0) {
			int n = sc.nextInt();
			LinkedList<Integer>[] pos = new LinkedList[N+1];
			for(int i = 0; i <= N; i++) {
				pos[i] = new LinkedList<>();
			}
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				pos[a].add(i);
			}
			int c = 0;
			boolean yes = true;
			for(int a = 0; a <= N; a++) {
				int od = 0, ev = 0;
				for(int p: pos[a]) {
					if(p % 2 == 0) ev++;
					else od++;
				}
				if(od > ev + 1 || ev > od + 1) yes = false;
				else {
					if(od > ev) {
						if(c % 2 == 0) yes = false;
					}
					else if(ev > od) {
						if(c % 2 == 1) yes = false;
					}
					else {
						;
					}
				}
				
				if(!yes) break;
				c += pos[a].size();
			}
			if(yes) System.out.println("YES");
			else System.out.println("NO");
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
