import java.util.*;
public class p093v2 {

	static int[][][] grs = { 
			{{0, 1}, {0, 1}, {0, 1}}, 
			{{0, 1}, {1, 2}, {0, 1}},
			{{1, 2}, {0, 1}, {0, 1}},
			{{1, 2}, {1, 2}, {0, 1}},
			{{2, 3}, {1, 2}, {0, 1}}
	};
	
	public static void main(String[] args) {
		int[] arr = new int[4];
		TreeMap<String, TreeSet<Integer>> count = new TreeMap<>();
		while(arr != null) {
			HashSet<Integer> testset = new HashSet<>();
			for(int a: arr) testset.add(a);
			if(testset.size() == 4) {
				for(int[][] g: grs) {
					int[] ops = new int[3];
					while(ops != null) {
						LinkedList<Double> vals = new LinkedList<>();
						for(int i = 0; i < 4; i++) {
							vals.add(arr[i]*1.0);
						}
						for(int it = 0; it < 3; it++) {
							Double v = calc(vals.get(g[it][0]), vals.get(g[it][1]), ops[it]);
							if(v == null) break;
							vals.remove(g[it][0]); vals.remove(g[it][0]);
							vals.add(g[it][0], v);
						}
						double val = vals.getFirst();
						if(Math.round(val) == val) {
							int[] brr = arr.clone();
							Arrays.sort(brr);
							String key = Arrays.toString(brr);
							if(!count.containsKey(key)) count.put(key, new TreeSet<>());
							count.get(key).add((int)val);
						}
						ops = next(ops, 4);
					}	
				}
			}
			arr = next(arr, 10);
		}
		System.out.println(count);
		String res = ""; int max = 0;
		for(String k: count.keySet()) {
			TreeSet<Integer> s = count.get(k);
			int v = test(count.get(k));
			if(v > max) {
				res = k; max = v;
			}
		}
		System.out.println(res);
	}
	static int test(TreeSet<Integer> set) {
		int i = 1;
		while(set.contains(i)) i++;
		return i;
	}
	static Double calc(double a, double b, int op) {
		if(op == 0) return a + b;
		else if(op == 1) return a - b;
		else if(op == 2) return a * b;
		else if(op == 3) {
			if(b == 0) return null;
			else return a / b;
		}
		return null;
	}
	static int[] next(int[] arr, int m) {//i = 0 .. m-1
		int n = arr.length;
		int i = n-1;
		for(; i >= 0; i--) {
			arr[i]++;
			if(arr[i] == m) arr[i] = 0;
			else break;
		}
		if(i < 0) return null;
		return arr;
	}

}
