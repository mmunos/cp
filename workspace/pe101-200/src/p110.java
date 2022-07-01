import java.math.BigInteger;
import java.util.*;
public class p110 {
	
	static long[] ps = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
	public static void main(String...strings) {
		PriorityQueue<Key> q = new PriorityQueue<Key>();
		HashSet<String> seen = new HashSet<>();
		int[] u0 = new int[ps.length];
		String s0 = code(u0);
		q.add(new Key(s0));
		seen.add(s0);
		long max = 0;
		
		while(!q.isEmpty()) {
			Key u = q.poll();
			int c = fastcount(u.val);
			if(c > max) {
				max = c;
				System.out.println(u.val+" "+u.s+" "+c);
				int[] arr = decode(u.s);
				for(int i = 0; i < ps.length; i++) {
					if(i == 0 || arr[i] < arr[i-1]) {
						int[] brr = arr.clone();
						brr[i]++;
						String v = code(brr);
						if(!seen.contains(v)) {
							q.add(new Key(v));
						}
					}
				}
			}
		}
		
	}
	static int[] decode(String s) {
		String[] ss = s.split(",");
		int[] res = new int[ps.length];
		for(int i = 0; i < ps.length; i++) {
			res[i] = Integer.parseInt(ss[i]);
		}
		return res;
	}
	static String code(int[] es) {
		return Arrays.toString(es).replaceAll("[\\[\\] ]", "");
	}
	static BigInteger get(int[] es) {
		BigInteger res = v(1);
		for(int i = 0; i < es.length; i++) {
			res = m(res, v(ps[i]).pow(es[i]));
		}
		return res;
	}
	static class Key implements Comparable<Key>{
		String s;
		BigInteger val;
		public Key(String s) {
			this.s = s;
			val = get(decode(s));
		}
		@Override
		public int compareTo(Key key) {
			return val.compareTo(key.val);
		}
		public String toString() {
			return s;
		}
	}
	
	static BigInteger v(long x) {return BigInteger.valueOf(x);}
	static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
	static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
	static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
	static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
	static boolean pos(BigInteger a) {return a.signum() > 0;}
	static boolean neg(BigInteger a) {return a.signum() < 0;}
	
	static int fastcount(BigInteger n) {
		BigInteger orign = n.abs();
		HashSet<BigInteger> divs = new HashSet<>();
		divs.add(v(1));
		for(BigInteger d = v(2); d.compareTo(n) <= 0; d = d.add(v(1)) ) {
			if(n.mod(d).signum() == 0) {
				int c = 0;
				while(n.mod(d).signum() == 0) {
					c++; n = n.divide(d);
				}
				HashSet<BigInteger> newdivs = new HashSet<>();
				BigInteger dd = v(1);
				for(int i = 0; i <= 2*c; i++) {
					for(BigInteger x: divs) {
						if(m(x,dd).compareTo(orign) <= 0) {
							newdivs.add(m(x, dd));
						}
					}
					dd = m(dd, d);
				}
				divs = newdivs;
			}
		}
		return divs.size();
	}
//	static long count2(long n) {
//		long res = 0;
//		for(int d = 1; d <= n; d++) {
//			if(n % d == 0) {
//				res++;x	
//			}
//		}
//		return res;
//	}
	static void printfacs(long n) {
		for(int d = 2; d <= n; d++) {
			while(n % d == 0) {
				System.out.print(d+" "); n /= d;
			}
		}
		System.out.println("");
	}
	static int count(long n) {
		int res = 0;
		for(long d = 1; d <= n; d++) {
			if(n * n % d == 0) res++;
		}
		return res;	
	}
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}
	static void countandprint(long n) {
		int res = 0;
		for(long d = 1; d <= n; d++) {
			if(n * n % d == 0) {
				System.out.print(d+" ");
			}
		}
		System.out.println("");
	}

}
