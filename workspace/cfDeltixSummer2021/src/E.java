import java.util.*;
import java.io.*;
public class E {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		int[] brr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++) {
			brr[i] = sc.nextInt();
		}
		int[] crr = new int[n];
		for(int i = 0; i < n; i++) {
			crr[i] = brr[i] - arr[i];
		}
		long[] acc = new long[n+1];
		for(int i = 1; i <= n; i++) {
			acc[i] = acc[i-1] + crr[i-1];
		}
		Node st = new Node(0, n, acc);
		StringBuilder sb = new StringBuilder();
		while(q-- > 0) {
			int L = sc.nextInt()-1;
			int R = sc.nextInt()-1;
			if(acc[R+1] == acc[L] && st.querymin(L, R+1) == acc[L]) {
				long r = st.querymax(L, R+1) - acc[L];
				sb.append(r+"\n");
			}
			else {
				sb.append("-1\n");
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	
	static class Node{
		int L, R;
		long min, max, sum;
		Node left, right;
		public Node(int L, int R, long[] arr){
			this.L = L; this.R = R;
			if(L == R) {
				sum = max = min = arr[L];
			}
			else {
				left = new Node(L, (L+R)/2, arr);
				right = new Node((L+R)/2+1, R, arr);
				min = Math.min(left.min, right.min);
				max = Math.max(left.max, right.max);
				sum = left.sum + right.sum;
			}
		}
		public long querysum(int qL, int qR) {
			if(qR < L || R < qL) return 0;
			else if(qL <= L && R <= qR) return sum;
			else {
				long x = left.querysum(qL, qR);
				long y = right.querysum(qL, qR);
				return x + y;
			}
		}
		public long querymax(int qL, int qR) {
			if(qR < L || R < qL) return Long.MIN_VALUE;
			else if(qL <= L && R <= qR) return max;
			else {
				long x = left.querymax(qL, qR);
				long y = right.querymax(qL, qR);
				return Math.max(x, y);
			}
		}
		public long querymin(int qL, int qR) {
			if(qR < L || R < qL) return Long.MAX_VALUE;
			else if(qL <= L && R <= qR) return min;
			else {
				long x = left.querymin(qL, qR);
				long y = right.querymin(qL, qR);
				return Math.min(x, y);
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
