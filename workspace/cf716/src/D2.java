import java.util.*;
import java.io.*;
public class D2 {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int q = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			arr.add(a);
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
		ArrayList<Integer> b;
	 
		//nums are in range [x,y]
		public WaveletTree(ArrayList<Integer> arr, int x, int y){
			lo = x; hi = y;
			if(lo == hi || arr.isEmpty()) return;
			int mid = (lo+hi)/2;
			b = new ArrayList<>();
			int curr = 0;
			b.add(curr);
			for(int v: arr) {
				if(v <= mid) curr++;
				b.add(curr);
			}
			ArrayList<Integer> arrlo = new ArrayList<>();
			ArrayList<Integer> arrhi = new ArrayList<>();
			for(int v: arr) {
				if(v <= mid) arrlo.add(v);
				else arrhi.add(v);
			}
			wtl = new WaveletTree(arrlo, lo, mid);
			wtr = new WaveletTree(arrhi, mid+1, hi);
		}
	 
		//kth smallest element in [l, r]
		int kth(int l, int r, int k){
			if(l > r) return 0;
			if(lo == hi) return lo;
			int inLeft = b.get(r) - b.get(l-1);
			int lb = b.get(l-1); //amt of nos in first (l-1) nos that go in left 
			int rb = b.get(r); //amt of nos in first (r) nos that go in left
			if(k <= inLeft) return wtl.kth(lb+1, rb , k);
			return wtr.kth(l-lb, r-rb, k-inLeft);
		}
	 
		//count of nos in [l, r] Less than or equal to k
		int LTE(int l, int r, int k) {
			if(l > r || k < lo) return 0;
			if(hi <= k) return r - l + 1;
			int lb = b.get(l-1), rb = b.get(r);
			return wtl.LTE(lb+1, rb, k) + wtr.LTE(l-lb, r-rb, k);
		}
	 
		//count of nos in [l, r] equal to k
		int count(int l, int r, int k) {
			if(l > r || k < lo || k > hi) return 0;
			if(lo == hi) return r - l + 1;
			int lb = b.get(l-1), rb = b.get(r), mid = (lo+hi)/2;
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
