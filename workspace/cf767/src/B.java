import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			String[] arr = new String[n];
			String[] rra = new String[n];
			boolean yes = false;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.next();
				rra[i] = (new StringBuilder(arr[i])).reverse().toString();
				if(arr[i].equals(rra[i])) yes = true;
			}
			if(yes) {//by itself
				System.out.println("YES"); continue;
			}
			//there are none of size 1
			HashSet<String> _3from3 = new HashSet<String>();
			HashSet<String> _2from3 = new HashSet<String>();
			HashSet<String> _2from2 = new HashSet<String>();
			for(int i = 0; i < n; i++) {
				if(arr[i].length() == 2) {
					if(_2from3.contains(rra[i])) {
						yes = true; break;
					}
					if(_2from2.contains(rra[i])) {
						yes = true; break;
					}
				}
				else {
					if(_3from3.contains(rra[i])) {
						yes = true; break;
					}
					String s = rra[i].substring(0, 2);
					if(_2from2.contains(s)) {
						yes = true; break;
					}
				}
				
				if(arr[i].length() == 2) {
					_2from2.add(arr[i]);
				}
				else {
					_3from3.add(arr[i]);
					String s = arr[i].substring(0, 2);
					_2from3.add(s);
				}
			}
			if(yes) {
				System.out.println("YES"); continue;
			}
			else {
				System.out.println("NO");
			}
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
