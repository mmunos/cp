import java.util.*;
public class p118b {

	public static void main(String[] args) {
		int[] arr = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = i+1;
		}
		long res = 0;
		while(arr != null) {
			curr = new LinkedList<Long>();
			res += count(arr);
			arr = next(arr);
		}
		System.out.println(res);
	}
	static int count(int[] arr) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int a: arr) list.add(a);
		return count(list);
	}
	static LinkedList<Long> curr;
	static int count(LinkedList<Integer> list) {
		if(list.isEmpty()) {
			System.out.println(curr);
			return 1;
		}
		String s = "";
		LinkedList<Integer> stack = new LinkedList<>();
		int res = 0;
		while(!list.isEmpty()) {
			int d = list.removeFirst();
			stack.add(d);
			s += d;
			long v = Long.parseLong(s);
			if((curr.isEmpty() || v > curr.peekLast()) && isPrime(v)) {
				curr.add(v);
				res += count(list);
				curr.removeLast();
			}
		}
		while(!stack.isEmpty()) {
			list.addFirst(stack.removeLast());
		}
		return res;
	}
	static boolean isPrime(long x) {
		if(x == 1) return false;
		for(long d = 2; d*d <= x; d++) {
			if(x % d == 0) return false;
		}
		return true;
	}
	static int[] next(int[] arr) {
		int n = arr.length;
		Multiset vals = new Multiset();
		for(int i = n-1; i >= 1; i--) {
			vals.add(arr[i]);
			if(arr[i] > arr[i-1]) {
				vals.add(arr[i-1]);
				arr[i-1] = vals.map.higherKey(arr[i-1]);
				vals.remove(arr[i-1]);
				for(int j = i; j < n; j++){
					arr[j] = vals.map.firstKey();
					vals.remove(arr[j]);
				}
				return arr;
			}
		}
		return null;
	} // bring in the multiset too !!!
	static class Multiset{
		TreeMap<Integer, Integer> map;
		public Multiset() {
			map = new TreeMap<>();
		}
		public void add(int a) {
			if(!map.containsKey(a)) map.put(a, 1);
			else map.put(a, map.get(a)+1);
		}
		public void remove(int a) {
			map.put(a, map.get(a)-1);
			if(map.get(a) == 0) map.remove(a);
		}
		public boolean contains(int a) {
			return map.containsKey(a);
		}
		public int count(int a) {
			if(!map.containsKey(a)) return 0;
			else return map.get(a);
		}
		public boolean isEmpty() {
			return map.isEmpty();
		}
		public boolean equals(Multiset ms) {
			for(int k: map.keySet()) {
				if(count(k) != ms.count(k)) return false;
			}
			return true;
		}
		public String toString() {
			return map.toString();
		}
	}

}
