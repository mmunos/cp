import java.util.*;
import java.io.*;
public class G {

	public static void main(String[] args) {
		int[] max = new int[100];
		int[] min = new int[100];
		for(int i = 1; i < 1000000000; i++) {
			int c = calc(i);
			if(min[c] == 0) min[c] = i;
			max[c] = i;
		}
		for(int i = 0; i < 100; i++) {
			System.out.println(i+" "+min[i]+" "+max[i]);
		}
	}
	static int[] c = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
	static int calc(int x) {
		int res = 0;
		while(x > 0) {
			res += c[x%10];
			x/=10;
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
