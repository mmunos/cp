import java.util.*;
import java.io.*;
public class C {

	static long mod = 1000000007;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int caso = 1;
		while(T--> 0) {
			int n = sc.nextInt();
			ch = new ArrayList[n+1];
			for(int i = 0; i <= n; i++) {
				ch[i] = new ArrayList<Integer>();
			}
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			LinkedList<Integer> st = new LinkedList<>();
			st.add(0);
			ch[0].add(1);
			st.add(1);
			boolean nope = false;
			for(int i = 1; i < n; i++) {
				int d = arr[i-1] - arr[i] + 1;
				if(d < 0) {
					nope = true; break;
				}
				while(d--> 0) {
					st.pollLast();
				}
				ch[st.peekLast()].add(i+1);
				st.add(i+1);
			}
			long v;
			if(nope) v = 0;
			else v = calc(0)[1];
			System.out.printf("Case #%d: %d\n", caso++, v);
		}
	}
	static ArrayList<Integer>[] ch;
	static long[] calc(int u) { //size of graph, ans
		if(ch[u].size() == 0) return new long[] {1, 1};
		long res = 1;
		ArrayList<long[]> next = new ArrayList<>();
		for(int v: ch[u]) {
			next.add(calc(v));
		}
		int count = 0;
		for(long[] nx: next) {
			count += nx[0];
			res = (res * nx[1]) % mod;
			long comb = choose(count-1, (int)nx[0]-1);
			res = (res * comb) % mod;
		}
		return new long[] {count + 1, res};
	}
	
	static int N = 100000;
	static long[] fac = new long[N+1];
	static long[] invfac = new long[N+1];
	static long fac(int n){
		if(n == 0) return fac[0] = 1;
		else if(fac[n] > 0) return fac[n];
		else return fac[n] = n * fac(n-1) % mod;
	}
	static long invfac(int n){
		if(invfac[n] > 0) return invfac[n];
		else return invfac[n] = inv(fac[n]);
	}
	static long choose(int n, int k){
		return fac(n) * invfac(k) % mod * invfac(n-k) % mod;
	}
	static long inv(long a){
		return (gcdex(a, mod).r + mod) % mod;
	}
	static Pair gcdex(long a, long b){
		if(b > a) return gcdex(b, a).invert();
		else if(b == 0) return new Pair(1, 0);
		else{
			Pair p = gcdex(b, a % b);
			return new Pair(p.s, p.r - p.s*(a/b));
		}
	}
	static class Pair{
		long r, s;
		public Pair(long r, long s){
			this.r = r; this.s = s;
		}
		public Pair invert(){
			return new Pair(s, r);
		}
		public String toString() {
			return r+" "+s;
		}
	}
}
