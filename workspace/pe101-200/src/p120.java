import java.util.*;
public class p120 {
	
	public static void main(String...strings) {
		long tot = 0;
		for(int a = 3; a <= 1000; a++) {
			tot += rmax(a);
		}
		System.out.println(tot);
	}
	static long rmax(long a) {
		long max = 2;
		for(int i = 1; i < a*a; i += 2) {
			max = Math.max(max, (2 * i * a) % (a * a));
		}
		return max;
	}
	

}
