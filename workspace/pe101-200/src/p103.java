import java.util.*;
public class p103 {
	
	static long _t1;
	public static void main(String...strings) {
		_t1 = System.currentTimeMillis();
		int N = 40;
		for(int i = 2; i <= N; i++) {
			for(int j = i+1; j <= 2*N; j++) {
				HashSet<Integer> set = new HashSet<>();
				set.add(0);
				set.add(i);
				set.add(j);
				set.add(i+j);
				stack = new LinkedList<>();
				stack.add(i);
				stack.add(j);
				next(set, j, i+j, 5);
			}
		}
	}
	static long totmin = 1000;
	static LinkedList<Integer> stack;
	
	static void next(HashSet<Integer> set, int min, int max, int k) {
		if(k == 0) {
			int sum = 0;
			int m = stack.size();
			int[] acc = new int[m+1];
			int ind = 0;
			for(int s: stack) {
				acc[++ind] = s + acc[ind-1];
				sum += s;
			}
			if(acc[m] - acc[m-2] < acc[3] && acc[m] - acc[m-3] < acc[4]) {
				if(sum < totmin) {
					totmin = sum;
					System.out.println(stack + " " + sum);
					long _t2 = System.currentTimeMillis();
					System.out.println(_t2 - _t1);
				}
			}
		}
		for(int v = min+1; v < max; v++) {
			HashSet<Integer> newset = new HashSet<>(set);
			for(int s: set) newset.add(s + v);
			if(newset.size() == set.size() * 2) {
				stack.add(v);
				next(newset, v, max, k-1);
				stack.removeLast();
			}
		}
	}
	

}
