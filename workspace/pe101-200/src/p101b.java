import java.util.*;
import java.math.*;
public class p101b {

	public static void main(String[] args) {
		int N = 12;
		for(int n = 1; n <= N; n++) {
			Fraction[] poly = getpoly(n);
			for(int i = 1; i <= N; i++) {
				System.out.println(eval(poly, i));
			}
			System.out.println("");
		}
	}
	static Fraction eval(Fraction[] poly, long x) {
		long xi = 1;
		Fraction res = new Fraction(0, 1);
		for(Fraction d: poly) {
			res = res.add(d.mult(xi));
			xi *= x;
		}
		return res;
	}
	static long pow(long x, int a) {
		long res = 1;
		while(a-->0) res *= x;
		return res;
	}
	static Fraction[] getpoly(int n) {
		Fraction[][] mat = new Fraction[n][n+1];
		for(int i = 0; i < n; i++) {
			long x = i+1;
			for(int j = 0; j < n; j++) {
				mat[i][j] = new Fraction(pow(x, j), 1);
			}
			mat[i][n] = new Fraction(f(x), 1);
		}
		Fraction[] res = new Fraction[n];
		int ress = gauss(mat, res);
		if(ress == 1) {
			return res;
		}
		else {
			return null;
		}
	}
	static long f(long x) {
		return (pow(x, 11) + 1) / (x + 1);
	}
	
	static Fraction EPS = new Fraction(1, 1000000000);
	static int INF = 2; // it doesn't actually have to be infinity or a big number

	static int gauss (Fraction[][] a, Fraction[] ans) {
	    int n = (int) a.length;
	    int m = (int) a[0].length - 1;

	    int[] where = new int[m];
	    Arrays.fill(where, -1);
	    for (int col=0, row=0; col<m && row<n; ++col) {
	        int sel = row;
	        for (int i=row; i<n; ++i) {
	        	if(a[i][col].abs().compareTo(a[sel][col].abs()) > 0) {
	        		sel = i;
	        	}
	        }
	        if (a[sel][col].abs().compareTo(EPS) < 0) {
	            continue;
	        }
	        for (int i=col; i<=m; ++i) {
	        	Fraction aux = a[sel][i]; a[sel][i] = a[row][i]; a[row][i] = aux;
	        }
	        where[col] = row;

	        for (int i=0; i<n; ++i) {
	            if (i != row) {
	                Fraction c = a[i][col].div(a[row][col]);
	                for (int j=col; j<=m; ++j) {
	                	a[i][j] = a[i][j].sub(a[row][j].mult(c));
	                }
	            }
	        }
	        ++row;
	    }
	    for(int i = 0; i < ans.length; i++) {
			ans[i] = new Fraction(0, 1);
		}
	    for (int i=0; i<m; ++i) {
	        if (where[i] != -1) {
	            ans[i] = a[where[i]][m].div(a[where[i]][i]);
	        }
	    }
	    for (int i=0; i<n; ++i) {
	        Fraction sum = new Fraction(0, 1);
	        for (int j=0; j<m; ++j) {
	        	sum = sum.add(ans[j].mult(a[i][j]));
	        }
	        if(sum.sub(a[i][m]).abs().compareTo(EPS) > 0) {
	        	Fraction d1 = sum;
	        	Fraction d2 = a[i][m];
	        	Fraction d3 = sum.sub(a[i][m]);
	        	Fraction d4 = sum.sub(a[i][m]).abs();
	        	Fraction d5 = EPS;
	        	int wea = sum.sub(a[i][m]).abs().compareTo(EPS);
	            return 0;
	        }
	    }

	    for (int i=0; i<m; ++i) {
	        if (where[i] == -1) {
	            return INF;
	        }
	    }
	    return 1;
	}
	
	static class Fraction implements Comparable<Fraction> {
		BigInteger a, b;
		public Fraction(long a, long b) {
			long g = gcd(Math.abs(a), Math.abs(b));
			this.a = v(a / g); this.b = v(b / g);
		}
		public Fraction(BigInteger a, BigInteger b) {
			BigInteger g = a.gcd(b);
			this.a = d(a, g); this.b = d(b, g);
			if(neg(this.b)) {
				this.a = this.a.negate();
				this.b = this.b.negate();
			}
		}
		public Fraction add(Fraction f) {
			return new Fraction(s(m(a,f.b),m(f.a,b)), m(b,f.b));
		}
		public Fraction sub(Fraction f) {
			return add(f.mult(-1));
		}
		public Fraction mult(long x) {
			return new Fraction(m(a,v(x)), b);
		}
		public Fraction mult(Fraction f) {
			return new Fraction(m(a,f.a), m(b,f.b));
		}
		public Fraction inv() {
			return new Fraction(b, a);
		}
		public Fraction div(Fraction f) {
			return mult(f.inv());
		}
		public Fraction abs() {
			if(compareTo(new Fraction(0,1)) >= 0) return this;
			else return mult(-1);
		}
		public int compareTo(Fraction f) {
			BigInteger d = sub(m(a,f.b),m(f.a,b));
			return d.signum();
		}
		static long gcd(long a, long b) {
			if(b > a) return gcd(b, a);
			else if(b == 0) return a;
			else return gcd(b, a % b);
		}
		public String toString() {
			return a+"/"+b;
		}
		static BigInteger v(long x) {return BigInteger.valueOf(x);}
		static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
		static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
		static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
		static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
		static boolean pos(BigInteger a) {return a.signum() > 0;}
		static boolean neg(BigInteger a) {return a.signum() < 0;}
	}

}
