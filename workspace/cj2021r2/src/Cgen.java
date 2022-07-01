import java.util.*;
import java.io.*;
public class Cgen {

	static long mod = 1000000007;
	public static void main(String[] args) throws Exception {
		
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
