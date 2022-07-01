import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class FFTmod {

    static long mod = 998244353;

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

    static int root = 31;
    static int kmax = 23;
    static int kk = 21;

    static int rev[] = new int[1 << kmax];
    static long degs[] = new long[kmax];
    static long rdeg[] = new long[kmax];

    static void fft(long[] a, boolean flag) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            int j = rev[i];
            if (i < j) {
                long tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        for (int len = 2, t = 1; len <= n; len <<= 1, ++t) {
            long step = degs[kmax - t];
            if (flag) {
                step = rdeg[kmax - t];
            }
            for (int i = 0; i < n; i += len) {
                long w = 1;
                for (int j = 0; j < len / 2; ++j) {
                    long x = a[i + j];
                    long y = a[i + j + len / 2];
                    y = y * w % mod;
                    a[i + j] = a[i + j + len / 2] = x;
                    a[i + j] = (a[i + j] + y) % mod;
                    a[i + j + len / 2] = (a[i + j + len / 2] - y + mod) % mod;
                    w = w * step % mod;
                }
            }
        }
        if (flag) {
            long rn = pow(n, mod - 2);
            for (int i = 0; i < n; ++i) {
                a[i] = a[i] * rn % mod;
            }
        }
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt() / 2;
        int nn = n;
        int k = scanner.nextInt();
//
        rev[0] = 0;
        int oldest = -1;
        for (int i = 1; i < (1 << kk); ++i) {
            if ((i & (i - 1)) == 0) {
                ++oldest;
            }
            rev[i] = (rev[i ^ (1 << oldest)] | (1 << (kk - oldest - 1)));
        }

        degs[0] = root;
        for (int i = 1; i < kmax; ++i) {
            degs[i] = degs[i - 1];
            degs[i] = degs[i] * degs[i] % mod;
        }

        for (int i = 0; i < kmax; ++i) {
            rdeg[i] = pow(degs[i], mod - 2);
        }


        long[] f = new long[1 << kk];
        for (int i = 0; i < k; i++) {
            f[scanner.nextInt()] = 1;
        }

        fft(f, false);

        for (int i = 0; i < (1 << kk); ++i) {
            f[i] = pow(f[i], nn);
        }

        fft(f, true);

        long ans = 0;
        for (int i = 0; i < (1 << kk); ++i) {
            long val = f[i];
            val = val * val % mod;
            ans = (ans + val) % mod;
        }
        System.out.println(ans);
    }
}