import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		int N = 100000;
		int[] sieve = new int[N+1];  //is prime iff sieve[i] == i
		int sqN = (int)Math.sqrt(N);
		for(int i = 2; i <= N; i++) {
			if(sieve[i] == 0) {
				sieve[i] = i;
				if(i > sqN) continue;
				for(int j = i*i; j <= N; j += i) {
					sieve[j] = i;
				}
			}
		}
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ps = new int[N];
		Arrays.fill(ps, n);
		int[] next = new int[n];
		Arrays.fill(next, n);
		for(int i = n-1; i >= 0; i--) {
			int a = arr[i];
			while(a > 1) {
				int p = sieve[a];
				next[i] = Math.min(next[i], ps[p]);
				ps[p] = i; 
				while(a % p == 0) a /= p;
			}
		}
//		System.out.println(Arrays.toString(next));
		Pair[] qs = new Pair[q];
		for(int i = 0; i < q; i++) {
			int L = sc.nextInt()-1;
			int R = sc.nextInt()-1;
			qs[i] = new Pair(L, R, i);
		}
		Arrays.sort(qs);
		int[] acc = new int[n];
		SegmentTreeL st = new SegmentTreeL(acc);
		int qi = q-1;
		long[] res = new long[q];
		int icheck = n;
		for(int i = n-1; i >= 0; i--) {
			st.update(i, i, 1);
			if(next[i] < n) {
				if(next[i] <= icheck) {
					st.update(next[i], n-1, 1);
					icheck = i;
				}
				else if(next[i] < next[icheck]) {
					st.update(next[i], next[icheck]-1, 1);
					icheck = i;
				}
			}
			print(st, n);
			while(qi >= 0 && qs[qi].a > i) qi--;
			while(qi >= 0 && qs[qi].a == i) {
				long r = st.queryMax(qs[qi].b, qs[qi].b);
				res[qs[qi].ind] = r;
				qi--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < q; i++) {
			sb.append(res[i]+"\n");
		}
		PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
	}
	static void print(SegmentTreeL st, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(st.queryMax(i, i)+"  ");
		}
		System.out.println("");
	}
	static class Pair implements Comparable<Pair>{
		int a, b, ind;
		public Pair(int a, int b, int ind) {
			this.a = a; this.b = b; this.ind = ind;
		}
		@Override
		public int compareTo(Pair p) {
			if(a == p.a) return b - p.b;
			else return a - p.a;
		}
		public String toString() {
			return a+" "+b;
		}

	}
	
	static class SegmentTreeL { /* Author: Po-Chun Chiu */
		int size;
		private long[] max;
//		private int[] min;
//		private int[] sum;

		private long[] lazy;

		private int left(int pos) {return 2*pos;}
		private int right(int pos) {return 2*pos + 1;}
		
		public SegmentTreeL(int[] array){
			size = array.length;
			max = new long[array.length*4];
//			min = new int[array.length*4];
//			sum = new int[array.length*4];
			lazy = new long[array.length*4];
			buildTree(array, 1, 0, size - 1);
		}

		private void buildTree(int[] array, int pos, int front, int end){
			//Basis case for returning the elements itself
			if(front == end){
				max[pos] = array[front];
//				min[pos] = array[front];
//				sum[pos] = array[front];
				return;
			}
			//Building trees by dividing into two subtrees
			buildTree(array, left(pos), front, (front+end)/2);
			buildTree(array, right(pos), (front+end)/2 + 1, end);

			recalc(pos, front, end);
		}

		private void recalc(int pos, int front, int end) {
			max[pos] = Math.max(getMax(left(pos)), getMax(right(pos)));
//			min[pos] = Math.min(getMin(left(pos)), getMin(right(pos)));
//			sum[pos] = getSum(left(pos), front, (front+end)/2) + 
//					   getSum(right(pos), (front+end)/2 + 1, end);
		}

		private long getMax(int pos){
			return max[pos] + lazy[pos];
		}

//		private int getMin(int pos){
//			return min[pos] + lazy[pos];
//		}
//
//		private int getSum(int pos,int front,int end){
//			return sum[pos] + lazy[pos] * (end - front + 1);
//		}

		public long queryMax(int queryFront, int queryEnd) {
			return queryMax(1, 0, size - 1, queryFront, queryEnd);
		}

		private long queryMax(int pos, int front, int end, int queryFront, int queryEnd){
			//Case for entirely inclusive
			if(front >= queryFront && queryEnd >= end){
				return getMax(pos);
			}
			//Case for entirely exclusive
			if(end < queryFront || queryEnd < front){
				return Integer.MIN_VALUE;
			}
			propagate(pos, front, end);
			long leftAns = queryMax(left(pos), front,(front+end)/2, queryFront, queryEnd);
			long rightAns = queryMax(right(pos), (front+end)/2+1, end, queryFront, queryEnd);
			return Math.max(leftAns, rightAns);
		}

//		public int queryMin(int queryFront, int queryEnd) {
//			return queryMin(1, 0, size-1, queryFront, queryEnd);
//		}
//
//		private int queryMin(int pos,int front,int end, int queryFront, int queryEnd){
//			//Case for entirely inclusive
//			if(front >= queryFront && queryEnd >= end){
//				return getMin(pos);
//			}
//			//Case for entirely exclusive
//			if(end < queryFront || queryEnd < front){
//				return Integer.MAX_VALUE;
//			}
//			propagate(pos,front,end);
//			int leftAns = queryMin(left(pos), front, (front+end)/2, queryFront, queryEnd);
//			int rightAns = queryMin(right(pos), (front+end)/2+1, end, queryFront, queryEnd);
//			return Math.min(leftAns, rightAns);
//		}
//		public int querySum(int queryFront, int queryEnd) {
//			return querySum(1, 0, size - 1, queryFront, queryEnd);
//		}
//
//		private int querySum(int pos, int front, int end, int queryFront, int queryEnd){
//			//Case for entirely inclusive
//			if(queryFront <= front && end <= queryEnd){
//				return getSum(pos, front, end);
//			}
//			//Case for entirely exclusive
//			if(end < queryFront || queryEnd < front){
//				return 0;
//			}
//			propagate(pos,front,end);
//			int leftAns = querySum(left(pos), front, (front+end)/2, queryFront, queryEnd);
//			int rightAns = querySum(right(pos), (front+end)/2+1, end, queryFront, queryEnd);
//			return leftAns + rightAns;
//		}


		private void propagate(int pos,int front, int end){
			lazy[left(pos)] += lazy[pos];
			lazy[right(pos)] += lazy[pos];
			max[pos] = getMax(pos);
//			min[pos] = getMin(pos);
//			sum[pos] = getSum(pos, front, end);
			lazy[pos] = 0;
			//Set the propagation to 0 so that it will not propagate the value again and again
		}

		public void update(int updateFront, int updateEnd, long delta){
			update(1, 0, size - 1, updateFront, updateEnd, delta);
		}

		private void update(int pos, int front, int end, int updateFront, int updateEnd, long value){
			//Case for entirely inclusive
			if(updateFront <= front && end <= updateEnd){
				lazy[pos]+=value;
				return;
			}
			//Case for entirely exclusive
			if(end < updateFront || updateEnd < front){
				return;
			}
			
			propagate(pos, front, end);
			
			update(left(pos), front, (front+end)/2, updateFront, updateEnd, value);
			update(right(pos), (front+end)/2 + 1, end, updateFront, updateEnd, value);
			recalc(pos, front, end);
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
