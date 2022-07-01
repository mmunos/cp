
public class p156 {

	public static void main(String[] args) {
		long sumsum = 0;
		for(int d = 1; d <= 9; d++) {
			long n = 99999999999999L;
			long r;
			long sum = 0;
			while(n > 0) {
				r = calc(d, n);
				if(r < n) {
					System.out.println(n+": "+r);
					n = r;
				}
				else if(r == n) {
					System.out.println(n+": "+r+" :0");
					sum += n;
					n--;
				}
				else {//r > n
					System.out.println(n+": "+r+" :(");
					long nn = invcalc(d, n);
					if(nn == n) {
						System.out.println("what");
						n = nn-1;
					}
					else {// nn < n
						n = nn;
					}
				}
			}
			System.out.println("chan cha chan: "+sum);	
			sumsum += sum;
		}
		System.out.println("ans: "+sumsum);
	}
	
	static long invcalc(int d, long x) {//find lowest n s.t. f(n) = x
		long a = 1, b = x; //f(x) > x
		while(b - a > 1) {
			long c = (a + b)/2;
			if(calc(d, c) >= x) b = c;
			else a = c;
		}
		return b;
	}
	
	static long calc(int d, long x) {
		if(x < d) return 0;
		if(x < 10) return 1;
		String s = x+"";
		int k = s.length()-1;
		int a = s.charAt(0) - '0';
		long b = Long.parseLong(s.substring(1));
		long res1; //times d appears as the most significant digit
		if(d < a) res1 = (long)Math.pow(10, k);
		else if(d == a) res1 = b+1;
		else res1 = 0;
		long res2 = calc(d, b);
		long res3 = a * (long)Math.pow(10, k-1) * k;
		return res1 + res2 + res3;
	}

}
