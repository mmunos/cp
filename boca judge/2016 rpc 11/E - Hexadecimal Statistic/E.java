import java.util.*;
import java.io.*;
public class E {
	static final long M = (long)1e9+7;
	static int n;
	static char[][] nums = new char[0x3f][9];
	static long[] fac = new long[17];
	public static void main(String[] args) throws Exception{
		fac[0] = 1;
		for(long i = 1; i <= 16; i++) fac[(int)i] = (fac[(int)i-1]*i)%M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line == null) break;
			n = Integer.parseInt(line,16);
			for(int i = 0; i < n; i++){
				String num = br.readLine(); int m = num.length();
				Arrays.fill(nums[i], 0, 9-m, '0');
				System.arraycopy(num.toCharArray(), 0, nums[i], 9-m, m);
			}
			eval = new long[1 << 16];
			dpmin = new long[1 << 16]; Arrays.fill(dpmin, -1); dpmin[(1 << 16)-1] = 0;
			dpmax = new long[1 << 16]; Arrays.fill(dpmax, -1); dpmax[(1 << 16)-1] = 0;
			//dptot = new long[1 << 16]; Arrays.fill(dptot, -1);
			
			String ss = "0123456789abcdef";
			for(int i = 0; i < 16; i++){
				code[ss.charAt(i)] = i;
			}
			
			for(int s = 0; s < (1 << 16); s++){
				eval[s] = eval(s);
			}
			PrintWriter pw = new PrintWriter(new File("heyey.txt"));
			pw.println(Arrays.toString(eval));
			pw.close();
			
			//bottom up
			for(int s = (1 << 16)-2; s >= 0; s--){
				long min = Long.MAX_VALUE; long max = Long.MIN_VALUE;
				for(int i = 0; i < 16; i++){
					int t = s | (1 << i);
					if(t != s){
						min = Long.min(min, dpmin[t]);
						max = Long.max(max, dpmax[t]);
					}
				}
				dpmin[s] = min + eval[s];
				dpmax[s] = max + eval[s];
			}
			System.out.printf("%s %s %s\n", hex(dpmin[0]), hex(dpmax[0]), hex(calctot()));
		}
	}
	static String oldcode = "0123456789abcdef";
	static int[] code = new int[256];
	static long calcmin(int s){
		if(dpmin[s] >= 0) return dpmin[s];
		if(s == (1 << 16)-1) return 0;
		long min = Long.MAX_VALUE;
		for(int i = 0; i < 16; i++){
			int t = s | (1 << i);
			if(t != s){
				min = Long.min(min, calcmin(t));
			}
		}
		return dpmin[s] = min + eval[s];
	}
	static long calcmax(int s){
		if(dpmax[s] >= 0) return dpmax[s];
		if(s == (1 << 16)-1) return 0;
		long max = 0;
		for(int i = 0; i < 16; i++){
			int t = s | (1 << i);
			if(t != s){
				max = Long.max(max, calcmax(t));
			}
		}
		return dpmax[s] = max + eval[s];
	}
//	static long calctot(int s){
//		if(dptot[s] >= 0) return dptot[s];
//		if(s == (1 << 16)-1) return 0;
//		long tot = 0; int ns = 0;
//		for(int i = 0; i < 16; i++){
//			int t = s | (1 << i);
//			if(t != s){
//				ns++;
//				tot = s(tot, calctot(t));
//			}
//		}
//		long curr = m(eval(s),fac[ns]);
//		return dptot[s] = s(tot, curr);
//	}
	static long calctot(){
		long res = 0;
		for(int i = 1; i < (1 << 16); i++){
			int o = ones(i);
			res = s(res, m(eval[i],m(fac[o],fac[16-o])));
		}
		return res;
	}
	static long s(long x, long y){
		return ((x % M) + (y % M)) % M;
	}
	static long m(long x, long y){
		return ((x % M) * (y % M)) % M;
	}
	static int ones(int x){
		int res = 0;
		while(x > 0){
			res += x&1; x>>=1;
		}
		return res;
	}
	static long eval(int s){
		if(s == 0) return 0;
		long res = 0;
		for(int i = 0; i < n; i++){
			long curr = 0; long k = 0;
			for(int j = 8; j >= 0; j--){
				int c = code[nums[i][j]];
				if((s | (1 << c)) > s){
					curr += (((long)c) << k << k << k << k); k++;
				}
			}
			res += curr;
		}
		
		
//		HashSet<Character> rem = new HashSet<>();
//		for(int i = 0; i < 16; i++){
//			if((s&(1<<i))>0) rem.add(oldcode.charAt(i));
//		}
//		for(int i = 0; i < n; i++){
//			StringBuilder sb = new StringBuilder();
//			for(char c: nums[i]){
//				if(!rem.contains(c)) sb.append(c);
//			}
//			if(sb.length() > 0) res += Long.parseLong(sb.toString(),16);
//		}
		return res;
	}
	static long dpmin[];
	static long dpmax[];
	static long dptot[];
	static long eval[];
	static String hex(long x){
		return Long.toHexString(x);
	}
}
