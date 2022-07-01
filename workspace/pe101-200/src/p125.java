import java.util.*;
public class p125 {

	public static void main(String[] args) {
		for(long a = 1; a*a < N; a++) {
			add(a);
		}
		long tot = 0;
		for(long x: prs) tot += x;
		System.out.println(tot);
	}
	static long N = 100000000;
	static HashSet<Long> prs = new HashSet<Long>(); 
	static void add(long a) {
		long curr = a*a;
		a++;
		long res = 0;
		while(curr < N) {
			curr += a*a;
			if(curr >= N) break;
			if(checkpalin(curr)) {
				if(prs.contains(curr)) {
					System.out.println("whaat "+curr);
				}
				prs.add(curr);
				res += curr;
			}
			a++;
		}
	}
	static boolean checkpalin(long x) {
		char[] s = (x+"").toCharArray();
		int n = s.length;
		for(int i = 0; i < n; i++) {
			if(s[i] != s[n-i-1]) return false;
		}
		return true;
	}

}
