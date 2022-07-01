import java.util.*;
import java.io.*;
public class D3 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		WaveletTree wt = new WaveletTree(arr, 1, n);
		StringBuilder sb = new StringBuilder();
		for(int qi = 0; qi < q; qi++) {
			int L = sc.nextInt();
			int R = sc.nextInt();
			int d = R - L + 1;
			int med = wt.kth(L, R, d/2+1);
			int c = wt.count(L, R, med);
			int res = Math.max(c - (d - c), 1);
			sb.append(res+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static class WaveletTree{
		int lo, hi;
		WaveletTree wtl, wtr;
		int[] b;
	 
		//nums are in range [x,y]
		public WaveletTree(int[] arr, int x, int y){
			lo = x; hi = y;
			if(lo == hi || arr.length == 0) return;
			int mid = (lo+hi)/2;
			b = new int[arr.length + 1];
			int ib = 0;
			int curr = 0;
			b[ib++] = curr;
			int k = 0;
			for(int v: arr) {
				if(v <= mid) {
					k++; curr++;
				}
				b[ib++] = curr;
			}
			int[] arrlo = new int[k];
			int[] arrhi = new int[arr.length - k];
			int ilo = 0, ihi = 0;
			for(int v: arr) {
				if(v <= mid) arrlo[ilo++] = v;
				else arrhi[ihi++] = v;
			}
			wtl = new WaveletTree(arrlo, lo, mid);
			wtr = new WaveletTree(arrhi, mid+1, hi);
		}
	 
		//kth smallest element in [l, r]
		int kth(int l, int r, int k){
			if(l > r) return 0;
			if(lo == hi) return lo;
			int inLeft = b[r] - b[l-1];
			int lb = b[l-1]; //amt of nos in first (l-1) nos that go in left 
			int rb = b[r]; //amt of nos in first (r) nos that go in left
			if(k <= inLeft) return wtl.kth(lb+1, rb , k);
			return wtr.kth(l-lb, r-rb, k-inLeft);
		}
	 
		//count of nos in [l, r] Less than or equal to k
		int LTE(int l, int r, int k) {
			if(l > r || k < lo) return 0;
			if(hi <= k) return r - l + 1;
			int lb = b[l-1], rb = b[r];
			return wtl.LTE(lb+1, rb, k) + wtr.LTE(l-lb, r-rb, k);
		}
	 
		//count of nos in [l, r] equal to k
		int count(int l, int r, int k) {
			if(l > r || k < lo || k > hi) return 0;
			if(lo == hi) return r - l + 1;
			int lb = b[l-1], rb = b[r], mid = (lo+hi)/2;
			if(k <= mid) return wtl.count(lb+1, rb, k);
			return wtr.count(l-lb, r-rb, k);
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
