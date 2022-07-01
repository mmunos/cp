import java.util.*;
import java.math.*;
public class p086 {

	public static void main(String[] args) {
		int tot = 0;
		for(int a = 1; a < 2000; a++) {
			tot += count(a);
			if(tot > 1000000) {
				System.out.println(a); break;
			}
		}
	}
	static int count(long a) {
		int count = 0;
		for(long b = 1; b <= a; b++) {
			for(long c = 1; c <= b; c++) {
				long dd = a * a + (b + c) * (b + c);
				if(issq(dd)) count++;
			}
		}
		return count;
	}
	static boolean issq(long x) {
		long rx = (long)Math.sqrt(x);
		return rx * rx == x;
	}
}
