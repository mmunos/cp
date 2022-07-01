import java.util.*;
public class p108 {
	
	public static void main(String...strings) {
		for(int i = 1; i < 10000000; i++) {
			if(count(i) > 1000) {
				System.out.println(i); break;
			}
		}
	}
	static int count(long n) {
		int res = 0;
		for(long x = n+1; x <= 2*n; x++) {
			if(n*x%(x-n) == 0) res++;
		}
		return res;
	}

}
