import java.math.BigInteger;
import java.util.*;
public class p146 {
	
	// 7777777777777777777777777777773 = 3 x 76733384561 x 33787022525138119231

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		factor(v(s));

	}
	static Longg ZERO = v(0);
    static Longg ONE  = v(1);
    static Longg TWO  = v(2);
    static Random random = new Random();
    
    public static void factor(Longg N) {
        if (N.eq(ONE)) return;
        if (N.isprime()) { System.out.println(N); return; }
        Longg divisor = rho(N);
        factor(divisor);
        factor(N.d(divisor));
    }

    public static Longg rho(Longg N) {
        Longg divisor;
        Longg c  = v(new BigInteger(N.val.bitLength(), random));
        Longg x  = v(new BigInteger(N.val.bitLength(), random));
        Longg xx = x;

        // check divisibility by 2
        if (N.mod(TWO).eq(ZERO)) return TWO;

        do {
            x  =  x.m(x).mod(N).s(c).mod(N);
            xx = xx.m(xx).mod(N).s(c).mod(N);
            xx = xx.m(xx).mod(N).s(c).mod(N);
            divisor = x.sub(xx).gcd(N);
        } while(divisor.eq(ONE));

        return divisor;
    }
    
    static Longg v(long x) { return new Longg(x);}
    static Longg v(String s) { return new Longg(s);}
    static Longg v(BigInteger b) { return new Longg(b);}
    static class Longg implements Comparable<Longg>{
    	BigInteger val;
    	public Longg(long x) {
    		val = BigInteger.valueOf(x);
    	}
    	public Longg(String s) {
    		val = new BigInteger(s);
    	}
    	public Longg(BigInteger b) {
    		val = b;
    	}
    	public boolean eq(Longg l) {
    		return val.equals(l.val);
    	}
    	public Longg s(Longg l) {
    		return new Longg(val.add(l.val));
    	}
    	public Longg sub(Longg l) {
    		return new Longg(val.subtract(l.val));
    	}
    	public Longg m(Longg l) {
    		return new Longg(val.multiply(l.val));
    	}
    	public Longg d(Longg l) {
    		return new Longg(val.divide(l.val));
    	}
    	public Longg mod(Longg l) {
    		return new Longg(val.mod(l.val));
    	}
    	public Longg gcd(Longg l) {
    		return new Longg(val.gcd(l.val));
    	}
    	public boolean isprime() {
    		return val.isProbablePrime(20);
    	}
    	public String toString() {
    		return val.toString();
    	}
    	@Override
    	public int compareTo(Longg l) {
    		return val.compareTo(l.val);
    	}
    	@Override
    	public int hashCode() {
    		return val.hashCode();
    	}
    	@Override
    	public boolean equals(Object o) {
    		return val.equals(((Longg)o).val);
    	}
    }

    

}
