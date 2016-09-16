import java.util.*;
import java.math.*;
public class lucky {
	static final int[] nums = 	{4,	7,	44,		47,		74,				77,				444};
	static final long[] tot_lucks = {2,	8,	464,	4096,	18728400854L, 	75422540336L};
	static final ArrayList<Integer> lcks_od = new ArrayList<Integer>();
	static final ArrayList<Integer> lcks_ev = new ArrayList<Integer>();
	static BigInteger[][][] count = new BigInteger[7][223][223];
	
	public static void main(String[] args) {
		for(int d: nums){
			if(d%2==0) lcks_ev.add(d/2);
			else lcks_od.add(d/2);
		}
		Scanner seer = new Scanner(System.in);
		int T = seer.nextInt();
		for(int test = 1; test <= T; test++){
			long n = seer.nextLong();
			int k = 0;
			for(; k < tot_lucks.length; k++){
				if(n <= tot_lucks[k]) break;
				else n -= tot_lucks[k];
			}
			int L = nums[k];
			BigInteger N = big(n);
			if(L % 2 == 0){
				StringBuilder sb = new StringBuilder();
				BigInteger tot = big(0); int a = 0, b = 0;
				for(int i = 0; i < L/2; i++){
					BigInteger curr = count_ev(k, a+1, b);
					if(N.compareTo(tot.add(curr)) <= 0){
						sb.append('4'); a++;
					}
					else{
						sb.append('7'); b++; tot = tot.add(curr);
					}
				}
				System.out.printf("Query #%d: %s\n",test,sb.toString()+sb.reverse().toString());
			}
			else{
				StringBuilder sb = new StringBuilder();
				BigInteger tot = big(0); int a = 0, b = 0;
				for(int i = 0; i < L/2; i++){
					BigInteger curr = count_od(k, a+1, b);
					if(N.compareTo(tot.add(curr)) <= 0){
						sb.append('4'); a++;
					}
					else{
						sb.append('7'); b++; tot = tot.add(curr);
					}
				}
				if(lcks_od.contains(a) || lcks_ev.contains(b)){
					System.out.printf("Query #%d: %s\n",test,sb.toString()+"4"+sb.reverse().toString());
				}
				else{
					System.out.printf("Query #%d: %s\n",test,sb.toString()+"7"+sb.reverse().toString());
				}
			}
		}
	}
	
	static BigInteger count_ev(int ind, int a, int b){
		int L = nums[ind];
		if(a+b > L/2) {
			return big(0);
		}
		else if(count[ind][a][b] != null){
			return count[ind][a][b];
		}
		else if(a+b==L/2){
			if(lcks_ev.contains(a) || lcks_ev.contains(b)){
				return count[ind][a][b] = big(1);
			}
			else return count[ind][a][b] = big(0);
		}
		else{
			BigInteger A = count_ev(ind,a+1,b);
			BigInteger B = count_ev(ind,a,b+1);
			return count[ind][a][b] = A.add(B);
		}
	}
	static BigInteger count_od(int ind, int a, int b){
		int L = nums[ind];
		if(a+b > L/2) return big(0);
		if(count[ind][a][b] != null){
			return count[ind][a][b];
		}
		if(a+b==L/2){
			BigInteger res = big(0);
			if(lcks_od.contains(a) || lcks_od.contains(b)){
				res = res.add(big(1));
			}
			if(lcks_ev.contains(a) || lcks_ev.contains(b)){
				res = res.add(big(1));
			}
			return count[ind][a][b] = res;
		}
		else{
			BigInteger A = count_od(ind,a+1,b);
			BigInteger B = count_od(ind,a,b+1);
			return count[ind][a][b] = A.add(B);
		}
	}
	
	static BigInteger big(long x){
		if(x == 0) return BigInteger.ZERO;
		if(x == 1) return BigInteger.ONE;
		return BigInteger.valueOf(x);
	}
}
