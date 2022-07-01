import java.util.*;
import java.math.*;
import java.io.*;
public class Fbig {

	static int N = 300003;
	static int sqN = 400;
	
	static BigInteger v(long x) {return BigInteger.valueOf(x);}
	static BigInteger s(BigInteger a, BigInteger b) {return a.add(b);}
	static BigInteger m(BigInteger a, BigInteger b) {return a.multiply(b);}
	static BigInteger sub(BigInteger a, BigInteger b) {return a.subtract(b);}
	static BigInteger d(BigInteger a, BigInteger b) {return a.divide(b);}
	static boolean pos(BigInteger a) {return a.signum() > 0;}
	static boolean neg(BigInteger a) {return a.signum() < 0;}

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		int n = sc.nextInt();
	    int sqn = (int)Math.sqrt(n);
	    int[] arr = new int[n];
	    for(int i = 0; i < n; i++){
	    	arr[i] = sc.nextInt();
	    }
	    BigInteger[] res = new BigInteger[n];
	    BigInteger[] f = new BigInteger[N+1];
	    BigInteger[] facc = new BigInteger[N+1];
	    BigInteger[] fiacc = new BigInteger[N+1];
	    BigInteger asum = v(0);
	    BigInteger[] smallmods = new BigInteger[sqN];
	    for(int iter = 0; iter < n; iter++){
	        if(iter % sqn == 0){//update
	            for(int d = 1; d <= sqn && iter-d >= 0; d++){
	                for(int i = 1; i < sqN; i++){
	                    smallmods[i] = smallmods[i].add(v(arr[iter-d]).divide(v(i)).multiply(v(i)));
	                }
	                f[arr[iter-d]] = f[arr[iter-d]].add(v(1));
	            }
	            for(int i = 1; i <= N; i++){
	                facc[i] = f[i].multiply(v(i));
	                facc[i] = facc[i].multiply(facc[i-1]);
	                fiacc[i] = f[i];
	                fiacc[i] = fiacc[i].add(fiacc[i-1]); 
	            }
	        }
	        int a = arr[iter];
	        BigInteger val = v(0);

	        //a mod the rest
	        //n * a - sum_{k = 1..N} k * c(k) * [a / k] . 
	        val = s(val,v(a * iter));
	        int sqa = (int)Math.sqrt(arr[iter]);
	        for(int d = 1; d < sqa; d++){
	            int l = (int)(a / (d+1)) + 1, r = (int)(a / d);
	            val -= (facc[r] - facc[l-1]) * d;
	        }
	        for(int i = (int)(a / sqa); i >= 1; i--){
	            val -= f[i] * i * (a / i);
	        }

	        //the rest mod a
	        //sum_{i < n} arr[i] - sum_{k = 1..N} c(k) * a * [k / a] . 
	        val += asum;
	        if(a < sqN){
	            val -= smallmods[(int)a];
	        }
	        else{
	            int mul = 1;
	            while((mul+1) * a <= N){
	                val -= (fiacc[(int)((mul+1) * a)] - fiacc[(int)(mul * a - 1)]) * a * mul;
	                mul++;
	            }
	            val -= (fiacc[N] - fiacc[(int)(mul * a - 1)]) * a * mul;
	        }

	        res[iter] += val;
	        //offline update
	        for(int it = iter+1; it < n && it % sqn != 0; it++){
	            res[it] -= a * (arr[it] / a);
	            res[it] -= arr[it] * (a / arr[it]);
	        }

	        asum += a;
	    }
	    StringBuilder sb = new StringBuilder();
	    BigInteger totres = 0;
	    for(int i = 0; i < n; i++){
	        totres += res[i];
	        sb.append(totres+" ");
	    }
	    sb.replace(sb.length()-1, sb.length(), "\n");
	    PrintWriter pw = new PrintWriter(System.out);
		pw.println(sb.toString().trim());
		pw.flush();
		
	}
	
	
	
	static class FastScanner {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in), 32768);
			tokenizer = null;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextBigInteger() {
			return Long.parseLong(next());
		}
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		public String nextLine() {
			try {
				return reader.readLine();
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

}
