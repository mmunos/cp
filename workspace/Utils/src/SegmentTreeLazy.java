
public class SegmentTreeLazy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class SegmentTree { /* Author: Po-Chun Chiu */
		int size;
		private int[] max;
		private int[] min;
		private int[] sum;

		private int[] lazy;

		private int left(int pos) {return 2*pos;}
		private int right(int pos) {return 2*pos + 1;}
		
		public SegmentTree(int[] array){
			size = array.length;
			max = new int[array.length*4];
			min = new int[array.length*4];
			sum = new int[array.length*4];
			lazy = new int[array.length*4];
			buildTree(array, 1, 0, size - 1);
		}

		private void buildTree(int[] array, int pos, int front, int end){
			//Basis case for returning the elements itself
			if(front == end){
				max[pos] = array[front];
				min[pos] = array[front];
				sum[pos] = array[front];
				return;
			}
			//Building trees by dividing into two subtrees
			buildTree(array, left(pos), front, (front+end)/2);
			buildTree(array, right(pos), (front+end)/2 + 1, end);

			recalc(pos, front, end);
		}

		private void recalc(int pos, int front, int end) {
			max[pos] = Math.max(getMax(left(pos)), getMax(right(pos)));
			min[pos] = Math.min(getMin(left(pos)), getMin(right(pos)));
			sum[pos] = getSum(left(pos), front, (front+end)/2) + 
					   getSum(right(pos), (front+end)/2 + 1, end);
		}

		private int getMax(int pos){
			return max[pos] + lazy[pos];
		}

		private int getMin(int pos){
			return min[pos] + lazy[pos];
		}

		private int getSum(int pos,int front,int end){
			return sum[pos] + lazy[pos] * (end - front + 1);
		}

		public int queryMax(int queryFront, int queryEnd) {
			return queryMax(1, 0, size - 1, queryFront, queryEnd);
		}

		private int queryMax(int pos, int front, int end, int queryFront, int queryEnd){
			//Case for entirely inclusive
			if(front >= queryFront && queryEnd >= end){
				return getMax(pos);
			}
			//Case for entirely exclusive
			if(end < queryFront || queryEnd < front){
				return Integer.MIN_VALUE;
			}
			propagate(pos, front, end);
			int leftAns = queryMax(left(pos), front,(front+end)/2, queryFront, queryEnd);
			int rightAns = queryMax(right(pos), (front+end)/2+1, end, queryFront, queryEnd);
			return Math.max(leftAns, rightAns);
		}

		public int queryMin(int queryFront, int queryEnd) {
			return queryMin(1, 0, size-1, queryFront, queryEnd);
		}

		private int queryMin(int pos,int front,int end, int queryFront, int queryEnd){
			//Case for entirely inclusive
			if(front >= queryFront && queryEnd >= end){
				return getMin(pos);
			}
			//Case for entirely exclusive
			if(end < queryFront || queryEnd < front){
				return Integer.MAX_VALUE;
			}
			propagate(pos,front,end);
			int leftAns = queryMin(left(pos), front, (front+end)/2, queryFront, queryEnd);
			int rightAns = queryMin(right(pos), (front+end)/2+1, end, queryFront, queryEnd);
			return Math.min(leftAns, rightAns);
		}
		public int querySum(int queryFront, int queryEnd) {
			return querySum(1, 0, size - 1, queryFront, queryEnd);
		}

		private int querySum(int pos, int front, int end, int queryFront, int queryEnd){
			//Case for entirely inclusive
			if(queryFront <= front && end <= queryEnd){
				return getSum(pos, front, end);
			}
			//Case for entirely exclusive
			if(end < queryFront || queryEnd < front){
				return 0;
			}
			propagate(pos,front,end);
			int leftAns = querySum(left(pos), front, (front+end)/2, queryFront, queryEnd);
			int rightAns = querySum(right(pos), (front+end)/2+1, end, queryFront, queryEnd);
			return leftAns + rightAns;
		}


		private void propagate(int pos,int front, int end){
			lazy[left(pos)] += lazy[pos];
			lazy[right(pos)] += lazy[pos];
			max[pos] = getMax(pos);
			min[pos] = getMin(pos);
			sum[pos] = getSum(pos, front, end);
			lazy[pos] = 0;
			//Set the propagation to 0 so that it will not propagate the value again and again
		}

		public void update(int updateFront, int updateEnd, int delta){
			update(1, 0, size - 1, updateFront, updateEnd, delta);
		}

		private void update(int pos, int front, int end, int updateFront, int updateEnd, int value){
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

}
