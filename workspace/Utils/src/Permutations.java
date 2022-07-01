import java.util.*;
public class Permutations {

	public static void main(String[] args) {
		int[] arr = {3,3,3};
//		System.out.println(multiperms(arr,9));
//		List<List<Integer>> lists = perms(4, 4); 
//		System.out.println(lists);
//		System.out.println(lists.get(2294));
		
		System.out.println(8*8*8*8);
		for(int mask = 0; mask < 8*8*8*8; mask++) {
			System.out.println("4");
			int aux = mask;
			for(int k = 0; k < 4; k++) {
				System.out.print(aux % 8+" ");
				aux /= 8;
			}
			System.out.println("");
		}
	}
	static List<List<Integer>> perms(int n, int k){
		if(k == 0) {
			List<Integer> vac = new ArrayList<>();
			List<List<Integer>> res = new ArrayList<>();
			res.add(vac);
			return res;
		}
		else {
			List<List<Integer>> next = perms(n, k-1);
			List<List<Integer>> res = new ArrayList<>();
			for(List<Integer> list: next) {
				HashSet<Integer> nums = new HashSet<>();
				for(int i = 0; i < n; i++) nums.add(i);
				for(int x: list) nums.remove(x);
				for(int x: nums) {
					List<Integer> newlist = clone(list);
					newlist.add(x);
					res.add(newlist);
				}
			}
			return res;
		}
	}
	static List<Integer> clone(List<Integer> list){
		List<Integer> res = new ArrayList<>();
		for(int k: list) res.add(k);
		return res;
	}
	
	static List<List<Integer>> multiperms(int[] arr, int k){
		if(k == 0) {
			List<Integer> vac = new ArrayList<>();
			List<List<Integer>> res = new ArrayList<>();
			res.add(vac);
			return res;
		}
		else {
			List<List<Integer>> next = multiperms(arr, k-1);
			List<List<Integer>> res = new ArrayList<>();
			int n = arr.length;
			for(List<Integer> list: next) {
				Multiset nums = new Multiset();
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < arr[i]; j++) {
						nums.add(i);
					}
				}
				for(int x: list) nums.remove(x);
				for(int x: nums.map.keySet()) {
					List<Integer> newlist = clone(list);
					newlist.add(x);
					res.add(newlist);
				}
			}
			return res;
		}
	}
	static class Multiset{
		HashMap<Integer, Integer> map;
		public Multiset() {
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
