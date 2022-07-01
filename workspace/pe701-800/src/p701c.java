import java.util.*;
public class p701c {

	static int n = 6, m = 3, nm = 3;
	public static void main(String[] args) {
		long _t1 = System.currentTimeMillis();
		char[] s0 = "0000000".toCharArray();
		HashMap<State, Long>[] dp = new HashMap[m+1];
		for(int i = 0; i <= m; i++) {
			dp[i] = new HashMap<>();
		}
		dp[0].put(new State(s0), 1L);
		for(int i = 1; i <= m; i++) {
			for(int mask = 0; mask < (1 << n); mask++) {
				char[] s = decode(mask);
				for(State st: dp[i-1].keySet()) {
					State nextst = st.add(new State(s));
					if(!dp[i].containsKey(nextst)) dp[i].put(nextst, dp[i-1].get(st));
					else dp[i].put(nextst, dp[i].get(nextst)+dp[i-1].get(st));
				}
			}
			System.out.println(dp[i].size());
//			System.out.println(dp);
		}
		HashMap<HalfState, TreeMap<Integer, Long>> mapm = new HashMap<>();
		for(State st1: dp[m].keySet()) {
			HalfState hs = new HalfState(st1.group, st1.size);
			if(!mapm.containsKey(hs)) mapm.put(hs, new TreeMap<>());
			mapm.get(hs).put(st1.max, dp[m].get(st1));	
		}
		System.out.println(mapm.size());
		HashMap<HalfState, TreeMap<Integer, Long>> mapnm = new HashMap<>();
		for(State st2: dp[nm].keySet()) {
			HalfState hs = new HalfState(st2.group, st2.size);
			if(!mapnm.containsKey(hs)) mapnm.put(hs, new TreeMap<>());
			mapnm.get(hs).put(st2.max, dp[nm].get(st2));	
		}
		System.out.println(mapnm.size());
		long tot = 0;
		int maxmax = 0;
		for(HalfState st1: mapm.keySet()) {
			for(HalfState st2: mapnm.keySet()) {
				int max = calcmax(st1, st2);
				TreeMap<Integer, Long> tm1 = mapm.get(st1);
				TreeMap<Integer, Long> acc1 = new TreeMap<>();
				long acc = 0;
				for(Integer k: tm1.keySet()) {
					acc += tm1.get(k);
					acc1.put(k, acc);
					maxmax = Math.max(maxmax, k);
				}
				TreeMap<Integer, Long> tm2 = mapnm.get(st2);
				TreeMap<Integer, Long> acc2 = new TreeMap<>();
				acc = 0;
				for(Integer k: tm2.keySet()) {
					acc += tm2.get(k);
					acc2.put(k, acc);
					maxmax = Math.max(maxmax, k);
				}
				long prod = 0;
				for(Integer k: tm1.keySet()) {
					Integer k2 = acc2.lowerKey(k);
					if(k2 != null) {
						prod += Long.max(k, max) * tm1.get(k) * acc2.get(k2);
					}
				}
				for(Integer k: tm2.keySet()) {
					Integer k1 = acc1.lowerKey(k);
					if(k1 != null) {
						prod += Long.max(k, max) * tm2.get(k) * acc1.get(k1);
					}
				}
				for(Integer k: tm1.keySet()) {
					if(tm2.containsKey(k)) {
						prod += Long.max(k, max) * tm1.get(k) * tm2.get(k);
					}
				}
				tot += prod;
			}
		}
		System.out.println(maxmax);
		System.out.println(tot);

		long _t2 = System.currentTimeMillis();
		System.out.println(_t2 - _t1);
	}
	static int calcmax(HalfState hs1, HalfState hs2) {
		HalfState hs = new HalfState(hs1.arr1, hs2.arr1);
		if(!prec.containsKey(hs)) prec.put(hs, mix(hs));
		int[] auxg = prec.get(hs);
		int[] news = new int[n];
		HashSet<Integer> ga = new HashSet<>();
		HashSet<Integer> gb = new HashSet<>();
		for(int i = 0; i < n; i++) {
			ga.add(hs.arr1[i]);
			gb.add(hs.arr2[i]);
		}
		for(int a: ga) {
			if(a < 0) continue;
			if(auxg[a+n] >= 0) news[auxg[a+n]] += hs1.arr2[a];
		}
		for(int b: gb) {
			if(b < 0) continue;
			news[auxg[b]] += hs2.arr2[b];
		}
		int res = 0;
		for(int i = 0; i < n; i++) {
			res = Math.max(res, news[i]);
		}
		return res;
	}
	static char[] decode(int mask) {
		String s = Integer.toBinaryString(mask);
		String s2 = String.format("%"+n+"s", s).replaceAll(" ", "0");
		return s2.toCharArray();
	}
	static class HalfState{
		int[] arr1, arr2;
		public HalfState(int[] arr1, int[] arr2) {
			this.arr1 = arr1;
			this.arr2 = arr2;
		}
		@Override
		public int hashCode() {
			int res = 0;
			for(int a: arr1) {
				res *= 2;
				if(a >= 0) {
					res++;
				}
			}
			for(int a: arr2) {
				res *= 2;
				if(a >= 0) {
					res++;
				}
			}
			return res;
		}
		@Override
		public boolean equals(Object o) {
			HalfState hs = (HalfState) o;
			for(int i = 0; i < n; i++) {
				if(arr1[i] != hs.arr1[i]) return false;
				if(arr2[i] != hs.arr2[i]) return false;
			}
			return true;
		}
	}
	static HashMap<HalfState, int[]> prec = new HashMap<>();
	static int[] mix(HalfState hs) {
		HashSet<Integer> ga = new HashSet<>();
		HashSet<Integer> gb = new HashSet<>();
		for(int i = 0; i < n; i++) {
			ga.add(hs.arr1[i]);
			gb.add(hs.arr2[i]);
		}
		HashSet<Integer>[] gs = new HashSet[2*n];
		for(int i = 0; i < 2*n; i++) {
			gs[i] = new HashSet<>();
		}
		for(int i = 0; i < n; i++) {
			if(hs.arr2[i] >= 0 && hs.arr1[i] >= 0) {
				gs[hs.arr1[i] + n].add(hs.arr2[i]);
				gs[hs.arr2[i]].add(hs.arr1[i] + n);
			}
		}
		LinkedList<Integer> q = new LinkedList<>();
		int[] auxg = new int[2*n];
		Arrays.fill(auxg, -1);
		int g = 0;
		for(int i: gb) {
			if(i >= 0 && auxg[i] < 0) {
				auxg[i] = g++;
				q.add(i);
				while(!q.isEmpty()) {
					int u = q.removeFirst();
					for(int v: gs[u]) {
						if(auxg[v] < 0) {
							auxg[v] = auxg[u];
							q.add(v);
						}
					}
				}
			}
		}
		return auxg;
	}
	static class State{
		int[] group, size; int max;
		public State(char[] s) {//binary
			int g = 0;
			group = new int[n];
			size = new int[n];
			max = 0;
			for(int i = 0; i < n; i++) {
				if(s[i]=='0') {
					group[i] = -1;
 				}
				else {
					max = 1;
					if(i > 0 && s[i-1] == '1') {
						group[i] = group[i-1];
						size[group[i]]++;
					}
					else {
						group[i] = g++;
						size[group[i]]++;
					}
				}
			}
		}
		public State(int[] group, int[] size, int max) {
			this.group = group; this.size = size; this.max = max;
		}
		@Override
		public int hashCode() {
			int res = 0;
			for(int a: group) {
				res *= 2;
				if(a >= 0) {
					res++;
				}
			}
			for(int a: size) {
				res *= 2;
				if(a >= 0) {
					res++;
				}
			}
			return res + max;
		}
		@Override
		public boolean equals(Object o) {
			State s = (State)o;
			if(max != s.max) return false;
			for(int i = 0; i < n; i++) {
				if(group[i] != s.group[i]) return false;
				if(size[i] != s.size[i]) return false;
			}
			return true;
		}
		public State add(State s) {
			HashSet<Integer> ga = new HashSet<>();
			HashSet<Integer> gb = new HashSet<>();
			for(int i = 0; i < n; i++) {
				ga.add(group[i]);
				gb.add(s.group[i]);
			}
			HalfState hs = new HalfState(group, s.group);
			if(!prec.containsKey(hs)) prec.put(hs, mix(hs));
			int[] auxg = prec.get(hs);
			int[] newg = new int[n];
			Arrays.fill(newg, -1);
			for(int i = 0; i < n; i++) {
				if(s.group[i] >= 0) {
					newg[i] = auxg[s.group[i]];
				}
			}
			int[] news = new int[n];
			for(int a: ga) {
				if(a < 0) continue;
				if(auxg[a+n] >= 0) news[auxg[a+n]] += size[a];
			}
			for(int b: gb) {
				if(b < 0) continue;
				news[auxg[b]] += s.size[b];
			}
			int newmax = max;
			for(int i = 0; i < n; i++) {
				newmax = Math.max(newmax, news[i]);
			}
			return new State(newg, news, newmax);
		}
		public int merge(State s) {
			HashSet<Integer> ga = new HashSet<>();
			HashSet<Integer> gb = new HashSet<>();
			for(int i = 0; i < n; i++) {
				ga.add(group[i]);
				gb.add(s.group[i]);
			}
			HashSet<Integer>[] gs = new HashSet[2*n];
			for(int i = 0; i < 2*n; i++) {
				gs[i] = new HashSet<>();
			}
			for(int i = 0; i < n; i++) {
				if(group[i] >= 0 && s.group[i] >= 0) {
					gs[group[i] + n].add(s.group[i]);
					gs[s.group[i]].add(group[i] + n);
				}
			}
			LinkedList<Integer> q = new LinkedList<>();
			HalfState hs = new HalfState(group, s.group);
			if(!prec.containsKey(hs)) prec.put(hs, mix(hs));
			int[] auxg = prec.get(hs);
			int[] news = new int[n];
			for(int a: ga) {
				if(a < 0) continue;
				if(auxg[a+n] >= 0) news[auxg[a+n]] += size[a];
			}
			for(int b: gb) {
				if(b < 0) continue;
				news[auxg[b]] += s.size[b];
			}
			int res = Math.max(max, s.max);
			for(int i = 0; i < n; i++) {
				res = Math.max(res, news[i]);
			}
			return res;
		}
		public String toString() {
			return Arrays.toString(group)+" "+Arrays.toString(size)+" "+max;
		}
	}

}
	