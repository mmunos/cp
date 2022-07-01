import java.math.BigInteger;
import java.util.*;
public class p146b2 {
	
	// 7777777777777777777777777777773 = 3 x 76733384561 x 33787022525138119231

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		System.out.println(factor(x));

	}
	static long factor(long number) {
		long loop = 1, count;
	    long x_fixed = 2, x = 2, size = 2, factor;

	    do {
	        count = size;
	        do {
	            x = (x * x + 1) % number;
	            factor = gcd(Math.abs(x - x_fixed), number);
	        } while (--count > 0 && (factor == 1));
	        size *= 2;
	        x_fixed = x;
	        loop = loop + 1;
	    } while (factor == 1);
	    
	    return factor;
	}
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}

    

}
