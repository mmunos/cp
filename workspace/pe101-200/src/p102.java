import java.util.*;
public class p102 {
	
	public static void main(String...strings) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long tot = 0;
		while(n-- > 0) {
			long[][] ps = new long[3][2];
			for(int i = 0; i < 3; i++) {
				ps[i][0] = sc.nextLong();
				ps[i][1] = sc.nextLong();
			}
			if(check(ps)) tot++;
		}
		System.out.println(tot);
	}
	public static boolean check(long[][] ps) {
		long[] cs = new long[3];
		for(int i = 0; i < 3; i++) {
			cs[i] = cross(ps[i], ps[(i+1)%3]);
		}
		Arrays.sort(cs);
		if(cs[0] > 0 && cs[2] > 0) return true;
		else if(cs[0] < 0 && cs[2] < 0) return true;
		else return false;
	}
	static long cross(long[] a, long[] b) {
		return a[0] * b[1] - a[1] * b[0];
	}

}
