import java.util.*;
public class p153 {

	public static void main(String[] args) {
		long n = 100000000;
		long sqn = (int)Math.sqrt(n);
		long res = 0;
		for(long a = 1; a <= sqn; a++) {
			for(long b = 1; b <= a; b++) {
				if(gcd(a, b) > 1) continue;
				if(b < a) {
					long d = b*b+a*a;
					for(long fac = 1; fac * d <= n; fac++) {
						res += (n / d / fac) * (a + b) * fac * 2;
//						System.out.printf("a:%d b:%d fac:%d val:%d\n", a, b, fac, (n / d / fac) * (a + b) * fac * 2);
					}
				}
				else {//b == a
					long d = b*b+a*a;
					for(long fac = 1; fac * d <= n; fac++) {
						res += (n / d / fac) * a * fac * 2;
//						System.out.printf("a:%d b:%d fac:%d val:%d\n", a, b, fac, (n / d / fac) * a * fac * 2);
					}
				}
			}
		}
		for(long a = 1; a <= n; a++) {
			res += (n / a) * a;
		}
		System.out.println(res);
//		System.out.println(test());
	}
	static long gcd(long a, long b) {
		if(b > a) return gcd(b, a);
		else if(b == 0) return a;
		else return gcd(b, a % b);
	}
	static int test() {
		int n = 100;
		HashSet<String>[] sols = new HashSet[n+1];
		for(int i = 0; i <= n; i++) {
			sols[i] = new HashSet<>();
		}
		for(int a = 1; a <= n; a++) {
			for(int b = -n; b <= n; b++) {
				for(int c = 1; c <= n; c++) {
					for(int d = -n; d <= n; d++) {
						int x = a*c - b*d;
						int y = a*d + b*c;
						if(y == 0 && x > 0 && x <= n) {
							sols[x].add(a+","+b);
							sols[x].add(c+","+d);
						}
					}
				}
			}
		}
		int res = 0;
		for(int i = 1; i <= n; i++) {
			int count = 0, sum = 0;
			for(String s: sols[i]) {
				count++; sum += Integer.parseInt(s.split(",")[0]);
			}
			System.out.println(i+": "+sols[i]+" c:"+count+" s:"+sum);
			res += sum;
		}
		return res;
	}

}
