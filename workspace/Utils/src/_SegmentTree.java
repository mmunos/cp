import java.util.*;

public class _SegmentTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class SegmentTreeInd {         // the segment tree is stored like a heap array
		private int[] st; private long[] A;
		private int n;
		private int left (int p) { return p << 1; } // same as binary heap operations
		private int right(int p) { return (p << 1) + 1; }

		private void build(int p, int L, int R) {
			if (L == R)                            // as L == R, either one is fine
				st[p] = L;                                         // store the index
			else {                                // recursively compute the values
				build(left(p) , L              , (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R          );
				int p1 = st[left(p)], p2 = st[right(p)];
				st[p] = (A[p1] <= A[p2]) ? p1 : p2;
			} 
		}

		private int rmq(int p, int L, int R, int i, int j) {          // O(log n)
			if (i >  R || j <  L) return -1; // current segment outside query range
			if (L >= i && R <= j) return st[p];               // inside query range

			// compute the min position in the left and right part of the interval
			int p1 = rmq(left(p) , L              , (L+R) / 2, i, j);
			int p2 = rmq(right(p), (L+R) / 2 + 1, R          , i, j);

			if (p1 == -1) return p2;   // if we try to access segment outside query
			if (p2 == -1) return p1;                               // same as above
			return (A[p1] <= A[p2]) ? p1 : p2; }          // as as in build routine

		private int update_point(int p, int L, int R, int idx, long new_value) {
			// this update code is still preliminary, i == j
			// must be able to update range in the future!
			int i = idx, j = idx;

			// if the current interval does not intersect 
			// the update interval, return this st node value!
			if (i > R || j < L)
				return st[p];

			// if the current interval is included in the update range,
			// update that st[node]
			if (L == i && R == j) {
				A[i] = new_value; // update the underlying array
				return st[p] = L; // this index
			}

			// compute the minimum position in the 
			// left and right part of the interval
			int p1, p2;
			p1 = update_point(left(p) , L              , (L + R) / 2, idx, new_value);
			p2 = update_point(right(p), (L + R) / 2 + 1, R          , idx, new_value);

			// return the position where the overall minimum is
			return st[p] = (A[p1] <= A[p2]) ? p1 : p2;
		}

		public SegmentTreeInd(long[] _A) {
			A = _A; n = A.length;                   // copy content for local usage
			st = new int[4 * n];
			for (int i = 0; i < 4 * n; i++) st[i] = 0; // create vector with length `len' and fill it with zeroes
			build(1, 0, n - 1);                                  // recursive build
		}

		public int rmq(int i, int j) { return rmq(1, 0, n - 1, i, j); } // overloading

		public int update_point(int idx, long new_value) {
			return update_point(1, 0, n - 1, idx, new_value); 
		}
	}
	
	static class SegmentTree {
		private int[] st; private int[] A;
		private int n;
		private int left (int p) { return p << 1; }
		private int right(int p) { return (p << 1) + 1; }
		
		static int neutral = Integer.MAX_VALUE;					//MIN
		static int op(int x, int y) { return Math.min(x, y); }
//		static int neutral = Integer.MIN_VALUE;					//MAX
//		static int op(int x, int y) { return Math.max(x, y); }
//		static int neutral = 0;									//SUM
//		static int op(int x, int y) { return x + y; }

		private void build(int p, int L, int R) {
			if (L == R)
				st[p] = A[L];
			else {
				build(left(p) , L              , (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R          );
				int v1 = st[left(p)], v2 = st[right(p)];
				st[p] = op(v1, v2);
			} }

		private int rmq(int p, int L, int R, int i, int j) {
			if (i >  R || j <  L) return neutral;
			if (L >= i && R <= j) return st[p];

			int v1 = rmq(left(p) , L              , (L+R) / 2, i, j);
			int v2 = rmq(right(p), (L+R) / 2 + 1, R          , i, j);

			return op(v1, v2);
		}

		private int update_point(int p, int L, int R, int idx, int new_value) {
			int i = idx, j = idx;
			if (i > R || j < L)
				return st[p];

			if (L == i && R == j) {
				A[i] = new_value;													// += IF DELTA
				return st[p] = A[L];
			}

			int v1, v2;
			v1 = update_point(left(p) , L              , (L + R) / 2, idx, new_value);
			v2 = update_point(right(p), (L + R) / 2 + 1, R          , idx, new_value);

			return st[p] = op(v1, v2);
		}

		public SegmentTree(int[] _A) {
			A = _A; n = A.length;
			st = new int[4 * n];
			for (int i = 0; i < 4 * n; i++) st[i] = 0;
			build(1, 0, n - 1);
		}

		public int rmq(int i, int j) { return rmq(1, 0, n - 1, i, j); }

		public int update_point(int idx, int new_value) {
			return update_point(1, 0, n - 1, idx, new_value); }
		
		public String toString() {
			return Arrays.toString(A);
		}
	}
	
	static class SegmentTreeLong {
		private long[] st; private long[] A;
		private int n;
		private int left (int p) { return p << 1; }
		private int right(int p) { return (p << 1) + 1; }
		
		static long neutral = Long.MAX_VALUE;					//MIN
		static long op(long x, long y) { return Math.min(x, y); }
//		static long neutral = Long.MIN_VALUE;					//MAX
//		static long op(long x, long y) { return Math.max(x, y); }
//		static long neutral = 0L;								//SUM
//		static long op(long x, long y) { return x + y; }

		private void build(int p, int L, int R) {
			if (L == R)
				st[p] = A[L];
			else {
				build(left(p) , L              , (L + R) / 2);
				build(right(p), (L + R) / 2 + 1, R          );
				long v1 = st[left(p)], v2 = st[right(p)];
				st[p] = op(v1, v2);
			} }

		private long rmq(int p, int L, int R, int i, int j) {
			if (i >  R || j <  L) return neutral;
			if (L >= i && R <= j) return st[p];

			long v1 = rmq(left(p) , L              , (L+R) / 2, i, j);
			long v2 = rmq(right(p), (L+R) / 2 + 1, R          , i, j);

			return op(v1, v2);
		}

		private long update_point(int p, int L, int R, int idx, long new_value) {
			int i = idx, j = idx;
			if (i > R || j < L)
				return st[p];

			if (L == i && R == j) {
				A[i] = new_value; 													// += IF DELTA
				return st[p] = A[L];
			}

			long v1 = update_point(left(p) , L              , (L + R) / 2, idx, new_value);
			long v2 = update_point(right(p), (L + R) / 2 + 1, R          , idx, new_value);

			return st[p] = op(v1, v2);
		}

		public SegmentTreeLong(long[] _A) {
			A = _A; n = A.length;
			st = new long[4 * n];
			for (int i = 0; i < 4 * n; i++) st[i] = 0;
			build(1, 0, n - 1);
		}

		public long rmq(int i, int j) { return rmq(1, 0, n - 1, i, j); }

		public long update_point(int idx, long new_value) {
			return update_point(1, 0, n - 1, idx, new_value); }
		
		public String toString() {
			return Arrays.toString(A);
		}
	}
	
	
	static class BinaryIndexedTree {  
	    final static int MAX = 1000000;      
	    int BITree[] = new int[MAX]; 
	    int getSum(int index) { 
	        int sum = 0; 
	        index = index + 1; 
	        while(index > 0) { 
	            sum += BITree[index]; 
	            index -= index & (-index); 
	        } 
	        return sum; 
	    } 
	  
	    public void updateBIT(int n, int index, int delta) { 
	        index = index + 1; 
	        while(index <= n) { 
	        	BITree[index] += delta; 
	        	index += index & (-index); 
	        } 
	    } 
	  
	    void constructBITree(int arr[], int n) { 
	        for(int i=1; i<=n; i++) { 
	            BITree[i] = 0; 
	        }
	      
	        for(int i = 0; i < n; i++) { 
	            updateBIT(n, i, arr[i]);
	        }
	    } 
	} 
	  
	// This code is contributed by Ranjan Binwani 

	
}
