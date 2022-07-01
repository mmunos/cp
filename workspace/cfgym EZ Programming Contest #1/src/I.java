import java.util.*;
import java.io.*;
public class I {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		while(T-->0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long res = 0;
			int c = 0;
			while(a+b>0) {
				if(a % 2 == 0 && b % 2 == 0) {
					//nothing
				}
				else if(a % 2 == 0 && b % 2 == 1) {
					res = -1; break;
				}
				else if(a % 2 == 1 && b % 2 == 0) {
					res += (1L << c);						
				}
				else{ //(a % 2 == 1 && b % 2 == 1)
					//nothing
				}
				a /= 2; b /= 2; c++;
			}
			System.out.println(res);
		}	

	}
	static void sort(int[] arr) {
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) {
			int ind = r.nextInt(arr.length);
			int aux = arr[ind]; arr[ind] = arr[i]; arr[i] = aux; 
		}
		Arrays.sort(arr);
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
