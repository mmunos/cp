import java.util.HashMap;
public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Pair implements Comparable<Pair>{
		int u, w;
		public Pair(int u, int w) {
			this.u = u; this.w = w;
		}
		@Override
		public int compareTo(Pair p) {
			return w - p.w;
		}
		public String toString() {
			return u+" ("+w+")";
		}
	}
	static class Multiset{
		HashMap<Long, Integer> map;
		public Multiset() {
			map = new HashMap<>();
		}
		public void add(long a) {
			if(!map.containsKey(a)) map.put(a, 1);
			else map.put(a, map.get(a)+1);
		}
		public void remove(long a) {
			map.put(a, map.get(a)-1);
			if(map.get(a) == 0) map.remove(a);
		}
		public boolean contains(long a) {
			return map.containsKey(a);
		}
		public int count(long a) {
			if(!map.containsKey(a)) return 0;
			else return map.get(a);
		}
		public boolean isEmpty() {
			return map.isEmpty();
		}
		public boolean equals(Multiset ms) {
			for(long k: map.keySet()) {
				if(count(k) != ms.count(k)) return false;
			}
			return true;
		}
		public String toString() {
			return map.toString();
		}
	}
	
	static class MultisetInt{
		HashMap<Integer, Integer> map;
		public MultisetInt() {
			map = new HashMap<>();
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
