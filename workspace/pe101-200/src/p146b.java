import java.math.*;
import java.util.*;

public class p146b {
	
	// 7777777777777777777777777777773 = 3 x 76733384561 x 33787022525138119231

	public static void main(String[] args) {
		long n = 150000000/10;
		long tot = 0;
		for(int i = 1; i < n; i++) {
			if(check(v(10*i))) {
				System.out.println(10*i);
				tot += 10*i;
			}
		}
		System.out.println(tot);
	}
	static boolean check(Longg n) {
		return n.m(n).s(v(1)).isprime() &&
				n.m(n).s(v(3)).isprime() &&
//				!n.m(n).s(v(5)).isprime() &&
				n.m(n).s(v(7)).isprime() &&
				n.m(n).s(v(9)).isprime() &&
				!n.m(n).s(v(11)).isprime() &&
				n.m(n).s(v(13)).isprime() &&
//				!n.m(n).s(v(15)).isprime() &&
				!n.m(n).s(v(17)).isprime() &&
				!n.m(n).s(v(19)).isprime() &&
				!n.m(n).s(v(21)).isprime() &&
				!n.m(n).s(v(23)).isprime() &&
//				!n.m(n).s(v(25)).isprime() &&
				n.m(n).s(v(27)).isprime();
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
    		return val.isProbablePrime(30);
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
