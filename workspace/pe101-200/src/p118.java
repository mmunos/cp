import java.util.*;
public class p118 {

	public static void main(String[] args) {
		int[] arr = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = i+1;
		}
		long res = 0;
		sets = new HashSet<String>();
		while(arr != null) {
			curr = new LinkedList<String>();
			res += count(arr);
			arr = next(arr);
		}
		System.out.println(sets.size());
	}
	static int count(int[] arr) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int a: arr) list.add(a);
		return count(list);
	}
	static LinkedList<String> curr;
	static HashSet<String> sets;
	static int count(LinkedList<Integer> list) {
		if(list.isEmpty()) {
			System.out.println(curr);
			String[] arr = new String[curr.size()];
			for(int i = 0; i < curr.size(); i++) {
				arr[i] = curr.get(i);
			}
			Arrays.sort(arr);
			sets.add(Arrays.toString(arr));
		}
		String s = "";
		LinkedList<Integer> stack = new LinkedList<>();
		int res = 0;
		while(!list.isEmpty()) {
			int d = list.removeFirst();
			stack.add(d);
			s += d;
			if(isPrime(Long.parseLong(s))) {
				curr.add(s);
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
