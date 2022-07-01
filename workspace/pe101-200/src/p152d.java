import java.util.*;

public class p152d {

	static int N = 45;
	static int[] ps = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
	static ArrayList<Integer>[] nums;
	static int pn = ps.length;
	public static void main(String[] args) {
		nums = new ArrayList[pn];
		for(int pi = 0; pi < pn; pi++) {
			int p = ps[pi];
			nums[pi] = new ArrayList<>();
			for(int i = 1; i <= N/p; i++) {
				if(i % p != 0) {
					nums[pi].add(i);
				}
			}
		}
		int[] N = new int[pn];
		for(int i = 0; i < pn; i++) {
			N[i] = nums[i].size();
		}
		f = new int[pn][];
		for(int pi = 0; pi < pn; pi++) {
			int p = ps[pi];
			f[pi] = new int[N[pi]];
			for(int i = 0; i < N[pi]; i++) {
				int n = nums[pi].get(i);
				f[pi][i] = (int)inv(n*n, p*p);
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
		listoflists = new LinkedList[pn];
		long tot = 1;
		for(int pi = 0; pi < pn; pi++) {
			listoflists[pi] = new LinkedList<>();
			list = new LinkedList<>();
			System.out.println("seeing "+ps[pi]);
			process(pi, N[pi]-1, 0);
			long sz = listoflists[pi].size();
			tot *= sz;
			System.out.println(sz);
		}
		currset = new TreeSet<>(); 
		bigprocess(0);
		currset.add(9);
		bigprocess(0);
	}
	static int[][] f;
	static TreeSet<Integer> currset;
	static int[] p2s = {2, 4, 8, 16, 32, 64};
	static double err = 0.0000000001;
	static void bigprocess(int pi) {
		if(pi >= pn) {
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
				System.out.print(currset);
				System.out.print(toadd);
				System.out.println(" "+val);
			}
		}
		else {
			int p = ps[pi];
			for(LinkedList<Integer> list: listoflists[pi]) {
				HashSet<Integer> toadd = new HashSet<>();
				for(int a: list) {
					if(!currset.contains(a*p)) toadd.add(a*p);
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
				System.out.println(list);
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
				list.add(nums[pi].get(n) * p);
				process(pi, n-1, news);
				list.removeLast();
			}
		}
	}
	static boolean[][][] dp;
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
