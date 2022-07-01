import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int n = sc.nextInt();
			long p = sc.nextInt();
			int[] arr = new int[n];
			TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				if(!map.containsKey(arr[i])) map.put(arr[i], new ArrayList<>());
				map.get(arr[i]).add(i);
			}
			long res = p * (n-1);
			boolean[] checked = new boolean[n-1];
			for(int a: map.keySet()) {
				if(a >= p) break;
				for(int ind: map.get(a)) {
					//left
					if(ind > 0 && !checked[ind-1]) {
						int i = ind-1;
						while(i >= 0 && !checked[i] && arr[i] % a == 0) {
							res -= p; res += a; checked[i] = true; i--;
						}
					}
					//right
					if(ind < n-1 && !checked[ind]) {
						int i = ind+1;
						while(i < n && !checked[i-1] && arr[i] % a == 0) {
							res -= p; res += a; checked[i-1] = true; i++;
						}
					}
				}
			}
			sb.append(res+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
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
