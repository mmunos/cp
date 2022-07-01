import java.util.*;
public class FFTmod2 {

	public static void main(String[] aaaa) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] f = new long[n];
        for(int i = 0; i < n; i++) {
            f[i] = sc.nextLong();
        }
        
        int m = sc.nextInt();
        
        long[] g = new long[m];
        for(int i = 0; i < m; i++){
			g[i] = sc.nextLong();
		}
        
        System.out.println("va");
        long[] h = FFTmod.mod_multiply(f, g);
        System.out.println("voy");
        
        for(int i = 0; i < 2*n; i++){
			System.out.print(h[i] + " ");
		}
    }
	
	static long inv(long a){
		return (gcdex(a, mod)[0] + mod) % mod;
	}
	static long[] gcdex(long a, long b){
		if(b > a) {
			long[] p = gcdex(b, a);
			return new long[] {p[1], p[0]};
		}
		else if(b == 0) return new long[] {1, 0};
		else{
			long[] p = gcdex(b, a % b);
			return new long[] {p[1], p[0] - p[1]*(a/b)};
		}
	}
	
	static long pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            b >>= 1;
            if (b > 0) {
                a = a * a % mod;
            }
        }
        return ans;
    }
		 
	static long mod = 998244353;
	
	static class FFTmod {
		static long[] roots = { 0, 1 };
		static int rootssize = 2;
		static int[] bit_reverse;
		static int brsize = 0;
		static int max_size = -1;
		static long root = -1;
	 
		static boolean is_power_of_two(int n) {
			return (n & (n - 1)) == 0;
		}
	 
		static int round_up_power_two(int n) {
			assert(n > 0);
	 
			while ((n & (n - 1)) > 0)
				n = (n | (n - 1)) + 1;
	 
			return n;
		}
	 
		// Given n (a power of two), finds k such that n == 1 << k.
		static int get_length(int n) {
			assert(is_power_of_two(n));
			return Integer.numberOfTrailingZeros(n);
		}
	 
		// Rearranges the indices to be sorted by lowest bit first, then second lowest, etc., rather than highest bit first.
		// This makes even-odd div-conquer much easier.
		static void bit_reorder(int n, long[] values) {
			if (brsize != n) {
				bit_reverse = new int[n];
				int length = get_length(n);
	 
				for (int i = 0; i < n; i++)
					bit_reverse[i] = (bit_reverse[i >> 1] >> 1) + ((i & 1) << (length - 1));
			}
	 
			for (int i = 0; i < n; i++)
				if (i < bit_reverse[i]) {
					long aux = values[i]; values[i] = values[bit_reverse[i]]; values[bit_reverse[i]] = aux;
				}
		}
	 
		static void find_root() {
			long order = mod - 1;
			max_size = 1;
	 
			while (order % 2 == 0) {
				order /= 2;
				max_size *= 2;
			}
	 
			root = 2;
	 
			// Find a max_size-th primitive root of MOD.
			while (!(pow(root, max_size) == 1 && pow(root, max_size / 2) != 1))
				root++;
		}
	 
		static void prepare_roots(int n) {
			if (max_size < 0)
				find_root();
	 
			assert(n <= max_size);
	 
			if (rootssize >= n)
				return;
	 
			int length = get_length(rootssize);
			long[] auxroots = roots.clone();
			roots = new long[n];
			for (int i = 0; i < auxroots.length; i++) {
				roots[i] = auxroots[i];
			}
			rootssize = n;
	 
			// The roots array is set up such that for a given power of two n >= 2, roots[n / 2] through roots[n - 1] are
			// the first half of the n-th primitive roots of MOD.
			while ((1 << length) < n) {
				// z is a 2^(length + 1)-th primitive root of MOD.
				long z = pow(root, max_size >> (length + 1));
	 
				for (int i = 1 << (length - 1); i < (1 << length); i++) {
					roots[2 * i] = roots[i];
					roots[2 * i + 1] = roots[i] * z % mod;
				}
	 
				length++;
			}
		}
	 
		static void fft_iterative(int N, long[] values) {
			assert(is_power_of_two(N));
			prepare_roots(N);
			bit_reorder(N, values);
	 
			for (int n = 1; n < N; n *= 2)
				for (int start = 0; start < N; start += 2 * n)
					for (int i = 0; i < n; i++) {
						long even = values[start + i];
						long odd = values[start + n + i] * roots[n + i] % mod;
						values[start + n + i] = (even - odd + mod) % mod;
						values[start + i] = (even + odd) % mod;
					}
		}
	 
//		int FFT_CUTOFF = 150;
	 
		static long[] mod_multiply(long[] left, long[] right) {
			int n = left.length;
			int m = right.length;
	 
			// Brute force when either n or m is small enough.
//			if (Math.min(n, m) < FFT_CUTOFF) {
//				long[] result = new long[n + m - 1];
//	 
//				for (int i = 0; i < n; i++) {
//					for (int j = 0; j < m; j++) {
//						result[i + j] += left[i] * right[j] % mod;
//						result[i + j] %= mod;
//					}
//				}
//	 
//				return result;
//			}
	 
			int N = round_up_power_two(n + m - 1);
			
			long[] a = new long[N], b = new long[N];
			for(int i = 0; i < n; i++) a[i] = left[i];
			for(int i = 0; i < m; i++) b[i] = right[i];
	 
			fft_iterative(N, a);
			fft_iterative(N, b);
	 
			long inv_N = inv(N);
	 
			for (int i = 0; i < N; i++)
				a[i] = a[i] * b[i] % mod * inv_N % mod;
			
			long[] c = new long[N];
			c[0] = a[0];
			for(int i = 1; i < N; i++){
				c[i] = a[N-i];
			}
			fft_iterative(N, c);
			return c;
		}
	 
	}

}
