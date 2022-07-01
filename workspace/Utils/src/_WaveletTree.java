import java.util.*;
public class _WaveletTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			arr.add(a);
		}
		WaveletTree wt = new WaveletTree(arr, 1, 9);
		int q = sc.nextInt();
		while(q-- > 0) {
			int x = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			int k = sc.nextInt();
			if(x == 0){
				//kth smallest
				System.out.print("Kth smallest: ");
				System.out.println(wt.kth(l, r, k));
			}
			if(x == 1){
				//less than or equal to K
				System.out.print("LTE: ");
				System.out.println(wt.LTE(l, r, k));
			}
			if(x == 2){
				//count occurence of K in [l, r]
				System.out.print("Occurence of K: ");
				System.out.println(wt.count(l, r, k));
			}
		}
	}
	static class WaveletTree{
		int lo, hi;
		WaveletTree wtl, wtr;
		ArrayList<Integer> b;
	 
		//nums are in range [x,y]
		//array indices are [from, to)
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

}
