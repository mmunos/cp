import java.util.*;

public class p152e {

	static int N = 72;
	static int[] ps = {11, 13, 17, 19, 23, 29, 31, 37};
	static int[] psqs = {9, 25, 49};
	static ArrayList<Integer>[] nums, numssq;
	static int pn = ps.length;
	static int psqn = psqs.length;
	public static void main(String[] args) {
		for(int i = 3; i <= N; i += 3) {
			int n = i/3;
//			System.out.println(i+" "+9*inv(n*n, 81));
		}
		nums = new ArrayList[pn];
		for(int pi = 0; pi < pn; pi++) {
			int p = ps[pi];
			nums[pi] = new ArrayList<>();
			for(int i = p; i <= N; i += p) {
				nums[pi].add(i);
			}
		}
		numssq = new ArrayList[psqn];
		for(int pi = 0; pi < psqn; pi++) {
			int p2 = psqs[pi];
			int p = (int)Math.sqrt(p2);
			numssq[pi] = new ArrayList<>();
			for(int i = p; i <= N; i += p) {
				if((i / p) % p2 != 0) {
					numssq[pi].add(i);
				}
			}
		}
		int[] N = new int[pn];
		for(int i = 0; i < pn; i++) {
			N[i] = nums[i].size();
		}
		int[] Nsq = new int[psqn];
		for(int i = 0; i < psqn; i++) {
			Nsq[i] = numssq[i].size();
		}
		f = new int[pn][];
		for(int pi = 0; pi < pn; pi++) {
			int p = ps[pi];
			f[pi] = new int[N[pi]];
			for(int i = 0; i < N[pi]; i++) {
				int n = nums[pi].get(i)/p;
				f[pi][i] = (int)inv(n*n, p*p);
			}
		}
		f2 = new int[psqn][];
		for(int pi = 0; pi < psqn; pi++) {
			int p2 = psqs[pi];
			int p = (int)Math.sqrt(p2);
			f2[pi] = new int[Nsq[pi]];
			for(int i = 0; i < Nsq[pi]; i++) {
				int n = numssq[pi].get(i);
				if(n % p2 == 0) {
					f2[pi][i] = (int)inv((n/p2)*(n/p2), p2*p2);
				}
				else {
					f2[pi][i] = p2*(int)inv((n/p)*(n/p), p2*p2) % (p2*p2);
				}
			}
		}
		dp = new boolean[pn][][];
		for(int pi = 0; pi < pn; pi++) {
			int p = ps[pi];
			dp[pi] = new boolean[N[pi]+1][p*p];
			dp[pi][0][0] = true;
			for(int i = 0; i < N[pi]; i++) {
				int n = nums[pi].get(i);
				for(int j = 0; j < p*p; j++) {
					if(dp[pi][i][j]) {
						dp[pi][i+1][j] = true;
						dp[pi][i+1][(j + f[pi][i]) % (p*p)] = true;
					}
				}
			}
		}
		long tot = 1;
		listoflists = new LinkedList[pn+psqn];
		for(int pi = 0; pi < pn; pi++) {
			listoflists[pi] = new LinkedList<>();
			list = new LinkedList<>();
			System.out.println("seeing "+ps[pi]);
			process(pi, N[pi]-1, 0);
			long sz = listoflists[pi].size();
			tot *= sz;
			System.out.println(sz);
		}
		dp2 = new boolean[psqn][][];
		for(int pi = 0; pi < psqn; pi++) {
			int p = psqs[pi];
			dp2[pi] = new boolean[Nsq[pi]+1][p*p];
			dp2[pi][0][0] = true;
			for(int i = 0; i < Nsq[pi]; i++) {
				int n = numssq[pi].get(i);
				for(int j = 0; j < p*p; j++) {
					if(dp2[pi][i][j]) {
						dp2[pi][i+1][j] = true;
						dp2[pi][i+1][(j + f2[pi][i]) % (p*p)] = true;
					}
				}
			}
		}
		for(int pi = 0; pi < psqn; pi++) {
			listoflists[pi+pn] = new LinkedList<>();
			list = new LinkedList<>();
			System.out.println("seeing "+psqs[pi]);
			process2(pi, Nsq[pi]-1, 0);
			long sz = listoflists[pi+pn].size();
			tot *= sz;
			System.out.println(sz);
		}
		System.out.println(tot);
		currset = new TreeSet<>(); 
		bigprocess(0);
		System.out.println(sols.size());
	}
	static boolean[][][] dp, dp2;
	static int[][] f, f2;
	static TreeSet<Integer> currset;
	static int[] p2s = {2, 4, 8, 16, 32, 64};
	static double err = 0.0000000001;
	static HashSet<String> sols = new HashSet<>();
	static void bigprocess(int pi) {
		if(pi >= psqn+pn) {
			//check
			double val = 0;
			for(int a: currset) {
				val += 1.0/a/a;
			}
			if(val > 0.5 + err);
			HashSet<Integer> toadd = new HashSet<>();
			for(int p2: p2s) {
				if(val + 1.0/p2/p2 <= 0.5 + err) {
					val += 1.0/p2/p2;
					toadd.add(p2);
				}
			}
			if(Math.abs(val - 0.5) < err) {
				String sol = currset.toString() + toadd.toString();
				if(!sols.contains(sol)) {
					sols.add(sol);
					System.out.println(sol + " " + val);
				}
			}
		}
		else {
			for(LinkedList<Integer> list: listoflists[pi]) {
				HashSet<Integer> toadd = new HashSet<>();
				for(int a: list) {
					if(!currset.contains(a)) toadd.add(a);
				}
				currset.addAll(toadd);
				bigprocess(pi+1);
				for(int a: toadd) {
					currset.remove(a);
				}
			}
		}
	}
	static LinkedList<LinkedList<Integer>>[] listoflists;
	static LinkedList<Integer> list;
	static LinkedList<Integer> clone(LinkedList<Integer> list){
		LinkedList<Integer> res = new LinkedList<Integer>();
		for(int a: list) res.add(a);
		return res;
	}
	static void process(int pi, int n, int s) {
		if(n < 0) {
			if(s == 0) {
//				System.out.println(list);
				listoflists[pi].add(clone(list));
			}
		}
		else {
			//do not add n
			if(dp[pi][n][s]) {
				process(pi, n-1, s);
			}
			//add n
			int p = ps[pi];
			int news = (s - f[pi][n] + p*p) % (p*p);
			if(dp[pi][n][news]) {
				list.add(nums[pi].get(n));
				process(pi, n-1, news);
				list.removeLast();
			}
		}
	}
	static void process2(int pi, int n, int s) {
		if(n < 0) {
			if(s == 0) {
//				System.out.println(list);
				listoflists[pi+pn].add(clone(list));
			}
		}
		else {
			//do not add n
			if(dp2[pi][n][s]) {
				process2(pi, n-1, s);
			}
			//add n
			int p = psqs[pi];
			int news = (s - f2[pi][n] + p*p) % (p*p);
			if(dp2[pi][n][news]) {
				list.add(numssq[pi].get(n));
				process2(pi, n-1, news);
				list.removeLast();
			}
		}
	}
	static long inv(long a, long mod){
		return (gcdex(a, mod)[0] + mod) % mod;
	}
	static long[] gcdex(long a, long b){
		if(b > a) {
			long[] p = gcdex(b, a);
			return new long[] {p[1], p[0]};
		}
		else if(b == 0) return new long[] {1, 0};
		else{
			long[] p = gcdex(b, a % b);
			return new long[] {p[1], p[0] - p[1]*(a/b)};
		}
	}
	
}
