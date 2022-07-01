import java.util.*;

public class p701e {

	static int n = 7;
	public static void main(String[] args) {
		long _t1 = System.currentTimeMillis();
		
		char[] s0 = "0000000".toCharArray();
		HashMap<State, Long>[] dp = new HashMap[n+1];
		for(int i = 0; i <= n; i++) {
			dp[i] = new HashMap<>();
		}
		dp[0].put(new State(s0), 1L);
		for(int i = 1; i <= n; i++) {
			for(int mask = 0; mask < (1 << n); mask++) {
				char[] s = decode(mask);
				for(State st: dp[i-1].keySet()) {
					State nextst = st.add(new State(s));
					if(!dp[i].containsKey(nextst)) dp[i].put(nextst, dp[i-1].get(st));
					else dp[i].put(nextst, dp[i].get(nextst)+dp[i-1].get(st));
				}
			}
			System.out.println(dp[i].size());
//			System.out.println(dp[i]);
		}
		long tot = 0;
		for(State st: dp[n].keySet()) {
			tot += st.max * dp[n].get(st);
		}
		System.out.println(tot);
		
		long _t2 = System.currentTimeMillis();
		System.out.println(_t2 - _t1);
	}
	static char[] decode(int mask) {
		String s = Integer.toBinaryString(mask);
		String s2 = String.format("%"+n+"s", s).replaceAll(" ", "0");
		return s2.toCharArray();
	}
	static class HalfState{
		int[] group1, group2;
		int hc;
		public HalfState(int[] arr1, int[] arr2) {
			this.group1 = arr1;
			this.group2 = arr2;
			hc = 0;
			for(int i = 0; i < group1.length; i++) {
				hc <<= 2;
				hc += arr1[i];
			}
			for(int i = 0; i < group2.length; i++) {
				hc <<= 2;
				hc += arr2[i];
			}
		}
		@Override
		public int hashCode() {
			return hc;
		}
		@Override
		public boolean equals(Object o) {
			HalfState hs = (HalfState) o;
			for(int i = 0; i < group1.length; i++) {
				if(group1[i] != hs.group1[i]) return false;
			}
			for(int i = 0; i < group2.length; i++) {
				if(group2[i] != hs.group2[i]) return false;
			}
			return true;
		}
	}
	static int gn = 4;
	static HashMap<HalfState, int[]> prec = new HashMap<>();
	static int[] mix(int[] group, int[] sgroup) {
		HashSet<Integer> ga = new HashSet<>();
		HashSet<Integer> gb = new HashSet<>();
		for(int i = 0; i < n; i++) {
			ga.add(group[i]);
			gb.add(sgroup[i]);
		}
		HashSet<Integer>[] gs = new HashSet[2*gn];
		for(int i = 0; i < 2*gn; i++) {
			gs[i] = new HashSet<>();
		}
		for(int i = 0; i < n; i++) {
			if(group[i] >= 0 && sgroup[i] >= 0) {
				gs[group[i] + gn].add(sgroup[i]);
				gs[sgroup[i]].add(group[i] + gn);
			}
		}
		LinkedList<Integer> q = new LinkedList<>();
		int[] auxg = new int[2*gn];
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
		int mask;
		int hc;
		public State(char[] s) {//binary
			int g = 0;
			group = new int[n];
			size = new int[gn];
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
			for(int i = 0; i < gn; i++) {
				max = Math.max(max, size[i]);
			}
			hc = 0;
			for(int i = 0; i < group.length; i++) {
				hc <<= 2;
				hc += group[i];
			}
			for(int i = 0; i < size.length; i++) {
				hc <<= 2;
				hc += size[i];
			}
			for(int i = 0; i < n; i++) {
				mask <<= 1;
				if(s[i] == '1') mask += 1;
			}
		}
		public State(int[] group, int[] size, int max) {
			this.group = group; this.size = size; this.max = max;
			mask = 0;
			for(int i = 0; i < n; i++) {
				mask <<= 1;
				if(group[i] >= 0) mask += 1;
			}
			hc = 0;
			for(int i = 0; i < group.length; i++) {
				hc <<= 2;
				hc += group[i];
			}
			for(int i = 0; i < size.length; i++) {
				hc <<= 2;
				hc += size[i];
			}
		}
		@Override	
		public int hashCode() {
			return hc;
		}
		@Override
		public boolean equals(Object o) {
			State s = (State)o;
			if(max != s.max) return false;
			for(int i = 0; i < n; i++) {
				if(group[i] != s.group[i]) return false;
			}
			for(int i = 0; i < gn; i++) {
				if(size[i] != s.size[i]) return false;
			}
			return true;
		}
		public State add(State s) {
			if((mask & s.mask) == 0) {
				return new State(s.group, s.size, Math.max(max, s.max));
			}
			HashSet<Integer> ga = new HashSet<>();
			HashSet<Integer> gb = new HashSet<>();
			for(int i = 0; i < n; i++) {
				ga.add(group[i]);
				gb.add(s.group[i]);
			}
			HalfState hs = new HalfState(group, s.group);
			if(!prec.containsKey(hs)) prec.put(hs, mix(hs.group1, hs.group2));
			int[] auxg = prec.get(hs);
			int[] newg = new int[n];
			Arrays.fill(newg, -1);
			for(int i = 0; i < n; i++) {
				if(s.group[i] >= 0) {
					newg[i] = auxg[s.group[i]];
				}
			}
			int[] news = new int[gn];
			for(int a: ga) {
				if(a < 0) continue;
				if(auxg[a+gn] >= 0) news[auxg[a+gn]] += size[a];
			}
			for(int b: gb) {
				if(b < 0) continue;
				news[auxg[b]] += s.size[b];
			}
			int newmax = max;
			for(int i = 0; i < gn; i++) {
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
			HashSet<Integer>[] gs = new HashSet[2*gn];
			for(int i = 0; i < 2*gn; i++) {
				gs[i] = new HashSet<>();
			}
			for(int i = 0; i < n; i++) {
				if(group[i] >= 0 && s.group[i] >= 0) {
					gs[group[i] + gn].add(s.group[i]);
					gs[s.group[i]].add(group[i] + gn);
				}
			}
			LinkedList<Integer> q = new LinkedList<>();
			int res = Math.max(max, s.max);
			boolean[] seen = new boolean[2*n];
			for(int i: gb) {
				if(!seen[i]) {
					int curr = s.size[i];
					q.add(i);
					while(!q.isEmpty()) {
						int u = q.removeFirst();
						for(int v: gs[u]) {
							if(!seen[v]) {
								seen[v] = true;
								if(v < n) curr += s.size[v];
								else curr += size[v-gn];
								q.add(v);
							}
						}
					}
					res = Math.max(res, curr);
				}
			}
			return res;
		}
		public String toString() {
			return Arrays.toString(group)+" "+Arrays.toString(size)+" "+max;
		}
	}

}
	